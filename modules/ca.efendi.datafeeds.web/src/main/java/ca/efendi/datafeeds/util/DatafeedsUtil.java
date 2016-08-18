/*
 * INTERCALL CONFIDENTIAL 
 * 
 * (c)2013. InterCall is a subsidiary of West Corporation. All rights reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property of InterCall. 
 * The intellectual and technical concepts contained herein are proprietary to InterCall
 * and may be covered by U.S. and Foreign Patents, patents in process, and are 
 * protected by trade secret or copyright law. 
 * 
 * Dissemination of this information or reproduction of this material is strictly 
 * forbidden unless prior written permission is obtained from InterCall.
 */
package ca.efendi.datafeeds.util;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 *
 */
public class DatafeedsUtil {

    public static Sort[] getCJProductSorts(
            final String orderByCol, final String orderByType) {
        if (Validator.isNull(orderByCol) || Validator.isNull(orderByType)) {
            return SortFactoryUtil.getDefaultSorts();
        }
        boolean reverse = true;
        if (orderByType.equals("asc")) {
            reverse = false;
        }
        if (orderByCol.equals("create-date")) {
            final String fieldName = Field.CREATE_DATE;
            return new Sort[]{
                    SortFactoryUtil.create(fieldName, Sort.LONG_TYPE, reverse),
                    SortFactoryUtil.create(null, Sort.SCORE_TYPE, false)
            };
        } else if (orderByCol.equals("modified-date")) {
            final String fieldName = Field.MODIFIED_DATE;
            return new Sort[]{
                    SortFactoryUtil.create(fieldName, Sort.LONG_TYPE, reverse),
                    SortFactoryUtil.create(null, Sort.SCORE_TYPE, false)
            };
        } else if (orderByCol.equals("score")) {
            final String fieldName = null;
            return new Sort[]{
                    SortFactoryUtil.create(fieldName, Sort.SCORE_TYPE, !reverse),
                    SortFactoryUtil.create(
                            Field.MODIFIED_DATE, Sort.LONG_TYPE, true)
            };
        } else if (orderByCol.equals("title")) {
            final String fieldName = "titleKeyword";
            return new Sort[]{
                    SortFactoryUtil.create(fieldName, Sort.STRING_TYPE, reverse),
                    SortFactoryUtil.create(null, Sort.SCORE_TYPE, false)
            };
        } else if (orderByCol.equals("user-name")) {
            final String fieldName = Field.USER_NAME;
            return new Sort[]{
                    SortFactoryUtil.create(fieldName, Sort.STRING_TYPE, reverse),
                    SortFactoryUtil.create(null, Sort.SCORE_TYPE, false)
            };
        }
        return SortFactoryUtil.getDefaultSorts();
    }
}
