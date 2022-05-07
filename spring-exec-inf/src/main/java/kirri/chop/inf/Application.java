package kirri.chop.inf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

//    @Bean
//    public Holoman holoman() {
//        Holoman holo = new Holoman();
//        holo.setName("kirrrri");
//        holo.setHowLong(50);
//        return holo;
//    }
    //여기서 빈 설정을 해줘도 이 빈을 컴포넌트 스캔한 뒤 auto configuration 빈이 등록되면서 덮어버림
}
