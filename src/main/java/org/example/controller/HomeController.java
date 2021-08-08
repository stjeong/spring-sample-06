package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("var1", "World");
        return "hello";
    }

    @RequestMapping(value="/reqTest", method=RequestMethod.GET)
    public String reqTest(Model model) {
        model.addAttribute("var1", "world");
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

        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

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