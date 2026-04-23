package re.sission12security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import re.sission12security.re.dto.RegisterResquest;
import re.sission12security.re.entity.Employee;
import re.sission12security.re.entity.User;
import re.sission12security.re.repository.EmployeeRepository;
import re.sission12security.re.repository.IUserRespository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
    private final IUserRespository userRespository;
    public User addUser(RegisterResquest registerResquest) {

        User user = new User();
        user.setUsername(registerResquest.getUsername());
        user.setPassword(passwordEncoder.encode(registerResquest.getPassword()));
        user.setFullName(registerResquest.getFullname());
        userRespository.save(user);
        return user;
    }
}
