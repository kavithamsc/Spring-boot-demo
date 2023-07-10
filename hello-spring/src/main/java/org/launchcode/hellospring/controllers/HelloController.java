package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "hello")
@ResponseBody
public class HelloController {
    //Handles request at path /Hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")

    public String goodbye(){
        return "goodbye,Spring!";
    }
    //Handles request at the form /Hello?coder=launch code
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "hello, "+ name + "!";
    }
    //Handles request at the form /hello/LaunchCode
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name){
        return "hello, "+name+ "!";

    }
    @GetMapping("form")

    public String helloForm(){
       String html= "<html>" +
                "<body>" +
                "<form method='post'  action = 'hello'>" +
                "<input type = 'text' name='name'/>" +
                "<input type = 'submit' value = 'greet me!'>"+
                "</form>" +
                "</body>" +
                "</html>";
return html;
    }
}
