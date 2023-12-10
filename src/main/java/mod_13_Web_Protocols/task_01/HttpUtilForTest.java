package mod_13_Web_Protocols.task_01;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtilForTest {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    // Task 1.1. POST. Crete new object of UserForTest
    public static UserForHttp sendPOST(URI uriPost, String jsonString)  {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uriPost)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        HttpResponse<String> response = null;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final UserForHttp userHttpPost = GSON.fromJson(response.body(), UserForHttp.class);
        System.out.println("\n----- Task 1.1. POST -----\n  Status:  " + response.statusCode());
        System.out.println("  Headers: " + response.headers());
//        System.out.println("  Body:\n" + httpResponse.body());

        return userHttpPost;
    }

    // Task 1.2. PUT. Update object of UserForTest
    public static UserForHttp sendPUT(URI uriPUT, String jsonStringPut)  {

        // Create request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uriPUT)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonStringPut))
                .build();
        // Update response
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final UserForHttp userHttpPut = GSON.fromJson(httpResponse.body(), UserForHttp.class);
        System.out.println("\n----- Task 1.2. PUT -----\n  Status:  " + httpResponse.statusCode());
        System.out.println("  Headers: " + httpResponse.headers());
//        System.out.println("  Body:\n" + httpResponse.body());

        return userHttpPut;
    }

    // Task 1.3. DELETE. Delete user
    public static void sendDELETE(URI uriPUT, String jsonStringDelete)  {

        // Create request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uriPUT)
                .header("Content-Type", "application/json")
                .method("DELETE",  HttpRequest.BodyPublishers.ofString(jsonStringDelete) )
                .build();
        // Update response
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n----- Task 1.3. DELETE -----\n  Status:  " + httpResponse.statusCode());
        System.out.println("  Headers: " + httpResponse.headers());
//        System.out.println("  Body:\n" + httpResponse.body());

    }


    // Task 1.4. Get. Read object of UserForTest
    public static  HttpResponse<String> sendGET(URI uriGET)  {
        // Create request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uriGET)
//                .header("Content-Type", "application/json")
//                .GET()
                .build();
        // Update response
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("  GET Status:  " + httpResponse.statusCode());
//        System.out.println("  Headers: " + httpResponse.headers());
//        System.out.println("  Body:\n" + httpResponse.body());

        return httpResponse;
    }
}