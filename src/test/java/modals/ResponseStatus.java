package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    Integer id;
    String name;
    String announcement;
    boolean show_announcements;
    boolean is_completed;
    String completed_on;
    String suite_mode;
    String url;
    Integer depth;
    String description;
    Integer display_order;
    Integer parent_id;
    Integer suite_id;
    String title;
    String error;
}
