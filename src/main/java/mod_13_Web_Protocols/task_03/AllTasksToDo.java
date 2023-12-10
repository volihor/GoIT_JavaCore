package mod_13_Web_Protocols.task_03;

import mod_13_Web_Protocols.task_01.HttpUtilForTest;
import mod_13_Web_Protocols.task_01.HttpUtilUrlComplete;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/*
* All data print to console
 */

public class AllTasksToDo {
    private static final String API_TEST_URL = "https://jsonplaceholder.typicode.com";
    private final int idUser ;
    public AllTasksToDo(int idUser) {
        this.idUser = idUser;
    }

    public static void main(String[] args) {
        AllTasksToDo allTasksToDo = new AllTasksToDo(3);  // for testing purpose
        allTasksToDo.getAllTasksToDoForUser();
    }

    private void getAllTasksToDoForUser() {
        final HttpResponse<String> responseToDo = HttpUtilForTest.sendGET(HttpUtilUrlComplete.buildUri(API_TEST_URL, "users", idUser, "todos"));

        JSONArray jsonArrayAll = new JSONArray(responseToDo.body());
        JSONObject jsonObjectToDo = new JSONObject();
        // Iterate over each object in the array
        for (int i = 0; i <jsonArrayAll.length(); i++) {
            JSONObject jsonObjI = jsonArrayAll.getJSONObject(i);
            if(!jsonArrayAll.getJSONObject(i).getBoolean("completed")){
                jsonObjectToDo.put("id", jsonObjI.get("id"));
                jsonObjectToDo.put("title", jsonObjI.get("title"));
                System.out.println(jsonObjectToDo);
            }
        }
    }
}
