package re.sission12security.re.dto.request;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import re.sission12security.re.entity.Role;
import re.sission12security.re.entity.RoleName;

@Getter
@Setter
public class EmployeeRequest {
    private String username;
    private String password;
    private String apartment;
    private String email;
    private String phone;
    @NotBlank
    @Size(min = 5, max = 100)
    private String fullName;
    private MultipartFile avartar;
    private RoleName role;
}
