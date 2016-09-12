package ca.efendi.datafeeds.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "collaboration")
@Meta.OCD(
	id = "ca.efendi.datafeeds.configuration.CJProductConfiguration",
	localization = "content/Language", name = "cjproduct.configuration.name"
)
public interface CJProductConfiguration {

	/**
	 * Set the location of the XML file containing the configuration of the
	 * default display templates for the Blogs portlet.
	 */
	@Meta.AD(
		deflt = "com/liferay/blogs/web/template/dependencies/portlet-display-templates.xml",
		required = false
	)
	public String displayTemplatesConfig();

	/**
	 * Set the interval in minutes on how often CheckEntryMessageListener will
	 * run to check for and display blog entries scheduled to display.
	 */
	@Meta.AD(deflt = "1", required = false)
	public int entryCheckInterval();

	/**
	 * Set the interval on which the LinkbackMessageListener will run. The value
	 * is set in one minute increments.
	 */
	@Meta.AD(deflt = "5", required = false)
	public int linkbackJobInterval();

}