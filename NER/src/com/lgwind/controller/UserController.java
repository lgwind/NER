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
	 * ��ת���û���¼ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("userLogin")
	public String userLogin(Model model) {
		System.out.println("��ת���û���¼����");
//		model.addAttribute("message","Hello World��");
		return "userLogin";
	}
	
	/**
	 * ִ�е�¼��������֤�û���������
	 * @param user �û�ʵ����
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user, Model model) {
		//�����¼ʱ���û���
		UserUtil.username=user.getUsername();
		
		//��֤�Ƿ���ϵͳ�����û�
		boolean superUser=UserUtil.isSuperUser(user);
		//���ǳ����û��������õ�¼��ɫΪ��������Ա�������û���̨����
		if (superUser) {
			UserUtil.userrole="��������Ա";
			//���ý���ҳ��
			UserUtil.page="��ҳ";
			return "userBackstage";
		}
		
		//��֤�û����Ƿ����
		boolean exit = UserUtil.isExitName(user.getUsername());
		//���û��������ڣ��򷵻ص�¼ҳ�����µ�¼
		if (!exit) {			
			//�����û�ʵ���ഫ��ȥ
			model.addAttribute("user",user);
			//���û��������ڵ���Ϣ����ȥ
			if(user.getUsername().equals("")) {
				model.addAttribute("loginResult","������û���Ϊ�գ����������룡����");
			}else {
				model.addAttribute("loginResult","���û��������ڣ����������룡����");
			}
			return "userLogin";
		}
		
		//��֤�����Ƿ���ȷ
		boolean truePassword=UserUtil.isTruePassword(user);
		//�����벻��ȷ���򷵻ص�¼ҳ�����µ�¼
		if(!truePassword) {			
			//�����û�ʵ���ഫ��ȥ
			model.addAttribute("user",user);
			//����������������Ϣ����ȥ
			if(user.getPassword().equals("")) {
				model.addAttribute("loginResult","���������Ϊ�գ����������룡����");
			}else {
				model.addAttribute("loginResult","��������������������룡����");
			}
			return "userLogin";
		}
		
		//��֤�û���ɫ���
		String role = UserUtil.roleIS(user.getUsername());
		//����ɫ����ǹ���Ա�������õ�¼��ɫΪ����Ա�������̨����
		if(role.equals("����Ա")) {
			UserUtil.userrole="����Ա";
			//���ý���ҳ��
			UserUtil.page="��ҳ";
			return "userBackstage";
		}
		//����ɫ�������ͨ�û��������õ�¼��ɫΪ��ͨ�û��������̨����
		UserUtil.userrole="��ͨ�û�";
		//���ý���ҳ��
		UserUtil.page="��ҳ";
		return "userBackstage";
	}
	
	/**
	 * �����ο͵�¼����
	 * @param model
	 * @return
	 */
	@RequestMapping("loginVisitor")
	public String loginVisitor(Model model) {
		//�����¼ʱ���û���Ϊ�ο�
		UserUtil.username="�ο�";
		//����ɫ�������ͨ�û��������õ�¼��ɫΪ�οͣ������̨����
		UserUtil.userrole="�ο�";
		//���ý���ҳ��
		UserUtil.page="��ҳ";
		return "userBackstage";
	}
	
	/**
     * ��ʾ��ͨ�û�ע��ҳ�浯����
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("registerPopup")
    public String registerPopup(Model model) {
        System.out.println("��ʾ��ͨ�û�ע��ҳ�浯����");
        //���ز���Ϊע��
        model.addAttribute("op","registerData");
        return "userLogin";
    }
    
    /**
     * ������ͨ�û�ע�����
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("register")
    public String register(User user,String password2, Model model) {
        System.out.println("������ͨ�û�ע�����");
        //��֤�û����Ƿ����
        boolean exit = UserUtil.isExitName(user.getUsername());
        //���û����Ѵ��ڣ����ش�����Ϣ
        if(exit){
            System.err.println("���û����Ѵ��ڣ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //���ظ��û����Ѵ��ڵ���Ϣ
            model.addAttribute("registerResult","���û����Ѵ��ڣ�");
            //���ز���Ϊע��
            model.addAttribute("op","registerData");
            return "userLogin";            
        }
        //���û���Ϊ�գ����ش�����Ϣ
        if(user.getUsername().equals("")) {
            System.err.println("�û���Ϊ�գ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //�����û���Ϊ�յ���Ϣ
            model.addAttribute("registerResult","�û���Ϊ�գ�");
            //���ز���Ϊע��
            model.addAttribute("op","registerData");
            return "userLogin";            
        }
        //������Ϊ�գ��򷵻ش�����Ϣ
        if(user.getPassword().equals("")) {
            System.err.println("����Ϊ�գ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //��������Ϊ�յ���Ϣ
            model.addAttribute("registerResult","����Ϊ�գ�");
            //���ز���Ϊע��
            model.addAttribute("op","registerData");
            return "userLogin";            
        }
        //��֤��������������Ƿ�һ��
        boolean twiceSamePassword = UserUtil.isTwiceSamePassword(user.getPassword(), password2);
        //��������������벻һ�£����ش�����Ϣ
        if(!twiceSamePassword){
            System.err.println("�û�ע���쳣��������������벻һ�£�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //����������������벻һ�µ���Ϣ
            model.addAttribute("registerResult","������������벻һ�£�");
            //���ز���Ϊע��
            model.addAttribute("op","registerData");
            return "userLogin";
        }
        //�����û���ɫΪ��ͨ�û�
        user.setRole("��ͨ�û�");
        //������ݿ�������Ϣ
        try {
            new UserDao().add(user);
            System.out.println("�û�ע��ɹ�");
        }catch(Exception e) {
            System.err.println("�û�ע���쳣");
            e.printStackTrace();
        }
        //�����û������б�
        model.addAttribute("user",user);
        return "userLogin";
    }
	
	/**
	 * �����û���ѯ����
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
		//���ز�ѯ���ַ���
		model.addAttribute("searchStr",username);
		//�����û������б�
		List<User> userList = new UserDao().getAll(usernameStr);
		model.addAttribute("userList",userList);
		return "userBackstage";
	}
	
	/**
	 * ��ʾ����û�ҳ�浯����
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("addPopup")
	public String addPopup(Model model) {
		System.out.println("��ʾ����û�ҳ�浯����");
		//�����û������б�
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		//���ز���Ϊ���
		model.addAttribute("op","addData");
		return "userBackstage";
	}
	
	/**
	 * ��������û����ݲ���
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String add(User user, Model model) {
		System.out.println("��������û����ݲ���");
		//�������ݿ�����
		try {
			new UserDao().add(user);
			System.out.println("����û����ݳɹ�");
		}catch(Exception e) {
			System.err.println("����û������쳣");
			e.printStackTrace();
		}
		//�����û������б�
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		return "userBackstage";
	}
	
	/**
	 * ��ʾ�û��޸�ҳ�浯����
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("updatePopup")
	public String updatePopup(@RequestParam(value="username",required=true) String username, Model model) {
		System.out.println("��ʾ�û��޸�ҳ�浯����");
		//����ѡ��Ҫ�޸ĵ��û����û�����Ϣ
		User user=new UserDao().get(username);
		model.addAttribute("user",user);
		//�����û������б�
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		//���ز���Ϊ�޸�
		model.addAttribute("op","updateData");
		return "userBackstage";
	}
	
	/**
	 * �����û������޸Ĳ���
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(User user, Model model) {
		System.out.println("�����û������޸Ĳ���");
		//�������ݿ�����
		try {
			new UserDao().update(user);
			System.out.println("�û������޸ĳɹ�");
		}catch(Exception e) {
			System.err.println("�û������޸��쳣");
			e.printStackTrace();
		}
		//�����û������б�
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		return "userBackstage";
	}
	
	/**
	 * �����û�����ɾ������
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam(value="username",required=true) String username, Model model) {
		System.out.println("�����û�����ɾ������");
		// �������ݿ�����
		try {
			new UserDao().delete(username);
			System.out.println("�û�����ɾ���ɹ�");
		} catch (Exception e) {
			System.err.println("�û�����ɾ���쳣");
			e.printStackTrace();
		}
		// �����û������б�
		List<User> userList = new UserDao().getAll();
		model.addAttribute("userList",userList);
		return "userBackstage";
	}

}
