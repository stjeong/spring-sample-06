package org.example.controller;

import lombok.Setter;
import org.example.domain.Searchable;
import org.example.domain.User;
import org.example.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @Transactional
    @RequestMapping(value="/signup", method= RequestMethod.POST)
    @ResponseBody
    public String signup(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

        // userMapper.insert(user);

        System.out.println("user = " + user);
        return "success";
    }

    // @Autowired
    private UserMapper mapper;

    @RequestMapping("/lists")
    public String lists(Model model) {
         List<User> allUsers = mapper.selectAll();
         model.addAttribute("users", allUsers);

        return "list";
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email,
                       @RequestParam(required = false) String order) {
        Searchable searchable = new Searchable();
        searchable.setName(name);
        searchable.setEmail(email);
        searchable.setOrderParam(order);
        // model.addAttribute("users", userMapper.findByProvider(searchable));

        return "list";
    }
}
