package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // 스프링을 사용하는 방식으로 바꾸어보자.

        // ApplicationContext를 스프링 컨테이너라고 보자. @Bean을 모두 관리해줌.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // name은 메서드이름으로 등록이 되므로 memberService 참고로 @Bean(name="어쩌구")로 바꿀 수 있다, 두번째는 타입 지정
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
