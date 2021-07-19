package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    int id;
    String name;
    String announcement;
    boolean showAnnouncements;
    boolean isCompleted;
    String completedOn;
    String suiteMode;
    String url;
    int depth;
    String description;
    int displayOrder;
    int parentId;
    int suiteId;
    String title;
    String error;
}
