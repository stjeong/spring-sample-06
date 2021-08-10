package org.example.controller;

import org.example.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("var1", "World");
        return "hello";
    }

    @RequestMapping("/sessionTest")
    @ResponseBody
    public String sessionTest(HttpSession session) {
        session.setAttribute("a", 3);
        session.removeAttribute("a");
        return "success";
    }

    @RequestMapping("/sessionTest2")
    @ResponseBody
    public String sessionTest2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("a", 3);
        session.removeAttribute("a");
        return "sessionTest2";
    }

    @RequestMapping(value="/reqTest", method=RequestMethod.GET)
    public String reqTest(Model model) {
        model.addAttribute("var1", "world");

        try {
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "hello";
    }

    @RequestMapping(value="/paramTest")
    public String paramTest(
            @RequestParam(name="a", required = false, defaultValue = "0") int a,
            @RequestParam("b") String b,
            @RequestParam(name="c", defaultValue = "true") boolean c) {

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        return "hello";
    }

    @RequestMapping(value="mapTest")
    public String mapTest(@RequestParam Map<String, String> map) {

        map.forEach((key, value) -> System.out.println(key + "=" + value) );

        /* Raw use of parameterized class 'Map.Entry'
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        */

        return "hello";
    }

    @RequestMapping("pathTest/{a}/{b}/{c}")
    public String pathTest(Model model,
            @PathVariable(value="a") String a,
            @PathVariable String b,
            @PathVariable int c) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        model.addAttribute("var1", "PathTest");

        return "hello";
    }
}