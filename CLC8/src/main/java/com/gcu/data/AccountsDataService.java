package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;

/**
 * The Class AccountsDataService.
 */
@Service
public class AccountsDataService{

	/** The data source. */
	private DataSource dataSource;
	
	/** The jdbc template object. */
	private JdbcTemplate jdbcTemplateObject;
	
	
	/**
	 * Instantiates a new accounts data service.
	 *
	 * @param dS the dataSource
	 */
	public AccountsDataService(DataSource dS)
	{
		this.dataSource = dS;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Find by username.
	 *
	 * @param username
	 * @return the account model
	 */
	public AccountModel findByUsername(String username)
	{
		String sql = "SELECT * FROM CLIENTS WHERE USERNAME = '" + username + "'";
		AccountModel account = null;
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new ClientModel(
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getInt("AGE"),
						srs.getInt("WEIGHT"),
						srs.getInt("HEIGHT"),
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("idCLIENTS"));
			}
			
			
			sql = "SELECT * FROM TRAINERS WHERE USERNAME = '" + username + "'";
			srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new TrainerModel(
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getString("idtrainers"),
						srs.getString("TRAINER_ID"));
			}
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return account;
	}
	
	/**
	 * Find all info under Clients and Trainers.
	 *
	 * @return the list of clients and/or trainers
	 */
	public List<AccountModel> findAll() {
		String sql = "SELECT * FROM CLIENTS";
		List<AccountModel> accounts = new ArrayList<AccountModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				accounts.add(new ClientModel(
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getInt("AGE"),
						srs.getInt("WEIGHT"),
						srs.getInt("HEIGHT"),
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("idCLIENTS")));
			}
			
			
			sql = "SELECT * FROM TRAINERS";
			srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				accounts.add(new TrainerModel(
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getString("idtrainers"),
						srs.getString("TRAINER_ID")));
			}
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return accounts;
	}

	/**
	 * Find all clients.
	 *
	 * @return the list
	 */
	public List<ClientModel> findAllClients()
	{
		String sql = "SELECT * FROM CLIENTS";
		List<ClientModel> accounts = new ArrayList<ClientModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				accounts.add(new ClientModel(
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getInt("AGE"),
						srs.getInt("WEIGHT"),
						srs.getInt("HEIGHT"),
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("idCLIENTS")));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	/**
	 * Find all trainers.
	 *
	 * @return the list
	 */
	public List<TrainerModel> findAllTrainers() {
		String sql = "SELECT * FROM TRAINERS";
		List<TrainerModel> accounts = new ArrayList<TrainerModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				accounts.add(new TrainerModel(
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getString("idtrainers"),
						srs.getString("TRAINER_ID")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return accounts;
	}



	/**
	 * Creates the client.
	 *
	 * @param client 
	 * @return true, if successful
	 */
	public boolean createClient(ClientModel client) {
		String sql = "INSERT INTO CLIENTS(FIRST_NAME,LAST_NAME,AGE,WEIGHT,HEIGHT, USERNAME, PASSWORD) VALUES(?,?,?,?,?,?,?)";
		try
		{
			int rows =jdbcTemplateObject.update(sql,
					client.getFirstName(),
					client.getLastName(),
					client.getAge(),
					client.getWeight(),
					client.getHeight(),
					client.getUsername(),
					client.getPassword());
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Creates the trainer.
	 *
	 * @param trainer 
	 * @return true, if successful
	 */
	public boolean createTrainer(TrainerModel trainer) {
		String sql = "INSERT INTO TRAINERS(FIRST_NAME,LAST_NAME, USERNAME, PASSWORD, TRAINER_ID) VALUES(?,?,?,?,?)";
		try
		{
			int rows =jdbcTemplateObject.update(sql,
					trainer.getFirstName(),
					trainer.getLastName(),
					trainer.getUsername(),
					trainer.getPassword(),
					trainer.getTrainerID());
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Update client.
	 *
	 * @param client
	 * @return true, if successful
	 */
	public boolean updateClient(ClientModel client) {
		String sql = "UPDATE CLIENTS SET "
				+ "FIRST_NAME = ?,LAST_NAME = ?,AGE = ?,WEIGHT = ?,HEIGHT = ?, USERNAME = ?, PASSWORD = ?, ACCOUNT_ID = ?) VALUES(?,?,?,?,?,?,?,?)";
		try
		{
			int rows = jdbcTemplateObject.update(sql,
					client.getFirstName(),
					client.getLastName(),
					client.getAge(),
					client.getWeight(),
					client.getHeight(),
					client.getUsername(),
					client.getPassword(),
					client.getAccountID());
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update trainer.
	 *
	 * @param trainer 
	 * @return true, if successful
	 */
	public boolean updateTrainer(TrainerModel trainer) {
		String sql = "UPDATE TRAINERS SET "
				+ "FIRST_NAME = ?,LAST_NAME = ?, USERNAME = ?, PASSWORD = ?, ACCOUNT_ID = ?, TRAINER_ID = ?) VALUES(?,?,?,?,?,?)";
		try
		{
			int rows = jdbcTemplateObject.update(sql,
					trainer.getFirstName(),
					trainer.getLastName(),
					trainer.getUsername(),
					trainer.getPassword(),
					trainer.getAccountID(),
					trainer.getTrainerID());
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Delete client.
	 *
	 * @param AccountID 
	 * @return true, if successful
	 */
	public boolean deleteClient(String AccountID) {
		String sql = "DELETE FROM CLIENTS WHERE idCLIENTS = " + AccountID;
		try
		{
			int rows = jdbcTemplateObject.update(sql);
			return rows == 1? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Delete trainer.
	 *
	 * @param AccountID 
	 * @return true, if successful
	 */
	public boolean deleteTrainer(int AccountID) {
		String sql = "DELETE FROM TRAINERS WHERE idtrainers = " + AccountID;
		try
		{
			int rows = jdbcTemplateObject.update(sql);
			return rows == 1? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * Find client.
	 *
	 * @param clientID 
	 * @return the client model
	 */
	public ClientModel findClient(String clientID) {
		String sql = "SELECT * FROM CLIENTS WHERE idCLIENTS = " + clientID;
		ClientModel client = null;
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				client =(new ClientModel(
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getInt("AGE"),
						srs.getInt("WEIGHT"),
						srs.getInt("HEIGHT"),
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("idCLIENTS")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return client;
	}


	/**
	 * Gets the account by ID.
	 *
	 * @param accountID 
	 * @return the account by ID
	 */
	public AccountModel getAccountByID(String accountID) {
		String sql = "SELECT * FROM CLIENTS WHERE idCLIENTS = " + accountID;
		AccountModel account = null;
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new ClientModel(
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getInt("AGE"),
						srs.getInt("WEIGHT"),
						srs.getInt("HEIGHT"),
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("idCLIENTS"));
			}
			
			
			sql = "SELECT * FROM TRAINERS WHERE idtrainers = "+ accountID;
			srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new TrainerModel(
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getString("idtrainers"),
						srs.getString("TRAINER_ID"));
			}
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return account;
	}


	/**
	 * Gets the account by login.
	 *
	 * @param username 
	 * @param password 
	 * @return the account by login
	 */
	public AccountModel getAccountByLogin(String username, String password) {
		String sql = "SELECT * FROM CLIENTS WHERE (USERNAME = '" + username + "' AND PASSWORD = '" + password + "')";
		AccountModel account = null;
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new ClientModel(
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getInt("AGE"),
						srs.getInt("WEIGHT"),
						srs.getInt("HEIGHT"),
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("idCLIENTS"));
			}
			
			
			sql = "SELECT * FROM TRAINERS WHERE (USERNAME = '" + username + "' AND PASSWORD = '" + password + "')";
			srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new TrainerModel(
						srs.getString("USERNAME"),
						srs.getString("PASSWORD"),
						srs.getString("FIRST_NAME"),
						srs.getString("LAST_NAME"),
						srs.getString("idtrainers"),
						srs.getString("TRAINER_ID"));
			}
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return account;
	}

		

}
