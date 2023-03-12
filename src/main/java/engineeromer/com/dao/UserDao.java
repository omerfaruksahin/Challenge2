package engineeromer.com.dao;

import engineeromer.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByNormalizedName(String normalizedName);

    User findByEmail(String email);

}
