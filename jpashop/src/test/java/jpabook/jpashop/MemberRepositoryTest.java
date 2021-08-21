package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    PrevMemberRepository memberRepository;

    @Test
    @Transactional
//    @Rollback(false)
    public void testMember() throws Exception {
        //given
        PrevMember prevMember = new PrevMember();
        prevMember.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(prevMember);
        PrevMember findPrevMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findPrevMember.getId()).isEqualTo(prevMember.getId());
        Assertions.assertThat(findPrevMember.getUsername()).isEqualTo(prevMember.getUsername());
        Assertions.assertThat(findPrevMember).isEqualTo(prevMember);
    }
}