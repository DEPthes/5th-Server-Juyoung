package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberDataRepository extends JpaRepository<Member, Long> {
        List<Member> findByEmail(String email);

}
