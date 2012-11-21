package net.jirasystems.ckan.data;

import com.google.gson.annotations.SerializedName;

public class Resource {
	@SerializedName("contentLength")
	private String contentLength; // : "19968", 
	@SerializedName("resourceGroupId")
	private String resourceGroupId; // : "f97959e2-c651-a5ad-8586-acb8746f7c38", 
	@SerializedName("cacheLastUpdated")
	private String cacheLastUpdated; // : "2012-06-27T16:19:59.597590", 
	@SerializedName("packageId")
	private String packageId; // : "00055483-dd79-4ada-b4be-eb54eeaec19b", 
	@SerializedName("webstore_last_updated")
	private String webstoreLastUpdated; // : null, 
	@SerializedName("datastore_active")
	private String datastoreActive; // : "False", 
	@SerializedName("id")
	private String id; // : "fe5bd141-d2a4-40d6-ac8f-cc9225f5b5b9", 
	@SerializedName("size")
	private String size; // : "19968", 
	@SerializedName("cache_filepath")
	private String cacheFilepath; // : "/mnt/shared/ckan_resource_cache/fe/fe5bd141-d2a4-40d6-ac8f-cc9225f5b5b9/public-weighbridges.xls", 
	@SerializedName("openness_score")
	private String opennessScore; // : "0", 
	@SerializedName("last_modified")
	private String lastModified; // : "2012-06-27T16:19:59.597703", 
	@SerializedName("hash")
	private String hash; // : "c436142061293acbca81ae81280fca06989f039f", 
	@SerializedName("description")
	private String description; // : "", 
	@SerializedName("format")
	private String format; // : "XLS", 
	@SerializedName("tracking_summary")
	private TrackingSummary trackingSummary; // : {
	//},
	@SerializedName("mimetype_inner")
	private String mimetypeInner; // : null, 
	@SerializedName("openness_score_failure_count")
	private String opennessScoreFailureCount; // : "1", 
	@SerializedName("content_type")
	private String contentType; // : "application/vnd.ms-excel", 
	@SerializedName("openness_score_reason")
	private String opennessScoreReason; // : "The format entered for the resource doesn't match the description from the web server", 
	@SerializedName("mimetype")
	private String mimetype; // : "application/vnd.ms-excel", 
	@SerializedName("cacheUrl")
	private String cacheUrl; // : "http://data.gov.uk/data/resource_cache/fe/fe5bd141-d2a4-40d6-ac8f-cc9225f5b5b9/public-weighbridges.xls", 
	@SerializedName("name")
	private String name; // : null, 
	@SerializedName("created")
	private String created; // : null, 
	@SerializedName("url")
	private String url; // : "http://opendata.s3.amazonaws.com/public-weighbridges.xls", 
	@SerializedName("webstore_url")
	private String webstoreUrl; // : null, 
	@SerializedName("position")
	private String position; // : 0, 
	@SerializedName("resource_type")
	private String resourceType; // : null

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resource [contentLength=" + contentLength + ", resourceGroupId=" + resourceGroupId
				+ ", cacheLastUpdated=" + cacheLastUpdated + ", packageId=" + packageId + ", webstore_last_updated="
				+ webstoreLastUpdated + ", datastore_active=" + datastoreActive + ", id=" + id + ", size=" + size
				+ ", cache_filepath=" + cacheFilepath + ", openness_score=" + opennessScore + ", last_modified="
				+ lastModified + ", hash=" + hash + ", description=" + description + ", format=" + format
				+ ", trackingSummary=" + trackingSummary + ", mimetypeInner=" + mimetypeInner
				+ ", openness_score_failure_count=" + opennessScoreFailureCount + ", content_type=" + contentType
				+ ", openness_score_reason=" + opennessScoreReason + ", mimetype=" + mimetype + ", cache_url="
				+ cacheUrl + ", name=" + name + ", created=" + created + ", url=" + url + ", webstore_url="
				+ webstoreUrl + ", position=" + position + ", resource_type=" + resourceType + "]";
	}

	/**
	 * @return the contentLength
	 */
	public String getContentLength() {
		return contentLength;
	}

