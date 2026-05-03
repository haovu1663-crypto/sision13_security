package re.sission12security.re.dto.respone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtEmployeeRespone {
    private String username;
    private String type;
    private String accessToken;
}
