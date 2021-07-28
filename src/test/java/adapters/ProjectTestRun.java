package adapters;

import io.qameta.allure.Step;
import modals.ResponseStatus;
import modals.TestRun;

public class ProjectTestRun extends BaseAdapter {
    private static final String ProjectRunAPIPOST = "add_run/";
    private static final String ProjectRunCloseAPIPOST = "close_run/";

    @Step("Getting answer from API after create test run request")
    public ResponseStatus create(TestRun testRun, int status, int projectId) {
        String response = post(gsonReader.toJson(testRun), status, baseUrl + ProjectRunAPIPOST + projectId);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after close run request")
    public ResponseStatus close(int status, int runId) {
        String response = postCloseRun(status, baseUrl + ProjectRunCloseAPIPOST + runId);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }
}
