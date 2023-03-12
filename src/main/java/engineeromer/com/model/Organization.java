package engineeromer.com.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int organizationId;

    private String organizationName;

    private String normalizedOrganizationName;

    @Column(unique = true)
    private int registryNumber;

    private int organizationMail;

    private LocalDate yearFounded;

    private int phoneNumber;

    private int companySize;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



}
