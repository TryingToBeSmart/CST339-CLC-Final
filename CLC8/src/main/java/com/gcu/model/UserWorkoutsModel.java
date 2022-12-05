package com.gcu.model;

/**
 * The Class UserWorkoutModel.
 */
public class UserWorkoutsModel extends WorkoutModel {

	/** Date completion. */
	private String dateComplete;
	
	/** The Status. */
	private String status;
	
	private String Id;
	/**
	 * Instantiates a new user workout model.
	 *
	 * @param name the name
	 * @param calories the calories
	 * @param setTime the set time
	 * @param completion the completion
	 * @param status the status
	 */
	public UserWorkoutsModel(String Id, String name, int calories, String setTime, String status, String dateComplete) {
		super(Id, name, calories, setTime);
		this.dateComplete = dateComplete;
		this.status = status;
		System.out.println("UserWorkoutsModel created with workout Id: "+Id);
	}
	
	/**
	 * Gets the completion.
	 *
	 * @return the completion
	 */
	public String getDateComplete() {
		return dateComplete;
	}
	
	/**
	 * Sets the completion date.
	 *
	 * @param completion the new completion
	 */
	public void setDateComplete(String dateComplete) {
		this.dateComplete = dateComplete;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
}
