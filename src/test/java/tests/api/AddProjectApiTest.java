package tests.api;

import adapters.BaseAdapter;
import adapters.ProjectAdapter;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import modals.ResponseStatus;
import org.testng.annotations.Test;

import static modals.UserFactory.randomString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Log4j2
public class AddProjectApiTest extends BaseAdapter {


    @Test(description = "Project should be created with API request", testName = "2023")
    public void projectShouldBeCreated() {
        Project project = Project.builder()
                .name(randomString())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.getName(), project.getName());
        assertFalse(actual.isShowAnnouncements());
        ResponseStatus actualGet = new ProjectAdapter().get(actual.getId(), 200);
        assertEquals(actualGet.getName(), project.getName());
        new ProjectAdapter().delete(200, actualGet.getId());
        ResponseStatus getError = new ProjectAdapter().get(actual.getId(), 400);
        assertEquals(getError.getError(), "Field :project_id is not a valid or accessible project.");
    }


}
