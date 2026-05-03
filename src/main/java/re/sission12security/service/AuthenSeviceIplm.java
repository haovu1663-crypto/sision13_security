package re.sission12security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import re.sission12security.re.config.jwt.JwtService;
import re.sission12security.re.dto.request.FormLogin;
import re.sission12security.re.dto.request.FormRegister;
import re.sission12security.re.dto.respone.JwtRespone;
import re.sission12security.re.entity.Role;
import re.sission12security.re.entity.RoleName;
import re.sission12security.re.entity.User;
import re.sission12security.re.repository.IRoleRepository;
import re.sission12security.re.repository.IUserRespository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenSeviceIplm implements IAuthenService {
    private final IUserRespository userRespository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public void register(FormRegister formRegister) {
        // tạo mới user
        User user = new User();
        user.setUsername(formRegister.getUsername());
        user.setPassword(passwordEncoder.encode(formRegister.getPassword()));
        user.setEmail(formRegister.getEmail());
        user.setPhone(formRegister.getPhone());
        user.setFullName(formRegister.getFullName());

        Role role = roleRepository.findByRoleName(formRegister.getRoleName())
                .orElseThrow(() -> new RuntimeException("không tìm thấy role"));
        user.setRole(role);
        userRespository.save(user);
    }

    @Override
    public JwtRespone login(FormLogin formLogin) {
        Authentication authentication = null;
        try{
            // phương thức kiểm tra
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(formLogin.getUsername(), formLogin.getPassword()));
        }catch (Exception e){
            e.printStackTrace(); // ← thêm dòng này
         throw new RuntimeException("mk haoc tk sai ");
        }
        // trả vè jwtRespone
        User user = userRespository.findByUsername(formLogin.getUsername()).orElseThrow(()->new RuntimeException("ko tìm thấy "));
         JwtRespone res =  JwtRespone.builder()
                 .userId(user.getId())
                 .fullName(user.getFullName())
                 .accessToken(jwtService.generateAccessToken(user.getUsername()))
                 .expirationDate(new Date(new Date().getTime()+15*60*1000))
                 .refreshToken(null)
                 .build();
        return res;
    }
}
