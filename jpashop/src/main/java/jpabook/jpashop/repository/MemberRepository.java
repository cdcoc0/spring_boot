package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext //jpa 엔티티 매니저를 여기에 주입
    private EntityManager em;

//    @PersistenceUnit
//    private EntityManagerFactory emf;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); //타입, pk
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //JPQL, 반환 타입
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
