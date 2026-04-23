package re.sission12security.re.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.sission12security.re.dto.RegisterResquest;
import re.sission12security.re.repository.EmployeeRepository;
import re.sission12security.service.EmployeeService;

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
}