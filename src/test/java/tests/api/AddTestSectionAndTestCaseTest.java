package tests.api;

import adapters.BaseAdapter;
import adapters.ProjectSection;
import adapters.ProjectTestCase;
import lombok.extern.log4j.Log4j2;
import modals.ResponseStatus;
import modals.Section;
import modals.TestCase;
import org.testng.annotations.Test;

import static modals.UserFactory.randomString;
import static modals.UserFactory.randomStringInt;
import static org.testng.Assert.assertEquals;

@Log4j2
public class AddTestSectionAndTestCaseTest extends BaseAdapter {

    private static final int projectId = 1;

    @Test(description = "Section should be added with API request", testName = "2024")
    public void sectionShouldBeAddToTheExistingProject() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        assertEquals(responseStatusSection.getName(), section.getName());
    }

    @Test(description = "Section should be deleted with API request", testName = "2025")
    public void sectionShouldBeDeleted() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        assertEquals(responseStatusSection.getName(), section.getName());
        new ProjectSection().delete(200, Integer.parseInt(responseStatusSection.getId()));
        ResponseStatus getError = new ProjectSection().get(Integer.parseInt(responseStatusSection.getId()), 400);
        assertEquals(getError.getError(), "Field :section_id is not a valid section.");

    }

    @Test(description = "Test case should be added with API request", testName = "2027")
    public void testCaseShouldBeAddToTheProjectWithSection() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        TestCase testCase = TestCase.builder()
                .title(randomString())
                .priorityId(randomStringInt())
                .build();
        ResponseStatus responseStatusTestCease = new ProjectTestCase().create(testCase, 200, Integer.parseInt(responseStatusSection.getId()));
        assertEquals(responseStatusTestCease.getTitle(), testCase.getTitle());
        assertEquals(responseStatusTestCease.getPriorityId(), testCase.getPriorityId());
    }

    @Test(description = "Test case should be deleted with API request", testName = "2028")
    public void testCaseShouldBeDeleted() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        TestCase testCase = TestCase.builder()
                .title(randomString())
                .build();
        ResponseStatus responseStatusTestCeaseCreate = new ProjectTestCase().create(testCase, 200, Integer.parseInt(responseStatusSection.getId()));
        assertEquals(responseStatusTestCeaseCreate.getTitle(), testCase.getTitle());
        new ProjectTestCase().delete(200, Integer.parseInt(responseStatusTestCeaseCreate.getId()));
        ResponseStatus getError = new ProjectTestCase().get(Integer.parseInt(responseStatusTestCeaseCreate.getId()), 400);
        assertEquals(getError.getError(), "Field :case_id is not a valid test case.");
    }

}
