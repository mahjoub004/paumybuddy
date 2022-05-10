package com.PayMyBuddyV1.controller;

import com.PayMyBuddyV1.model.Account;
import com.PayMyBuddyV1.model.User;
import com.PayMyBuddyV1.repository.UserRepository;
import com.PayMyBuddyV1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yaml.snakeyaml.Yaml;

@Controller
public class AddAmountController {

    @Autowired // injection dependency
    private UserRepository userRepository ;
    @Autowired
    private UserService userService ;

    @GetMapping ("/addAmount")
    public String getAddAmountPage(Model model){
       User user = new User();
       model.addAttribute("user" , user);
        return "accueil";
    }


    @RequestMapping( value = "/addAmount", method = RequestMethod.POST)
    public String addAmount (@ModelAttribute("user") User user ){
        Account account = new Account();
        account.setAmount(user.getAccount().getAmount());
        userRepository.save(user);
        return "accueil";

    }
}
