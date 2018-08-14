package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.controller.util.DatasUtil;
import com.lgwind.dao.DatasDao;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.Datas;
import com.lgwind.domain.User;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    
    /**
     * 进行个人设置的用户数据表数据修改操作
     * @param datas
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Datas datas, Model model) {
        System.out.println("进行个人设置的用户数据表数据修改操作");
        //若用户信息表没有此用户
        if(new DatasDao().get(datas.getUsername())==null){
            //判断用户名/报道时间/到现场时间/生日是否为空
            if(datas.getUsername().equals("") 
                    || datas.getReporttime().equals("")
                    || datas.getStarttime().equals("") 
                    || datas.getBirthday().equals("")){
                //返回错误信息
                if(datas.getUsername().equals("")){
                    model.addAttribute("personalResult","用户名不能为空!");
                }else if(datas.getReporttime().equals("")){
                    model.addAttribute("personalResult","到报道时间不能为空!");
                }else if(datas.getStarttime().equals("")){
                    model.addAttribute("personalResult","到现场时间不能为空!");
                }else if(datas.getBirthday().equals("")){
                    model.addAttribute("personalResult","生日不能为空!");
                }
                //返回填写信息
                model.addAttribute("datas",datas);
                return "userBackstage";
            }
            //更新数据库数据
            try {
                new DatasDao().add(datas);
                System.out.println("添加用户数据表数据成功");
                //返回修改结果信息
                model.addAttribute("personalResult","用户数据修改成功！");
            }catch(Exception e) {
                System.err.println("添加用户数据表数据异常");
                //返回修改结果信息
                model.addAttribute("personalResult","用户数据修改失败！");
                e.printStackTrace();
            }
            //返回填写信息
            model.addAttribute("datas",datas);
            return "userBackstage";
        }
        //更新数据库数据
        try {
            new DatasDao().update(datas);
            System.out.println("个人设置用户数据修改成功");
            //返回修改结果信息
            model.addAttribute("personalResult","用户数据修改成功！");
        }catch(Exception e) {
            System.err.println("个人设置用户数据修改异常");
            //返回修改结果信息
            model.addAttribute("personalResult","用户数据修改失败！");
            e.printStackTrace();
        }
        //返回填写信息
        model.addAttribute("datas",datas);
        return "userBackstage";
    }

}
