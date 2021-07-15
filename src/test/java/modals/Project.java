package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    String name;
    String announcement;
    boolean showTheAnnouncement;
    String testSuiteType;
    String defaultAccess;
    String userAccess;
    String defectViewURL;
    String defectAddURL;
    String defectPlugin;
    String referenceViewURL;
    String referenceAddURL;
    String referencePlugin;

}
