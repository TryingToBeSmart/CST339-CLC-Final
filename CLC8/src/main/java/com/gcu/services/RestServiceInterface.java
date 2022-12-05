package com.gcu.services;

import java.util.List;

import com.gcu.model.UserWorkoutsModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface RestServiceInterface. To be used for constructor injection in the Controllers.
 */
public interface RestServiceInterface {

	/**
	 * Gets the user workouts.
	 *
	 * @param id 
	 * @return the user workouts
	 */
	public List<UserWorkoutsModel> getUserWorkouts(String id);
	
	/**
	 * Gets the workouts.
	 *
	 * @return the workouts
	 */
	public List<WorkoutModel> getWorkouts();
	
	/**
	 * Gets the clients.
	 *
	 * @return the clients
	 */
	public List<ClientModel> getClients();
	
	/**
	 * Adds the client.
	 *
	 * @param client 
	 */
	public void addClient(ClientModel client);
	
	/**
	 * Adds the trainer.
	 *
	 * @param trainer 
	 */
	public void addTrainer(TrainerModel trainer);
	
	/**
	 * Adds the workout.
	 *
	 * @param workout
	 */
	public void addWorkout(WorkoutModel workout);
	
	/**
	 * Adds the user workout.
	 *
	 * @param workout 
	 * @param client 
	 */
	public void addUserWorkout(WorkoutModel workout, ClientModel client);
	
	/**
	 * Removes the user workout.
	 *
	 * @param workoutId 
	 */
	public void removeUserWorkout(String workoutId);
	
	/**
	 * Gets the workout by name.
	 *
	 * @param workoutName 
	 * @return the workout by name
	 */
	public WorkoutModel getWorkoutByName(String workoutName);
	
	/**
	 * Gets the client.
	 *
	 * @param clientID 
	 * @return the client
	 */
	public ClientModel getClient(String clientID);
	
	/**
	 * Gets the account by ID.
	 *
	 * @param accountID 
	 * @return the account by ID
	 */
	public AccountModel getAccountByID(String accountID);
	
	/**
	 * Gets the account by login.
	 *
	 * @param username 
	 * @param password 
	 * @return the account by login
	 */
	public AccountModel getAccountByLogin(String username, String password);

	/**
	 * Gets the workout by id.
	 *
	 * @param workoutid 
	 * @return the workout by id
	 */
	public WorkoutModel getWorkoutById(String workoutid);

	/**
	 * Gets the user workout by id.
	 *
	 * @param workoutId 
	 * @return the user workout by id
	 */
	public UserWorkoutsModel getUserWorkoutById(String workoutId);
	
	/**
	 * Gets the user workout by name.
	 *
	 * @param workoutName 
	 * @return the user workout by name
	 */
	public UserWorkoutsModel getUserWorkoutByName(String workoutName);

	/**
	 * Complete user workout.
	 *
	 * @param id 
	 * @param date 
	 */
	public void completeUserWorkout(String id, String date);

}
