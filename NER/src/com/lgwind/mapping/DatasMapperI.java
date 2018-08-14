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
 * ����user���sqlӳ��ӿڣ�ʹ��ע��ָ������Ҫִ�е�SQL���
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

	// ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	// ʹ��@Results������ݿ�����������������ֶβ�һ��������
	@Insert(insert)
//	@Results({@Result(property = "datasId", column = "datas_id")})
    public int add(Datas datas);	

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
	@Delete(delete)
    public int delete(String username);

	// ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
	@Update(update)
    public int update(Datas datas);

	// ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
	@Select(select)
    public Datas get(String username);

	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
	@Select(selectAll)
    public List<Datas> getAll(String username);
}