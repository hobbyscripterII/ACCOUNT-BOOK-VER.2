package com.project.accountbook.user;

import org.apache.ibatis.annotations.Mapper;

import com.project.accountbook.security.MyUserDetails;

@Mapper
public interface UserMapper {
	MyUserDetails getUser(String id);
}