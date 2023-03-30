package jpabook.jpashop.domain.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());

        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }

    }

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findByAll(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)     //데이터 변경 안됨(조회 최적화)
    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }
}
