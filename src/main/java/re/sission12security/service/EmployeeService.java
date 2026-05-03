package re.sission12security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import re.sission12security.re.config.jwt.JwtService;
import re.sission12security.re.dto.RegisterResquest;
import re.sission12security.re.dto.request.EmployeeRequest;
import re.sission12security.re.dto.request.FormLogin;
import re.sission12security.re.dto.request.FormRegister;
import re.sission12security.re.dto.respone.EmployeeRespone;
import re.sission12security.re.dto.respone.JwtEmployeeRespone;
import re.sission12security.re.dto.respone.JwtRespone;
import re.sission12security.re.entity.Employee;
import re.sission12security.re.entity.Role;
import re.sission12security.re.entity.RoleName;
import re.sission12security.re.entity.User;
import re.sission12security.re.repository.EmployeeRepository;
import re.sission12security.re.repository.IRoleRepository;
import re.sission12security.re.repository.IUserRespository;
import re.sission12security.re.upload.LoadAvartar;
import re.sission12security.re.upload.UploadService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final IRoleRepository roleRepository;
    private final JwtService jwtService;
    private final LoadAvartar  loadAvartar;
    private final UploadService uploadService;

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

    // login
    public JwtEmployeeRespone login(FormLogin formLogin) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            formLogin.getUsername(), formLogin.getPassword()
                    )
            );
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Tài khoản hoặc mật khẩu sai");
        }
        Employee employee = employeeRepository.findByUsername(formLogin.getUsername())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy employee"));
        return JwtEmployeeRespone.builder()
                .username(employee.getUsername())
                .type("Bearer")
                .accessToken(jwtService.generateAccessToken(employee.getUsername()))
                .build();
    }
     // dk
    public void register(FormRegister formRegister) throws IOException {
        Employee employee = new Employee();
        employee.setUsername(formRegister.getUsername());
        employee.setPassword(passwordEncoder.encode(formRegister.getPassword()));
        employee.setEmail(formRegister.getEmail());
        employee.setFullName(formRegister.getFullName());

        Role role = roleRepository.findByRoleName(formRegister.getRoleName())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy role"));
        employee.setRole(role);
//        String avartar = loadAvartar.aupload(formRegister.getAvatar());
//        employee.setAvartar(avartar);
        String avertar= uploadService.uploadFile(formRegister.getAvatar());
        employee.setAvartar(avertar);
        employeeRepository.save(employee);
    }
    public EmployeeRespone updateEmployee(EmployeeRequest  employeeRequest,long id) throws IOException {
        Employee e = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("không tim thây nhân viên "));
        e.setFullName(employeeRequest.getFullName());
        e.setEmail(employeeRequest.getEmail());
        e.setApartment(employeeRequest.getApartment());
        e.setUsername(employeeRequest.getUsername());
        e.setPassword(employeeRequest.getPassword());
        e.getRole().setRoleName(employeeRequest.getRole());
        String avertar= uploadService.uploadFile(employeeRequest.getAvartar());
        e.setAvartar(avertar);
        e.setId(id);
        Role role = roleRepository.findByRoleName(employeeRequest.getRole())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy role"));

        e.setRole(role);
        employeeRepository.save(e);
        return new EmployeeRespone(e.getApartment(),e.getFullName(),e.getEmail(),e.getPhone(),e.getAvartar());
    }

}
