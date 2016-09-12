package ca.efendi.datafeeds.web.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
	category = "collaboration",
	scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
	id = "ca.efendi.datafeeds.web.configuration.CJProductPortletInstanceConfiguration",
	localization = "content/Language",
	name = "cjproduct.portlet.instance.configuration.name"
)
public interface CJProductPortletInstanceConfiguration {

	@Meta.AD(deflt = "abstract", required = false)
	public String displayStyle();

	@Meta.AD(deflt = "0", required = false)
	public long displayStyleGroupId();

	@Meta.AD(deflt = "true", required = false)
	public boolean enableCommentRatings();

	@Meta.AD(deflt = "true", required = false)
	public boolean enableComments();

	@Meta.AD(deflt = "true", required = false)
	public boolean enableFlags();

	@Meta.AD(deflt = "true", required = false)
	public boolean enableRatings();

	@Meta.AD(deflt = "true", required = false)
	public boolean enableRelatedAssets();

	@Meta.AD(deflt = "true", required = false)
	public boolean enableSocialBookmarks();

	@Meta.AD(deflt = "false", required = false)
	public boolean enableViewCount();

	@Meta.AD(
		deflt = "${server-property://com.liferay.portal/search.container.page.default.delta}",
		required = false
	)
	public String pageDelta();

	@Meta.AD(deflt = "bottom", required = false)
	public String socialBookmarksDisplayPosition();

	@Meta.AD(deflt = "menu", required = false)
	public String socialBookmarksDisplayStyle();

	@Meta.AD(
		deflt = "${server-property://com.liferay.portal/social.bookmark.types}",
		required = false
	)
	public String socialBookmarksTypes();

}