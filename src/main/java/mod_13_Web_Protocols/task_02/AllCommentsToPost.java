package mod_13_Web_Protocols.task_02;

import mod_13_Web_Protocols.task_01.HttpUtilForTest;
import mod_13_Web_Protocols.task_01.HttpUtilUrlComplete;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.http.HttpResponse;

/*
 * All data saved to file named: "user-X-post-Y-comments.json", where Х - userId, Y - postId
 * and for checking print to console
 */

public class AllCommentsToPost {
    private static final String API_TEST_URL = "https://jsonplaceholder.typicode.com";
    private static final String DIRECTORY_JSON_PATH = "src/main/java/mod_13_Web_Protocols/task_02";
    private String userName ;

    public AllCommentsToPost(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
        AllCommentsToPost allComments = new AllCommentsToPost("Karianne"); // for testing purpose
        allComments.getAllCommentsFromLastPostOfUser();
    }

    public void getAllCommentsFromLastPostOfUser() {
        // 1. Get user
        final HttpResponse<String> responseUser = HttpUtilForTest.sendGET(HttpUtilUrlComplete.buildUri(API_TEST_URL, "users", userName));
        JSONObject jsonObjUser = new JSONObject(responseUser.body().replaceAll("\\[|\\]", ""));

        // 2. Get maximum post id of this user
        final HttpResponse<String> responseUserPosts = HttpUtilForTest.sendGET(HttpUtilUrlComplete.buildUri(API_TEST_URL, "users", jsonObjUser.getInt("id"), "posts"));
        JSONArray jsonArrayId = new JSONArray(responseUserPosts.body());
        int maxPostId = getMaxPostId(jsonArrayId, 0);

        // 3.1. Get data for saving to json file:  "user-X-post-Y-comments.json", where Х - userId, Y - postId
        final HttpResponse<String> responsePostsComments = HttpUtilForTest.sendGET(HttpUtilUrlComplete.buildUri(API_TEST_URL, "posts", maxPostId, "comments"));

        JSONArray jsonArrayComments = new JSONArray(responsePostsComments.body());
        String fileName = setFileName(jsonObjUser, maxPostId);
        // Iterate over each object in the array
        for (int i = 0; i < jsonArrayComments.length(); i++) {
            JSONObject jsonObject = jsonArrayComments.getJSONObject(i);
            // Save the JSON object to a file
            saveJsonObjectToFile(jsonObject, fileName);
            System.out.println(jsonObject); // Print for test only
        }
    }

    private static int getMaxPostId(JSONArray jsonArrayId, int maxPostId) {
        for (int i = 0; i < jsonArrayId.length(); i++) {
            int idNumber = jsonArrayId.getJSONObject(i).getInt("id");
            maxPostId = (maxPostId > idNumber) ? maxPostId : idNumber;
        }
        return maxPostId;
    }

    private static String setFileName(JSONObject jsonObjUser, int maxPostId) {
        int userId = jsonObjUser.getInt("id");
        int postId = maxPostId;
        String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
        return fileName;
    }

    private static void saveJsonObjectToFile(JSONObject jsonObject, String fileName) {
        File file = new File(DIRECTORY_JSON_PATH, fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write(jsonObject.toString(2)); // Using 2 spaces for indentation
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
