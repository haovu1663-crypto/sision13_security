package re.sission12security.re.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import re.sission12security.re.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    @Query("SELECT e FROM Employee e JOIN FETCH e.role WHERE e.email = :username OR e.username = :username")
    Optional<Employee> findByUsername(@Param("username") String username);
}
