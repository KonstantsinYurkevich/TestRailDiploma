package adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import tests.base.PropertyReader;

import java.util.Base64;

import static io.restassured.RestAssured.given;


public class BaseAdapter {
    String user = System.getenv().getOrDefault("TESTRAIL.USER", PropertyReader.getProperty("testrail.user"));
    String password = System.getenv().getOrDefault("TESTRAIL.PASSWORD", PropertyReader.getProperty("testrail.password"));
    String contentType = System.getenv().getOrDefault("API_CONTENT_TYPE", PropertyReader.getProperty("api.content.type"));
    String contentTypeValue = System.getenv().getOrDefault("API_CONTENT_TYPE_VALUE", PropertyReader.getProperty
            ("api.content.type.value"));
    String baseUrl = System.getenv().getOrDefault("API_BASE_URL", PropertyReader.
            getProperty("api.base.url"));

    Gson gsonReader = new Gson();


    @Step("API post request for crate")
    public String post(String body, int status, String url) {
        String auth = getAuthorization(user,password);
        return
                given().
                        header("Authorization", "Basic "+ auth).
                        header(contentType, contentTypeValue).
                        body(body).
                        log().all().
                        when().
                        post(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    @Step("API post request for crate")
    public String post(int status, String url) {
        String auth = getAuthorization(user,password);
        return
                given().
                        header("Authorization", "Basic "+ auth).
                        header(contentType, contentTypeValue).
                        log().all().
                        when().
                        post(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    @Step("API get request")
    public String get(int status, String url) {
        String auth = getAuthorization(user,password);
        return
                given().
                        header("Authorization", "Basic "+ auth).
                        header(contentType, contentTypeValue).
                        log().all().
                        when().
                        get(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    /*@Step("API get authorization token")
    public String token() {
        return "Basic " + DatatypeConverter.printBase64Binary((user + ":" + password).getBytes(StandardCharsets.UTF_8));
    }*/
    private static String getAuthorization(String user, String password)
    {
        try
        {
            return new String(Base64.getEncoder().encode((user + ":" + password).getBytes()));
        }
        catch (IllegalArgumentException e)
        {
            // Not thrown
        }

        return "";
    }
}