	/**
	 * @param contentLength
	 *            the contentLength to set
	 */
	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}

	/**
	 * @param resourceGroupId
	 *            the resourceGroupId to set
	 */
	public void setResourceGroupId(String resourceGroupId) {
		this.resourceGroupId = resourceGroupId;
	}

	/**
	 * @return the cacheLastUpdated
	 */
	public String getCacheLastUpdated() {
		return cacheLastUpdated;
	}

	/**
	 * @param cacheLastUpdated
	 *            the cacheLastUpdated to set
	 */
	public void setCacheLastUpdated(String cacheLastUpdated) {
		this.cacheLastUpdated = cacheLastUpdated;
	}

	/**
	 * @return the packageId
	 */
	public String getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId
	 *            the packageId to set
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/**
	 * @return the webstoreLastUpdated
	 */
	public String getWebstoreLastUpdated() {
		return webstoreLastUpdated;
	}

	/**
	 * @param webstoreLastUpdated
	 *            the webstoreLastUpdated to set
	 */
	public void setWebstoreLastUpdated(String webstoreLastUpdated) {
		this.webstoreLastUpdated = webstoreLastUpdated;
	}

	/**
	 * @return the datastoreActive
	 */
	public String getDatastoreActive() {
		return datastoreActive;
	}

	/**
	 * @param datastoreActive
	 *            the datastoreActive to set
	 */
	public void setDatastoreActive(String datastoreActive) {
		this.datastoreActive = datastoreActive;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the cacheFilepath
	 */
	public String getCacheFilepath() {
		return cacheFilepath;
	}

	/**
	 * @param cacheFilepath
	 *            the cacheFilepath to set
	 */
	public void setCacheFilepath(String cacheFilepath) {
		this.cacheFilepath = cacheFilepath;
	}

	/**
	 * @return the opennessScore
	 */
	public String getOpennessScore() {
		return opennessScore;
	}

	/**
	 * @param opennessScore
	 *            the opennessScore to set
	 */
	public void setOpennessScore(String opennessScore) {
		this.opennessScore = opennessScore;
	}

	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash
	 *            the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the trackingSummary
	 */
	public TrackingSummary getTrackingSummary() {
		return trackingSummary;
	}

	/**
	 * @param trackingSummary
	 *            the trackingSummary to set
	 */
	public void setTrackingSummary(TrackingSummary trackingSummary) {
		this.trackingSummary = trackingSummary;
	}

	/**
	 * @return the mimetypeInner
	 */
	public String getMimetypeInner() {
		return mimetypeInner;
	}

	/**
	 * @param mimetypeInner
	 *            the mimetypeInner to set
	 */
	public void setMimetypeInner(String mimetypeInner) {
		this.mimetypeInner = mimetypeInner;
	}

	/**
	 * @return the opennessScoreFailureCount
	 */
	public String getOpennessScoreFailureCount() {
		return opennessScoreFailureCount;
	}

	/**
	 * @param opennessScoreFailureCount
	 *            the opennessScoreFailureCount to set
	 */
	public void setOpennessScoreFailureCount(String opennessScoreFailureCount) {
		this.opennessScoreFailureCount = opennessScoreFailureCount;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the opennessScoreReason
	 */
	public String getOpennessScoreReason() {
		return opennessScoreReason;
	}

	/**
	 * @param opennessScoreReason
	 *            the opennessScoreReason to set
	 */
	public void setOpennessScoreReason(String opennessScoreReason) {
		this.opennessScoreReason = opennessScoreReason;
	}

	/**
	 * @return the mimetype
	 */
	public String getMimetype() {
		return mimetype;
	}

	/**
	 * @param mimetype
	 *            the mimetype to set
	 */
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	/**
	 * @return the cacheUrl
	 */
	public String getCacheUrl() {
		return cacheUrl;
	}

	/**
	 * @param cacheUrl
	 *            the cacheUrl to set
	 */
	public void setCacheUrl(String cacheUrl) {
		this.cacheUrl = cacheUrl;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the webstoreUrl
	 */
	public String getWebstoreUrl() {
		return webstoreUrl;
	}

	/**
	 * @param webstoreUrl
	 *            the webstoreUrl to set
	 */
	public void setWebstoreUrl(String webstoreUrl) {
		this.webstoreUrl = webstoreUrl;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType
	 *            the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
}
