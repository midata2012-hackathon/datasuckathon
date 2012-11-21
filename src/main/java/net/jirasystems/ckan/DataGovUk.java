package net.jirasystems.ckan;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.net.ssl.SSLPeerUnverifiedException;

import net.jirasystems.ckan.data.Package;
import net.jirasystems.resourceutil.ResourceUtilCsv;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;

import com.google.gson.Gson;

public class DataGovUk {

	private static final String resourcePath = "/home/david/workspace/ckan/src/main/resources";

	public static List<String> getPackages() throws ClientProtocolException, IOException {
		String resource = "/packages.txt";
		String json = null;
		String[] packages;

		// Get the Json from resource, or the web:
		try {

			// Read resource:
			json = ResourceUtilCsv.getString(resource);
//			System.out.println("Found resource for packages.");

		} catch (IOException e) {

			// Download
			String uri = "http://data.gov.uk/api/2/rest/package";
			System.out.println("Getting packages from " + uri);
			Client client = new Client();
			try {
				json = client.get(uri);
			} catch (HttpResponseException e2) {
				System.out.println("packages: " + e2.getMessage());
			}

			// Save to file:
			File tagResource = new File(resourcePath, resource);
			FileUtils.writeStringToFile(tagResource, json);
			System.out.println("Saved to " + tagResource);

		}

		if (json != null) {
			// Parse the Json:
			Gson gson = new Gson();
			packages = gson.fromJson(json, String[].class);
		} else {
			packages = new String[0];
		}

		if (packages != null) {
//			System.out.println(packages.length + " packages.");
			return Arrays.asList(packages);
		} else {
			return new ArrayList<String>();
		}
	}

	public static Package getPackage(String id) throws ClientProtocolException, IOException {
		String resource = "/packages/" + id + ".txt";
		String json = null;
//		String[] packages;

		// Get the Json from resource, or the web:
		try {

			// Read resource:
			json = ResourceUtilCsv.getString(resource);
//			System.out.println("Found resource for package " + id);

		} catch (IOException e) {

			// Download
			String uri = "http://data.gov.uk/api/2/rest/package/" + id;
			System.out.println("Getting package from " + uri);
			Client client = new Client();
			try {
				json = client.get(uri);
			} catch (HttpResponseException e2) {
				System.out.println(id + ": " + e2.getMessage());
			}

			// Save to file:
			File packageResource = new File(resourcePath, resource);
			FileUtils.writeStringToFile(packageResource, json);
			System.out.println("Saved to " + packageResource);

		}

		Package data;
		if (json != null) {
			// Parse the Json:
			Gson gson = new Gson();
			data = gson.fromJson(json, Package.class);
		} else {
			data = new Package();
		}

//		if (packages != null) {
//			System.out.println(packages.length + " packages.");
//			return Arrays.asList(packages);
//		} else {
		return data;
//		}
	}

	public static List<String> getPackagesByTag(String tag) throws ClientProtocolException, IOException {
		String resource = "/tags/" + toFileName(tag) + ".txt";
		String json = null;
		String[] packages;

		// Get the Json from resource, or the web:
		try {

			// Read resource:
			json = ResourceUtilCsv.getString(resource);
//			System.out.println("Found resource for tag " + tag);

		} catch (IOException e) {

			// Download
			String uri = "http://data.gov.uk/api/2/rest/tag/" + URLEncoder.encode(tag, "UTF8");
			System.out.println("Getting packages from " + uri);
			Client client = new Client();
			try {
				json = client.get(uri);
			} catch (HttpResponseException e2) {
				System.out.println(tag + ": " + e2.getMessage());
			}

			// Save to file:
			File tagResource = new File(resourcePath, resource);
			FileUtils.writeStringToFile(tagResource, json);
			System.out.println("Saved to " + tagResource);

		}

		if (json != null) {
			// Parse the Json:
			Gson gson = new Gson();
			packages = gson.fromJson(json, String[].class);
		} else {
			packages = new String[0];
		}

//		System.out.println("---");
//		for (int i = 0; i < 5; i++) {
//			System.out.println(result.get(i));
//		}
//		System.out.println("...");
//		for (int i = result.size() - 5; i < result.size(); i++) {
//			System.out.println(result.get(i));
//		}
//		System.out.println("---");

		if (packages != null) {
			System.out.println(packages.length + " packages.");
			return Arrays.asList(packages);
		} else {
			return new ArrayList<String>();
		}
	}

