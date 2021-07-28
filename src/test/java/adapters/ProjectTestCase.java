package adapters;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.ResponseStatus;
import modals.TestCase;

@Log4j2
public class ProjectTestCase extends BaseAdapter {

    private static final String testCaseAPIPOST = "add_case/";
    private static final String testCaseAPIGET = "get_case/";
    private static final String testCaseAPIDELETE = "delete_case/";

    @Step("Getting answer from API after create test case request")
    public ResponseStatus create(TestCase testCase, int status, int section_id) {
        String response = post(gsonReader.toJson(testCase), status, baseUrl + testCaseAPIPOST + section_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after get project request")
    public ResponseStatus get(int case_id, int codeStatus) {
        String response = get(codeStatus, baseUrl + testCaseAPIGET + case_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after delete project request")
    public ResponseStatus delete(int status, int case_id) {
        String response = postDelete(status, baseUrl + testCaseAPIDELETE + case_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    public ResponseStatus testCaseRunStatus(TestCase testCase, int status, int runId, int case_id) {
        String response = post(gsonReader.toJson(testCase), status, baseUrl + "add_result_for_case/" + runId + "/" + case_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }
}
