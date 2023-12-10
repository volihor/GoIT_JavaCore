package mod_13_Web_Protocols.task_01;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * All data and status of transactions print to console
 */

public class HttpTest {
    private static final String API_TEST_URL = "https://jsonplaceholder.typicode.com";
    private static final String FILE_TEST_PATH = "src/main/java/mod_13_Web_Protocols/task_01";

    public static void main(String[] args) throws IOException, InterruptedException {
        String urlSufix = "";
        // Read JSON file
        String jsonStringPost = new String(Files.readAllBytes(Paths.get(FILE_TEST_PATH + "/user.json")));
        String jsonStringPut = new String(Files.readAllBytes(Paths.get(FILE_TEST_PATH + "/userPut.json")));

// *** Task 1 ***

        // Task 1.1. POST. Crete new object of UserForTest
        final UserForHttp userPost = HttpUtilForTest.sendPOST( HttpUtilUrlComplete.buildUri(API_TEST_URL, "users"), jsonStringPost);
//        System.out.println("\n  Users PUT:" + userPost);

        // Task 1.2. PUT. update object of UserForTest
        final UserForHttp userPut = HttpUtilForTest.sendPUT( HttpUtilUrlComplete.buildUri(API_TEST_URL, "users", 3), jsonStringPut);
//        System.out.println("\n  Users PUT:" + userPut);

        // Task 1.3. DELETE. Delete user
        HttpUtilForTest.sendDELETE(HttpUtilUrlComplete.buildUri(API_TEST_URL, "users", 3), jsonStringPut);

        System.out.println("\n----- Task 1.4. GET users (all, byId, byName) -----");
//        // Task 1.4. Get. Read all data from all users
        final HttpResponse<String> userResponseGet = HttpUtilForTest.sendGET( HttpUtilUrlComplete.getAllInPath(API_TEST_URL, "users"));
//        System.out.println("\n  Users, GET all users:\n" + userResponseGet.body());

//        // Task 1.5. Get. Read object by id
        final HttpResponse<String> userResponseGetId = HttpUtilForTest.sendGET( HttpUtilUrlComplete.buildUri(API_TEST_URL, "users", 3));
//        System.out.println("\n  Users, GET user by id:\n" + userResponseGetId.body());

//        // Task 1.6. Get. Read object by username
        final HttpResponse<String> userResponseGetUsername = HttpUtilForTest.sendGET( HttpUtilUrlComplete.buildUri(API_TEST_URL, "users","Karianne"));
//        System.out.println("\n  Users, GET user by username:\n" + userResponseGetUsername.body());

    }
}
