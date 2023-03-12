package engineeromer.com.dao;

import engineeromer.com.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDao extends JpaRepository<Organization,Integer> {
    Organization findByRegistryNumber(int registryNumber);
}
