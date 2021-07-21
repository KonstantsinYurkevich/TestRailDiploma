package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    String name;
    String announcement;
    @SerializedName("show_announcement")
    boolean showAnnouncement;
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
