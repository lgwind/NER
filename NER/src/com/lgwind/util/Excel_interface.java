package com.lgwind.util;

import com.lgwind.domain.Datas;

public interface Excel_interface {

	/**
	 * �½�excel��ʹ��Ĭ�����֣�
	 * 
	 * @param path·��
	 */
	public abstract void newXLS(String path);

	/**
	 * �½�excel��
	 * 
	 * @param path·��
	 * @param name�ļ���
	 */
	public abstract void newXLS(String path, String name);

	/**
	 * д��һ�����ݣ�Ĭ��������������ݣ�
	 */
	public abstract void writeXLS();

	/**
	 * д��һ������
	 * 
	 * @param row�������ݵľ�������
	 */
	public abstract void writeXLS(String[] row);

	/**
	 * д��һ��Work����
	 * 
	 * @param work
	 */
	public abstract void writeXLS(int index, Datas datas);

	/**
	 * д�����ݲ��ر��ļ�
	 */
	public abstract void writeclose();
	
	

}
