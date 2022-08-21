package kirri.chop.springinit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;





//애플리케이션 실행된 후
@Component
public class SampleListener implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo: " + args.containsOption("foo"));
        System.out.println("bar: " + args.containsOption("bar"));
    }
}

//@Component
//public class SampleListener implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//        Arrays.stream(args).forEach(System.out::println);
//    }
//}

//애플리케이션 argument 사용하기
//@Component
//public class SampleListener {
//    public SampleListener(ApplicationArguments arguments) {
//        System.out.println("foo: " + arguments.containsOption("foo"));
//        System.out.println("bar: " + arguments.containsOption("bar"));
//    }
//}

//애플리케이션 컨텍스트가 만들어진 후 (빈 실행 가능)
//@Component
//public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationStartedEvent event) {
//        System.out.println("==============================");
//        System.out.println("started!");
//        System.out.println("==============================");
//    }
//}

//애플리케이션 시작될 때 (빈 사용 X, 빈으로 등록해도 리스너 동작X)
//public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationStartingEvent event) {
//        System.out.println("==============================");
//        System.out.println("Applicaion is starting");
//        System.out.println("==============================");
//    }
//}
