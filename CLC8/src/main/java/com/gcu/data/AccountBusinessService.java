package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.model.accounts.AccountModel;

/**
 * The Class AccountBusinessService.
 */
@Service
public class AccountBusinessService implements UserDetailsService{

	/** Constructor injection. Loads the Data from MySQL*/
	@Autowired
	AccountsDataService service;
	
	/**
	 * Load user by username.
	 *
	 * @param username 
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountModel user = service.findByUsername(username);
		if(user != null)
		{
			return new AccountsDetailsService(user);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}
	}

}
