package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    String title;
    Integer type_id;
    Integer priority_id;
    Integer template_id;
    String estimate;
    String refs;
}
