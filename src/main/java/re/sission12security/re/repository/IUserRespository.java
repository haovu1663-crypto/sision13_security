package re.sission12security.re.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.sission12security.re.entity.User;

public interface IUserRespository extends JpaRepository<User,Long> {
}
