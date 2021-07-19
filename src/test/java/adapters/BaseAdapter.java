package adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import tests.base.PropertyReader;

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
        return
                given().
                        header("Authorization", "Basic eW1hY2JyaWRlLmRzY290dHZAY29sZXZpbGxlY2FwaXRhbC5jb206NE41M3pNeHJ6OEdPRS9aUW4vN3g=").
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
        return
                given().
                        header("Authorization", "Basic eW1hY2JyaWRlLmRzY290dHZAY29sZXZpbGxlY2FwaXRhbC5jb206NE41M3pNeHJ6OEdPRS9aUW4vN3g=").
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

        return
                given().
                        header("Authorization", "Basic eW1hY2JyaWRlLmRzY290dHZAY29sZXZpbGxlY2FwaXRhbC5jb206NE41M3pNeHJ6OEdPRS9aUW4vN3g=").
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
}
