package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.UserWorkoutsModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.ClientModel;

public class UserWorkoutsDataService{

	
	/** The data source. */
	private DataSource dataSource;
	
	/** The jdbc template object. */
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Instantiates a new workouts data service.
	 */
	public UserWorkoutsDataService(DataSource dS)
	{
		this.dataSource = dS;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Find all workouts and return list.
	 *
	 * @return the list
	 */
	public List<UserWorkoutsModel> findAll() {
		
		String sql = "SELECT * FROM user_workouts";
		List<UserWorkoutsModel> workouts = new ArrayList<UserWorkoutsModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				workouts.add(new UserWorkoutsModel(
						srs.getString("idworkouts"),
						srs.getString("NAME"),
						srs.getInt("CALORIES_PER_SET"),
						srs.getString("TIME_PER_SET"),
						srs.getString("STATUS"),
						srs.getString("DATE_COMPLETE")
						));
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return workouts;
	}

	
	/**
	 * Find workout by name.
	 *
	 * @param name the name
	 * @return the workout model
	 */
	public UserWorkoutsModel findByName(String name) {
		String sql = "SELECT * FROM user_workouts WHERE NAME = '" + name + "'";
		System.out.println(sql);
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				return new UserWorkoutsModel(
						srs.getString("idworkouts"),
						srs.getString("NAME"),
						srs.getInt("CALORIES_PER_SET"),
						srs.getString("TIME_PER_SET"),
						srs.getString("STATUS"),
						srs.getString("DATE_COMPLETE")
						);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
		
		public UserWorkoutsModel getUserWorkoutById(String workoutId) {
			String sql = "SELECT * FROM user_workouts WHERE NAME = '" + workoutId + "'";
			try
			{
				//Execute SQL Query and loop over result set
				SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
				while(srs.next())
				{
					return new UserWorkoutsModel(
							srs.getString("idworkouts"),
							srs.getString("NAME"),
							srs.getInt("CALORIES_PER_SET"),
							srs.getString("TIME_PER_SET"),
							srs.getString("STATUS"),
							srs.getString("DATE_COMPLETE")
							);
				}
				
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Find workout by client ID.
	 *
	 * @param id
	 * @return the workouts
	 */

	public List<UserWorkoutsModel> findByClientId(String id) {
		String sql = "SELECT * FROM user_workouts WHERE CLIENT_ID = '" + id+"'";
		List<UserWorkoutsModel> workouts = new ArrayList<UserWorkoutsModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				workouts.add(new UserWorkoutsModel(
						srs.getString("idworkouts"),
						srs.getString("NAME"),
						srs.getInt("CALORIES_PER_SET"),
						srs.getString("TIME_PER_SET"),
						srs.getString("STATUS"),
						srs.getString("DATE_COMPLETE")
						));
				System.out.println(srs.getString("idworkouts"));
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return workouts;
	}
	
	/**
	 * Creates workout for user.
	 *
	 * @param workout
	 * @return true, if successful
	 */
	public boolean createBaseWorkout(WorkoutModel workout, ClientModel client) {
		String sql = "INSERT INTO user_workouts(NAME,CALORIES_PER_SET,TIME_PER_SET,CLIENT_ID) VALUES(?,?,?,?)";
		try
		{
			int rows =jdbcTemplateObject.update(sql,
					workout.getName(),
					workout.getCaloriesPerSet(),
					workout.getTimePerSet(),
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
	 * Update user workout.
	 *
	 * @param workout the workout
	 * @return true, if successful
	 */
	public boolean updateBaseWorkout(UserWorkoutsModel workout) {
		String sql = "UPDATE user_workouts SET "
				+ "NAME = ?,CALORIES_PER_SET = ?,TIME_PER_SET = ?,STATUS = ?,DATE_COMPLETE = ?) VALUES(?,?,?,?,?)";
		try
		{
			int rows =jdbcTemplateObject.update(sql,
					workout.getName(),
					workout.getCaloriesPerSet(),
					workout.getTimePerSet(),
					workout.getStatus(),
					workout.getDateComplete());
			
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	//TODO not being called by clientWorkouts.html
	/**
	 * Delete by name of workout.
	 *
	 * @param name
	 * @return true, if successful
	 */
	public boolean delete(String workoutId) {
		String sql = "DELETE FROM user_workouts WHERE name = '" + workoutId + "'";
		System.out.println(sql);
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

	public void removeUserWorkout(UserWorkoutsModel workout) {
		// TODO Auto-generated method stub
		
	}

	public boolean completeWorkoutbyId(String id, String date) {
		String sql = "UPDATE user_workouts SET `STATUS` = 'Complete', "
				+ "`DATE_COMPLETE` = '"+ date +"' WHERE (`NAME` = '" + id + "')";
		System.out.println(sql);
		try
		{
			int rows =jdbcTemplateObject.update(sql);
			
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	


}
