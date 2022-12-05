package com.gcu.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class WorkoutModel.
 */
public class WorkoutModel {
	
	/** The name. */
	@NotNull(message = "Workout name is a required field")
	@Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
	private String name;
	
	/** The calories per set. */
	@NotNull(message = "Calories is a required field")
	@Min(value = 1, message = "Calories should not be less than 1")
	@Max(value = 2000, message = "No way you have a set that burns over 2000 calories")
	
	private int caloriesPerSet;
	
	/** The time per set. */
	@NotNull(message = "Time Per Set is a required field")
	@Size(min = 1, max = 32, message = "Time per Set must be between 1 and 32 characters")
	private String timePerSet;
	
	/** The Id. */
	String Id;
	
	/**
	 * Instantiates a new workout model.
	 *
	 * @param Id 
	 * @param name 
	 * @param calories 
	 * @param setTime 
	 */
	public WorkoutModel(String Id,String name, int calories, String setTime) {
		super();
		this.Id = Id;
		this.name = name;
		caloriesPerSet = calories;
		setTimePerSet(setTime);
	}
	
	/**
	 * Instantiates a new workout model.
	 */
	public WorkoutModel() {}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the calories per set.
	 *
	 * @return the calories per set
	 */
	public int getCaloriesPerSet() {
		return caloriesPerSet;
	}
	
	/**
	 * Sets the calories per set.
	 *
	 * @param calories per set
	 */
	public void setCaloriesPerSet(int calories) {
		caloriesPerSet = calories;
	}
	
	/**
	 * Gets the time per set.
	 *
	 * @return the time per set
	 */
	public String getTimePerSet() {
		return timePerSet;
	}
	
	/**
	 * Sets the time per set.
	 *
	 * @param timePerSet 
	 */
	public void setTimePerSet(String timePerSet) {
		this.timePerSet = timePerSet;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	
	
}
