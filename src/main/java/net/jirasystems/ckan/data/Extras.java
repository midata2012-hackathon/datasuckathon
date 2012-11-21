package net.jirasystems.ckan.data;

import com.google.gson.annotations.SerializedName;

public class Extras {
	@SerializedName("geographic_coverage")
	private String geographicCoverage; // : "100000: England", 
	@SerializedName("geographical_granularity")
	private String geographicalGranularity; // : "point", 
	@SerializedName("openness_score")
	private String opennessScore; // : "0", 
	@SerializedName("external_reference")
	private String externalReference; // : "", 
	@SerializedName("temporal_granularity")
	private String temporalGranularity; // : "", 
	@SerializedName("date_updated")
	private String dateUpdated; // : "12/05/2006 08:21", 
	@SerializedName("published_via")
	private String publishedVia; // : "", 
	@SerializedName("agency")
	private String agency; // : "", 
	@SerializedName("precision")
	private String precision; // : "", 
	@SerializedName("taxonomy_url")
	private String taxonomyUrl; // : "", 
	@SerializedName("temporal_coverage_to")
	private String temporalCoverageTo; // : "", 
	@SerializedName("temporal_coverage_from")
	private String temporalCoverageFrom; // : "", 
	@SerializedName("published_by")
	private String publishedBy; // : "Warwickshire County Council [11428]", 
	@SerializedName("nationalStatistic")
	private String nationalStatistic; // : "", 
	@SerializedName("import_source")
	private String importSource; // : "COSPREAD-cospread-2010-05-17.csv", 
	@SerializedName("update_frequency")
	private String updateFrequency; // : "", 
	@SerializedName("department")
	private String department; // : "Warwickshire County Council", 
	@SerializedName("openness_score_last_checked")
	private String opennessScoreLastChecked; // : "2011-06-07T11:44:22.072861", 
	@SerializedName("date_released")
	private String dateReleased; // : "10/05/2006 13:30", 
	@SerializedName("categories")
	private String categories; // : ""

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Extras [geographic_coverage=" + geographicCoverage + ", geographical_granularity="
				+ geographicalGranularity + ", openness_score=" + opennessScore + ", external_reference="
				+ externalReference + ", temporal_granularity=" + temporalGranularity + ", date_updated=" + dateUpdated
				+ ", published_via=" + publishedVia + ", agency=" + agency + ", precision=" + precision
				+ ", taxonomy_url=" + taxonomyUrl + ", temporal_coverage_to=" + temporalCoverageTo
				+ ", temporal_coverage_from=" + temporalCoverageFrom + ", published_by=" + publishedBy
				+ ", national_statistic=" + nationalStatistic + ", import_source=" + importSource
				+ ", update_frequency=" + updateFrequency + ", department=" + department
				+ ", openness_score_last_checked=" + opennessScoreLastChecked + ", date_released=" + dateReleased
				+ ", categories=" + categories + "]";
	}

}
