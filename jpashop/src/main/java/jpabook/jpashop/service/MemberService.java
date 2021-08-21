package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //기본적으로 데이터 변경은 트랜잭션 안에서 이루어져야 함(spring 제공 annotation 권장)
//@AllArgsConstructor
@RequiredArgsConstructor //롬복!
public class MemberService {

    //@Autowired
    private final MemberRepository memberRepository;

    //constructor injection -> 롬복으로 대체
    //@Autowired 최신버전 스프링에서는 생성자 하나인 경우 Autowired 자동으로 해줌
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName((member.getName()));
        //멀티스레드를 대비해 DB에서 name을 unique 제약조건 주는 것까지 해야 안전
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }

        //이 방법 외에도 findMember의 수를 세어서 1 이상이면 에러 처리리
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
