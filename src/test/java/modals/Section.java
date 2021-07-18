package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Section {
    String name;
    Integer parent_id;
    String description;
}
