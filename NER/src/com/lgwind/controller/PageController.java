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
	 * ��ת����ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping("home")
	public String home(Model model) {
		System.out.println("��ת����ҳ");
        //���ض�λ��ǰҳ��λ��
		UserUtil.page="��ҳ";
		return "userBackstage";
	}
	
	/**
	 * ��ת���û������ ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("userManage")
	public String userManage(Model model) {
		System.out.println("��ת���û������ҳ��");
		//�����û����б���Ϣ
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		//���ض�λ��ǰҳ��λ��
		UserUtil.page="�û������";
		return "userBackstage";
	}
	
	/**
	 * ��ת���û����ݱ���� ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("userDataManage")
	public String userDataManage(Model model) {
		System.out.println("��ת���û����ݱ����ҳ��");
		//�����û����ݱ���Ϣ
		List<Datas> datasList = new DatasDao().getAll();
		model.addAttribute("datasList", datasList);
        //���ض�λ��ǰҳ��λ��
		UserUtil.page="�û����ݱ����";
		return "userBackstage";
	}
	
	/**
	 * ��ת�������޸� ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("passwordUpdate")
	public String passwordUpdate(Model model) {
		System.out.println("��ת�������޸�ҳ��");
        //���ض�λ��ǰҳ��λ��
		UserUtil.page="�����޸�";
		return "userBackstage";
	}
	
	/**
	 * ��ת���������� ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("personal")
	public String personal(Model model) {
		System.out.println("��ת����������ҳ��");
        //���ض�λ��ǰҳ��λ��
		UserUtil.page="��������";
		//���ظ�����Ϣ
		return "userBackstage";
	}
	
	/**
     * ��ת��ϵͳ���� ҳ��
     * @param model
     * @return
     */
    @RequestMapping("systemSet")
    public String systemSet(Model model) {
        System.out.println("��ת��ϵͳ����ҳ��");
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="ϵͳ����";
        return "userBackstage";
    }

}
