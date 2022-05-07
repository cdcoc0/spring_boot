package kirri.chop.inf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    //해당 빈이 없는 경우에만 빈으로 등록
    public Holoman holoman(HolomanProperties properties) {
        Holoman holo = new Holoman();
        holo.setHowLong(properties.getHowLong());
        holo.setName(properties.getName());
        return holo;
    }
}
