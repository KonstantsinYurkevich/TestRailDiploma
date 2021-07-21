package modals;

import com.github.javafaker.Faker;
import tests.base.Constants;
import tests.base.ListOfDefectPlugin;
import tests.base.ListOfProjectDefaultAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectFactory {

    public static Project get() {

        Faker faker = new Faker();

        List<String> projectSuiteType = new ArrayList<>();
        projectSuiteType.add(Constants.suiteTypeBaseline.getValue());
        projectSuiteType.add(Constants.suiteTypeAll.getValue());
        projectSuiteType.add(Constants.suiteTypeManage.getValue());

        Random random = new Random();
        int digit = random.nextInt(projectSuiteType.size());

        ListOfProjectDefaultAccess defaultAccessOptions = new ListOfProjectDefaultAccess();
        int digitAccess = random.nextInt(defaultAccessOptions.getSize());

        ListOfDefectPlugin defectPluginOptions = new ListOfDefectPlugin();
        int digitReferencePlugin = random.nextInt(defectPluginOptions.getSize());
        int digitDefectPlugin = random.nextInt(defectPluginOptions.getSize());

        boolean randomBoolean = random.nextBoolean();

        return Project.builder()
                .name(faker.funnyName().name())
                .announcement(faker.harryPotter().spell())
                .testSuiteType(projectSuiteType.get(digit))
                .showAnnouncement(randomBoolean)
                .defaultAccess(defaultAccessOptions.getValue(digitAccess))
                .userAccess(defaultAccessOptions.getValue(digitAccess))
                .defectViewURL(faker.internet().url())
                .defectAddURL(faker.internet().url())
                .defectPlugin(defectPluginOptions.getValue(digitDefectPlugin))
                .referenceAddURL(faker.internet().url())
                .referenceViewURL(faker.internet().url())
                .referencePlugin(defectPluginOptions.getValue(digitReferencePlugin))
                .build();
    }

}
