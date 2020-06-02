package com.demo.nmr.Controller;

// Imports of spring framework
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//HomeController class controlling index(front page)
//@Annotation for spring
@Controller
public class HomeController {

    //@Getmapping annotation for Spring
    //Returns index page
    @GetMapping("/")
    public String showPage(){
        return "home/index";
    }
}
