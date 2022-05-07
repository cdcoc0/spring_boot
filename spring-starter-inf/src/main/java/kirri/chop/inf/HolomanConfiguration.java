package kirri.chop.inf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HolomanConfiguration {

    @Bean
    public Holoman holoman() {
        Holoman holo = new Holoman();

        holo.setHowLong(5);
        holo.setName("kirri");
        return holo;
    }
}
