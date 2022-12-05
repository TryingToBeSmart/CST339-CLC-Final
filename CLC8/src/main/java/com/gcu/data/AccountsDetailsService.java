package com.gcu.data;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;

/**
 * The Class AccountsDetailsService.
 */
public class AccountsDetailsService implements UserDetails {

	
	/** The account. */
	AccountModel account;
	
	/**
	 * Instantiates a new accounts details service.
	 *
	 * @param account the account
	 */
	public AccountsDetailsService(AccountModel account)
	{
		this.account = account;
	}
	
	/**
	 * Instantiates a new accounts details service.
	 */
	public AccountsDetailsService()
	{
		
	}
	
	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(account instanceof ClientModel)
		{
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_client"));
		}
		else
		{
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_trainer"));
		}
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return account.getPassword();
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return account.getUsername();
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
