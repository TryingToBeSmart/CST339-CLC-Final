package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	//Show index of registration
	@GetMapping("")
	public String displayIndex(Model model) 
	{
		model.addAttribute("title", "");
		return "register_index";
	}
	
	//Sends form to register as a trainer
	@GetMapping("/trainer")
	public String registerTrainer(Model model) 
	{
		model.addAttribute("title", "");
		model.addAttribute("trainerModel", new TrainerModel());
		return "registerTrainer";
	}
	
	//Sends form to register as a client
	@GetMapping("/client")
	public String registerClient(Model model) 
	{
		model.addAttribute("title", "");
		model.addAttribute("clientModel", new ClientModel());
		return "registerClient";
	}
}
