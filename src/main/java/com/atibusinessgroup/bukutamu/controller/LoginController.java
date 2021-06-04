package com.atibusinessgroup.bukutamu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;

@Controller
public class LoginController {

	@Autowired
	private BukuTamuRepository bukuTamuRepository;
	
    @GetMapping("/")
    public String index(Model model) {
    	
    	List<BukuTamu> getBukuTamu = bukuTamuRepository.findAll();
    	model.addAttribute("bukuTamu", getBukuTamu);
    	
        return "index";
    }
}
