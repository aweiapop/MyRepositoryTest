package com.dom.mapper;


import com.dom.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by little Stone
 * Date 2019/6/24 Time 14:46
 */
public interface UserMapper {

	User queryUserById(@Param("id") int id);
	User queryUserByUsernameAndPassword(@Param("user") User user);
}
