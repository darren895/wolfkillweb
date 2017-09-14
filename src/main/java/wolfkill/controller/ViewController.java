package wolfkill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

	@RequestMapping("free")
	public String free(@RequestParam(value="a",required = false)String attr, Model model){
		model.addAttribute("a", attr);
		return "free";
	}
}
