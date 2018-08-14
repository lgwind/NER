package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.controller.util.UserUtil;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 跳转到用户登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping("userLogin")
	public String userLogin(Model model) {
		System.out.println("跳转到用户登录界面");
//		model.addAttribute("message","Hello World！");
		return "userLogin";
	}
	
	/**
	 * 执行登录操作，验证用户名和密码
	 * @param user 用户实体类
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user, Model model) {
		//保存登录时的用户名
		UserUtil.username=user.getUsername();
		
		//验证是否是系统超级用户
		boolean superUser=UserUtil.isSuperUser(user);
		//若是超级用户，则设置登录角色为超级管理员，进入用户后台界面
		if (superUser) {
			UserUtil.userrole="超级管理员";
			//设置进入页面
			UserUtil.page="首页";
			return "userBackstage";
		}
		
		//验证用户名是否存在
		boolean exit = UserUtil.isExitName(user.getUsername());
		//若用户名不存在，则返回登录页面重新登录
		if (!exit) {			
			//将此用户实体类传回去
			model.addAttribute("user",user);
			//将用户名不存在的信息传回去
			if(user.getUsername().equals("")) {
				model.addAttribute("loginResult","输入的用户名为空，请重新输入！！！");
			}else {
				model.addAttribute("loginResult","该用户名不存在，请重新输入！！！");
			}
			return "userLogin";
		}
		
		//验证密码是否正确
		boolean truePassword=UserUtil.isTruePassword(user);
		//若密码不正确，则返回登录页面重新登录
		if(!truePassword) {			
			//将此用户实体类传回去
			model.addAttribute("user",user);
			//将秘密输入错误的信息传回去
			if(user.getPassword().equals("")) {
				model.addAttribute("loginResult","输入的密码为空，请重新输入！！！");
			}else {
				model.addAttribute("loginResult","密码输入错误，请重新输入！！！");
			}
			return "userLogin";
		}
		
		//验证用户角色身份
		String role = UserUtil.roleIS(user.getUsername());
		//若角色身份是管理员，则设置登录角色为管理员，进入后台界面
		if(role.equals("管理员")) {
			UserUtil.userrole="管理员";
			//设置进入页面
			UserUtil.page="首页";
			return "userBackstage";
		}
		//若角色身份是普通用户，则设置登录角色为普通用户，进入后台界面
		UserUtil.userrole="普通用户";
		//设置进入页面
		UserUtil.page="首页";
		return "userBackstage";
	}
	
	/**
	 * 进入游客登录界面
	 * @param model
	 * @return
	 */
	@RequestMapping("loginVisitor")
	public String loginVisitor(Model model) {
		//保存登录时的用户名为游客
		UserUtil.username="游客";
		//若角色身份是普通用户，则设置登录角色为游客，进入后台界面
		UserUtil.userrole="游客";
		//设置进入页面
		UserUtil.page="首页";
		return "userBackstage";
	}
	
	/**
     * 显示普通用户注册页面弹出层
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("registerPopup")
    public String registerPopup(Model model) {
        System.out.println("显示普通用户注册页面弹出层");
        //返回操作为注册
        model.addAttribute("op","registerData");
        return "userLogin";
    }
    
    /**
     * 进行普通用户注册操作
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("register")
    public String register(User user,String password2, Model model) {
        System.out.println("进行普通用户注册操作");
        //验证用户名是否存在
        boolean exit = UserUtil.isExitName(user.getUsername());
        //若用户名已存在，返回错误信息
        if(exit){
            System.err.println("该用户名已存在！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回该用户名已存在的信息
            model.addAttribute("registerResult","该用户名已存在！");
            //返回操作为注册
            model.addAttribute("op","registerData");
            return "userLogin";            
        }
        //若用户名为空，返回错误信息
        if(user.getUsername().equals("")) {
            System.err.println("用户名为空！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回用户名为空的信息
            model.addAttribute("registerResult","用户名为空！");
            //返回操作为注册
            model.addAttribute("op","registerData");
            return "userLogin";            
        }
        //若密码为空，则返回错误信息
        if(user.getPassword().equals("")) {
            System.err.println("密码为空！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回密码为空的信息
            model.addAttribute("registerResult","密码为空！");
            //返回操作为注册
            model.addAttribute("op","registerData");
            return "userLogin";            
        }
        //验证两次输入的密码是否一致
        boolean twiceSamePassword = UserUtil.isTwiceSamePassword(user.getPassword(), password2);
        //若两次输入的密码不一致，返回错误信息
        if(!twiceSamePassword){
            System.err.println("用户注册异常：两次输入的密码不一致！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回两次输入的密码不一致的信息
            model.addAttribute("registerResult","两次输入的密码不一致！");
            //返回操作为注册
            model.addAttribute("op","registerData");
            return "userLogin";
        }
        //设置用户角色为普通用户
        user.setRole("普通用户");
        //添加数据库数据信息
        try {
            new UserDao().add(user);
            System.out.println("用户注册成功");
        }catch(Exception e) {
            System.err.println("用户注册异常");
            e.printStackTrace();
        }
        //返回用户数据列表
        model.addAttribute("user",user);
        return "userLogin";
    }
	
	/**
	 * 进行用户查询操作
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("search")
	public String search(String username, Model model) {
		String usernameStr="%";
		for(int i=0; i<username.length(); i++) {
			usernameStr=usernameStr+username.charAt(i)+"%";
		}
		//返回查询的字符串
		model.addAttribute("searchStr",username);
		//返回用户数据列表
		List<User> userList = new UserDao().getAll(usernameStr);
		model.addAttribute("userList",userList);
		return "userBackstage";
	}
	
	/**
	 * 显示添加用户页面弹出层
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("addPopup")
	public String addPopup(Model model) {
		System.out.println("显示添加用户页面弹出层");
		//返回用户数据列表
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		//返回操作为添加
		model.addAttribute("op","addData");
		return "userBackstage";
	}
	
	/**
	 * 进行添加用户数据操作
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String add(User user, Model model) {
		System.out.println("进行添加用户数据操作");
		//更新数据库数据
		try {
			new UserDao().add(user);
			System.out.println("添加用户数据成功");
		}catch(Exception e) {
			System.err.println("添加用户数据异常");
			e.printStackTrace();
		}
		//返回用户数据列表
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		return "userBackstage";
	}
	
	/**
	 * 显示用户修改页面弹出层
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("updatePopup")
	public String updatePopup(@RequestParam(value="username",required=true) String username, Model model) {
		System.out.println("显示用户修改页面弹出层");
		//返回选择要修改的用户的用户表信息
		User user=new UserDao().get(username);
		model.addAttribute("user",user);
		//返回用户数据列表
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		//返回操作为修改
		model.addAttribute("op","updateData");
		return "userBackstage";
	}
	
	/**
	 * 进行用户数据修改操作
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(User user, Model model) {
		System.out.println("进行用户数据修改操作");
		//更新数据库数据
		try {
			new UserDao().update(user);
			System.out.println("用户数据修改成功");
		}catch(Exception e) {
			System.err.println("用户数据修改异常");
			e.printStackTrace();
		}
		//返回用户数据列表
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		return "userBackstage";
	}
	
	/**
	 * 进行用户数据删除操作
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam(value="username",required=true) String username, Model model) {
		System.out.println("进行用户数据删除操作");
		// 更新数据库数据
		try {
			new UserDao().delete(username);
			System.out.println("用户数据删除成功");
		} catch (Exception e) {
			System.err.println("用户数据删除异常");
			e.printStackTrace();
		}
		// 返回用户数据列表
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		return "userBackstage";
	}

}
