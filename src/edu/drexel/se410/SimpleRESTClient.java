package edu.drexel.se410;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.json.JSONObject;


/**
 * Simple Rest Client
 *
 * This class can be used to connect to a HTTP REST server that uses JSON data exchange.  There is a single overloaded
 * publically facing method that will automatically determine whether the request is a GET or POST.
 *
 * @author Kyle Weisel (kyle@present.tv)
 * @version 1.0 (Feb. 24, 2015)
 */
public final class SimpleRESTClient {

    public static final int MAX_SUCCESS_CODE = 300;
    private static final String TAG = "SimpleRESTClient";
    private static final Logger log = Logger.getLogger(TAG);
    private static final String USER_AGENT = "Rest Client v. 1.0";

    //private UserContext userContext;

    /**
     * Instantiates a SimpleRESTClient.
     */
    public SimpleRESTClient() {
        log.info(TAG + ": SimpleRESTClient() -> No argument constructor called.");
    }

    /**
     * Makes a request to an HTTP server.
     * @param route is a String denoting a fully qualified route to use to make the request.
     * @return a ResponseWrapper containing the server's response.
     * @throws java.net.MalformedURLException if the route is not a valid URL.
     */
    public final ResponseWrapper makeRequest(final String route) throws MalformedURLException {
        log.info(TAG + ": makeRequest() -> Single argument method called.  This will be a GET request.");
        return this.makeRequest(route, null);
    }

    /**
     * Makes a request to an HTTP server.
     * @param route is a String denoting a fully qualified route to use to make the request.
     * @param payload is a JSONObject that, if not null, will be POSTed.
     * @return a ResponseWrapper containing the server's response.
     * @throws MalformedURLException if the route is not a valid URL.
     */
    public final ResponseWrapper makeRequest(final String route, final JSONObject payload) throws MalformedURLException {

        final boolean isPost = (payload != null);
        final URL url = new URL(route);
        final HttpURLConnection connection;
        final int responseCode;
        final String responseString;
        ResponseWrapper responseObject;

        System.setProperty("http.keepAlive", "false");

        try {

            log.info(TAG + ": makeRequest() -> Ready to create connection to " + url.toString() + ".");
            connection = (HttpURLConnection) url.openConnection();

            // Set connection headers
            log.info(TAG + ": makeRequest() -> Now setting headers for the connection.");
            connection.setRequestMethod(isPost ? "POST" : "GET");
            connection.setDefaultUseCaches(false);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(isPost);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("Content-Type", "application/json");

            // If the request is POST, write the data for the request.
            if(isPost) {
                log.info(TAG + ": makeRequest() -> This is a POST request.  Writing data...");
                final DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeBytes(payload.toString());
                outputStream.flush();
                outputStream.close();
            }

            responseCode = connection.getResponseCode();
            log.info(TAG + ": makeRequest() -> Response code from API came back " + String.valueOf(responseCode) + ".");

            responseString = this.getResponse(connection, (responseCode > MAX_SUCCESS_CODE));
            log.info(TAG + ": makeRequest() -> The raw response from the API was: " + responseString + ".");

            responseObject = new ResponseWrapper(responseCode, responseString);


        } catch (IllegalStateException exception) {
            log.severe(TAG + ": makeRequest() -> Caught an IllegalStateException that says: " + exception.getMessage());
            return null;
        } catch (IOException exception) {
            log.severe(TAG + ": makeRequest() -> Caught an IOException that says: " + exception.getMessage());
            return null;
        }

        return responseObject;

    }

    /**
     * Gets the response from a connection's input stream.
     * @param connection is a HttpsURLConnection object that is already initialized.
     * @param isError is a boolean value which determines what stream to read from (error or regular input).
     * @return a raw String response.
     * @throws IOException if there is an issue opening up the input stream.
     */
    private String getResponse(final HttpURLConnection connection, final boolean isError) throws IOException {

        String response;
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(isError ? connection.getErrorStream() : connection.getInputStream()));
        String inputLine;
        StringBuilder buffResponse = new StringBuilder();
        while ((inputLine = inputStream.readLine()) != null) {
            buffResponse.append(inputLine);
        }
        inputStream.close();
        response = buffResponse.toString();
        return response;

    }

}
