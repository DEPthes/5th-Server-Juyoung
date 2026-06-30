package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//추후 RestApi로 리팩토링 예정
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid LoginForm form, BindingResult result){

        if(result.hasErrors()){
            return "loginForm";
        }

        Member loginMember = memberService.login(form.getEmail(), form.getPassword());

        if(loginMember==null){
            result.reject("loginFail","이메일 또는 비밀번호가 맞지 않습니다");
            return "loginForm";
        }

        return "redirect:/items-view";
    }
}
