package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
        //스프링부트는 resources/templates/hello 를 찾아 랜더링된다.
        //컨트롤러에서 리턴 값으로 문자를 반환하면 뷰리졸버가 화면을 찾아 처리한다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body부분에 내가 직접 data를 넣어주겠다라는 뜻!!
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name") String name, @RequestParam("nickname") String nickname){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNickname(nickname);
        return hello;
        //객체를 반환하고 responsBody하면 json으로 반환하는게 디폴트
        //@ResponseBody어노테이션이 붙으면 viewResoler 대신에 HttpMessageConverter가 동작
        //기본문자처리: StringHttpMessageConveter
        //기본 객체처리: MappingJackson2HttpMessagConverter
    }

    static class Hello{
        private String name;
        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
