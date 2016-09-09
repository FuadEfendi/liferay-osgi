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

package ca.efendi.datafeeds.search;


import ca.efendi.datafeeds.model.CJProduct;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.OpenSearch;
import com.liferay.portal.kernel.util.StringPool;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = OpenSearch.class)
public class CJProductOpenSearchImpl extends HitsOpenSearchImpl {

    public static final String TITLE = "Liferay Bookmarks Search: ";

    @Override
    public String getClassName() {
        return CJProduct.class.getName();
    }

    @Override
    public Indexer<CJProduct> getIndexer() {
        return IndexerRegistryUtil.getIndexer(CJProduct.class);
    }

    @Override
    public String getSearchPath() {
        return StringPool.BLANK;
    }

    @Override
    public String getTitle(String keywords) {
        return TITLE + keywords;
    }

}