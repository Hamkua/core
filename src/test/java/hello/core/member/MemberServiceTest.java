package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    // 테스트 실행 전 무조건 실행된다.
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given 이러이러한게 주어짐
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 그럴때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 됨
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
