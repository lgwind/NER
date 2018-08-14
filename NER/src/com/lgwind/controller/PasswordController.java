package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgwind.controller.util.PU;
import com.lgwind.controller.util.UserUtil;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

@Controller
@RequestMapping("/password")
public class PasswordController {
	
	/**
	 * 进行用户密码更新 操作
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String userManage(PU pu, Model model) {
		System.out.println("进行用户密码更新操作");
		//若原密码为空
		if(pu.getPasswordOld().equals("")){
	        //返回输入的内容
	        model.addAttribute("pu",pu);
	        //返回错误信息
            model.addAttribute("PUResult","原秘密输入不能为空！");
            return "userBackstage";
		}
		//若为用户角色为超级管理员
		if(pu.getUserrole().equals("超级管理员")){
		    //若秘密输入正确
		    if(pu.getPasswordOld().equals(UserUtil.getPasswordSuper())){
		        //若新密码为空
		        if(pu.getPasswordNew().equals("")){
		            //返回输入的内容
		            model.addAttribute("pu",pu);
		            //返回错误信息
		            model.addAttribute("PUResult","新秘密输入不能为空！");
		            return "userBackstage";
		        }
		        //若新秘密不为空
		        //修改系统超级用户的秘密
		        UserUtil.setPasswordSuper(pu.getPasswordNew());
                //返回输入的内容
                model.addAttribute("pu",pu);
                //返回成功信息
                model.addAttribute("PUResult","密码修改成功！");
                return "userBackstage";
		    }
		    //若秘密输入错误
		    else{
	            //返回输入的内容
	            model.addAttribute("pu",pu);
	            //返回错误信息
	            model.addAttribute("PUResult","密码输入错误！");
	            return "userBackstage";
		    }
		}
		//若用户角色不是超级管理员
		//获取该用户数据
		User user = new UserDao().get(pu.getUsername());
		//若秘密输入正确
		if(pu.getPasswordOld().equals(user.getPassword())){
		    //若新密码为空
            if(pu.getPasswordNew().equals("")){
                //返回输入的内容
                model.addAttribute("pu",pu);
                //返回错误信息
                model.addAttribute("PUResult","新秘密输入不能为空！");
                return "userBackstage";
            }
            //若新秘密不为空
            //修改该用户的密码
            try {
                user.setPassword(pu.getPasswordNew());
                new UserDao().update(user);
                // 返回成功信息
                model.addAttribute("PUResult", "秘密修改成功！");
            } catch (Exception e) {
                // 返回错误信息
                model.addAttribute("PUResult", "秘密修改失败！");
                e.printStackTrace();
            }
            //返回输入的内容
            model.addAttribute("pu",pu);
            return "userBackstage";
            
		}
		//若原秘密输入错误
        //返回输入的内容
        model.addAttribute("pu",pu);
        //返回错误信息
        model.addAttribute("PUResult","密码输入错误！");
        return "userBackstage";
	}

}
