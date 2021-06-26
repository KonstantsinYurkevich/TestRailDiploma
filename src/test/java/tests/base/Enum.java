package tests.base;

public enum Enum {
    suiteTypeAll("Use a single repository for all cases (recommended)"),
    suiteTypeBaseline("Use a single repository with baseline support"),
    suiteTypeManage("Use multiple test suites to manage cases"),
    ProjectAddTabAccess("projects-tabs-access"),
    ProjectAddTabDefects("projects-tabs-defects"),
    ProjectAddTabReferences("projects-tabs-references"),
    ProjectAddTabUserVariables("users-fields-fields"),
    ProjectAddDefaultAccessGlobal("Global Role"),
    ProjectAddDefaultAccessNo("No Access"),
    ProjectAddDefaultAccessRead("Read-only"),
    ProjectAddDefaultAccessTester("Tester"),
    ProjectAddDefaultAccessDesigner("Designer"),
    ProjectAddDefaultAccessLead("Lead");

    public final String value;

    Enum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
