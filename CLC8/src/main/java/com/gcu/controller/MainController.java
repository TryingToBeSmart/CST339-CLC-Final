package com.gcu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.AccountBusinessService;
import com.gcu.data.AccountsDetailsService;
import com.gcu.model.UserWorkoutsModel;
import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;
import com.gcu.services.RestServiceInterface;

/**
 * The Class MainController.
 */
@Controller
@RequestMapping("")
public class MainController 
{
	
	/** Constructor injection */
	@Autowired
	private RestServiceInterface service;
	
	/** The account details from MySQL */
	@Autowired
	private AccountBusinessService accountDetails;
	
	/**
	 * Display.
	 *
	 * @param model 
	 * @return the string
	 */
	@GetMapping("")
	public String display(Model model) 
	{
		model.addAttribute("title", "");
		return "index";
	}
	
	/**
	 * Display login.
	 *
	 * @param model 
	 * @return the string login view
	 */
	//Display the login page that any user can use to log in
	@GetMapping("/login")
	public String displayLogin(Model model) 
	{
		model.addAttribute("title", "");
		model.addAttribute("accountModel", new AccountModel());
		model.addAttribute("failedLogin", false);
		return "login";
	}
	
	
	/**
	 * Register client mapping.
	 *
	 * @param clientModel 
	 * @param bindingResult 
	 * @param model 
	 * @return the string clientHome view
	 */
	@PostMapping("/doRegisterClient")
	public String doRegisterClient(@Valid ClientModel clientModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("First name: %s Last name: %s Age: %s Weight: %s Height: "
				+ "%s Username: %s Password: %s", clientModel.getFirstName(), clientModel.getLastName(), clientModel.getAge(), clientModel.getWeight(), 
				clientModel.getHeight(), clientModel.getUsername(), clientModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "");
			return "registerClient";
		}
		// display the Home view

		model.addAttribute("client", clientModel);
		service.addClient(clientModel);
		return "clientHome";
	}
	
	/**
	 * Register trainer mapping.
	 *
	 * @param trainerModel 
	 * @param bindingResult
	 * @param model 
	 * @return the string trainer view
	 */
	// Post mapping to confirm the inputs added to the trainer profile 
	@PostMapping("/doRegisterTrainer")
	public String doRegisterTrainer(@Valid TrainerModel trainerModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("First name: %s Last name: %s Employee ID: Username: %s Password: %s", 
				trainerModel.getFirstName(), trainerModel.getLastName(), trainerModel.getTrainerID(), trainerModel.getUsername(), trainerModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			return "registerTrainer";
		}
		// display the Home view
		service.addTrainer(trainerModel);
		return "trainer";
	}
	
	
	/**
	 * Do login.
	 *
	 * @param model 
	 * @return the string login view
	 */
	@PostMapping("/login")
	public String doLogin(Model model)
	{
		System.out.println("In /doLogin");
		model.addAttribute("failedLogin", true);
		return "login";
	}
	
	/**
	 * Client home.
	 *
	 * @param request 
	 * @param model 
	 * @return the string home view
	 */
	//Home page for client
	@GetMapping("/client/home")
	public String clientHome(HttpServletRequest request, Model model) {
		//send client info
		
		UserDetails user = accountDetails.loadUserByUsername(request.getUserPrincipal().getName());
		AccountModel client = service.getAccountByLogin(user.getUsername(), user.getPassword());
		
		if(client instanceof ClientModel)
		{
			model.addAttribute("client", ((ClientModel) client));
			model.addAttribute("workouts", service.getUserWorkouts(client.getAccountID()));
			return "clientHome";
		}
		return "home";
		
	}
	
	/**
	 * Complete client workouts.
	 *
	 * @param model 
	 * @param id 
	 * @param workoutId 
	 * @return the string clientHome view
	 */
	@GetMapping("/client/completeClientWorkout/{id}/{workoutId}")
	public String completeClientWorkouts(Model model, @PathVariable String id, @PathVariable String workoutId)
	{
		
		ClientModel client = service.getClient(id);
		System.out.println("Client ID in MainController is: " + id);
		System.out.println("workoutId in MainController is: " + workoutId);
		
		UserWorkoutsModel userWorkout = service.getUserWorkoutById(workoutId);
		System.out.println("userWorkout in TrainerController ID is: "+ userWorkout.getId());
		
		model.addAttribute("client", client);
		System.out.println("MainController.completeUserWorkout " + id +" "+ workoutId);
		
		//get current date toString
		String date = java.time.LocalDate.now().toString();
		System.out.println(date);
		service.completeUserWorkout(userWorkout.getName(), date);
		model.addAttribute("workouts", service.getUserWorkouts(id));

		return "clientHome";
	}
}