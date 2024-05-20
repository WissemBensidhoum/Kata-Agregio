package kata.agregio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI api() {
        Info info = new Info().title("Agregio Kata API")
                .description("""
                        An API for managing energy sales by Agregio across various markets. It allows creating offers with different energy quantities and prices for primary, secondary, and rapid reserves. Additionally, it facilitates listing offers per market and retrieving the parks selling energy on a specific market
                        ## Owners :
                        - Wissem BENSIDHOUM wbensidhoum@takima.fr
                        """);

        return new OpenAPI()
                .info(info);
    }
}
