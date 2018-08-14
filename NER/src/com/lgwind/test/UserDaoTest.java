package com.lgwind.test;

import java.util.List;

import org.junit.Test;

import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

public class UserDaoTest {

	@Test
	public void testAdd() {
		// 新建用户表实体类
		User user = new User("小黑2", "11111", "老师");
		new UserDao().add(user);
	}

	@Test
	public void testDelete() {
		new UserDao().delete("小黑2");
	}

	@Test
	public void testUpdate() {
		// 新建用户表实体类
		User user = new User("小黑2", "123456", "学生");
		new UserDao().update(user);
	}

	@Test
	public void testGet() {
		User user = new UserDao().get("小黑2");
		System.out.println(user);
	}

	@Test
	public void testGetAll() {
		List<User> listUser = new UserDao().getAll();
		System.out.println(listUser);
	}

}
