package re.sission12security.re.dto.respone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class JwtRespone {
   private String accessToken;
   private String refreshToken;
   private final String type="Bearer";
   private Long userId;
   private String fullName;
   private Date expirationDate;
   private final LocalDateTime timestamp = LocalDateTime.now();
}
