package kirri.chop.springinit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Value("${kirri.name}")
    private String name;

    @Value(("${kirri.age}"))
    private int age;

    @Value("${kirri.fullName}")
    private String fullName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============================");
        System.out.println(name);
        System.out.println(age);
        System.out.println(fullName);
        System.out.println("==============================");
    }
}
