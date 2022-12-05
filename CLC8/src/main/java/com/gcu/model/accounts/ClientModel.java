package com.gcu.model.accounts;

import java.util.ArrayList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gcu.model.GoalsModel;
import com.gcu.model.UserWorkoutsModel;

/**
 * The Class ClientModel.
 */
public class ClientModel extends AccountModel
{
	
	/** The age. */
	@Min(value = 1, message = "Age should not be less than 1")
	private int age;
	
	/** The weight. */
	@Min(value = 1, message = "Weight should not be less than 1 pound")
	private int weight;
	
	/** The height. */
	@Min(value = 1, message = "Height should not be less than 1 inch")
	private int height;
	
	/** The workouts. */
	private ArrayList<UserWorkoutsModel> workouts = new ArrayList<UserWorkoutsModel>();
	
	/** The goals. */
	private ArrayList<GoalsModel> goals = new ArrayList<GoalsModel>();
	
	
	/**
	 * Instantiates a new client model.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param age the age
	 * @param weight the weight
	 * @param height the height
	 * @param username the username
	 * @param password the password
	 * @param accountID the account ID
	 */
	public ClientModel(
			@NotNull(message = "First name is a required field") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String firstName,
			@NotNull(message = "Last name is a required field") @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") String lastName,
			@Min(value = 1, message = "Age should not be less than 1") int age,
			@Min(value = 1, message = "Weight should not be less than 1 pound") int weight,
			@Min(value = 1, message = "Height should not be less than 1 inch") int height,
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password,
			String accountID) {
		super(username, password, firstName, lastName, accountID);
		this.age = age;
		this.weight = weight;
		this.height = height;
	System.out.println("client created");
	}

	/**
	 * Instantiates a new client model.
	 */
	public ClientModel() {
		super();
		//Blank Client Model
	}

	/**
	 * Gets the workouts.
	 *
	 * @return the workouts
	 */
	public ArrayList<UserWorkoutsModel> getWorkouts() {
		return workouts;
	}

	/**
	 * Sets the workouts.
	 *
	 * @param workouts the new workouts
	 */
	public void setWorkouts(ArrayList<UserWorkoutsModel> workouts) {
		this.workouts = workouts;
	}

	/**
	 * Gets the goals.
	 *
	 * @return the goals
	 */
	public ArrayList<GoalsModel> getGoals() {
		return goals;
	}

	/**
	 * Sets the goals.
	 *
	 * @param goals the new goals
	 */
	public void setGoals(ArrayList<GoalsModel> goals) {
		this.goals = goals;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() 
	{
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) 
	{
		this.age = age;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() 
	{
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) 
	{
		this.height = height;
	}
}