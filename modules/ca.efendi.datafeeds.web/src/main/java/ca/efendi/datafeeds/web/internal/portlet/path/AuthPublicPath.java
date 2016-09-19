package ca.efendi.datafeeds.web.internal.portlet.path;

import org.osgi.service.component.annotations.Component;


@Component(
        immediate = true,
        property = {
                "auth.public.path=/cjproduct/find_entry",
                "auth.public.path=/cjproduct/rss"
        },
        service = Object.class
)
public class AuthPublicPath {
}