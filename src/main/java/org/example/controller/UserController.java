package org.example.controller;

import org.example.domain.Searchable;
import org.example.domain.User;
import org.example.repository.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.naming.Binding;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserMapper userMapper;

    @Inject
    private UserService userService;

    @RequestMapping("/signin")
    public String signin() { return "signin"; }

    @RequestMapping("/signinSuccess")
    public String signinSuccess() {
        System.out.println("signin Success");
        return "signinSuccess";
    }

    @RequestMapping("/signinFailed")
    public String signinFailed() {
        System.out.println("signin Failed");
        return "signinFailed";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @Transactional
    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signup(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

        userService.signup(user);

        // userMapper.insert(user);

        System.out.println("user = " + user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("user", userMapper.findOne(id));
        return "edit";
    }

    @RequestMapping(value="/edit", method= RequestMethod.POST)
    public String edit(@ModelAttribute User user) {
        userMapper.update(user);
        return "redirect:/user/list";

    }

    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String delete(@RequestParam int id) {
        userMapper.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/lists")
    public String lists(Model model) {
         List<User> allUsers = userMapper.selectAll();
         model.addAttribute("list", allUsers);

        return "list";
    }

    /*
    http://localhost:18080/user/list?name=admin&email=user1@email.com&order=age
    http://localhost:18080/user/list?order=age
    http://localhost:18080/user/list?name=admin
    */
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email,
                       @RequestParam(required = false) String order) {
        Searchable searchable = new Searchable();
        searchable.setName(name);
        searchable.setEmail(email);
        searchable.setOrderParam(order);
        model.addAttribute("list", userMapper.findByProvider(searchable));

        return "list";
    }
}
