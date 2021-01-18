package com.javainuse.user;

//import org.springframework.security.core.userdetails.UserDetails;

public interface JwtUserDetailsService {
	public User save(LoginUser user);
	//public UserDetails loadUserByUsername(String userName);
}
