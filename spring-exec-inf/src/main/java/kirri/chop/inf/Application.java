package kirri.chop.inf;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) throws LifecycleException, IOException {
//        자바 코드로 톰캣 생성
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        //디렉토리 생성
        String docBase = Files.createTempDirectory("tomcat-basedir").toString();

        Context context = tomcat.addContext("/", docBase);

        //서블릿 생성
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Tomcat Server with java code");
                writer.println("</title></head>");
                writer.println("<body><h1>Let's get Tomcat!</h1></body>");
                writer.println("</html>");
            }
        };

        String servletName = "servletKirriMade";
        tomcat.addServlet("/", servletName, servlet);
        context.addServletMappingDecoded("/hello", servletName);

        tomcat.getConnector(); //Tomcat 9.x에서는 이 코드가 필요함
        tomcat.start();
//        tomcat.getServer().await();

//        웹 서버 구동
//        SpringApplication.run(Application.class, args);

//        웹 서버 아닌 형태로 구동
//        SpringApplication app = new SpringApplication(Application.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
//        app.run(args);
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
