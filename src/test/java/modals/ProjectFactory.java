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

        List<String> projectDefectPlugin = new ArrayList<>();
        projectDefectPlugin.add(Enum.DefectPluginAsana.getValue());
        projectDefectPlugin.add(Enum.DefectPluginAssembla.getValue());
        projectDefectPlugin.add(Enum.DefectPluginAxosoftOnTimeREST.getValue());
        projectDefectPlugin.add(Enum.DefectPluginAxosoftOnTimeSOAPOldVersions.getValue());
        projectDefectPlugin.add(Enum.DefectPluginAxosoftV17REST.getValue());
        projectDefectPlugin.add(Enum.DefectPluginAzureDevOpsCLOUD.getValue());
        projectDefectPlugin.add(Enum.DefectPluginAzureDevOpsSERVER.getValue());
        projectDefectPlugin.add(Enum.DefectPluginBitbucket.getValue());
        projectDefectPlugin.add(Enum.DefectPluginBugzilla.getValue());
        projectDefectPlugin.add(Enum.DefectPluginBugzillaREST.getValue());
        projectDefectPlugin.add(Enum.DefectPluginBugzilla_XMLRPC.getValue());
        projectDefectPlugin.add(Enum.DefectPluginEmail.getValue());
        projectDefectPlugin.add(Enum.DefectPluginGitHub.getValue());
        projectDefectPlugin.add(Enum.DefectPluginGitLab.getValue());
        projectDefectPlugin.add(Enum.DefectPluginJIRACloud.getValue());
        projectDefectPlugin.add(Enum.DefectPluginJIRARESTJIRAServer5_7AndLater.getValue());
        projectDefectPlugin.add(Enum.DefectPluginJIRASOAPJIRAServer3_4.getValue());
        projectDefectPlugin.add(Enum.DefectPluginLighthouse.getValue());
        projectDefectPlugin.add(Enum.DefectPluginMantisREST.getValue());
        projectDefectPlugin.add(Enum.DefectPluginMantisSOAP.getValue());
        projectDefectPlugin.add(Enum.DefectPluginManuscript.getValue());
        projectDefectPlugin.add(Enum.DefectPluginPivotalTracker.getValue());
        projectDefectPlugin.add(Enum.DefectPluginRally.getValue());
        projectDefectPlugin.add(Enum.DefectPluginRedmine.getValue());
        projectDefectPlugin.add(Enum.DefectPluginSample.getValue());
        projectDefectPlugin.add(Enum.DefectPluginTrac.getValue());
        projectDefectPlugin.add(Enum.DefectPluginTrello.getValue());
        projectDefectPlugin.add(Enum.DefectPluginVersionOne.getValue());
        projectDefectPlugin.add(Enum.DefectPluginYouTrack.getValue());
        projectDefectPlugin.add(Enum.DefectPluginYouTrack20182.getValue());
        projectDefectPlugin.add(Enum.DefectPluginYouTrack20184.getValue());
        projectDefectPlugin.add(Enum.DefectPluginYouTrack20191.getValue());
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
