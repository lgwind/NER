package com.lgwind.controller.util;

public class SystemSet {
    
    public static String ip="192.168.1.212";//服务器IP地址
    public static String port="8080";       //服务器端口
    public static String xlsName="新员工到岗登记表";//新员工到岗登记表表明
    public static String csvName="outlook导入联系人信息表";//新员工到岗登记表表明
    public static String saveURL="D:/Lgwind/apache-tomcat-6.0.43/webapps/NER/file";//文件保存路径
    
    public static String downloadXLS(){
        return "http://"+ip+":"+port+"/NER/file/"+xlsName+".xls";
    }
    public static String downloadCSV(){
        return "http://"+ip+":"+port+"/NER/file/"+csvName+".csv";
    }

}
