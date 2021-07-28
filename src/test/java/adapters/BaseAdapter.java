package adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import tests.base.PropertyReader;
import tests.base.TestListener;

import static io.restassured.RestAssured.given;

@Log4j2
@Listeners(TestListener.class)
public class BaseAdapter {

    String baseUrl = System.getenv().getOrDefault("API_BASE_URL", PropertyReader.getProperty("api.base.url"));
    String LOGIN = System.getenv().getOrDefault("TESTRAIL_USER", PropertyReader.getProperty("testrail.user"));
    String PASSWORD = System.getenv().getOrDefault("TESTRAIL_PASSWORD", PropertyReader.getProperty("testrail.password"));

    Gson gsonReader = new Gson();

    @Step("API post request")
    public String post(String body, int status, String url) {
        return
                given().
                        auth().preemptive().basic(LOGIN, PASSWORD).
                        contentType(ContentType.JSON).
                        body(body).
                        log().all().
                        when().
                        post(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    @Step("API post request for delete")
    public String postDelete(int status, String url) {
        return
                given().
                        auth().preemptive().basic(LOGIN, PASSWORD).
                        contentType(ContentType.JSON).
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
                        auth().preemptive().basic(LOGIN, PASSWORD).
                        contentType(ContentType.JSON).
                        log().all().
                        when().
                        get(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    @Step("API post request for close test run")
    public String postCloseRun(int status, String url) {
        return
                given().
                        auth().preemptive().basic(LOGIN, PASSWORD).
                        contentType(ContentType.JSON).
                        log().all().
                        when().
                        post(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
