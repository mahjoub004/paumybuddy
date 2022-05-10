package com.PayMyBuddyV1.controller;

import com.PayMyBuddyV1.model.User;
import com.PayMyBuddyV1.repository.UserRepository;
import com.PayMyBuddyV1.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
@Controller
public class LoginController {
    @Autowired // injection dependency
    private UserRepository userRepository ;

    @Autowired
    private UserService userService ;

    @GetMapping ( "/")
    public String getHomePage(Model model){
        User user = userService.findAccount();
        model.addAttribute("user", user);

        return "accueil";
    }

    @GetMapping("logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}

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



/*
@PostMapping ( "/accueil")
public String showHomePage(ModelMap model , User user){
    model.put("username",user.getEmail());
    model.put("success" ,"you welcome");
    //System.out.println(user.getAccount().getAmount());
    return "accueil";
}
 */


