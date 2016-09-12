package ca.efendi.datafeeds.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
	category = "collaboration",
	scope = ExtendedObjectClassDefinition.Scope.GROUP
)
@Meta.OCD(
	id = "ca.efendi.datafeeds.configuration.CJProductGroupServiceConfiguration",
	localization = "content/Language",
	name = "cjproduct.group.service.configuration.name"
)
public interface CJProductGroupServiceConfiguration {

	@Meta.AD(deflt = "true", required = false)
	public boolean enableRss();

	@Meta.AD(
		deflt = "${server-property://com.liferay.portal/search.container.page.default.delta}",
		required = false
	)
	public String rssDelta();

	@Meta.AD(
		deflt = "${server-property://com.liferay.portal/rss.feed.display.style.default}",
		required = false
	)
	public String rssDisplayStyle();

	@Meta.AD(
		deflt = "${server-property://com.liferay.portal/rss.feed.type.default}",
		required = false
	)
	public String rssFeedType();

	@Meta.AD(deflt = "300", required = false)
	public int smallImageWidth();

}