package modals;

import com.github.javafaker.Faker;
import tests.base.Enum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectFactory {
    public static Project get() {

        Faker faker = new Faker();
        List<String> projectSuiteType = new ArrayList<>();
        projectSuiteType.add(Enum.suiteTypeBaseline.getValue());
        projectSuiteType.add(Enum.suiteTypeAll.getValue());
        projectSuiteType.add(Enum.suiteTypeManage.getValue());
        Random random = new Random();
        int digit = random.nextInt(projectSuiteType.size());

        List<String> projectDefaultAccess = new ArrayList<>();
        projectDefaultAccess.add(Enum.ProjectAddDefaultAccessGlobal.getValue());
        projectDefaultAccess.add(Enum.ProjectAddDefaultAccessDesigner.getValue());
        projectDefaultAccess.add(Enum.ProjectAddDefaultAccessLead.getValue());
        projectDefaultAccess.add(Enum.ProjectAddDefaultAccessNo.getValue());
        projectDefaultAccess.add(Enum.ProjectAddDefaultAccessRead.getValue());
        projectDefaultAccess.add(Enum.ProjectAddDefaultAccessTester.getValue());
        int digitAccess = random.nextInt(projectDefaultAccess.size());


        boolean randomBoolean = random.nextBoolean();
        return Project.builder()
                .name(faker.funnyName().name())
                .announcement(faker.harryPotter().spell())
                .testSuiteType(projectSuiteType.get(digit))
                .showTheAnnouncement(randomBoolean)
                .defaultAccess(projectDefaultAccess.get(digitAccess))
                .build();
    }

}
