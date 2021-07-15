package tests.base;

import java.util.ArrayList;
import java.util.List;

public class ListOfProjectDefaultAccess {

    public List<String> getList() {
        List<String> projectDefaultAccess = new ArrayList<>();
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessGlobal.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessDesigner.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessLead.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessRead.getValue());
        projectDefaultAccess.add(Constants.ProjectAddDefaultAccessTester.getValue());
        return projectDefaultAccess;
    }

    public String getValue(int index) {
        List<String> projectDefaultAccessList = getList();
        return projectDefaultAccessList.get(index);
    }

    public Integer getSize() {
        List<String> projectDefaultAccessList = getList();
        return projectDefaultAccessList.size();
    }
}
