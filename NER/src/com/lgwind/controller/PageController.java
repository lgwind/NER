package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgwind.controller.util.UserUtil;
import com.lgwind.dao.DatasDao;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.Datas;
import com.lgwind.domain.User;

@Controller
@RequestMapping("/page")
public class PageController {

	/**
	 * 跳转到首页
	 * @param model
	 * @return
	 */
	@RequestMapping("home")
	public String home(Model model) {
		System.out.println("跳转到首页");
        //返回定位当前页面位置
		UserUtil.page="首页";
		return "userBackstage";
	}
	
	/**
	 * 跳转到用户表管理 页面
	 * @param model
	 * @return
	 */
	@RequestMapping("userManage")
	public String userManage(Model model) {
		System.out.println("跳转到用户表管理页面");
		//返回用户表列表信息
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		//返回定位当前页面位置
		UserUtil.page="用户表管理";
		return "userBackstage";
	}
	
	/**
	 * 跳转到用户数据表管理 页面
	 * @param model
	 * @return
	 */
	@RequestMapping("userDataManage")
	public String userDataManage(Model model) {
		System.out.println("跳转到用户数据表管理页面");
		//返回用户数据表信息
		List<Datas> datasList = new DatasDao().getAll();
		model.addAttribute("datasList", datasList);
        //返回定位当前页面位置
		UserUtil.page="用户数据表管理";
		return "userBackstage";
	}
	
	/**
	 * 跳转到密码修改 页面
	 * @param model
	 * @return
	 */
	@RequestMapping("passwordUpdate")
	public String passwordUpdate(Model model) {
		System.out.println("跳转到密码修改页面");
        //返回定位当前页面位置
		UserUtil.page="密码修改";
		return "userBackstage";
	}
	
	/**
	 * 跳转到个人资料 页面
	 * @param model
	 * @return
	 */
	@RequestMapping("personal")
	public String personal(Model model) {
		System.out.println("跳转到个人资料页面");
        //返回定位当前页面位置
		UserUtil.page="个人资料";
		//返回个人信息
		return "userBackstage";
	}
	
	/**
     * 跳转到系统设置 页面
     * @param model
     * @return
     */
    @RequestMapping("systemSet")
    public String systemSet(Model model) {
        System.out.println("跳转到系统设置页面");
        //返回定位当前页面位置
        UserUtil.page="系统设置";
        return "userBackstage";
    }

}
