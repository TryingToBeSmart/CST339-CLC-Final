package com.gcu.model.accounts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class AccountModel.
 */
public class AccountModel {

	/** The username. */
	@NotNull(message = "Username is a required field")
	@Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
	private String username;
	
	/** The password. */
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;
	
	/** The first name. */
	@NotNull(message = "First name is a required field")
	@Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
	private String firstName;
	
	/** The last name. */
	@NotNull(message = "Last name is a required field")
	@Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
	private String lastName;
	
	/** The account ID. */
	private String accountID;
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	/**
	 * Instantiates a new account model.
	 *
	 * @param username the username
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param accountId the account id
	 */
	public AccountModel(
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password,
			@NotNull(message = "First name is a required field") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String firstName,
			@NotNull(message = "Last name is a required field") @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") String lastName,
			String accountId) {
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountId;
	}
	
	/**
	 * Instantiates a new account model.
	 */
	public AccountModel() {}
	
	/**
	 * Gets the account ID.
	 *
	 * @return the account ID
	 */
	public String getAccountID() {
		return accountID;
	}
	
	/**
	 * Sets the account ID.
	 *
	 * @param accountID the new account ID
	 */
	//not needed, will be set automatically in table
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
}
