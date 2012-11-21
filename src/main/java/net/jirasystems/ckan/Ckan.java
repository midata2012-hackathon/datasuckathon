package net.jirasystems.ckan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import net.jirasystems.ckan.data.Package;
import net.jirasystems.ckan.data.Resource;
import net.jirasystems.resourceutil.ResourceUtilCsv;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;

public class Ckan {

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

		// Get the tags:
		List<String> tags = DataGovUk.getTags();
		System.out.println("Tags: " + tags.size());

//		// Get the packages for the tags:
//		Set<String> packages = new HashSet<String>();
//		int total = tags.size();
//		int i = 0;
//		for (String tag : tags) {
//			List<String> packageList = DataGovUk.getPackagesByTag(tag);
//			for (String packageName : packageList) {
//				packages.add(packageName);
//			}
//			System.out.println(++i + " of " + total + " (" + packages.size() + " unique)");
//		}
//		System.out.println("Packages: "+packages.size());

		List<String> ids = DataGovUk.getPackages();
		System.out.println("Packages: " + ids.size());

		Properties urls;
		try {
			urls = ResourceUtilCsv.getProperties("/urls.properties");
		} catch (IOException e) {

			// Get all packages:
			Set<String> mimeTypes = new HashSet<String>();

			// Iterate packages
			int total = ids.size();
			int i = 0;
			Map<String, String> csvUrls = new HashMap<String, String>();
			urls = new Properties();
			for (String id : ids) {
				Package data = DataGovUk.getPackage(id);
				for (Resource resource : data.getResources()) {
					String mimeType = resource.getMimetype();
					String format = resource.getFormat();
					mimeTypes.add(format + "|" + mimeType);
					if (StringUtils.equalsIgnoreCase("text/csv", mimeType)
							|| StringUtils.equalsIgnoreCase("application/csv", mimeType)) {
						csvUrls.put(id, resource.getUrl().trim().replace(" ", "%20"));
						urls.put(id, resource.getUrl().trim());
					}
				}
				if (++i % 100 == 0) {
					System.out.println(i + " of " + total + " (" + mimeTypes.size() + " mime types)");
				}
			}

			System.out.println(mimeTypes);
			System.out.println(csvUrls.size());
			for (String format : mimeTypes) {
				if (StringUtils.containsIgnoreCase(format, "csv")) {
					System.out.println(format);
				}
			}
			DataGovUk.saveUrls(urls);
		}

		// Download the files:
		int file = 0;
		for (Entry<Object, Object> csvUrl : urls.entrySet()) {
			DataGovUk.download(csvUrl.getValue().toString(), csvUrl.getKey().toString());
			System.out.println("Done " + ++file + " of " + urls.size());
			DataGovUk.processFile(csvUrl.getKey().toString());
		}
	}
}
