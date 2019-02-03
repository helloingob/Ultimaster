package de.fhl.ultimaster.api.v1.auth.request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import de.fhl.ultimaster.api.v1.objects.json.Credential;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class AuthRequestPost {

    /** Request authentication from the printer. This generates new id/key combination that has to be used as username/password in the digest authentication on certain APIs.
     * @param printer Connection information of the printer
     * @param application Name of the application that wants access. Displayed to the user
     * @param user Name of the user who wants access. Displayed to the user when confirming access
     * @param hostName *OPTIONAL* The hostname of the service that is authenticating can be provided for future use
     * @param exclusionKey *OPTIONAL* This key can make sure only one authorisation will exist on the remote printer with this same key, This allows a new user to deauthenticate the old one preventing multiple printer controlling applications to use the printer at the same time. Naturally multiple authorisations can exist if this is omitted
     * @return {@link Credential} */
    public static Credential post(Printer printer, String application, String user, String hostName, String exclusionKey) {
        HttpPost request = new HttpPost(printer.getUrl() + "/auth/request");
        addParameter(request, application, user, hostName, exclusionKey);
        HttpResponse response = RestConnection.execute(printer, request);
        return AuthRequestPostResponseParser.parse(response);
    }

    private static void addParameter(HttpPost request, String application, String user, String hostName, String exclusionKey) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("application", application)
                                                                        .addTextBody("user", user);
        if (hostName != null) {
            builder.addTextBody("host_name", hostName);
        }
        if (exclusionKey != null) {
            builder.addTextBody("exclusion_key", exclusionKey);
        }
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
