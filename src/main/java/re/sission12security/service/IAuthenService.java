package re.sission12security.service;

import re.sission12security.re.dto.request.FormLogin;
import re.sission12security.re.dto.request.FormRegister;
import re.sission12security.re.dto.respone.JwtRespone;

public interface IAuthenService {
    // đăng ký
    void register(FormRegister formRegister);

    // đăng nhập
    JwtRespone  login(FormLogin formLogin);
}
