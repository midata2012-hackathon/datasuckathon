package net.jirasystems.ckan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Client {

	private HttpClient httpclient;

	/**
	 * Gets a URL.
	 * 
	 * @return The response body.
	 */
	public String get(String uri) throws ClientProtocolException, IOException {

		httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(uri);

			System.out.println("executing request " + httpget.getURI());

			// Create a response handler
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			return httpclient.execute(httpget, responseHandler);

		} finally {
			httpclient.getConnectionManager().shutdown();
		}

	}

	/**
	 * Gets a URL.
	 * 
	 * @return The response body.
	 */
	public void download(String uri, OutputStream output) throws ClientProtocolException, IOException {

		httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		try {
			HttpGet httpget = new HttpGet(uri);

			System.out.println("downloading " + httpget.getURI());

			response = httpclient.execute(httpget);
			InputStream content = response.getEntity().getContent();

			IOUtils.copy(content, output);

		} finally {
			if (response == null) {
				System.out.println("No response for " + uri);
			} else {
				EntityUtils.consume(response.getEntity());
			}
			httpclient.getConnectionManager().shutdown();
		}

	}

}
