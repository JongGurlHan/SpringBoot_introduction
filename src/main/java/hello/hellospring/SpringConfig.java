package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    //Configuration 읽고 MemberService를 스프링빈에 등록하라는 뜻으로 받아드린다.

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    //memberService, memberRepository를 스프링 빈에 등록하고
    //스프링빈에 등록된 memberRepository를 memberService에 넣어준다.

}

