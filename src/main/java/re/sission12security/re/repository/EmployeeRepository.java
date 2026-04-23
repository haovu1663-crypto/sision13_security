package re.sission12security.re.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.sission12security.re.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
