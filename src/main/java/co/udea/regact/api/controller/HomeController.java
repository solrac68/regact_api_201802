package co.udea.regact.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.udea.regact.api.service.GreetingService;

@Controller
public class HomeController {
	
	private final GreetingService service;
	
	public HomeController(GreetingService service) {
        this.service = service;
    }
	
	@RequestMapping("/")
    public @ResponseBody String greeting() {
		return service.greet();
    }

}
