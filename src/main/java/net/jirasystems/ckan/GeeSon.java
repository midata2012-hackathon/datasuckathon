package net.jirasystems.ckan;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class GeeSon {

	public static class Data {
		public static class Bob {
			String b;

			/**
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Bob [b=" + b + "]";
			}
		}

		private String licenseTitle;
		private String maintainer;
		@SerializedName("maintainer_email")
		private String maintainerEmail;
		private Bob id;

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Data [licenseTitle=" + licenseTitle + ", maintainer=" + maintainer + ", maintainerEmail="
					+ maintainerEmail + ", id=" + id + "]";
		}
	}

	public static void main(String[] args) {
		String json = "{" + "\"license_title\": \"UK Open Government Licence (OGL)\", " + "\"maintainer\": null, "
				+ "\"maintainer_email\": \"hello\", " + "\"id\": {b : \"00055483-dd79-4ada-b4be-eb54eeaec19b\"}}";
		System.out.println(new Gson().fromJson(json, Data.class));
	}

	/*
	 * 
	 * 
	 * {
	 * 
	 * @SerializedName("license_title") private String license_title;
	 * 
	 * @SerializedName("maintainer") private String maintainer;
	 * 
	 * @SerializedName("metadata_created") private String metadata_created;
	 * 
	 * @SerializedName("relationships") private String[] relationships;
	 * 
	 * @SerializedName("metadata_modified") private String metadata_modified;
	 * 
	 * @SerializedName("author") private String author;
	 * 
	 * @SerializedName("author_email") private String author_email;
	 * 
	 * @SerializedName("state") private String state;
	 * 
	 * @SerializedName("version") private String version;
	 * 
	 * @SerializedName("type") private String type;
	 * 
	 * @SerializedName("resource_group_id") private String resource_group_id;
	 * 
	 * @SerializedName("cache_last_updated") private String cache_last_updated;
	 * 
	 * @SerializedName("package_id") private String package_id;
	 * 
	 * @SerializedName("webstore_last_updated") private String webstore_last_updated;
	 * 
	 * @SerializedName("id") private String id;
	 * 
	 * @SerializedName("size") private String size;
	 * 
	 * @SerializedName("cache_filepath") private String cache_filepath;
	 * 
	 * @SerializedName("openness_score") private String openness_score;
	 * 
	 * @SerializedName("last_modified") private String last_modified;
	 * 
	 * @SerializedName("hash") private String hash;
	 * 
	 * @SerializedName("description") private String description;
	 * 
	 * @SerializedName("format") private String format;
	 * 
	 * @SerializedName("tracking_summary") private String tracking_summary;
	 * 
	 * @SerializedName("content_type") private String content_type;
	 * 
	 * @SerializedName("openness_score_reason") private String openness_score_reason;
	 * 
	 * @SerializedName("mimetype") private String mimetype;
	 * 
	 * @SerializedName("cache_url") private String cache_url;
	 * 
	 * @SerializedName("name") private String name;
	 * 
	 * @SerializedName("webstore_url") private String webstore_url; "warwickshire-county-council",
	 * "weighbridges"], "tracking_summary": {"total": 0, "recent": 0}, "groups":
	 * ["d615a457-c8a6-4474-9974-02171a5de623"], "name": "warwickshire-public-weighbridges",
	 * 
	 * @SerializedName("isopen") private String isopen;
	 * 
	 * @SerializedName("url") private String url;
	 * 
	 * @SerializedName("notes") private String notes;
	 * 
	 * @SerializedName("title") private String title;
	 * 
	 * @SerializedName("ratings_average") private String ratings_average;
	 * 
	 * @SerializedName("geographical_granularity") private String geographical_granularity;
	 * 
	 * @SerializedName("openness_score") private String openness_score;
	 * 
	 * @SerializedName("external_reference") private String external_reference;
	 * 
	 * @SerializedName("temporal_granularity") private String temporal_granularity;
	 * 
	 * @SerializedName("date_updated") private String date_updated;
	 * 
	 * @SerializedName("published_via") private String published_via;
	 * 
	 * @SerializedName("agency") private String agency;
	 * 
	 * @SerializedName("precision") private String precision;
	 * 
	 * @SerializedName("taxonomy_url") private String taxonomy_url;
	 * 
	 * @SerializedName("temporal_coverage_to") private String temporal_coverage_to;
	 * 
	 * @SerializedName("temporal_coverage_from") private String temporal_coverage_from;
	 * 
	 * @SerializedName("published_by") private String published_by;
	 * 
	 * @SerializedName("national_statistic") private String national_statistic;
	 * 
	 * @SerializedName("import_source") private String import_source;
	 * 
	 * @SerializedName("update_frequency") private String update_frequency;
	 * 
	 * @SerializedName("department") private String department;
	 * 
	 * @SerializedName("openness_score_last_checked") private String openness_score_last_checked;
	 * 
	 * @SerializedName("date_released") private String date_released;
	 * 
	 * @SerializedName("categories") private String categories;
	 * 
	 * @SerializedName("ratings_count") private String ratings_count;
	 */

}
