package engineeromer.com.controllers;

import engineeromer.com.dto.request.DeleteInvitationRequestDto;
import engineeromer.com.dto.request.InvitationSaveRequestDto;
import engineeromer.com.dto.response.InvitationResponseDto;
import engineeromer.com.service.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("invitation")
public class InvitationControllers {
    private final InvitationService invitationService;

    @PostMapping("/saveInvitation")
    public ResponseEntity<InvitationResponseDto> saveInvitation(@RequestBody InvitationSaveRequestDto invitationSaveRequestDto){
        return new ResponseEntity<>(invitationService.saveInvitation(invitationSaveRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteInvitation")
    public ResponseEntity<Boolean> deleteUser(@RequestBody DeleteInvitationRequestDto deleteInvitationRequestDto){
        return new ResponseEntity<>(invitationService.deleteInvatation(deleteInvitationRequestDto),HttpStatus.OK);
    }

    @GetMapping("/InvitationList")
    public ResponseEntity<List<InvitationResponseDto>> getUserList(){
        return new ResponseEntity<>(invitationService.getAllInvitation(),HttpStatus.OK);
    }

}
