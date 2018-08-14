package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgwind.controller.util.PU;
import com.lgwind.controller.util.SystemSet;
import com.lgwind.controller.util.UserUtil;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

@Controller
@RequestMapping("/systemSet")
public class SystemSetController {
	
	/**
	 * 进行系统设置 操作
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String userManage(String ip, String port, Model model) {
		System.out.println("进行系统设置操作");
		SystemSet.ip=ip;
        SystemSet.port=port;
        //返回错误信息
        model.addAttribute("SSResult","修改成功！");
        return "userBackstage";
	}

}
