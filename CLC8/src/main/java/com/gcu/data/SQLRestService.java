package com.gcu.data;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.model.UserWorkoutsModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;
import com.gcu.services.RestServiceInterface;

/**
 * The Class SQLRestService.
 */
@Service
public class SQLRestService implements RestServiceInterface {

	/** The data source. */
	@Autowired
	DataSource dataSource;
	
	/** The accounts service. */
	AccountsDataService accountsService;
	
	/** The workouts service. */
	WorkoutsDataService workoutsService;
	
	/** The user workouts service. */
	UserWorkoutsDataService userWorkoutsService;
	
	/**
	 * Instantiates a new SQL rest service.
	 *
	 * @param dS the data source
	 */
	public SQLRestService(DataSource dS) {
		accountsService = new AccountsDataService(dS);
		workoutsService = new WorkoutsDataService(dS);
		userWorkoutsService = new UserWorkoutsDataService(dS);
	}
	
	/**
	 * Gets the workouts.
	 *
	 * @return the workouts
	 */
	@Override
	public List<WorkoutModel> getWorkouts() {
		
		return workoutsService.findAll();
	}
	
	/**
	 * Gets the user workouts.
	 *
	 * @param id 
	 * @return the user workouts
	 */
	@Override
	public List<UserWorkoutsModel> getUserWorkouts(String id) {
		return (List<UserWorkoutsModel>) userWorkoutsService.findByClientId(id);
	}

	/**
	 * Gets the clients.
	 *
	 * @return the clients
	 */
	@Override
	public List<ClientModel> getClients() {
		return accountsService.findAllClients();
	}

	/**
	 * Adds the client.
	 *
	 * @param client 
	 */
	@Override
	public void addClient(ClientModel client) {
		client.setPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
		accountsService.createClient(client);
		
	}

	/**
	 * Adds the trainer.
	 *
	 * @param trainer 
	 */
	@Override
	public void addTrainer(TrainerModel trainer) {
		trainer.setPassword(new BCryptPasswordEncoder().encode(trainer.getPassword()));
		accountsService.createTrainer(trainer);
		
	}

	/**
	 * Adds the workout.
	 *
	 * @param workout 
	 */
	@Override
	public void addWorkout(WorkoutModel workout) {
		workoutsService.createBaseWorkout(workout);
		
	}
	
	/**
	 * Adds the user workout.
	 *
	 * @param workout 
	 * @param client 
	 */
	@Override
	public void addUserWorkout(WorkoutModel workout, ClientModel client) {
		userWorkoutsService.createBaseWorkout(workout, client);
	}

	/**
	 * Gets the client by ID.
	 *
	 * @param clientID 
	 * @return the client
	 */
	@Override
	public ClientModel getClient(String clientID) {
		return accountsService.findClient(clientID);
	}

	/**
	 * Gets the account by ID.
	 *
	 * @param accountID 
	 * @return the account by ID
	 */
	@Override
	public AccountModel getAccountByID(String accountID) {
		return accountsService.getAccountByID(accountID);
	}

	/**
	 * Gets the account by login.
	 *
	 * @param username 
	 * @param password 
	 * @return the account by login
	 */
	@Override
	public AccountModel getAccountByLogin(String username, String password) {
		return accountsService.getAccountByLogin(username, password);
	}

	/**
	 * Gets the workout by name.
	 *
	 * @param workoutName 
	 * @return the workout by name
	 */
	@Override
	public WorkoutModel getWorkoutByName(String workoutName) {
		return workoutsService.findByName(workoutName);
	}
	
	/**
	 * Gets the workout by id.
	 *
	 * @param workoutid 
	 * @return the workout by id
	 */
	@Override
	public WorkoutModel getWorkoutById(String workoutid) {
		return workoutsService.getWorkoutById(workoutid);
	}

	/**
	 * Removes the user workout.
	 *
	 * @param workoutId the workout id
	 */
	@Override
	public void removeUserWorkout(String workoutId) {

		System.out.println("delete user workout " + workoutId);
		userWorkoutsService.delete(workoutId);
	}

	/**
	 * Gets the user workout by name.
	 *
	 * @param workoutName 
	 * @return the user workout by name
	 */
	@Override
	public UserWorkoutsModel getUserWorkoutByName(String workoutName) {
		return userWorkoutsService.findByName(workoutName);
	}

	/**
	 * Gets the user workout by id.
	 *
	 * @param workoutId 
	 * @return the user workout by id
	 */
	@Override
	public UserWorkoutsModel getUserWorkoutById(String workoutId) {
		return userWorkoutsService.getUserWorkoutById(workoutId);
	}

	/**
	 * Complete user workout and add today's date.
	 *
	 * @param id 
	 * @param date 
	 */
	@Override
	public void completeUserWorkout(String id, String date) {
		userWorkoutsService.completeWorkoutbyId(id, date);
	}
}
