package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

      private EntityManager em;

      @Autowired
      public SpringConfig(EntityManager em){
          this.em = em;
      }
//    private DataSource dataSource;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    //Configuration 읽고 MemberService를 스프링빈에 등록하라는 뜻으로 받아드린다.

    @Bean
    public MemberRepository memberRepository(){
      //  return new MemoryMemberRepository();
    // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em );
    }

    //memberService, memberRepository를 스프링 빈에 등록하고
    //스프링빈에 등록된 memberRepository를 memberService에 넣어준다.

    @Bean
    public TimeTraceAop timeTraceAop(){
          return new TimeTraceAop();
    }
}

