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
	 * �����û�������� ����
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String userManage(PU pu, Model model) {
		System.out.println("�����û�������²���");
		//��ԭ����Ϊ��
		if(pu.getPasswordOld().equals("")){
	        //�������������
	        model.addAttribute("pu",pu);
	        //���ش�����Ϣ
            model.addAttribute("PUResult","ԭ�������벻��Ϊ�գ�");
            return "userBackstage";
		}
		//��Ϊ�û���ɫΪ��������Ա
		if(pu.getUserrole().equals("��������Ա")){
		    //������������ȷ
		    if(pu.getPasswordOld().equals(UserUtil.getPasswordSuper())){
		        //��������Ϊ��
		        if(pu.getPasswordNew().equals("")){
		            //�������������
		            model.addAttribute("pu",pu);
		            //���ش�����Ϣ
		            model.addAttribute("PUResult","���������벻��Ϊ�գ�");
		            return "userBackstage";
		        }
		        //�������ܲ�Ϊ��
		        //�޸�ϵͳ�����û�������
		        UserUtil.setPasswordSuper(pu.getPasswordNew());
                //�������������
                model.addAttribute("pu",pu);
                //���سɹ���Ϣ
                model.addAttribute("PUResult","�����޸ĳɹ���");
                return "userBackstage";
		    }
		    //�������������
		    else{
	            //�������������
	            model.addAttribute("pu",pu);
	            //���ش�����Ϣ
	            model.addAttribute("PUResult","�����������");
	            return "userBackstage";
		    }
		}
		//���û���ɫ���ǳ�������Ա
		//��ȡ���û�����
		User user = new UserDao().get(pu.getUsername());
		//������������ȷ
		if(pu.getPasswordOld().equals(user.getPassword())){
		    //��������Ϊ��
            if(pu.getPasswordNew().equals("")){
                //�������������
                model.addAttribute("pu",pu);
                //���ش�����Ϣ
                model.addAttribute("PUResult","���������벻��Ϊ�գ�");
                return "userBackstage";
            }
            //�������ܲ�Ϊ��
            //�޸ĸ��û�������
            try {
                user.setPassword(pu.getPasswordNew());
                new UserDao().update(user);
                // ���سɹ���Ϣ
                model.addAttribute("PUResult", "�����޸ĳɹ���");
            } catch (Exception e) {
                // ���ش�����Ϣ
                model.addAttribute("PUResult", "�����޸�ʧ�ܣ�");
                e.printStackTrace();
            }
            //�������������
            model.addAttribute("pu",pu);
            return "userBackstage";
            
		}
		//��ԭ�����������
        //�������������
        model.addAttribute("pu",pu);
        //���ش�����Ϣ
        model.addAttribute("PUResult","�����������");
        return "userBackstage";
	}

}
