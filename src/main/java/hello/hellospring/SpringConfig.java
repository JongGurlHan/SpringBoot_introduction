package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    //Configuration 읽고 MemberService를 스프링빈에 등록하라는 뜻으로 받아드린다.

    @Bean
    public MemberRepository memberRepository(){
      //  return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

    //memberService, memberRepository를 스프링 빈에 등록하고
    //스프링빈에 등록된 memberRepository를 memberService에 넣어준다.

}

