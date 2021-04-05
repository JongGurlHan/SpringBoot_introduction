package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //생성자에 @Autowired가 있으면 MemberController가 생성될때
    // 스프링빈에 등록되어있는 memberService를 스프링 컨테이너에 있는 memberService에 연결시켜준다
    //
}
