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
     * 读取文件
     * @param path 路径
     * @param name 文件名
     */
    public static void read(String path, String name) {
        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        try {
            String pathname = path +"\\"+name; // 路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
            }
            br.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 写入文件
     * @param path 路径
     * @param name 文件名
     * @param content
     */
    public static void write(String path, String name, String content) {
        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        try {
//            File writename = new File("src//txt//output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            File writename = new File(path+"\\"+name); 
            writename.createNewFile(); // 创建新文件
            FileOutputStream writerStream = new FileOutputStream(writename);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8"));
//            out.write("我会写入文件啦\r\n"); // 写入内容\r\n即为换行
            out.write("\uFEFF");//写入标志位，没有标志位会生成无bom格式
            out.write(content);//写入内容
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        String content ="Last Name,E-mail Address,Mobile Phone,Job Title,Department\n陈泽明,1019087978@qq.com ,,,\n苏悦君,919601128@qq.com,,,\n陈朝洋,674201281@qq.com,,,";
        FileIO.write("src\\txt","table.csv",content);
    }
    
}