package com.lgwind.controller.util;

public class SystemSet {
    
    public static String ip="192.168.1.212";//������IP��ַ
    public static String port="8080";       //�������˿�
    public static String xlsName="��Ա�����ڵǼǱ�";//��Ա�����ڵǼǱ����
    public static String csvName="outlook������ϵ����Ϣ��";//��Ա�����ڵǼǱ����
    public static String saveURL="D:/Lgwind/apache-tomcat-6.0.43/webapps/NER/file";//�ļ�����·��
    
    public static String downloadXLS(){
        return "http://"+ip+":"+port+"/NER/file/"+xlsName+".xls";
    }
    public static String downloadCSV(){
        return "http://"+ip+":"+port+"/NER/file/"+csvName+".csv";
    }

}