	public static String toFileName(String tag) {

		StringBuilder result = new StringBuilder();

		for (char c : tag.toCharArray()) {
			if (Character.isJavaIdentifierPart(c)) {
				result.append(String.valueOf(c).toLowerCase());
			}
		}

		return result.toString();
	}

	public static List<String> getTags() throws ClientProtocolException, IOException {
		String resource = "/tags.txt";
		String json;
		String[] tags;

		// Get the Json from resource, or the web:
		try {

			// Read resource:
			json = ResourceUtilCsv.getString(resource);
			System.out.println("Found tags resource.");

		} catch (IOException e) {

			// Download
			String uri = "http://data.gov.uk/api/2/rest/tag";
			System.out.println("Getting tags from " + uri);
			Client client = new Client();
			json = client.get(uri);

			// Save to file:
			File tagResource = new File(resourcePath, resource);
			FileUtils.writeStringToFile(tagResource, json);

		}

		// Parse the Json:
		Gson gson = new Gson();
		tags = gson.fromJson(json, String[].class);

		System.out.println(tags.length + " tags.");
		return Arrays.asList(tags);
	}

	public static void print(List<String> list) {

		System.out.println("---");
		for (int i = 0; i < 5; i++) {
			System.out.println(list.get(i));
		}
		System.out.println("...");
		for (int i = list.size() - 5; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---");

	}

	public static void download(String uri, String filename) throws ClientProtocolException, IOException {
		String resource = "/files/" + filename;

		// This one won't download:
		if (uri.equals("http://www.eastmidlands.nhs.uk/EasysiteWeb/getresource.axd?AssetID=48625&type=full&servicetype=Attachment")) {
			return;
		}

		// Get the file from resource, or the web:
		try {

			// Read resource:
			ResourceUtilCsv.getStream(resource).close();
//			System.out.println("Found resource for " + filename);

		} catch (IOException e) {

			// Download
			System.out.println("Getting packages from " + uri);
			File file = new File(resourcePath, resource);
			file.getParentFile().mkdir();
			Client client = new Client();

			// Save to file:
			OutputStream output = null;
			try {
				output = new BufferedOutputStream(new FileOutputStream(file));
				client.download(uri, output);
			} catch (SSLPeerUnverifiedException e2) {
				System.out.println("Don't like the look of the certificate on " + uri);
			} finally {
				IOUtils.closeQuietly(output);
			}

			System.out.println("Saved to " + file.getPath());
		}
	}

	public static void processFile(String filename) throws ClientProtocolException, IOException {
		String resource = "/files/" + filename;
		File csv = new File(resourcePath + resource + ".csv");

		// Get the file from resource, or the web:
		try {

			// Read resource:
			ResourceUtilCsv.getStream(resource + ".csv").close();
			System.out.println("Found CSV for " + filename);

		} catch (IOException e) {

			// Is it a zip or a CSV? Who knows..

			try {

				// Try zip:
				ZipFile zipFile = new ZipFile(resourcePath + resource);
				Enumeration<? extends ZipEntry> entries = zipFile.entries();
				InputStream input = null;
				while (entries.hasMoreElements()) {
					try {
						ZipEntry entry = entries.nextElement();
						input = zipFile.getInputStream(entry);
						File file = csv;
						FileUtils.copyInputStreamToFile(input, file);
					} finally {
						IOUtils.closeQuietly(input);
					}
				}
				System.out
						.println("Twere a zip they fe.deth me all for upon the tubes of this great tinternet. Hark not tith "
								+ csv.getPath());

			} catch (ZipException a) {

				// Probably a CSV then
				FileUtils.copyFile(new File(resourcePath + resource), csv);
				System.out.println("Saved to " + csv.getPath());
			}

		}
	}

	public static void saveUrls(Properties urls) throws IOException {
		OutputStream out = null;
		try {
			File file = new File(resourcePath, "/urls.properties");
			out = new FileOutputStream(file);
			urls.store(out, "URLs");
		} finally {
			IOUtils.closeQuietly(out);
		}
	}
}
