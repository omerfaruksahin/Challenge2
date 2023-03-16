package engineeromer.com.service;

import engineeromer.com.dao.OrganizationDao;
import engineeromer.com.dto.request.DeleteOrganizationRequestDto;
import engineeromer.com.dto.request.OrganizationSaveRequestDto;
import engineeromer.com.dto.response.OrganizationResponseDto;
import engineeromer.com.model.Organization;
import engineeromer.com.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrganizationService {

    private final OrganizationDao organizationDao;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public OrganizationResponseDto saveOrganization(OrganizationSaveRequestDto organizationSaveRequestDto){
        Organization organization = modelMapper.map(organizationSaveRequestDto,Organization.class);
        organization.setYearFounded(LocalDate.now());
        organizationDao.save(organization);

        return modelMapper.map(organization,OrganizationResponseDto.class);
    }

    public boolean deleteOrganization(DeleteOrganizationRequestDto deleteOrganizationRequestDto){
        int id = deleteOrganizationRequestDto.getOrganizationId();
        Organization organization = organizationDao.findById(id).orElseThrow();
        organizationDao.deleteById(organization.getOrganizationId());

        return !organizationDao.existsById(id);
    }

    public List<OrganizationResponseDto> getAllOrganization(){
        return organizationDao.findAll().stream().map(item->modelMapper.map(item,OrganizationResponseDto.class)).toList();
    }


    public OrganizationResponseDto findOrganizationAccordingToEmail(int registryNumber) {
        Organization organization = organizationDao.findByRegistryNumber(registryNumber);
        return modelMapper.map(organization,OrganizationResponseDto.class);
    }

    public Organization findById(int organizationId){
        return organizationDao.findById(organizationId).orElseThrow();
    }
}
