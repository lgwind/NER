package com.lgwind.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;

public class FileIO {
    
    /**
     * ��ȡ�ļ�
     * @param path ·��
     * @param name �ļ���
     */
    public static void read(String path, String name) {
        // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
        try {
            String pathname = path +"\\"+name; // ·��
            File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // ����һ������������reader
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // һ�ζ���һ������
            }
            br.close(); // ���ǵùر��ļ�
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * д���ļ�
     * @param path ·��
     * @param name �ļ���
     * @param content
     */
    public static void write(String path, String name, String content) {
        // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
        try {
//            File writename = new File("src//txt//output.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
            File writename = new File(path+"\\"+name); 
            writename.createNewFile(); // �������ļ�
            FileOutputStream writerStream = new FileOutputStream(writename);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8"));
//            out.write("�һ�д���ļ���\r\n"); // д������\r\n��Ϊ����
            out.write("\uFEFF");//д���־λ��û�б�־λ��������bom��ʽ
            out.write(content);//д������
            out.flush(); // �ѻ���������ѹ���ļ�
            out.close(); // ���ǵùر��ļ�

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        String content ="Last Name,E-mail Address,Mobile Phone,Job Title,Department\n������,1019087978@qq.com ,,,\n���þ�,919601128@qq.com,,,\n�³���,674201281@qq.com,,,";
        FileIO.write("src\\txt","table.csv",content);
    }
    
}