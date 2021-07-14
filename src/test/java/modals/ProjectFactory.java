package modals;

import com.github.javafaker.Faker;
import tests.base.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectFactory {
    public static Project get() {

        //TODO вкурить апликабельно ли https://www.tabnine.com/code/java/methods/com.github.javafaker.Faker/options
        Faker faker = new Faker();
        List<String> projectSuiteType = new ArrayList<>();
        projectSuiteType.add(Constants.suiteTypeBaseline.getValue());
        projectSuiteType.add(Constants.suiteTypeAll.getValue());
        projectSuiteType.add(Constants.suiteTypeManage.getValue());
        Random random = new Random();
        int digit = random.nextInt(projectSuiteType.size());

        List<String> projectDefaultAccess = new ArrayList<>();
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessGlobal.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessDesigner.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessLead.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessRead.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessTester.getValue());
        int digitAccess = random.nextInt(projectDefaultAccess.size());

        List<String> projectDefectPlugin = new ArrayList<>();
        projectDefectPlugin.add(Constants.DefectPluginAsana.getValue());
        projectDefectPlugin.add(Constants.DefectPluginAssembla.getValue());
        projectDefectPlugin.add(Constants.DefectPluginAxosoftOnTimeREST.getValue());
        projectDefectPlugin.add(Constants.DefectPluginAxosoftOnTimeSOAPOldVersions.getValue());
        projectDefectPlugin.add(Constants.DefectPluginAxosoftV17REST.getValue());
        projectDefectPlugin.add(Constants.DefectPluginAzureDevOpsCLOUD.getValue());
        projectDefectPlugin.add(Constants.DefectPluginAzureDevOpsSERVER.getValue());
        projectDefectPlugin.add(Constants.DefectPluginBitbucket.getValue());
        projectDefectPlugin.add(Constants.DefectPluginBugzilla.getValue());
        projectDefectPlugin.add(Constants.DefectPluginBugzillaREST.getValue());
        projectDefectPlugin.add(Constants.DefectPluginBugzilla_XMLRPC.getValue());
        projectDefectPlugin.add(Constants.DefectPluginEmail.getValue());
        projectDefectPlugin.add(Constants.DefectPluginGitHub.getValue());
        projectDefectPlugin.add(Constants.DefectPluginGitLab.getValue());
        projectDefectPlugin.add(Constants.DefectPluginJIRACloud.getValue());
        projectDefectPlugin.add(Constants.DefectPluginJIRARESTJIRAServer5_7AndLater.getValue());
        projectDefectPlugin.add(Constants.DefectPluginJIRASOAPJIRAServer3_4.getValue());
        projectDefectPlugin.add(Constants.DefectPluginLighthouse.getValue());
        projectDefectPlugin.add(Constants.DefectPluginMantisREST.getValue());
        projectDefectPlugin.add(Constants.DefectPluginMantisSOAP.getValue());
        projectDefectPlugin.add(Constants.DefectPluginManuscript.getValue());
        projectDefectPlugin.add(Constants.DefectPluginPivotalTracker.getValue());
        projectDefectPlugin.add(Constants.DefectPluginRally.getValue());
        projectDefectPlugin.add(Constants.DefectPluginRedmine.getValue());
        projectDefectPlugin.add(Constants.DefectPluginSample.getValue());
        projectDefectPlugin.add(Constants.DefectPluginTrac.getValue());
        projectDefectPlugin.add(Constants.DefectPluginTrello.getValue());
        projectDefectPlugin.add(Constants.DefectPluginVersionOne.getValue());
        projectDefectPlugin.add(Constants.DefectPluginYouTrack.getValue());
        projectDefectPlugin.add(Constants.DefectPluginYouTrack20182.getValue());
        projectDefectPlugin.add(Constants.DefectPluginYouTrack20184.getValue());
        projectDefectPlugin.add(Constants.DefectPluginYouTrack20191.getValue());
        int digitDefectPlugin = random.nextInt(projectDefaultAccess.size());
        int digitReferencePlugin = random.nextInt(projectDefaultAccess.size());


        boolean randomBoolean = random.nextBoolean();
        return Project.builder()
                .name(faker.funnyName().name())
                .announcement(faker.harryPotter().spell())
                .testSuiteType(projectSuiteType.get(digit))
                .showTheAnnouncement(randomBoolean)
                .defaultAccess(projectDefaultAccess.get(digitAccess))
                .userAccess(projectDefaultAccess.get(digitAccess))
                .defectViewURL(faker.internet().url())
                .defectAddURL(faker.internet().url())
                .defectPlugin(projectDefectPlugin.get(digitDefectPlugin))
                .referenceAddURL(faker.internet().url())
                .referenceViewURL(faker.internet().url())
                .referencePlugin(projectDefectPlugin.get(digitReferencePlugin))
                .build();
    }

}
