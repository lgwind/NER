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
     * 进行用户数据表数据查询操作
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("search")
    public String search(String username, Model model) {
        System.out.println("进行用户数据表数据查询");
        String usernameStr="%";
        for(int i=0; i<username.length(); i++) {
            usernameStr=usernameStr+username.charAt(i)+"%";
        }
        //返回查询的字符串
        model.addAttribute("searchStr",username);
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll(usernameStr);
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * 显示添加用户页面弹出层
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("addPopup")
    public String addPopup(Model model) {
        System.out.println("显示添加用户页面弹出层");
        //返回数据库中没有的datasId的最小值
        int datasId = 1;
        model.addAttribute("datasId",datasId);
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        //返回操作为添加
        model.addAttribute("op","addData");
        return "userBackstage";
    }
    
    /**
     * 进行添加用户数据表数据操作
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Datas datas, Model model) {
        System.out.println("进行添加用户数据表数据操作");
        //判断用户名/报道时间/到现场时间/生日是否为空
        if(datas.getUsername().equals("") 
                || datas.getReporttime().equals("")
                || datas.getStarttime().equals("") 
                || datas.getBirthday().equals("")){
            //返回用户数据表数据信息列表
            List<Datas> datasList = new DatasDao().getAll();
            model.addAttribute("datasList",datasList);
            //返回错误信息
            if(datas.getUsername().equals("")){
                model.addAttribute("datasAddResult","用户名不能为空!");
            }else if(datas.getReporttime().equals("")){
                model.addAttribute("datasAddResult","到报道时间不能为空!");
            }else if(datas.getStarttime().equals("")){
                model.addAttribute("datasAddResult","到现场时间不能为空!");
            }else if(datas.getBirthday().equals("")){
                model.addAttribute("datasAddResult","生日不能为空!");
            }
            //返回操作为添加
            model.addAttribute("op","addData");
            //返回已填的表单信息
            model.addAttribute("datas",datas);
            return "userBackstage";
        }
        //更新数据库数据
        try {
            new DatasDao().add(datas);
            System.out.println("添加用户数据表数据成功");
        }catch(Exception e) {
            System.err.println("添加用户数据表数据异常");
            e.printStackTrace();
        }
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * 显示用户数据表数据修改页面弹出层
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("updatePopup")
    public String updatePopup(@RequestParam(value="username",required=true) String username, Model model) {
        System.out.println("显示用户数据表数据修改页面弹出层");
        //返回选择要修改的用户数据表信息
        Datas datas=new DatasDao().get(username);
        model.addAttribute("datas",datas);
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        //返回操作为修改
        model.addAttribute("op","updateData");
        return "userBackstage";
    }
    
    /**
     * 进行用户数据表数据修改操作
     * @param datas
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Datas datas, Model model) {
        System.out.println("进行用户数据表数据修改操作");
        //更新数据库数据
        try {
            new DatasDao().update(datas);
            System.out.println("用户数据表数据修改成功");
        }catch(Exception e) {
            System.err.println("用户数据表数据修改异常");
            e.printStackTrace();
        }
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * 进行用户数据表数据删除操作
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam(value="username",required=true) String username, Model model) {
        System.out.println("进行用户数据表数据删除操作");
        // 更新数据库数据
        try {
            new DatasDao().delete(username);
            System.out.println("用户数据表数据删除成功");
        } catch (Exception e) {
            System.err.println("用户数据表数据删除异常");
            e.printStackTrace();
        }
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        return "userBackstage";
    }
    
    /**
     * 显示导出xls文件弹出层
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("exportXLSPopup")
    public String exportXLSPopup(Model model) {
        System.out.println("显示导出xls文件弹出层");
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        
     // 导出Excel
        try {
            // 新建文件
            Excel excel = new Excel();
            // 文件保存路径，没得修改
            excel.newXLS(SystemSet.saveURL, SystemSet.xlsName+".xls");
//            excel.newXLS("", name);//令人蛋疼的相对路径
            // 写入标题
            String[] title = { "ID", "姓名", "电话", "邮箱", "岗位", "报道时间", "到岗时间",
                    "职位", "方向", "生日" };
            excel.writeXLS(title);
            // 写入信息
            for (int i = 0; i < datasList.size(); i++) {
                excel.writeXLS(i+1,datasList.get(i));
            }
            // 写入内容并关闭文件
            excel.writeclose();
            model.addAttribute("result", "在服务器生成xls文件成功！！！");
            // 文件已保持在服务器，则下载文件
//            DownloadFileFromServer.url("http://"+UserLogin.ip+":8080/NewEmployeeRegistration/file/"+name+".xls", name1, name2, "GET");
        } catch (Exception e) {
            model.addAttribute("result", "在服务器生成xls文件失败！！！");
            e.printStackTrace();
        }
        //返回操作为添加
        model.addAttribute("op","showExportXLSPopup");
        return "userBackstage";
    }
    
    /**
     * 显示导出csv文件弹出层
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("exportCSVPopup")
    public String exportCSVPopup(Model model) {
        System.out.println("显示导出csv文件弹出层");
        //返回用户数据表数据信息列表
        List<Datas> datasList = new DatasDao().getAll();
        model.addAttribute("datasList",datasList);
        // 导出csv文件
           try {// 填写标题内容
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
               // ="Last Name,E-mail Address,Mobile Phone,Job Title,Department\n陈泽明,1019087978@qq.com ,,,\n苏悦君,919601128@qq.com,,,\n陈朝洋,674201281@qq.com,,,";
               // 创建文件并写入内容
               // 默认路径没得修改
               FileIO.write(
                       SystemSet.saveURL,
                       SystemSet.csvName + ".csv", content);
               model.addAttribute("CSVResult", "在服务器生成csv文件成功！！！");
               // 文件已保持在服务器，则下载文件
               // DownloadFileFromServer.url("http://"+UserLogin.ip+":8080/NewEmployeeRegistration/file/"+name+".xls",
               // name1, name2, "GET");
           } catch (Exception e) {
               model.addAttribute("CSVResult", "在服务器生成csv文件失败！！！");
               e.printStackTrace();
           }
        //返回操作为添加
        model.addAttribute("op","showExportCSVPopup");
        return "userBackstage";
    }

}
