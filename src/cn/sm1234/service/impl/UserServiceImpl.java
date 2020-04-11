package cn.sm1234.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sm1234.domain.User;
import cn.sm1234.dao.UserMapper;
import cn.sm1234.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userDao;

	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}

}
