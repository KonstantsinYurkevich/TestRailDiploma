package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Section {
    String name;
    @SerializedName("parent_id")
    String parentId;
    String description;
}
