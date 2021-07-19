package tests.api;

import adapters.ProjectAdapter;
import modals.Project;
import modals.ResponseStatus;
import org.testng.annotations.Test;

import static modals.UserFactory.randomString;
import static org.testng.Assert.assertEquals;

public class AddProjectApiTest {

    @Test(description = "Project should be created API ")
    public void projectShouldBeCreated() {
        Project project = Project.builder()
                .name(randomString())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.getName(), project.getName());
        ResponseStatus actualGet = new ProjectAdapter().get(actual.getId());
        assertEquals(actualGet.getName(), project.getName());
        ResponseStatus delete = new ProjectAdapter().delete(200, actualGet.getId());
    }


}
