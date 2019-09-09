package com.deer.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.deer.app.daoobj.DeerUser;

@Mapper
public interface UserRoleMapper {
	
	@Select("select * from t_table_user where username=#{username}")
	public DeerUser getUserByUsername(String username);
	
	@Select("select r.role from t_table_user u inner join t_user_role ur on ur.user_id = u.id inner join t_table_role r on ur.role_id=r.id where u.username=#{username}")
	public List<String> getRoleByUsername(String username);
}
