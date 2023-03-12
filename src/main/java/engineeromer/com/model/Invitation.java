package engineeromer.com.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invitation")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invitationId;

    private String invitationMessage;

    private LocalDate createdDate;

    private Category category;

    @OneToOne
    @JoinColumn(name = "user_Id",referencedColumnName = "userId")
    private User user;
}
