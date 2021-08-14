package kirri.springboot.tutorial;

import kirri.springboot.tutorial.repository.JdbcMemberRepository;
import kirri.springboot.tutorial.repository.JdbcTemplateMemberRepository;
import kirri.springboot.tutorial.repository.MemberRepository;
import kirri.springboot.tutorial.repository.MemoryMemberRepository;
import kirri.springboot.tutorial.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
