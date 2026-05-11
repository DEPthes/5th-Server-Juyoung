package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
//새 테스트 생성 ctrl+shift+t
//@Service
@Transactional
public class MemberService
{
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

//    회원가입
    public Long join(Member member){

//        중복회원 금지
        memberRepository.findByName(member.getName())
            .ifPresent((m->{
                throw new IllegalStateException("이미 존재하는 회원입니다");
        }));

        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
//    전체 회원 조회
    public List<Member> findMember(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
