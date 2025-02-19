import io.restassured.http.Headers;
import io.restassured.http.Header;
import java.util.HashMap;
import java.util.Map;

public class Header_Manager {

    // Method to get default headers with an optional Authorization header
    public static Headers getDefaultHeaders(boolean includeAuth) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Accept", "application/json");

        if (includeAuth) {
            headerMap.put("Authorization", "Bearer your_token_here");  // Example token
        }

        return convertToHeaders(headerMap);
    }

    // Method to return custom headers (Dynamic)
    public static Headers getCustomHeaders(Map<String, String> customHeaders) {
        return convertToHeaders(customHeaders);
    }

    // Utility method to convert HashMap to RestAssured Headers
    private static Headers convertToHeaders(Map<String, String> headerMap) {
        return new Headers(headerMap.entrySet().stream()
                .map(entry -> new Header(entry.getKey(), entry.getValue()))
                .toList());
    }
}
