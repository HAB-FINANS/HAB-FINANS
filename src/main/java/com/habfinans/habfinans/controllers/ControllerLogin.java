package com.habfinans.habfinans.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {
    @RequestMapping("/login")
	public String index(Model model) {
		return "login";
	}
}
