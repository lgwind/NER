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
	 * ����ϵͳ���� ����
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String userManage(String ip, String port, Model model) {
		System.out.println("����ϵͳ���ò���");
		SystemSet.ip=ip;
        SystemSet.port=port;
        //���ش�����Ϣ
        model.addAttribute("SSResult","�޸ĳɹ���");
        return "userBackstage";
	}

}
