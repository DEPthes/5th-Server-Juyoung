package jpabook.jpashop.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberDataRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberDataRepository memberDataRepository;

    @Transactional
    public Long join(@Valid Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member){
        List<Member> findMembers=memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원");
        }
    }

    public List<Member>findMembers(){
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    public Member login(String email, String password){
        return memberDataRepository.findByEmail(email).stream()
                .filter(m->m.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
