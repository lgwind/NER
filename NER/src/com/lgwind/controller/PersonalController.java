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
     * ���и������õ��û����ݱ������޸Ĳ���
     * @param datas
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Datas datas, Model model) {
        System.out.println("���и������õ��û����ݱ������޸Ĳ���");
        //���û���Ϣ��û�д��û�
        if(new DatasDao().get(datas.getUsername())==null){
            //�ж��û���/����ʱ��/���ֳ�ʱ��/�����Ƿ�Ϊ��
            if(datas.getUsername().equals("") 
                    || datas.getReporttime().equals("")
                    || datas.getStarttime().equals("") 
                    || datas.getBirthday().equals("")){
                //���ش�����Ϣ
                if(datas.getUsername().equals("")){
                    model.addAttribute("personalResult","�û�������Ϊ��!");
                }else if(datas.getReporttime().equals("")){
                    model.addAttribute("personalResult","������ʱ�䲻��Ϊ��!");
                }else if(datas.getStarttime().equals("")){
                    model.addAttribute("personalResult","���ֳ�ʱ�䲻��Ϊ��!");
                }else if(datas.getBirthday().equals("")){
                    model.addAttribute("personalResult","���ղ���Ϊ��!");
                }
                //������д��Ϣ
                model.addAttribute("datas",datas);
                return "userBackstage";
            }
            //�������ݿ�����
            try {
                new DatasDao().add(datas);
                System.out.println("����û����ݱ����ݳɹ�");
                //�����޸Ľ����Ϣ
                model.addAttribute("personalResult","�û������޸ĳɹ���");
            }catch(Exception e) {
                System.err.println("����û����ݱ������쳣");
                //�����޸Ľ����Ϣ
                model.addAttribute("personalResult","�û������޸�ʧ�ܣ�");
                e.printStackTrace();
            }
            //������д��Ϣ
            model.addAttribute("datas",datas);
            return "userBackstage";
        }
        //�������ݿ�����
        try {
            new DatasDao().update(datas);
            System.out.println("���������û������޸ĳɹ�");
            //�����޸Ľ����Ϣ
            model.addAttribute("personalResult","�û������޸ĳɹ���");
        }catch(Exception e) {
            System.err.println("���������û������޸��쳣");
            //�����޸Ľ����Ϣ
            model.addAttribute("personalResult","�û������޸�ʧ�ܣ�");
            e.printStackTrace();
        }
        //������д��Ϣ
        model.addAttribute("datas",datas);
        return "userBackstage";
    }

}
