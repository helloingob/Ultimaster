package de.fhl.ultimaster.connection;

import de.fhl.ultimaster.shared.printer.Printer;
import de.fhl.ultimaster.utils.Settings;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.pmw.tinylog.Logger;

public class RestConnection {

    private static RequestConfig getRequestConfig() {
        // @formatter:off
		return RequestConfig.custom().setConnectTimeout(Settings.Connection.TIMEOUT).setConnectionRequestTimeout(Settings.Connection.TIMEOUT).setSocketTimeout(Settings.Connection.TIMEOUT).build();
		// @formatter:on
    }

    public static HttpResponse execute(Printer printer, HttpRequest request) {
        CloseableHttpResponse response = null;
        try {
            HttpHost httpHost = new HttpHost(printer.getHost(), 80, "http");
            CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(getRequestConfig()).build();
            response = httpClient.execute(httpHost, request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
                Logger.debug("Authentication required! Retrying with Digest...");
                DigestScheme digestScheme = extractDigestAuthInfo(response);
                return executeWithDigest(printer, digestScheme, request);
            } else {
                return response;
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        return null;
    }

    private static DigestScheme extractDigestAuthInfo(HttpResponse response) {
        HashMap<String, String> authorizationHeader = parseAuthorizationHeader(response.getFirstHeader("WWW-Authenticate").getValue());
        DigestScheme digestScheme = new DigestScheme();
        digestScheme.overrideParamter("realm", authorizationHeader.get("realm"));
        digestScheme.overrideParamter("nonce", authorizationHeader.get("nonce"));
        digestScheme.overrideParamter("qop", authorizationHeader.get("qop"));
        return digestScheme;
    }

    private static HttpResponse executeWithDigest(Printer printer, DigestScheme digestScheme, HttpRequest request) {
        HttpHost httpHost = new HttpHost(printer.getHost(), 80, "http");
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()), new UsernamePasswordCredentials(printer.getPrinterId(), printer.getPrinterKey()));
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).setDefaultRequestConfig(getRequestConfig()).build();
        CloseableHttpResponse response = null;
        try {
            AuthCache authCache = new BasicAuthCache();
            authCache.put(httpHost, digestScheme);
            HttpClientContext localContext = HttpClientContext.create();
            localContext.setAuthCache(authCache);
            response = httpClient.execute(httpHost, request, localContext);
            return response;
        } catch (Exception e) {
            Logger.error(e);
        }
        return null;
    }

    private static HashMap<String, String> parseAuthorizationHeader(String headerString) {
        String headerStringWithoutScheme = headerString.substring(headerString.indexOf(" ") + 1).trim();
        HashMap<String, String> values = new HashMap<String, String>();
        String keyValueArray[] = headerStringWithoutScheme.split(",");
        for (String keyval : keyValueArray) {
            if (keyval.contains("=")) {
                String key = keyval.substring(0, keyval.indexOf("="));
                String value = keyval.substring(keyval.indexOf("=") + 1);
                values.put(key.trim(), value.replaceAll("\"", "").trim());
            }
        }
        return values;
    }

}
