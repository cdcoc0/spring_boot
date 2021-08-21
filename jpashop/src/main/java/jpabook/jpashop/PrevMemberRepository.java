package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PrevMemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(PrevMember prevMember) {
        em.persist(prevMember);
        return prevMember.getId(); //cmd랑 query를 분리해라..
    }

    public PrevMember find(Long id) {
        return em.find(PrevMember.class, id);
    }
}
