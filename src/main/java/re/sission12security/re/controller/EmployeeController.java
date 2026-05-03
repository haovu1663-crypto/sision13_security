package re.sission12security.re.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.sission12security.re.dto.RegisterResquest;
import re.sission12security.re.dto.request.EmployeeRequest;
import re.sission12security.re.dto.request.FormLogin;
import re.sission12security.re.dto.request.FormRegister;
import re.sission12security.re.repository.EmployeeRepository;
import re.sission12security.service.EmployeeService;

import java.io.IOException;

@RestController
@RequestMapping("/api/employess")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<?> getEmployee() {
        return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addUser(RegisterResquest registerResquest) {
         return  new ResponseEntity<>(employeeService.addUser(registerResquest), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody FormLogin formLogin) {
        return new ResponseEntity<>(employeeService.login(formLogin),HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<?> regisster(@ModelAttribute  FormRegister formRegister) throws IOException {
        employeeService.register(formRegister);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> getEmployee(@Valid @ModelAttribute EmployeeRequest employeeRequest, @PathVariable Long id) throws IOException {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeRequest,id), HttpStatus.OK);
    }
}