package re.sission12security;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import re.sission12security.re.config.jwt.JwtService;

@SpringBootApplication
public class Sission12SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sission12SecurityApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(JwtService jwtService) {
        return args -> {
            System.out.println(jwtService.generateAccessToken("haomilo"));
        };
    }

    @Value("${cloud-name}")
    private String cloudName;
    @Value("${api-key}")
    private String apiKey;
    @Value("${api-secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", true
        ));
    }

}
