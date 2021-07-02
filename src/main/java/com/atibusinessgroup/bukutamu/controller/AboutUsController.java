package com.atibusinessgroup.bukutamu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

	 @GetMapping("/about-us")
	 public String aboutUs(Model model) {
		 return "about-us";
	 }
}
