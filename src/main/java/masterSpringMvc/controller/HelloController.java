package masterSpringMvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
//@RequestMapping("/")
//public String hello(Model model) {
//    model.addAttribute("message", "Witaj w kontrolerze!");
//    return "resultPage";
//}
@RequestMapping("/")
public String hello(@RequestParam(defaultValue = "świecie", required = false) String name, Model model) {
    model.addAttribute("message", "Witaj, " + name + "!");
    return "resultPage";
}
}
