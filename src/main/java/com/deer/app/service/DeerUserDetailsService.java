package com.deer.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.deer.app.dao.UserRoleMapper;
import com.deer.app.daoobj.DeerUser;

@Component("userService")
public class DeerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DeerUser user = userRoleMapper.getUserByUsername(username);
		List<String> roles= userRoleMapper.getRoleByUsername(username);
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (String role : roles) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
			authorities.add(authority);
		}
		
		return new User(username, user.getPassword(), authorities);
	}

}
