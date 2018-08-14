package com.lgwind.util;

import java.io.File;
import java.io.IOException;

import com.lgwind.domain.Datas;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel implements Excel_interface {

	// �ļ�
	public WritableWorkbook book = null;
	// ��һҳ
	public WritableSheet first_sheet = null;
	// ��д�˶�����
	public int rows = 0;

	/**
	 * �½�excel��ʹ��Ĭ�����֣�
	 * @param path·��
	 */
	public void newXLS(String path) {
		newXLS(path, "eml����(Ĭ��).xls");
	}

	/**
	 * �½�excel��
	 * @param path·��
	 * @param name�ļ���
	 */
	public void newXLS(String path, String name) {

		try {
			// �½�һ���ļ�
			if(path.equals("")){
			    book = Workbook.createWorkbook(new File(name));
			}else{
			    book = Workbook.createWorkbook(new File(path + "\\" + name));
			}
			// ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			first_sheet = book.createSheet("��������", 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * д��һ�����ݣ�Ĭ��������������ݣ�
	 */
	public void writeXLS() {
		String[] row = { "��ѡ������", "�Ա�", "ӦƸ��λ", "����", "��������", "רҵ", "ר�Ʊ�ҵԺУ", "���Ʊ�ҵԺУ", "˶ʿ��ҵԺУ", "���ܣ�ǰ̨����̨��", "�����ؼ�����",
				"��������" };
		writeXLS(row);
	}

	/**
	 * д��һ������
	 * @param row�������ݵľ�������
	 */
	public void writeXLS(String[] row) {

		try {
			Label[] label = new Label[row.length];
			for (int i = 0; i < row.length; i++) {
				label[i] = new Label(i, rows, row[i]);
				// ������õĵ�Ԫ����ӵ���������
				first_sheet.addCell(label[i]);
			}
			
			//����ÿ�п�
			for(int i=0;i<row.length;i++){    
	            if(first_sheet.getColumnWidth(i)<getWordCount(row[i])+4){
	                first_sheet.setColumnView(i, getWordCount(row[i])+4);
	            }	            
	        }
			
			
			rows++;// ��д����=1
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * д��һ��Work����
	 * @param work
	 */
	public void writeXLS(int index, Datas datas) {
		String[] row = { ""+index,datas.getName(),datas.getPhone(),
		        datas.getEmail(),datas.getPost(),datas.getReporttime(),datas.getStarttime(),
		        datas.getPosition(),datas.getDirection(),datas.getBirthday()};
		writeXLS(row);
	}

	/**
	 * д�����ݲ��ر��ļ�
	 */
	public void writeclose() {
		try {
			// д������
			book.write();
			// �ر��ļ�
			book.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*����Java�ǻ���Unicode����ģ���ˣ�һ�����ֵĳ���Ϊ1��������2�� 
     * ����ʱ��Ҫ���ֽڵ�λ����ַ����ĳ��ȡ����磬��123abc���ǡ����ֽڳ��ȼ�����10������Unicode���㳤����8�� 
     * Ϊ�˻��10����Ҫ��ͷɨ������ַ���Ascii����þ���ĳ��ȡ�����Ǳ�׼���ַ���Ascii�ķ�Χ��0��255������Ǻ��ֻ�����ȫ���ַ���Ascii�����255�� 
     * ��ˣ����Ա�д���µķ�����������ֽ�Ϊ��λ���ַ������ȡ�*/  
    public static int getWordCount(String s)  
    {  
        int length = 0;  
        for(int i = 0; i < s.length(); i++)  
        {  
            int ascii = Character.codePointAt(s, i);  
            if(ascii >= 0 && ascii <=255)  
                length++;  
            else  
                length += 2;  

        }  
        return length;  
    }

}
