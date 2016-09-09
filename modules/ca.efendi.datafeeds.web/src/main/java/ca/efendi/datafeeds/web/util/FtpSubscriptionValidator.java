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

package ca.efendi.datafeeds.web.util;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import java.util.List;

public class FtpSubscriptionValidator {
    public static boolean validate(final ActionRequest request, final List<String> errors) {
        boolean valid = true;
        if (Validator.isNull(ParamUtil.getString(request, "ftpHost"))) {
            errors.add("ftp-host-required");
            valid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "ftpUser"))) {
            errors.add("ftp-user-required");
            valid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "ftpPassword"))) {
            errors.add("ftp-password-required");
            valid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "ftpFolder"))) {
            errors.add("ftp-folder-required");
            valid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "ftpDatafeedName"))) {
            errors.add("ftp-file-name-required");
            valid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "ftpFile"))) {
            errors.add("ftp-datafeed-name-required");
            valid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "ftpDatafeedDescription"))) {
            errors.add("ftp-description-required");
            valid = false;
        }
        return valid;
    }
}
