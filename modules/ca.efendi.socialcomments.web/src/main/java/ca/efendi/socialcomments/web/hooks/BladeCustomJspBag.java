package ca.efendi.socialcomments.web.hooks;

import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.url.URLContainer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component(
        immediate = true,
        property = {
                "context.id=SocialComments",
                "context.name=FE Social Comments",
                "service.ranking:Integer=100"
        }
)
public class BladeCustomJspBag implements CustomJspBag {

    @Override
    public String getCustomJspDir() {
        return "META-INF/jsps/";
    }

    @Override
    public List<String> getCustomJsps() {
        return _customJsps;
    }

    @Override
    public URLContainer getURLContainer() {
        return _urlContainer;
    }

    @Override
    public boolean isCustomJspGlobal() {
        return true;
    }

    @Activate
    protected void activate(BundleContext bundleContext) {
        bundle = bundleContext.getBundle();

        _customJsps = new ArrayList<>();

        Enumeration<URL> entries = bundle.findEntries(
                getCustomJspDir(), "*.jsp", true);

        while (entries != null && entries.hasMoreElements()) {
            URL url = entries.nextElement();

            _log.error("JSP found: " + url.getPath());

            _customJsps.add(url.getPath());
        }
    }

    private List<String> _customJsps;

    private final URLContainer _urlContainer = new URLContainer() {

        @Override
        public Set<String> getResources(String path) {
            Set<String> paths = new HashSet<>();

            for (String entry : _customJsps) {
                if (entry.startsWith(path)) {
                    paths.add(entry);
                }
            }

            return paths;
        }

        @Override
        public URL getResource(String name) {
            return bundle.getEntry(name);
        }

    };

    private Bundle bundle;


    private static final Log _log = LogFactoryUtil.getLog(BladeCustomJspBag.class);

}