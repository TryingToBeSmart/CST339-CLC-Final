package com.gcu;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The Class SpringConfig gets the data from MySQL
 */
@Configuration
public class SpringConfig {
	
	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource getDataSource()
	{
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/cst339");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("root");
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		return dataSourceBuilder.build();
	}
	
}
