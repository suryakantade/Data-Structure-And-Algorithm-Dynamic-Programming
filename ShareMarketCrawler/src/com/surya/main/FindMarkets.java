package com.surya.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class FindMarkets {

	List<String> urls = new ArrayList<>();
	List<String> expressions = new ArrayList<>();
	Map<String, Map<String, String>> responseAttributes = new HashMap<>();
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static String FILE_HEADER = "";
	public String currentUrl = null;

	public static void main(String[] args) throws Exception {
		FindMarkets fm = new FindMarkets();
		fm.initiateUrls();
		fm.initiateRegx();
		progressPercentage(5, 100);
		progressPercentage(10, 100);
		int count = 0;

		try {
			for (String url : fm.getUrls()) {
				count++;
				fm.currentUrl = url;
				String pageDetails = getPageDetails(url);
				float prog = (float) count / (float) fm.getUrls().size();
				progressPercentage((int) ((prog) * 80) + 10, 100);
				if (null != pageDetails) {
					Map<String, String> urlDetails = new HashMap<>();
					for (String expression : fm.getExpressions()) {
						urlDetails.put(expression.substring(0, expression.indexOf(':')).trim(),
								null != fetchElementValues(pageDetails,
										expression.substring(expression.indexOf(':') + 1).trim())
								? fetchElementValues(pageDetails,
										expression.substring(expression.indexOf(':') + 1).trim())
										.replace(",", "")
										: null);

					}
					fm.responseAttributes.put(url.split("/")[url.split("/").length - 1], urlDetails);
				}
			}
			progressPercentage(100, 100);
			fm.writeToCsv(fm.responseAttributes);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("issue occured for " + fm.currentUrl);
		}
	}

	public static String getPageDetails(String uri) {

		// configure the SSLContext with a TrustManager
		SSLContext ctx;
		try {
			ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
			SSLContext.setDefault(ctx);

			URL url = new URL(uri);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			conn.disconnect();
			// System.out.println(sb);
			return new String(sb);
			// Durability Score :

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String fetchElementValues(String data, String pattern) {
		// the pattern we want to search for
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(data);
		String codeGroup = null;
		// if we find a match, get the group
		if (m.find()) {
			// get the matching group
			codeGroup = m.group(1);
			// print the group
			// System.out.format("" + codeGroup);

		}
		return null != codeGroup ? codeGroup.trim() : null;
	}

	public void initiateUrls() {
		BufferedReader reader = null;
		try {
			/*
			 * Path path = FileSystems.getDefault().getPath(".");
			 * path.getFileSystem().getRootDirectories();
			 * 
			 * File dd = new File("");
			 */
			File file = new File("urls.txt");
			reader = new BufferedReader(new FileReader(file));
			String url = reader.readLine();
			while (null != url) {
				this.urls.add(url.trim());
				url = reader.readLine();
			}
			System.out.println("URLs are loaded from config...");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("urls.txt file is not found in current directory."
					+ "Please create a file called \"urls.txt\" and add all urls you want to crawl.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured while reading your urls.txt file, please check file format");
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("exception occured while closing buffered reader!!");
				}
			}
		}

	}

	public void initiateRegx() {
		BufferedReader reader = null;
		try {
			File file = new File("expressionToFetch.txt");
			reader = new BufferedReader(new FileReader(file));
			String expression = reader.readLine();
			while (null != expression) {
				this.expressions.add(expression.trim());
				expression = reader.readLine();
			}
			System.out.println("Expressions are loaded from config...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("expressionToFetch.txt file is not found in current directory."
					+ "Please create a file called \"expressionToFetch.txt\" and add all urls you want to crawl.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured while reading your expressionToFetch.txt file, please check file format");
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("exception occured while closing buffered reader!!");
				}
			}
		}
	}

	public void writeToCsv(Map<String, Map<String, String>> companyStockDetails) {

		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter("Stockdata.csv");

			// Write the CSV file header

			// Add a new line separator after the header

			fileWriter.append(NEW_LINE_SEPARATOR);
			FILE_HEADER += "company Name";
			for (String company : companyStockDetails.keySet()) {

				Map<String, String> companyDetl = companyStockDetails.get(company);
				for (String attribute : companyDetl.keySet()) {
					FILE_HEADER += COMMA_DELIMITER + attribute;
				}
				break;
			}
			fileWriter.append(FILE_HEADER.toString());
			// Write a new student object list to the CSV file
			for (String company : companyStockDetails.keySet()) {
				System.out.println("company : " + company);
				Map<String, String> companyDetl = companyStockDetails.get(company);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(company);
				for (String attribute : companyDetl.keySet()) {
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(companyDetl.get(attribute));
					System.out.println(attribute + " : " + companyDetl.get(attribute));
				}
				System.out.println("----------------------------------------------");
			}

			System.out.println("\nStockdata file was created successfully !!!");

		} catch (Exception e) {

			System.out.println("Error while populating Stockdata !!!");

			e.printStackTrace();

		} finally {

			try {

				fileWriter.flush();

				fileWriter.close();

			} catch (IOException e) {

				System.out.println("Error while flushing/closing fileWriter !!!");

				e.printStackTrace();

			}

		}

	}

	public static void progressPercentage(int remain, int total) {
		if (remain > total) {
			throw new IllegalArgumentException();
		}
		System.out.println();
		System.out.print(String.format("\033[H\033[2J"));
		int maxBareSize = 10; // 10unit for 100%
		int remainProcent = ((100 * remain) / total) / maxBareSize;
		char defaultChar = '-';
		String icon = "*";
		String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
		StringBuilder bareDone = new StringBuilder();
		bareDone.append("[");
		for (int i = 0; i < remainProcent; i++) {
			bareDone.append(icon);
		}
		String bareRemain = bare.substring(remainProcent, bare.length());
		System.out.print("" + bareDone + bareRemain + " " + remain  + "%");
		if (remain == total) {
			System.out.print("\n");
		}
	}

	public List<String> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<String> expressions) {
		this.expressions = expressions;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	private static class DefaultTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
}
