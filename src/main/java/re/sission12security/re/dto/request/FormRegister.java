package re.sission12security.re.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import re.sission12security.re.entity.Role;
import re.sission12security.re.entity.RoleName;

@Getter
@Setter
public class FormRegister {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private MultipartFile avatar;

    private RoleName roleName;

}
