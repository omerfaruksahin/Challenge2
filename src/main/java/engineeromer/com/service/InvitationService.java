package engineeromer.com.service;

import engineeromer.com.dao.InvitationDao;
import engineeromer.com.dto.request.DeleteInvitationRequestDto;
import engineeromer.com.dto.request.InvitationSaveRequestDto;
import engineeromer.com.dto.response.InvitationResponseDto;
import engineeromer.com.model.Invitation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InvitationService {

    private final InvitationDao invitationDao;

    private final ModelMapper modelMapper;

    public InvitationResponseDto saveInvitation(InvitationSaveRequestDto invitationSaveRequestDto){
        Invitation invitation = modelMapper.map(invitationSaveRequestDto,Invitation.class);
        invitation.setCreatedDate(LocalDate.now());
        invitationDao.save(invitation);

        return modelMapper.map(invitation,InvitationResponseDto.class);
    }

    public boolean deleteInvatation(DeleteInvitationRequestDto deleteInvitationRequestDto){
        int id = deleteInvitationRequestDto.getInvitationId();
        Invitation invitation = invitationDao.findById(id).orElseThrow();
        invitationDao.deleteById(invitation.getInvitationId());

        return !invitationDao.existsById(id);
    }

    public List<InvitationResponseDto> getAllInvitation(){
        return invitationDao.findAll().stream().map(item->modelMapper.map(item,InvitationResponseDto.class)).toList();
    }

    //public InvitationResponseDto sendInvitationUser()


}
