package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

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
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name,@RequestParam String language){
        String Greeting =HelloController.createMessage(name,language);
        return "<h3 Style ='color:red;'>" +Greeting +"</h3>";
    }
    //Handles request at the form /hello/LaunchCode
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name){
        return "hello, "+name+ "!";

    }
    @GetMapping("form")

    public String helloForm(){

               return  "<html>" +
                "<body>" +
                "<form method='post'  action = 'hello'>" +
                "<input type = 'text' name='name'/>" +
                "<select name= 'language'>" +
                "<option value = 'English'>English</option>"+
                        "<option value = 'Spanish'>Spanish</option>"+
                        "<option value = 'French'>French</option>"+
                        "<option value = 'German'>German</option>"+
                        "<option value = 'Italian'>Italian</option>"+
                       "</select> "+
                        "<input type = 'submit' value = 'greet me!'>"+
                "</form>" +
                "</body>" +
                "</html>";

    }
    public static String createMessage(String name,String language){
        switch (language)
        {
            case "Spanish":
                return "Hola, "+name;
            case "French":
                return "Bonjour, "+name;
            case "German":
                return "Hallo,"+name;
            case "Italian":
                return "Ciao, "+name;
            default:
                return "Hello, "+name;
        }
    }
}

