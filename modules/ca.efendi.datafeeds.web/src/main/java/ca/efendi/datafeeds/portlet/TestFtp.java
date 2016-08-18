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

package ca.efendi.datafeeds.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class TestFtp extends MVCPortlet {
    /*
     * 
     * 
     FTP address: datatransfer.cj.com
     Username: 3870073
     Password: FEYPvk-K

     */
    static String server = "datatransfer.cj.com";

    static String username = "3870073";

    static String password = "6gV$hFG7";

    static String remote = "/outgoing/productcatalog/171164";

    public static void main(final String[] args) throws XMLStreamException {
        final FTPClient ftp = new FTPClient();
        ftp.setCopyStreamListener(createListener());
        ftp.setControlKeepAliveTimeout(30);
        ftp.setControlKeepAliveReplyTimeout(30);
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
        try {
            int reply;
            ftp.connect(server);
            System.out.println("Connected to " + server + " on " + ftp.getDefaultPort());
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
            if (!ftp.login(username, password)) {
                ftp.logout();
                error = true;
                break __main;
            }
            System.out.println("Remote system is " + ftp.getSystemType());
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //ftp.enterLocalActiveMode();
            ftp.enterLocalPassiveMode();
            //final FTPClientConfig config = new FTPClientConfig();
            ////config.setLenientFutureDates(true);
            //ftp.configure(config);
            ftp.changeWorkingDirectory(remote);
            for (final String s : ftp.listNames(".")) {
                System.out.println("FILE: " + s);
                final InputStream is = ftp.retrieveFileStream(remote + "/" + s);
                if (is == null) {
                    throw new RuntimeException();
                }
                unzip(is, s);
                is.close();
                if (ftp.completePendingCommand()) {
                    continue;
                }
            }
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
                } catch (final IOException f) {
                    // do nothing
                }
            }
        }
    }

    private static CopyStreamListener createListener() {
        return new CopyStreamListener() {
            private long megsTotal = 0;

            @Override
            public void bytesTransferred(final CopyStreamEvent event) {
                bytesTransferred(event.getTotalBytesTransferred(), event.getBytesTransferred(), event.getStreamSize());
            }

            @Override
            public void bytesTransferred(final long totalBytesTransferred,
                                         final int bytesTransferred, final long streamSize) {
                final long megs = totalBytesTransferred / 1000000;
                for (long l = megsTotal; l < megs; l++) {
                    System.err.print("#");
                }
                megsTotal = megs;
            }
        };
    }

    public static void unzip(final InputStream is, final String filename) throws XMLStreamException {
        final byte[] buffer = new byte[1024];
        try {
            final GZIPInputStream gzis =
                    new GZIPInputStream(is);
            myParse(gzis);
            gzis.close();

            /*
            String uncompressedFilename = filename;
            if (filename.endsWith(".gz"))
            {
                uncompressedFilename = filename.substring(0, filename.length() - 3);
            }

            final FileOutputStream out =
                    new FileOutputStream(uncompressedFilename);

            int len;
            while ((len = gzis.read(buffer)) > 0)
            {
                out.write(buffer, 0, len);
            }

            gzis.close();
            out.close();

            System.out.println("Done");
            */
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void myParse(final InputStream is) throws XMLStreamException {
        List<MyCJProduct> empList = null;
        MyCJProduct currEmp = null;
        String tagContent = null;
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        final XMLStreamReader reader = factory.createXMLStreamReader(is);
        while (reader.hasNext()) {
            final int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("product".equals(reader.getLocalName())) {
                        currEmp = new MyCJProduct();
                        //currEmp.id = reader.getAttributeValue(0);
                    }
                    if ("catalog".equals(reader.getLocalName())) {
                        empList = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "product":
                            empList.add(currEmp);
                            break;
                        case "programname":
                            currEmp.programname = tagContent;
                            break;
                        case "programurl":
                            currEmp.programurl = tagContent;
                            break;
                        case "catalogname":
                            currEmp.catalogname = tagContent;
                            break;
                        case "lastupdated":
                            currEmp.lastupdated = tagContent;
                            break;
                        case "name":
                            currEmp.name = tagContent;
                            break;
                        case "keywords":
                            currEmp.keywords = tagContent;
                            break;
                        case "description":
                            currEmp.description = tagContent;
                            break;
                        case "sku":
                            currEmp.sku = tagContent;
                            break;
                        case "manufacturer":
                            currEmp.manufacturer = tagContent;
                            break;
                        case "manufacturerid":
                            currEmp.manufacturerid = tagContent;
                            break;
                        case "currency":
                            currEmp.currency = tagContent;
                            break;
                        case "price":
                            currEmp.price = tagContent;
                            break;
                        case "buyurl":
                            currEmp.buyurl = tagContent;
                            break;
                        case "impressionurl":
                            currEmp.impressionurl = tagContent;
                            break;
                        case "imageurl":
                            currEmp.imageurl = tagContent;
                            break;
                        case "instock":
                            currEmp.instock = tagContent;
                            break;
                    }
                    break;
                case XMLStreamConstants.START_DOCUMENT:
                    empList = new ArrayList<>();
                    break;
            }
        }
        //Print the employee list populated from XML 
        for (final MyCJProduct emp : empList) {
            System.out.println(emp);
        }
    }
}

/*
<product>
<programname>WristWatch.com</programname>
<programurl>http://www.wristwatch.com/</programurl>
<catalogname>Wristwatch Data Feed</catalogname>
<lastupdated>2014-12-09 16:02:02.578</lastupdated>
<name>Victorinox Swiss Army Chrono Classic Pink Leather strap #004145</name>
<keywords>Victorinox Swiss Army Watch - 004145</keywords>
<description>Pink genuine leather strap with contrast stitching and brushed silver-tone stainless steel buckle, Lug Width: 21.0 mm, Band Depth: 3.3 mm, Band Length: 164.0 mm, Buckle Width: 23.7 mm Fits the following Chrono Classic timepiece: 241419</description>
<sku>4145</sku>
<manufacturer>Victorinox Swiss Army</manufacturer>
<manufacturerid>4145</manufacturerid>
<currency>USD</currency>
<price>85</price>
<buyurl>http://www.dpbolvw.net/click-7674915-10283359?url=http%3A%2F%2Fwww.wristwatch.com%2FVictorinox-Chrono-Classic-Leather-004145%2Fdp%2FB00839PU6Y%3Fadid%3D2121--004145</buyurl>
<impressionurl>http://www.awltovhc.com/image-7674915-10283359</impressionurl>
<imageurl>http://ecx.images-amazon.com/images/I/21SToSLB4rL.jpg</imageurl>
<instock>yes</instock>
</product>
*/
class MyCJProduct {

    String programname;

    String programurl;

    String catalogname;

    String lastupdated;

    String name;

    String keywords;

    String description;

    String sku;

    String manufacturer;

    String manufacturerid;

    String currency;

    String price;

    String buyurl;

    String impressionurl;

    String imageurl;

    String instock;

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("CJProduct [programname=").append(programname).append(", programurl=").append(programurl).append(", catalogname=").append(catalogname)
                .append(", lastupdated=").append(lastupdated).append(", name=").append(name).append(", keywords=").append(keywords).append(", description=")
                .append(description).append(", sku=").append(sku).append(", manufacturer=").append(manufacturer).append(", manufacturerid=")
                .append(manufacturerid).append(", currency=").append(currency).append(", price=").append(price).append(", buyurl=").append(buyurl)
                .append(", impressionurl=").append(impressionurl).append(", imageurl=").append(imageurl).append(", instock=").append(instock).append("]");
        return builder.toString();
    }
}
