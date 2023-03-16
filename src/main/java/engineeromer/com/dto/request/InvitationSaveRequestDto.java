package engineeromer.com.dto.request;

import engineeromer.com.model.Category;
import engineeromer.com.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationSaveRequestDto {

    private String invitationMessage;

    private Category category;

    private int userId;


}
