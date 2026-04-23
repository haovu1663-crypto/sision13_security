package re.sission12security.re.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class adminController {
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "you are admin";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(){
        return "you are user";
    }
    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String manager(){
        return "you are manager";
    }
    @GetMapping("/aorm")
    @PreAuthorize("hasAnyRole('Admin','MANAGER')")
    public String adminOrManager(){
        return "you are admin or manager";
    }

}
