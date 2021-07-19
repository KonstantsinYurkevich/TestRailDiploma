package adapters;

import io.qameta.allure.Step;
import modals.Project;
import modals.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {

    private static final String projectAPIPOST = "add_project";
    private static final String projectAPIGET = "get_project/";
    private static final String projectAPIDELETE = "delete_project/";

    @Step("Getting answer from API after create project request")
    public ResponseStatus create(Project project, int status) {
        String response = post(gsonReader.toJson(project), status, baseUrl + projectAPIPOST);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after get project request")
    public ResponseStatus get(Integer projectId, int codeStatus) {
        String response = get(codeStatus, baseUrl + projectAPIGET + projectId);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after delete project request")
    public ResponseStatus delete(int status, Integer projectId) {
        String response = postDelete(status, baseUrl + projectAPIDELETE + projectId);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }
}
