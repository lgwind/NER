package com.lgwind.test;

import java.util.List;

import org.junit.Test;

import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

public class UserDaoTest {

	@Test
	public void testAdd() {
		// �½��û���ʵ����
		User user = new User("С��2", "11111", "��ʦ");
		new UserDao().add(user);
	}

	@Test
	public void testDelete() {
		new UserDao().delete("С��2");
	}

	@Test
	public void testUpdate() {
		// �½��û���ʵ����
		User user = new User("С��2", "123456", "ѧ��");
		new UserDao().update(user);
	}

	@Test
	public void testGet() {
		User user = new UserDao().get("С��2");
		System.out.println(user);
	}

	@Test
	public void testGetAll() {
		List<User> listUser = new UserDao().getAll();
		System.out.println(listUser);
	}

}
