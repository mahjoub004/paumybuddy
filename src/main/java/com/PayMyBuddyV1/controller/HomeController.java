package com.PayMyBuddyV1.controller;


import com.PayMyBuddyV1.model.Account;
import com.PayMyBuddyV1.model.User;
import com.PayMyBuddyV1.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Data
@Controller
public class HomeController {
    @Autowired // injection dependency
    private UserRepository userRepository ;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping ( "/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user" , new User());
        return "register";
    }

    @RequestMapping( value = "/processRegister", method = RequestMethod.POST)
    public String registerUser ( User user,Model model , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
            model.addAttribute("user" , user);
            Account account = new Account();
            account.setAmount(0.);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAccount(account);
            int i = 0 ;
            userRepository.save(user);
            return "index";
      
    }
}

