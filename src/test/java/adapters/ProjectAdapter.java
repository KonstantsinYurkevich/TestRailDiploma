package adapters;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import modals.ResponseStatus;

@Log4j2
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
    public ResponseStatus get(String projectId, int codeStatus) {
        int projectID = Integer.parseInt(String.valueOf(projectId));
        String response = get(codeStatus, baseUrl + projectAPIGET + projectID);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after delete project request")
    public ResponseStatus delete(int status, String projectId) {
        int projectID = Integer.parseInt(String.valueOf(projectId));
        String response = postDelete(status, baseUrl + projectAPIDELETE + projectID);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }
}
