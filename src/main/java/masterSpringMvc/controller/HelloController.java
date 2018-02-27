package masterSpringMvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
@RequestMapping("/")
@ResponseBody
public String hello() {
    return "Witaj, świecie!";
}
}