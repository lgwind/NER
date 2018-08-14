package com.lgwind.controller.util;

import java.util.List;

import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

public class UserUtil {
	
	public static String username="还没保存用户名哦~";//登录时保存的用户名，临时变量
	public static String userrole="还没保存用户角色哦~";//登录时保存的用户角色，临时变量
	
	public static String page="null";//当前页面，临时变量
	
	private static String usernameSuper="Lgwind";//超级用户的用户名
	private static String passwordSuper="11111";//超级用户的密码
	
	/**
	 * 验证是否是系统超级用户
	 * @param user 登录的用户信息实体类
	 * @return
	 */
	public static boolean isSuperUser(User user) {
		//若是超级用户的用户名
		if(user.getUsername().equals(usernameSuper)) {
			//若是超级用户的密码
			if(user.getPassword().equals(passwordSuper)) {
				//确定是系统超级用户
				return true;
			}
		}
		//验证后发现不是系统超级用户
		return false;
	}
	
	/**
	 * 验证用户名是否存在
	 * @param username 用户名
	 * @return
	 */
	public static boolean isExitName(String username) {
		//获取用户表的所有信息
		List<User> listUser = new UserDao().getAll();
		//遍历用户表所有信息，判断是否有此用户名
		String username_temp="";//临时用户名
//		System.out.println(username);
		for(int i=0; i<listUser.size(); i++) {
			username_temp=listUser.get(i).getUsername();
//			System.out.println("username_temp="+username_temp);
			//若用户表中存在相同的用户名，则返回true
			if(username.equals(username_temp)) {
				return true;
			}
		}
		//若用户表中不存在相同的用户名，则返回false
		return false;
	}
	
	/**
	 * 验证密码是否正确
	 * @param user 登录的用户信息实体类
	 * @return
	 */
	public static boolean isTruePassword(User user) {
		//获取数据库中此用户名对应的实体类信息
		User user_temp=new UserDao().get(user.getUsername());
		if(user_temp.getPassword().equals(user.getPassword())) {
			//若密码相同，则返回true
			return true;
		}
		//若密码不同，则返回false
		return false;
	}
	
	/**
	 * 返回用户名对应的角色身份
	 * @param username
	 * @return
	 */
	public static String roleIS(String username) {
		//获取数据库中此用户名对应的实体类信息
		User user_temp=new UserDao().get(username);
		//返回此用户名的角色身份
		return user_temp.getRole();
	}

	/**
	 * 超级管理员的密码的get() 
	 * @return
	 */
	public static String getPasswordSuper() {
		return passwordSuper;
	}

	/**
	 * 超级管理员的密码的set()
	 * @param passwordSuper
	 */
	public static void setPasswordSuper(String passwordSuper) {
		UserUtil.passwordSuper = passwordSuper;
	}
	
	/**
	 * 验证两次输入的密码是否一致
	 * @param password
	 * @param password2
	 * @return
	 */
	public static boolean isTwiceSamePassword(String password, String password2){
	    if(password.equals(password2)){
	        return true;
	    }
	    return false;
	}
	
	

}
