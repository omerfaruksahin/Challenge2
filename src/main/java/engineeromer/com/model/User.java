package engineeromer.com.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String normalizedName;

    private Category category;

    private LocalDate createdDate;

    @OneToOne(mappedBy = "user")
    private Invitation invitation;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "USER_ORGANIZATION",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "organizationId")
    )
    @JsonManagedReference
    private Set<Organization> organizationList = new HashSet<>();

    public void addOrganization(Organization organization){
        organizationList.add(organization);
    }

}
