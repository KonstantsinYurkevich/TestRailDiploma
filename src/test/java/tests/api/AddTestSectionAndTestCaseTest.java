package tests.api;

import adapters.BaseAdapter;
import adapters.ProjectSection;
import adapters.ProjectTestCase;
import modals.ResponseStatus;
import modals.Section;
import modals.TestCase;
import org.testng.annotations.Test;

import static modals.UserFactory.randomString;
import static org.testng.Assert.assertEquals;

public class AddTestSectionAndTestCaseTest extends BaseAdapter {

    private static final int projectId = 115;

    @Test(description = "Test case section should be added to the project")
    public void sectionShouldBeAddToTheExistingProject() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        assertEquals(responseStatusSection.getName(), section.getName());
    }

    @Test(description = "Test case section should be deleted from the project")
    public void sectionShouldBeDeleted() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        assertEquals(responseStatusSection.getName(), section.getName());
        ResponseStatus responseStatusSectionDelete = new ProjectSection().delete(200, responseStatusSection.getId());
        ResponseStatus getError = new ProjectSection().get(responseStatusSection.getId(), 400);
        assertEquals(getError.getError(), "Field :section_id is not a valid section.");

    }

    @Test(description = "Test case should be added to the project")
    public void testCaseShouldBeAddToTheProjectWithSection() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        TestCase testCase = TestCase.builder()
                .title(randomString())
                .build();
        ResponseStatus responseStatusTestCease = new ProjectTestCase().create(testCase, 200, responseStatusSection.getId());
        assertEquals(responseStatusTestCease.getTitle(), testCase.getTitle());
    }

    @Test(description = "Test case  should be deleted from the project")
    public void testCaseShouldBeDeleted() {
        Section section = Section.builder()
                .name(randomString())
                .build();
        ResponseStatus responseStatusSection = new ProjectSection().create(section, 200, projectId);
        TestCase testCase = TestCase.builder()
                .title(randomString())
                .build();
        ResponseStatus responseStatusTestCeaseCreate = new ProjectTestCase().create(testCase, 200, responseStatusSection.getId());
        assertEquals(responseStatusTestCeaseCreate.getTitle(), testCase.getTitle());
        ResponseStatus responseStatusTestCeaseDelete = new ProjectTestCase().delete(200, responseStatusTestCeaseCreate.getId());
        ResponseStatus getError = new ProjectTestCase().get(responseStatusSection.getId(), 400);
        assertEquals(getError.getError(), "Field :case_id is not a valid test case.");
    }
}
