package net.jirasystems.ckan;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.jirasystems.ckan.visualisation.Link;
import net.jirasystems.ckan.visualisation.Node;
import net.jirasystems.ckan.visualisation.Nodes;
import net.jirasystems.resourceutil.ResourceUtilCsv;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

public class CrossMatcher {

	private static final String resourcePath = "/files";
	private static final String filesPath = "/home/david/workspace/ckan/src/main/resources" + resourcePath;

	public static void main(String[] args) throws IOException {

		Map<String, List<String>> keys = new HashMap<String, List<String>>();

		// Get CSV files:
		File folder = new File(filesPath);
		File[] csvs = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return StringUtils.equalsIgnoreCase("csv", FilenameUtils.getExtension(filename));
			}
		});
		int totalRows = 0;
		for (File file : csvs) {
			System.out.println(file);
			System.out.println(file.exists());

			List<Map<String, String>> csv = ResourceUtilCsv.getCsv(resourcePath + "/" + file.getName());
			totalRows += csv.size();
			if (csv.size() > 0) {
				Map<String, String> columns = csv.get(0);
				for (String column : columns.keySet()) {
					String name = standardisedHeading(column);
					if (keys.keySet().contains(name)) {
						List<String> files = keys.get(name);
						if (!files.contains(file.getName())) {
							System.out.println("Matched heading: " + name);
							keys.get(name).add(file.getName());
						}
					} else {
						List<String> files = new ArrayList<String>();
						files.add(file.getName());
						keys.put(name, files);
					}
				}
			}

		}

		List<String> sorted = new ArrayList<String>(keys.keySet());
		List<String> summary = new ArrayList<String>();
		Collections.sort(sorted);
		ArrayList<Node> headings = new ArrayList<Node>();
		for (String heading : sorted) {
			List<String> list = keys.get(heading);
			if (list.size() > 1) {
				summary.add(pad(list.size()) + ": " + heading);
				System.out.println(heading + " : " + list);
				Properties urls = ResourceUtilCsv.getProperties("/urls.properties");
				for (String filename : list) {
					String id = FilenameUtils.getBaseName(filename);
					System.out.println(" - " + urls.getProperty(id, id));
				}
				if (!StringUtils.isEmpty(heading)) {
					Node node = new Node();
					node.setGroup(list.size());
					node.setName(heading);
					headings.add(node);
				}
			}
		}
		// Write to file for visualisation:
		Nodes nodes = new Nodes();
		nodes.setNodes(headings.toArray(new Node[] {}));
		nodes.setLinks(new Link[] {});
		String json = new Gson().toJson(nodes);
		System.out.println(json);
		FileUtils.writeStringToFile(new File("/var/lib/tomcat6/webapps/ROOT/headings.json"), json);

		// Screen 2:
		System.out.println("Computing screen 2...");
		ArrayList<Node> map = new ArrayList<Node>(headings);
		ArrayList<Link> mapLinks = new ArrayList<Link>();
		for (File file : csvs) {

			List<Map<String, String>> csv = ResourceUtilCsv.getCsv(resourcePath + "/" + file.getName());
			if (csv.size() > 0) {
				Map<String, String> columns = csv.get(0);
				for (String column : columns.keySet()) {
					String name = standardisedHeading(column);
					Node heading = new Node();
					heading.setName(name);

					if (!StringUtils.isEmpty(name)) {
						Node node = new Node();
						node.setGroup(0);
						node.setName(file.getName());
						map.add(node);

						Link link = new Link();
						link.setSource(map.indexOf(node));
						link.setTarget(map.indexOf(heading));
						link.setValue(1);
						if (link.getSource() >= 0 && link.getTarget() >= 0) {
							mapLinks.add(link);
						}
					}
				}
			}
		}
		// Write to file for visualisation:
		Nodes mapNodes = new Nodes();
		mapNodes.setNodes(map.toArray(new Node[] {}));
		mapNodes.setLinks(mapLinks.toArray(new Link[] {}));
		json = new Gson().toJson(mapNodes);
		System.out.println(json);
		FileUtils.writeStringToFile(new File("/var/lib/tomcat6/webapps/ROOT/map.json"), json);
		Nodes fromJson = new Gson().fromJson(json, Nodes.class);
		System.out.println(fromJson);
		for (Link link : fromJson.getLinks()) {
			if (link.getSource() >= fromJson.getNodes().length || link.getTarget() >= fromJson.getNodes().length) {
				System.out.println("Smellypants");
			}
		}

		Collections.sort(summary);
		for (String line : summary) {
			System.out.println(line);
		}

		System.out.println("Total rows: " + totalRows);
	}

	private static String pad(int size) {
		String result = String.valueOf(size);
		while (result.length() < 3) {
			result = 0 + result;
		}
		return result;
	}

	private static String standardisedHeading(String heading) {
		StringBuilder result = new StringBuilder();

		for (char c : heading.toCharArray()) {
			if (Character.isJavaIdentifierPart(c)) {
				result.append(String.valueOf(c).toLowerCase());
			}
		}

		return result.toString();
	}

}
