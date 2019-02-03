package de.fhl.ultimaster.api.v1.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;
import org.mockito.Mockito;
import de.fhl.ultimaster.utils.Settings;

public class MockedResponseHandler {

    public static HttpResponse mockResponseWithJsonResponse(String filename, String contentType, int status) {
        return mockResponse(FileLibrary.getFileContent(filename), contentType, status, null);
    }

    public static HttpResponse mockResponseWithJsonResponse(String filename, int status) {
        return mockResponse(FileLibrary.getFileContent(filename), Settings.Connection.CONTENT_TYPE_JSON, status, null);
    }

    public static HttpResponse mockResponseWithJsonResponse(String filename) {
        return mockResponse(FileLibrary.getFileContent(filename), Settings.Connection.CONTENT_TYPE_JSON, HttpStatus.SC_OK, null);
    }

    public static HttpResponse mockResponseWithIntegerResponse(int status) {
        return mockResponse("1", Settings.Connection.CONTENT_TYPE_JSON, status, null);
    }

    public static HttpResponse mockResponseWithDoubleResponse(int status) {
        return mockResponse("1.0", Settings.Connection.CONTENT_TYPE_JSON, status, null);
    }

    public static HttpResponse mockResponseWithStringResponse(int status) {
        return mockResponse("string", Settings.Connection.CONTENT_TYPE_JSON, status, null);
    }

    public static HttpResponse mockResponseWithCustomStringResponse(String input, int status) {
        return mockResponse(input, Settings.Connection.CONTENT_TYPE_JSON, status, null);
    }

    public static HttpResponse mockResponseWithNoResponse(int status) {
        return mockResponse("XXX set.", ContentType.DEFAULT_TEXT.toString(), status, null);
    }

    public static HttpResponse mockResponseWithLocationHeader(String value, int status) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("location", value);
        return mockResponse("?.", ContentType.DEFAULT_TEXT.toString(), status, headers);
    }

    private static HttpResponse mockResponse(String input, String contentType, int status, HashMap<String, String> headers) {
        HttpResponse mockedHttpResponse = mock(HttpResponse.class, Mockito.RETURNS_DEEP_STUBS);
        HttpEntity mockedHttpEntity = mock(HttpEntity.class);
        Header mockedHeader = mock(Header.class);
        HeaderElement mockedHeaderElement = mock(HeaderElement.class);
        HeaderElement[] headerElements = new HeaderElement[] { mockedHeaderElement };

        //Headers
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                when(mockedHttpResponse.getFirstHeader(header.getKey()).getValue()).thenReturn(header.getValue());
            }
        }

        //StatusLine
        when(mockedHttpResponse.getStatusLine().getStatusCode()).thenReturn(status);

        //Content-Type
        when(mockedHttpResponse.getEntity()).thenReturn(mockedHttpEntity);
        when(mockedHttpEntity.getContentType()).thenReturn(mockedHeader);
        when(mockedHeader.getValue()).thenReturn(contentType);

        //EntityUtils
        List<NameValuePair> nameValuePairs = new LinkedList<>();
        nameValuePairs.add(new BasicNameValuePair("Content-type", contentType));
        NameValuePair[] nameValuePairsArr = new NameValuePair[nameValuePairs.size()];
        nameValuePairsArr = nameValuePairs.toArray(nameValuePairsArr);
        when(mockedHeader.getElements()).thenReturn(headerElements);
        when(mockedHeaderElement.getParameters()).thenReturn(nameValuePairsArr);
        when(mockedHeaderElement.getName()).thenReturn("Content-type");
        try {
            InputStream stream = new ByteArrayInputStream(input.getBytes());
            when(mockedHttpEntity.getContent()).thenReturn(stream);
        } catch (UnsupportedOperationException | IOException e) {
            e.printStackTrace();
        }

        return mockedHttpResponse;
    }

}
