package engineeromer.com.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserJoinedAllOrganizationResponseDto {

    private String fullName;

    private List<OrganizationResponseDto> organizationResponseDtos;
 }
