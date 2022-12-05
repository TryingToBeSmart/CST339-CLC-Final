package com.gcu.model.accounts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class TrainerModel.
 */
public class TrainerModel extends AccountModel
{
	
	/** The trainer ID. */
	private String trainerID;

	/**
	 * Gets the trainer ID.
	 *
	 * @return the trainer ID
	 */
	public String getTrainerID() {
		return trainerID;
	}

	/**
	 * Sets the trainer ID.
	 *
	 * @param trainerID the new trainer ID
	 */
	public void setTrainerID(String trainerID) {
		this.trainerID = trainerID;
	}

	/**
	 * Instantiates a new trainer model.
	 *
	 * @param username the username
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param accountID the account ID
	 * @param trainerID the trainer ID
	 */
	public TrainerModel(
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password,
			@NotNull(message = "First name is a required field") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String firstName,
			@NotNull(message = "Last name is a required field") @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") String lastName,
			String accountID,
			String trainerID) {
		super(username, password, firstName, lastName, accountID);
		this.trainerID = trainerID;
	}
	
	/**
	 * Instantiates a new trainer model.
	 */
	public TrainerModel() {}
	
}
