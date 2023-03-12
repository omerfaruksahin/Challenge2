package engineeromer.com.dto.request;

import engineeromer.com.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {

    private String fullName;


    private String email;

    private String normalizedName;

    private Category category;
}
