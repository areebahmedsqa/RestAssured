import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class REST_Manager {

    public static Response _Response;

    /*================================================================================================================*/
    /**
     * This function will utilize to get the Base URL for the REST service
     *
     * @param ENV
     */
    /*================================================================================================================*/

    private void setBaseUrl(String ENV) {
        switch(ENV){
            case "TEST":
                RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
                break;
            case "PROD":
                RestAssured.baseURI = "https://prodfakerestapi.azurewebsites.net";
                break;
            case "STG":
                RestAssured.baseURI = "https://stagefakerestapi.azurewebsites.net";
                break;

            default:
                System.out.println("endpoint did not rectified");
                break;
        }
    }

    /*================================================================================================================*/

    /**
     * This function will utilize to get the response from GET http method
     *
     * @param env
     * @param endPoint
     * @return
     */
    /*================================================================================================================*/
    public Response _GET(String env, String endPoint, Headers aheader){
        setBaseUrl(env);
        System.out.println("GET "+RestAssured.baseURI + endPoint);
        _Response = given()
                .headers(aheader)
                .when()
                .get(endPoint)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .response();
        return _Response;
    }

    /*================================================================================================================*/
    /**
     * This function will utilize to get the response from POST http method
     *
     * @param env
     * @param endPoint
     */
     /*================================================================================================================*/
    public Response _POST(String env, String endPoint,Object oBody,Headers aHeaders, int statusCode){
        setBaseUrl(env);
        System.out.println("POST "+RestAssured.baseURI + endPoint);

            _Response = given()
                    .contentType(ContentType.JSON)
                    .headers(aHeaders)
                    .body(oBody)
                    .when()
                    .post(endPoint)
                    .then()
                    .assertThat()
                    .contentType(ContentType.JSON)
                    .statusCode(statusCode)
                    .extract()
                    .response();

        return _Response;
    }

    /*================================================================================================================*/
    /**
     * This function will utilize to get the response from DELETE http method
     *
     * @param env
     * @param endPoint
     * @param aHeaders
     * @param statusCode
     * @return Response
     */
    /*================================================================================================================*/
    public Response _DELETE(String env, String endPoint, Headers aHeaders, int statusCode) {
        setBaseUrl(env);
        System.out.println("DELETE " + RestAssured.baseURI + endPoint);

        _Response = given()
                .contentType(ContentType.JSON)
                .headers(aHeaders)
                .when()
                .delete(endPoint)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response();

        return _Response;
    }


}
