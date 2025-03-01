import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Activity_Test extends Test_Data {

    private REST_Manager RM = null;
    private Header_Manager HM = null;
    public String env = "TEST";

    public Activity_Test() {
       RM = new REST_Manager();
    }

    @Test
    public void GetActivity(){

        // Call GET Request
        REST_Manager._Response = RM._GET(env,
                RestAPI_EP.ENDPOINTS.EP_GETACTIVITIES.strGet_URL(),
                HM.getDefaultHeaders(false)
        );

        System.out.println("Response Body: " + REST_Manager._Response.asString());
    }

    @Test(dataProvider = "DataForPost")
    public void PostActivity(String title, String dueDate, String completed) {

        JSONObject request = new JSONObject();
        request.put("title", title);
        request.put("dueDate", dueDate);
        request.put("completed", completed);

        System.out.println("Request body " + request);

        REST_Manager._Response = RM._POST(env,
                RestAPI_EP.ENDPOINTS.EP_POSTACTIVITIES.strGet_URL(),
                request,
                HM.getDefaultHeaders(false),
                200);

        // Print Response
        System.out.println("Response Body: " + REST_Manager._Response.asString());
    }

    @Test
    public void PutActivity() {
        // Request body for creating an activity
        String requestBody = "{\"id\":10 ,\"title\": \"Activity 10\", \"dueDate\": \"2025-12-31T00:00:00.000Z\", \"completed\": true }";

        REST_Manager._Response = RM._POST(env,
                RestAPI_EP.ENDPOINTS.EP_PUTACTIVITYBYID.strGet_URL(),
                requestBody,
                HM.getDefaultHeaders(false),
                200);

        // Print Response
        System.out.println("Response Body: " + REST_Manager._Response.asString());
    }

    @Test
    public void GetActivityById() {
        // Request body for creating an activity
        int activityid = 3;

        REST_Manager._Response = RM._GET(env,
                RestAPI_EP.ENDPOINTS.EP_DELETEACTIVITYBYID.strGet_URL() + activityid,
                HM.getDefaultHeaders(false)
        );

        // Print Response
        System.out.println("Response Body: " + REST_Manager._Response.asString());
    }

    @Test
    public void DeleteActivity() {
        // Request body for creating an activity
        int activityid = 10;

        REST_Manager._Response = RM._DELETE(env,
                RestAPI_EP.ENDPOINTS.EP_DELETEACTIVITYBYID.strGet_URL() + activityid,
                HM.getDefaultHeaders(false),
                200);

        // Print Response
        System.out.println("Response Body: " + REST_Manager._Response.asString());
    }
}
