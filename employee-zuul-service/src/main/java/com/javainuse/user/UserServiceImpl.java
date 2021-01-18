package com.javainuse.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.dao.UserRepository;

@Service(value = "userService")
public class UserServiceImpl {
	//implements JwtUserDetailsService {

	/*@Autowired
	private UserRepository userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(LoginUser user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}*/

	/*public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		List<String> roles = new ArrayList<>();
		roles.add(user.getRole());
		Set<GrantedAuthority> grantedAuthorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toSet());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()),grantedAuthorities);
	}*/
}