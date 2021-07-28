package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    String id;
    String name;
    String announcement;
    @SerializedName("show_announcements")
    boolean showAnnouncements;
    @SerializedName("is_completed")
    boolean isCompleted;
    @SerializedName("completed_on")
    String completedOn;
    @SerializedName("suite_mode")
    String suiteMode;
    String url;
    @SerializedName("section_id")
    String sectionId;
    @SerializedName("priority_id")
    String priorityId;
    @SerializedName("template_id")
    String templateId;
    @SerializedName("type_id")
    String typeId;
    @SerializedName("milestone_id")
    String milestoneId;
    String refs;
    String depth;
    String description;
    @SerializedName("display_order")
    String displayOrder;
    @SerializedName("parent_id")
    String parentId;
    @SerializedName("suite_id")
    String suiteId;
    String title;
    String error;
}
