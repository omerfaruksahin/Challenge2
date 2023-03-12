package engineeromer.com.dao;

import engineeromer.com.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationDao extends JpaRepository<Invitation,Integer> {
}
