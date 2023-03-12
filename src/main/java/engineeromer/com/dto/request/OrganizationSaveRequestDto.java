package engineeromer.com.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationSaveRequestDto {

    private String organizationName;

    private String normalizedOrganizationName;

    private int registryNumber;

    private int organizationMail;

    private int phoneNumber;

    private int companySize;
}
