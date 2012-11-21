package net.jirasystems.ckan.data;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class Package {

	@SerializedName("license_title")
	private String licenseTitle; // : "UK Open Government Licence (OGL)", 
	@SerializedName("maintainer")
	private String maintainer; // : null, 
	@SerializedName("maintainer_email")
	private String maintainerEmail; // : null, 
	@SerializedName("id")
	private String id; // : "00055483-dd79-4ada-b4be-eb54eeaec19b", 
	@SerializedName("metadata_created")
	private String metadataCreated; // : "2010-05-19T12:33:30.420431", 
	@SerializedName("relationships")
	private String[] relationships; // : [],
	@SerializedName("license")
	private String license; // : "UK Open Government Licence (OGL)", 
	@SerializedName("metadata_modified")
	private String metadataModified; // : "2012-11-12T21:09:11.337779", 
	@SerializedName("author")
	private String author; // : "Trading Standards, Environment and Economy", 
	@SerializedName("author_email")
	private String authorEmail; // : "opendata@warwickshire.gov.uk", 
	@SerializedName("state")
	private String state; // : "active", 
	@SerializedName("version")
	private String version; // : null, 
	@SerializedName("license_id")
	private String licenseId; // : "uk-ogl", 
	@SerializedName("type")
	private String type; // : null, 
	@SerializedName("resources")
	private Resource[] resources; // : [{
	//}],
	@SerializedName("tags")
	private String[] tags; // : ["warwickshire", "warwickshire-county-council", "weighbridges"],
	@SerializedName("tracking_summary")
	private TrackingSummary tracking_summary; // : {
	//},
	@SerializedName("groups")
	private String[] groups; // : ["d615a457-c8a6-4474-9974-02171a5de623"],
	@SerializedName("name")
	private String name; // : "warwickshire-public-weighbridges", 
	@SerializedName("isopen")
	private String isopen; // : true, 
	@SerializedName("notes_rendered")
	private String notes_rendered; // : "<p>A list of all public weighbridges in Warwickshire, including address, telephone, capacity, approximate dimensions, opening times and fees\n</p>", 
	@SerializedName("url")
	private String url; // : null, 
	@SerializedName("ckan_url")
	private String ckan_url; // : "http://data.gov.uk//dataset/warwickshire-public-weighbridges", 
	@SerializedName("notes")
	private String notes; // : "A list of all public weighbridges in Warwickshire, including address, telephone, capacity, approximate dimensions, opening times and fees", 
	@SerializedName("title")
	private String title; // : "Public Weighbridges", 
	@SerializedName("ratings_average")
	private String ratings_average; // : null, 
	@SerializedName("extras")
	private Extras extras; // : {
	//},
	@SerializedName("license_url")
	private String license_url; // : "http://reference.data.gov.uk/id/open-government-licence", 
	@SerializedName("ratings_count")
	private String ratings_count; // : 0, 
	@SerializedName("revision_id")
	private String revisionId; // : "8894f663-cbab-4e06-a2bf-9b22db575b68"

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Package [licenseTitle=" + licenseTitle + ", maintainer=" + maintainer + ", maintainerEmail="
				+ maintainerEmail + ", id=" + id + ", metadataCreated=" + metadataCreated + ", relationships="
				+ Arrays.toString(relationships) + ", license=" + license + ", metadataModified=" + metadataModified
				+ ", author=" + author + ", authorEmail=" + authorEmail + ", state=" + state + ", version=" + version
				+ ", licenseId=" + licenseId + ", type=" + type + ", resources=" + Arrays.toString(resources)
				+ ", tags=" + Arrays.toString(tags) + ", tracking_summary=" + tracking_summary + ", groups="
				+ Arrays.toString(groups) + ", name=" + name + ", isopen=" + isopen + ", notes_rendered="
				+ notes_rendered + ", url=" + url + ", ckan_url=" + ckan_url + ", notes=" + notes + ", title=" + title
				+ ", ratings_average=" + ratings_average + ", extras=" + extras + ", license_url=" + license_url
				+ ", ratings_count=" + ratings_count + ", revisionId=" + revisionId + "]";
	}

	/**
	 * @return the resources
	 */
	public Resource[] getResources() {
		return resources;
	}

	/**
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

//	public static void main(String[] args) throws IOException {
//		String json = FileUtils.readFileToString(new File(
//				"/home/david/workspace/ckan/src/main/resources/packages/00055483-dd79-4ada-b4be-eb54eeaec19b.txt"),
//				"UTF8");
//		Package fromJson = new Gson().fromJson(json, Package.class);
//		System.out.println(fromJson);
//	}
}

class TrackingSummary {
	@SerializedName("total")
	private String total; // : 0, 
	@SerializedName("recent")
	private String recent; // : 0

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TrackingSummary [total=" + total + ", recent=" + recent + "]";
	}
}
