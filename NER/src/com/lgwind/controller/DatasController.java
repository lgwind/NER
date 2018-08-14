package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.controller.util.DatasUtil;
import com.lgwind.controller.util.SystemSet;
import com.lgwind.dao.DatasDao;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.Datas;
import com.lgwind.domain.User;
import com.lgwind.util.Excel;
import com.lgwind.util.FileIO;

@Controller
@RequestMapping("/datas")
public class DatasController {
    
    /**
     * �����û����ݱ����ݲ�ѯ����
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("search")
    public String search(String username, Model model) {
        System.out.println("�����û����ݱ����ݲ�ѯ");
        String usernameStr="%";
        for(int i=0; i<username.length(); i++) {
            usernameStr=usernameStr+username.charAt(i)+"%";
        }
        //���ز�ѯ���ַ���
        model.addAttribute("searchStr",username);
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll(usernameStr);
        model.addAttribute("datasList",datasList);
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
        //�������ݿ���û�е�datasId����Сֵ
        int datasId = 1;
        model.addAttribute("datasId",datasId);
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        //���ز���Ϊ���
        model.addAttribute("op","addData");
        return "userBackstage";
    }
    
    /**
     * ��������û����ݱ����ݲ���
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Datas datas, Model model) {
        System.out.println("��������û����ݱ����ݲ���");
        //�ж��û���/����ʱ��/���ֳ�ʱ��/�����Ƿ�Ϊ��
        if(datas.getUsername().equals("") 
                || datas.getReporttime().equals("")
                || datas.getStarttime().equals("") 
                || datas.getBirthday().equals("")){
            //�����û����ݱ�������Ϣ�б�
            List<Datas> datasList = new DatasDao().getAll();
            model.addAttribute("datasList",datasList);
            //���ش�����Ϣ
            if(datas.getUsername().equals("")){
                model.addAttribute("datasAddResult","�û�������Ϊ��!");
            }else if(datas.getReporttime().equals("")){
                model.addAttribute("datasAddResult","������ʱ�䲻��Ϊ��!");
            }else if(datas.getStarttime().equals("")){
                model.addAttribute("datasAddResult","���ֳ�ʱ�䲻��Ϊ��!");
            }else if(datas.getBirthday().equals("")){
                model.addAttribute("datasAddResult","���ղ���Ϊ��!");
            }
            //���ز���Ϊ���
            model.addAttribute("op","addData");
            //��������ı���Ϣ
            model.addAttribute("datas",datas);
            return "userBackstage";
        }
        //�������ݿ�����
        try {
            new DatasDao().add(datas);
            System.out.println("����û����ݱ����ݳɹ�");
        }catch(Exception e) {
            System.err.println("����û����ݱ������쳣");
            e.printStackTrace();
        }
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * ��ʾ�û����ݱ������޸�ҳ�浯����
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("updatePopup")
    public String updatePopup(@RequestParam(value="username",required=true) String username, Model model) {
        System.out.println("��ʾ�û����ݱ������޸�ҳ�浯����");
        //����ѡ��Ҫ�޸ĵ��û����ݱ���Ϣ
        Datas datas=new DatasDao().get(username);
        model.addAttribute("datas",datas);
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        //���ز���Ϊ�޸�
        model.addAttribute("op","updateData");
        return "userBackstage";
    }
    
    /**
     * �����û����ݱ������޸Ĳ���
     * @param datas
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Datas datas, Model model) {
        System.out.println("�����û����ݱ������޸Ĳ���");
        //�������ݿ�����
        try {
            new DatasDao().update(datas);
            System.out.println("�û����ݱ������޸ĳɹ�");
        }catch(Exception e) {
            System.err.println("�û����ݱ������޸��쳣");
            e.printStackTrace();
        }
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * �����û����ݱ�����ɾ������
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam(value="username",required=true) String username, Model model) {
        System.out.println("�����û����ݱ�����ɾ������");
        // �������ݿ�����
        try {
            new DatasDao().delete(username);
            System.out.println("�û����ݱ�����ɾ���ɹ�");
        } catch (Exception e) {
            System.err.println("�û����ݱ�����ɾ���쳣");
            e.printStackTrace();
        }
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * ��ʾ����xls�ļ�������
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("exportXLSPopup")
    public String exportXLSPopup(Model model) {
        System.out.println("��ʾ����xls�ļ�������");
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        
     // ����Excel
        try {
            // �½��ļ�
            Excel excel = new Excel();
            // �ļ�����·����û���޸�
            excel.newXLS(SystemSet.saveURL, SystemSet.xlsName+".xls");
//            excel.newXLS("", name);//���˵��۵����·��
            // д�����
            String[] title = { "ID", "����", "�绰", "����", "��λ", "����ʱ��", "����ʱ��",
                    "ְλ", "����", "����" };
            excel.writeXLS(title);
            // д����Ϣ
            for (int i = 0; i < datasList.size(); i++) {
                excel.writeXLS(i+1,datasList.get(i));
            }
            // д�����ݲ��ر��ļ�
            excel.writeclose();
            model.addAttribute("result", "�ڷ���������xls�ļ��ɹ�������");
            // �ļ��ѱ����ڷ��������������ļ�
//            DownloadFileFromServer.url("http://"+UserLogin.ip+":8080/NewEmployeeRegistration/file/"+name+".xls", name1, name2, "GET");
        } catch (Exception e) {
            model.addAttribute("result", "�ڷ���������xls�ļ�ʧ�ܣ�����");
            e.printStackTrace();
        }
        //���ز���Ϊ���
        model.addAttribute("op","showExportXLSPopup");
        return "userBackstage";
    }
    
    /**
     * ��ʾ����csv�ļ�������
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("exportCSVPopup")
    public String exportCSVPopup(Model model) {
        System.out.println("��ʾ����csv�ļ�������");
        //�����û����ݱ�������Ϣ�б�
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        // ����csv�ļ�
           try {// ��д��������
               String content = "Last Name,E-mail Address,Mobile Phone,Job Title,Department\n";
               for (int i = 0; i < datasList.size(); i++) {
                   Datas datas = datasList.get(i);
                   content += datas.getName() + ",";
                   content += datas.getEmail() + ",";
                   content += datas.getPhone() + ",";
                   content += datas.getPosition() + ",";
                   content += datas.getPost() + "\n";
               }
               // String content
               // ="Last Name,E-mail Address,Mobile Phone,Job Title,Department\n������,1019087978@qq.com ,,,\n���þ�,919601128@qq.com,,,\n�³���,674201281@qq.com,,,";
               // �����ļ���д������
               // Ĭ��·��û���޸�
               FileIO.write(
                       SystemSet.saveURL,
                       SystemSet.csvName + ".csv", content);
               model.addAttribute("CSVResult", "�ڷ���������csv�ļ��ɹ�������");
               // �ļ��ѱ����ڷ��������������ļ�
               // DownloadFileFromServer.url("http://"+UserLogin.ip+":8080/NewEmployeeRegistration/file/"+name+".xls",
               // name1, name2, "GET");
           } catch (Exception e) {
               model.addAttribute("CSVResult", "�ڷ���������csv�ļ�ʧ�ܣ�����");
               e.printStackTrace();
           }
        //���ز���Ϊ���
        model.addAttribute("op","showExportCSVPopup");
        return "userBackstage";
    }

}
