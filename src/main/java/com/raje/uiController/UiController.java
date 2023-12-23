package com.raje.uiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UiController {
	
	
@RequestMapping(value={"", "/", "home"})
public String home() {
	return "home.html";
}
}
