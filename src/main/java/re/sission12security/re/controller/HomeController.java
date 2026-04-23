package re.sission12security.re.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping("/admin/test")
    public String admin() {
        return  "admin get data success";
    }
    @GetMapping("/user/test")
    public String user() {
        return  "user get data success";
    }
    @GetMapping("/manager/test")
    public String manager() {
        return  "manager get data success";
    }
}