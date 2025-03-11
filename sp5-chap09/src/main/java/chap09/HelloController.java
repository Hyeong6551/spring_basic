package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("hello","hello world");
		return "main";
	}
	
	@GetMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue="Guest") String name) {
		model.addAttribute("greeting", "안녕하세요, " + name);
		return "hello";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
}
