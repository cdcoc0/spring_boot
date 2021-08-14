package kirri.springboot.tutorial.service;

import kirri.springboot.tutorial.domain.Member;
import kirri.springboot.tutorial.repository.MemberRepository;
import kirri.springboot.tutorial.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //테스트 케이스에서는 트랜잭션 실행 후 테스트 끝나면 롤백
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    //Dependency Injection
    //memberservice입장에서는 memberRepository를 외부에서 넣어주고 있음

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //특정 로직을 실행하면 이 에러가 나와야 함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.join(member2);

        //when
        List<Member> result = memberService.findMembers();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        //given

        //when

        //then
    }
}