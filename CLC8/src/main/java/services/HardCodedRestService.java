//package com.gcu.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.gcu.model.UserWorkoutsModel;
//import com.gcu.model.WorkoutModel;
//import com.gcu.model.accounts.AccountModel;
//import com.gcu.model.accounts.ClientModel;
//import com.gcu.model.accounts.TrainerModel;
//
//public class HardCodedRestService implements RestServiceInterface {
//
//	private List<WorkoutModel> workouts = new ArrayList<WorkoutModel>();
//	private List<ClientModel> clients = new ArrayList<ClientModel>();
//	private List<TrainerModel> trainers = new ArrayList<TrainerModel>();
//	
//	public HardCodedRestService()
//	{
////		workouts.add(new WorkoutModel("Lunges", 50, "1:00"));
////		
////		ClientModel testClient = new ClientModel("Testing", "Testing", 20, 100, 100, "Something", "Another Thing", 1);
////		testClient.getWorkouts().add(new UserWorkoutsModel("Lunges", 50, "1:00", "incomplete", "2000/01/01"));
////		
////		clients.add(testClient);
////		clients.add(new ClientModel("Example", "Example", 10, 10, 10, "Test", "Test", 2));
////		clients.add(new ClientModel("Example2", "Example2", 10, 10, 10, "Test2", "Test2", 3));
////		clients.add(new ClientModel("Example3", "Example3", 10, 10, 10, "Test3", "Test3", 4));
////		clients.add(new ClientModel("Example4", "Example4", 10, 10, 10, "Test4", "Test4", 5));
////		
////		trainers.add(new TrainerModel("Trainer1", "Trainer1", "Trainer1", "Trainer1", 1, 6));
//		
//	}
//	
//	@Override
//	public List<WorkoutModel> getWorkouts() {
//		return workouts;
//	}
//
//	@Override
//	public List<ClientModel> getClients() {
//		return clients;
//	}
//
//	@Override
//	public void addClient(ClientModel client) {
//		clients.add(client);
//		
//	}
//
//	@Override
//	public void addWorkout(WorkoutModel workout) {
//		workouts.add(workout);
//		
//	}
//	@Override
//	public ClientModel getClient(String clientID) {
//		
//		for(ClientModel client: clients)
//		{
//			if(client.getAccountID() == clientID)
//			{
//				return client;
//			}
//		}
//		System.out.println("Unable to find Client with Client ID of " + clientID);
//		return null;
//		
//	}
//
//	public AccountModel getAccountByID(String accountID) {
//		
//		for(ClientModel client: clients)
//		{
//			if(client.getAccountID() == accountID)
//			{
//				return client;
//			}
//		}
//		
//		for(TrainerModel trainer: trainers)
//		{
//			if(trainer.getAccountID() == accountID)
//			{
//				return  trainer;
//			}
//		}
//		System.out.println("Unable to find Account with Account ID of " + accountID);
//		
//		return null;
//	}
//	
//	@Override
//	public AccountModel getAccountByLogin(String Username, String Password) {
//		
//		for(ClientModel client: clients)
//		{
//			if(client.getUsername().equals(Username))
//				if(client.getPassword().equals(Password))
//					return client;
//		}
//		
//		for(TrainerModel trainer: trainers)
//		{
//			if(trainer.getUsername().equals(Username))
//				if(trainer.getPassword().equals(Password))
//					return  trainer;
//		}
//		System.out.println("Unable to find Account with Username of " + Username);
//		
//		return null;
//	}
//	
//	
//	public UserWorkoutsModel makeWorkout(String name, String status, String date) {
//		
//		for(WorkoutModel workout: workouts)
//		{
//			if(workout.getName().equals(name))
//			{
//				return new UserWorkoutsModel(workout.getName(), workout.getCaloriesPerSet(), workout.getTimePerSet(), status, date);
//			}
//		}
//		
//		return null;
//	}
//
//	@Override
//	public void addTrainer(TrainerModel trainer) {
//		trainers.add(trainer);
//	}
//
//	public List<UserWorkoutsModel> getUserWorkouts() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public WorkoutModel getWorkoutByName(String workoutName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addUserWorkout(WorkoutModel workout, ClientModel client) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public WorkoutModel getWorkoutById(int workid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public List<UserWorkoutsModel> getUserWorkouts(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void removeUserWorkout(String clientId, String workoutId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public AccountModel getAccountByID(int accountID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
