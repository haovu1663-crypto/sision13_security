package re.sission12security.re.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.sission12security.re.entity.RoleName;
import re.sission12security.re.entity.Role;

import java.util.Optional;
@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName name);
}
