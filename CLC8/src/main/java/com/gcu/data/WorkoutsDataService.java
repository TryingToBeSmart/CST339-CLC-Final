package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.WorkoutModel;


/**
 * The Class WorkoutsDataService.
 */
public class WorkoutsDataService{

	
	/** The data source. */
	private DataSource dataSource;
	
	/** The jdbc template object. */
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Instantiates a new workouts data service.
	 */
	public WorkoutsDataService(DataSource dS)
	{
		this.dataSource = dS;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Find all workouts and return list.
	 *
	 * @return the list
	 */
	public List<WorkoutModel> findAll() {
		
		String sql = "SELECT * FROM WORKOUTS";
		List<WorkoutModel> workouts = new ArrayList<WorkoutModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				workouts.add(new WorkoutModel(
						srs.getString("idworkouts"),
						srs.getString("NAME"),
						srs.getInt("CALORIES_PER_SET"),
						srs.getString("TIME_PER_SET")
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
	 * Find workout by ID.
	 *
	 * @param name the name
	 * @return the workout model
	 */
	public WorkoutModel getWorkoutById(String id) {
		String sql = "SELECT * FROM workouts WHERE idworkouts = " + id;
		System.out.println(sql);
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) {
				 return new WorkoutModel(
						srs.getString("idworkouts"),
						srs.getString("NAME"),
						srs.getInt("CALORIES_PER_SET"),
						srs.getString("TIME_PER_SET")
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
	 * Creates workout.
	 *
	 * @param workout
	 * @return true, if successful
	 */
	public boolean createBaseWorkout(WorkoutModel workout) {
		String sql = "INSERT INTO WORKOUTS(NAME,CALORIES_PER_SET,TIME_PER_SET) VALUES(?,?,?)";
		try
		{
			int rows =jdbcTemplateObject.update(sql,
					workout.getName(),
					workout.getCaloriesPerSet(),
					workout.getTimePerSet());
			
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * Update base workout.
	 *
	 * @param workout the workout
	 * @return true, if successful
	 */
	public boolean updateBaseWorkout(WorkoutModel workout) {
		String sql = "UPDATE WORKOUTS SET "
				+ "NAME = ?,CALORIES_PER_SET = ?,TIME_PER_SET = ?) VALUES(?,?,?)";
		try
		{
			int rows =jdbcTemplateObject.update(sql,
					workout.getName(),
					workout.getCaloriesPerSet(),
					workout.getTimePerSet());
			
			return rows == 1? true: false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * Delete by name of workout.
	 *
	 * @param name
	 * @return true, if successful
	 */
	public boolean delete(String name) {
		String sql = "DELETE FROM WORKOUTS WHERE NAME = " + name;
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

	public WorkoutModel findByName(String workoutName) {
		String sql = "SELECT * FROM workouts WHERE name = '" + workoutName + "'";
		System.out.println(sql);
		try
		{
			//Execute SQL Query and create WorkoutModel object base on return
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			
			while(srs.next())
			{
				return new WorkoutModel(
						srs.getString("idworkouts"),
						srs.getString("NAME"),
						srs.getInt("CALORIES_PER_SET"),
						srs.getString("TIME_PER_SET")
						);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}


}
