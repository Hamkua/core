package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//구현체가 하나만 있을경우, 인터페이스명+Impl으로 이름짓는것이 관례임.
@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    //테스트 용도 ( 싱글톤 )
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
