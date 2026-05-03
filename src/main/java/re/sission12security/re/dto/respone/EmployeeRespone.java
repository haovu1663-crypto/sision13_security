package re.sission12security.re.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import re.sission12security.re.entity.Role;
@Getter
@Setter
@AllArgsConstructor
public class EmployeeRespone {
    private String apartment;
    private String email;
    private String phone;
    private String fullName;
    private String avartar;

}
