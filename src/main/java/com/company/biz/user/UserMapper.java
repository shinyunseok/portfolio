package com.company.biz.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	
	@Select("select * from springUsers where ID=#{id} and PASSWORD=#{password}")
	public User getUser(User user);
	
}
