package com.lgwind.util;

import com.lgwind.domain.Datas;

public interface Excel_interface {

	/**
	 * 新建excel表（使用默认名字）
	 * 
	 * @param path路径
	 */
	public abstract void newXLS(String path);

	/**
	 * 新建excel表
	 * 
	 * @param path路径
	 * @param name文件名
	 */
	public abstract void newXLS(String path, String name);

	/**
	 * 写入一行数据（默认输入标题栏数据）
	 */
	public abstract void writeXLS();

	/**
	 * 写入一行数据
	 * 
	 * @param row该行数据的具体内容
	 */
	public abstract void writeXLS(String[] row);

	/**
	 * 写入一行Work数据
	 * 
	 * @param work
	 */
	public abstract void writeXLS(int index, Datas datas);

	/**
	 * 写入数据并关闭文件
	 */
	public abstract void writeclose();
	
	

}
