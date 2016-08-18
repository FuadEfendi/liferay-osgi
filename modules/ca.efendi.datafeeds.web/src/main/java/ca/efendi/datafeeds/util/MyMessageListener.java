/*
 * Copyright (c) 2016 Fuad Efendi <fuad@efendi.ca>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.efendi.datafeeds.util;

import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.model.FtpSubscription;
import ca.efendi.datafeeds.service.CJProductLocalService;
import ca.efendi.datafeeds.service.CJProductServiceUtil;
import ca.efendi.datafeeds.service.FtpSubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.osgi.service.component.annotations.Reference;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 *
 */
public class MyMessageListener implements MessageListener {

    /**
     * @see MessageListener#receive(Message)
     */
    @Override
    public void receive(final Message message) throws MessageListenerException {
        final List<FtpSubscription> ftpSubscriptions =
                FtpSubscriptionLocalServiceUtil.getAllFtpSubscriptions();
        for (final FtpSubscription ftpSubscription : ftpSubscriptions) {
            fetch(ftpSubscription);
        }
    }

    public void fetch(final FtpSubscription ftpSubscription) {
        if (_log.isDebugEnabled()) {
            _log.debug("fetching " + ftpSubscription);
        }
        final FTPClient ftp = new FTPClient();
        ftp.setControlKeepAliveTimeout(30);
        ftp.setControlKeepAliveReplyTimeout(30);
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
        try {
            int reply;
            ftp.connect(ftpSubscription.getFtpHost());
            _log.debug("Connected to " + ftpSubscription.getFtpHost() + " on " + ftp.getDefaultPort());
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            }
        } catch (final IOException e) {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (final IOException f) {
                    // do nothing
                }
            }
            System.err.println("Could not connect to server.");
            e.printStackTrace();
            System.exit(1);
        }
        boolean error = false;
        __main:
        try {
            if (!ftp.login(ftpSubscription.getFtpUser(), ftpSubscription.getFtpPassword())) {
                ftp.logout();
                error = true;
                break __main;
            }
            _log.info("Remote system is " + ftp.getSystemType());
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //ftp.enterLocalActiveMode();
            ftp.enterLocalPassiveMode();
            //final FTPClientConfig config = new FTPClientConfig();
            ////config.setLenientFutureDates(true);
            //ftp.configure(config);
            if (!StringUtils.isBlank(ftpSubscription.getFtpFolder())) {
                ftp.changeWorkingDirectory(ftpSubscription.getFtpFolder());
            }
            final InputStream is = ftp.retrieveFileStream(ftpSubscription.getFtpFile());
            if (is == null) {
                _log.error("FIle not found: " + ftp.getSystemType());
            } else {
                unzip(is);
                is.close();
            }
            ftp.completePendingCommand();
        } catch (final FTPConnectionClosedException e) {
            error = true;
            System.err.println("Server closed connection.");
            e.printStackTrace();
        } catch (final IOException e) {
            error = true;
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (final IOException e) {
                    _log.error(e);
                }
            }
        }
    }

    private void unzip(final InputStream is) {
        try {
            final GZIPInputStream gzis = new GZIPInputStream(is);
            parse(gzis);
            gzis.close();
        } catch (final IOException e) {
            _log.error(e);
        } catch (final XMLStreamException e) {
            _log.error(e);
        }
    }

    private void parse(final InputStream is) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, true);
        factory.setProperty(XMLInputFactory.IS_COALESCING, true);
        final XMLStreamReader reader = factory.createXMLStreamReader(is, "UTF-8");
        CJProduct product = null;
        String tagContent = null;
        final ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(20159);
        while (reader.hasNext()) {
            final int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    //tagContent = "";
                    if ("product".equals(reader.getLocalName())) {
                        product = getCJProductLocalService().createCJProduct(0);
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    //tagContent += reader.getText().trim();
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "product":
                            try {
                                product.setUrlTitle(product.getSku() + " " + product.getName());
                                CJProductServiceUtil.refresh(product, serviceContext);
                            } catch (final SystemException e) {
                                _log.error(e);
                            } catch (final PortalException e) {
                                _log.error(e);
                            }
                            break;
                        case "programname":
                            product.setProgramName(tagContent);
                            break;
                        case "programurl":
                            product.setProgramUrl(tagContent);
                            break;
                        case "catalogname":
                            product.setCatalogName(tagContent);
                            break;
                        case "lastupdated":
                            product.setLastUpdated(tagContent);
                            break;
                        case "name":
                            product.setName(tagContent);
                            break;
                        case "keywords":
                            product.setKeywords(tagContent);
                            break;
                        case "description":
                            product.setDescription(tagContent);
                            break;
                        case "sku":
                            product.setSku(tagContent);
                            break;
                        case "manufacturer":
                            product.setManufacturer(tagContent);
                            break;
                        case "manufacturerid":
                            product.setManufacturerId(tagContent);
                            break;
                        case "currency":
                            product.setCurrency(tagContent);
                            break;
                        case "price":
                            product.setPrice(tagContent);
                            break;
                        case "buyurl":
                            product.setBuyUrl(tagContent);
                            break;
                        case "impressionurl":
                            product.setImpressionUrl(tagContent);
                            break;
                        case "imageurl":
                            product.setImageUrl(tagContent);
                            break;
                        case "instock":
                            product.setInStock(tagContent);
                            break;
                    }
                    break;
                case XMLStreamConstants.START_DOCUMENT:
                    break;
            }
        }
    }

    public CJProductLocalService getCJProductLocalService() {
        return _cjProductLocalService;
    }

    @Reference
    public void setCJProductLocalService(CJProductLocalService cjProductLocalService) {
        this._cjProductLocalService = cjProductLocalService;
    }

    private CJProductLocalService _cjProductLocalService;

    private static final Log _log = LogFactoryUtil.getLog(MyMessageListener.class);
}
