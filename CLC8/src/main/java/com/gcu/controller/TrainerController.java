package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserWorkoutsModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.services.RestServiceInterface;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private RestServiceInterface service;
	
	//Home Controller for Trainer view
	@GetMapping("")
	public String displayHome()
	{
		return "trainer";
	}
	
	//Displays the list of clients for trainers to view
	@GetMapping("/clients")
	public String displayClients(Model model)
	{
		model.addAttribute("clients", service.getClients());
		return "clientsList";
	}

	//Displays the workouts for a specific client
	@GetMapping("/clients/view/{id}")
	public String viewClientWorkouts(Model model, @PathVariable String id)
	{
		ClientModel client = service.getClient(id);
		
		if(client == null)
		{
			return displayClients(model);
		}
		
		model.addAttribute("client", client);
		model.addAttribute("userWorkouts", service.getUserWorkouts(id));
		return "clientWorkouts";
	}
	
	//Edit the list of workouts a client has
	@GetMapping("/clients/edit/{id}")
	public String addClientWorkouts(Model model, @PathVariable String id)
	{
		ClientModel client = service.getClient(id);
		
		if(client == null)
		{
			return displayClients(model);
		}
		
		model.addAttribute("client", client);
		model.addAttribute("userworkouts", service.getUserWorkouts(id));
		model.addAttribute("addworkouts", service.getWorkouts());
		return "addWorkout";
	}
	
	//Adds workout to a client with client ID and workout id
	@GetMapping("/clients/addWorkout/{id}/{workoutId}")
	public String addClientWorkouts(Model model, @PathVariable String id, @PathVariable String workoutId)
	{
		ClientModel client = service.getClient(id);
		WorkoutModel workout = service.getWorkoutById(workoutId);
		UserWorkoutsModel userWorkout = new UserWorkoutsModel(null, workout.getName(), workout.getCaloriesPerSet(), workout.getTimePerSet(), "", "");
		if(client == null || workout == null)
		{
			return displayClients(model);
		}
		
		client.getWorkouts().add(userWorkout);
		
		model.addAttribute("client", client);
		service.addUserWorkout(userWorkout, client);
		model.addAttribute("userworkouts", service.getUserWorkouts(id));
		model.addAttribute("addworkouts", service.getWorkouts());
		return viewClientWorkouts(model, id);
	}
	
	//Remove client workout
	@GetMapping("/clients/removeClientWorkout/{id}/{workoutId}")
	public String removeClientWorkouts(Model model, @PathVariable String id, @PathVariable String workoutId)
	{
		System.out.println("Client ID is: " + id);
		ClientModel client = service.getClient(id);
		UserWorkoutsModel userWorkout = service.getUserWorkoutByName(workoutId);
		if(client == null || userWorkout == null)
		{
			return displayClients(model);
		}
		
//		client.getWorkouts().remove(userWorkout);

		service.removeUserWorkout(userWorkout.getName());
		model.addAttribute("client", client);
		model.addAttribute("workouts", service.getUserWorkouts(id));
		return viewClientWorkouts(model, id);
	}
	
		//complete client workout and add date completed
		@GetMapping("/clients/completeClientWorkout/{id}/{workoutId}")
		public String completeClientWorkouts(Model model, @PathVariable String id, @PathVariable String workoutId)
		{
			
			ClientModel client = service.getClient(id);
			System.out.println("Client ID in TrainerController is: " + id);
			System.out.println("workoutId in TrainerController is: " + workoutId);
			
			UserWorkoutsModel userWorkout = service.getUserWorkoutById(workoutId);
			System.out.println("userWorkout in TrainerController ID is: "+ userWorkout.getId());
//			if(client == null || userWorkout == null)
//			{
//				return displayClients(model);
//			}
//			
//			client.getWorkouts().complete(userWorkout);
			
			model.addAttribute("client", client);
			System.out.println("TrainerController.completeUserWorkout " + id +" "+ workoutId);
			
			//get current date toString
			String date = java.time.LocalDate.now().toString();
			System.out.println(date);
			service.completeUserWorkout(userWorkout.getName(), date);
			model.addAttribute("workouts", service.getUserWorkouts(id));
			return viewClientWorkouts(model, id);
		}
	
	//displays all the workouts available
	@GetMapping("/workouts")
	public String viewWorkouts(Model model)
	{
		model.addAttribute("workouts", service.getWorkouts());
		return "workoutsList";
	}
	
	//Allows trainer to add new workout to list of available workouts
	@GetMapping("/workouts/add")
	public String newWorkout(Model model)
	{
		model.addAttribute("workoutModel", new WorkoutModel());
		return "newWorkout";
	}
	
	//Takes in workout and adds to available workouts if valid
	@PostMapping("/workouts/add")
	public String addWorkout(@Valid WorkoutModel workout,BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "newWorkout";
		}
		
		service.addWorkout(workout);
		model.addAttribute("workouts", service.getWorkouts());
		return "workoutsList";
	}
	
	
	
}
