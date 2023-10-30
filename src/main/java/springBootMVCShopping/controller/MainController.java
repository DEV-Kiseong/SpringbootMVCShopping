package springBootMVCShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.LoginCommand;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommand) {
	
		
		return "thymeleaf/index";
	}
}
