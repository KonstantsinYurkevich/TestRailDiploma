package adapters;

import io.qameta.allure.Step;
import modals.ResponseStatus;
import modals.TestCase;

public class ProjectTestCase extends BaseAdapter {

    private static final String testCaseAPIPOST = "add_case/";
    private static final String testCaseAPIGET = "get_case/";
    private static final String testCaseAPIDELETE = "delete_case/";

    @Step("Getting answer from API after create test case request")
    public ResponseStatus create(TestCase testCase, int status, Integer section_id) {
        String response = post(gsonReader.toJson(testCase), status, baseUrl + testCaseAPIPOST + section_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after get project request")
    public ResponseStatus get(int case_id, int codeStatus) {
        String response = get(codeStatus, baseUrl + testCaseAPIGET + case_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after delete project request")
    public ResponseStatus delete(int status, Integer case_id) {
        String response = postDelete(status, baseUrl + testCaseAPIDELETE + case_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }
}
