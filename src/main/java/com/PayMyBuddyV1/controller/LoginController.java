package com.PayMyBuddyV1.controller;

import com.PayMyBuddyV1.model.User;
import com.PayMyBuddyV1.repository.UserRepository;
import com.PayMyBuddyV1.service.LoginService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Data
@Controller
public class LoginController {
    @Autowired // injection dependency
    private UserRepository userRepository ;

    @Autowired
    private LoginService loginService ;
/*
    @GetMapping ( "/")
    public ModelAndView showHomePage(){
        ModelAndView login = new ModelAndView("index");
        login.addObject("user" , new User());
        return login;
    }

   @PostMapping( "/login")
    public String login( @ModelAttribute("user") User user){

        User authUser = loginService.login(user.getEmail(), user.getPassword());

        System.out.println(user);

        if (Objects.nonNull(authUser) ) {
            return "redirect:/";
        }else {
            return "accueil";
        }

    }
*/
@GetMapping ( "/accueil")
public String getHomePage(Model model){
    User user = new User();
    model.addAttribute("user", user);
    return "index";
}

@PostMapping ( "/accueil")
public String showHomePage(ModelMap model , User user){
    model.put("username",user.getEmail());
    model.put("success" ,"you welcome");
    //System.out.println(user.getAccount().getAmount());
    return "accueil";
}

}
