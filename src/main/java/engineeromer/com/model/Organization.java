package engineeromer.com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


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

    private String organizationMail;

    private LocalDate yearFounded;

    private int phoneNumber;

    private int companySize;

    @ManyToMany(mappedBy = "organizationList",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<User> users = new HashSet<>();



}
