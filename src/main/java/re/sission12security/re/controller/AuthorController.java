package re.sission12security.re.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.sission12security.re.dto.request.FormLogin;
import re.sission12security.re.dto.request.FormRegister;
import re.sission12security.service.IAuthenService;

@RestController
@RequestMapping("/api/v1/aithor")
@RequiredArgsConstructor
public class AuthorController {
    private final IAuthenService  authenService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody FormRegister formRegister){
        authenService.register(formRegister);
        return  new ResponseEntity<>("register succefful",HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody FormLogin formLogin){
        return  new ResponseEntity<>(authenService.login(formLogin),HttpStatus.OK);
    }
}
