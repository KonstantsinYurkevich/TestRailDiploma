package adapters;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.ResponseStatus;
import modals.Section;

@Log4j2
public class ProjectSection extends BaseAdapter {

    private static final String projectSectionAPIPOST = "add_section/";
    private static final String projectSectionAPIGET = "get_section/";
    private static final String projectSectionAPIDELETE = "delete_section/";

    @Step("Getting answer from API after create project request")
    public ResponseStatus create(Section section, int status, int project_id) {
        String response = post(gsonReader.toJson(section), status, baseUrl + projectSectionAPIPOST + project_id);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after get project request")
    public ResponseStatus get(int sectionId, int codeStatus) {
        String response = get(codeStatus, baseUrl + projectSectionAPIGET + sectionId);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after delete project request")
    public ResponseStatus delete(int status, int sectionId) {
        String response = postDelete(status, baseUrl + projectSectionAPIDELETE + sectionId);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }
}
