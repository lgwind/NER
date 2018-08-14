package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.Datas;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 定义user表的sql映射接口，使用注解指明方法要执行的SQL语句
 * 
 * @author lgwind
 * 
 */
public interface DatasMapperI {
	
	String insert = "insert into datas(username, name, phone, email, post, reporttime, starttime, position, direction, birthday) "
			+ "values(#{username},#{name},#{phone},#{email},#{post},#{reporttime},#{starttime},#{position},#{direction},#{birthday})";
	String delete = "delete from datas "
			+ "where username=#{username}";
	String update = "update datas set name=#{name},phone=#{phone},email=#{email},post=#{post},reporttime=#{reporttime},starttime=#{starttime},position=#{position},direction=#{direction},birthday=#{birthday} "
			+ "where username=#{username}";
	String select = "select * from datas "
			+ "where username=#{username}";
	String selectAll = "select * from datas where username like #{username}";

	// 使用@Insert注解指明add方法要执行的SQL
	// 使用@Results解决数据库列名和类的属性名字段不一样的问题
	@Insert(insert)
//	@Results({@Result(property = "datasId", column = "datas_id")})
    public int add(Datas datas);	

	// 使用@Delete注解指明deleteById方法要执行的SQL
	@Delete(delete)
    public int delete(String username);

	// 使用@Update注解指明update方法要执行的SQL
	@Update(update)
    public int update(Datas datas);

	// 使用@Select注解指明getById方法要执行的SQL
	@Select(select)
    public Datas get(String username);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select(selectAll)
    public List<Datas> getAll(String username);
}