package re.sission12security.re.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import re.sission12security.re.entity.User;

import java.util.Optional;

public interface IUserRespository extends JpaRepository<User,Long> {


    @Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.email = :username OR u.username = :username OR u.phone = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
