package tests.base;

import java.util.ArrayList;
import java.util.List;

public class ListOfDefectPlugin {

    public List<String> getList() {
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
        return projectDefectPlugin;
    }

    public String getValue(int index) {
        List<String> projectDefectPluginList = getList();
        return projectDefectPluginList.get(index);
    }

    public Integer getSize() {
        List<String> projectDefectPluginList = getList();
        return projectDefectPluginList.size();
    }
}
