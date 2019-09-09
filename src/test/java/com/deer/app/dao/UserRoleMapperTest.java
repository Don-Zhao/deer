package com.deer.app.dao;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.deer.app.daoobj.DeerUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Test
	public void getUserByUsernameTest() {
		DeerUser user = userRoleMapper.getUserByUsername("zhao.jiahong");
		
		Assert.assertThat("zhao.jiahong", Matchers.equalTo(user.getPassword()));
		Assert.assertThat(1, Matchers.equalTo(user.getId()));
	}
	
	@Test
	public void getRoleByUsernameTest() {
		List<String> roles = userRoleMapper.getRoleByUsername("zhao.jiahong");
		
		Assert.assertNotNull(roles);
		Assert.assertThat(roles.get(0), Matchers.equalTo("ADMIN"));
	}
}
