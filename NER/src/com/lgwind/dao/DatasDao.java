package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.Datas;
import com.lgwind.domain.User;
import com.lgwind.mapping.DatasMapperI;

public class DatasDao {
	
	//创建sql会话
	SqlSession sqlSession;
	//获取mapper文件信息
	DatasMapperI mapper;

    public DatasDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 用户信息表添加操作
     * @param datas 用户实体类
     * @return 返回操作结果(int数据)
     */
    public int add(Datas datas) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //执行添加操作
        int retResult = mapper.add(datas);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户信息表删除操作
     * @param datasId 用户名
     * @return 返回操作结果(int数据)
     */
    public int delete(String  username) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //执行删除操作
        int retResult = mapper.delete(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户信息表更新操作
     * @param datas 用户表实体类
     * @return 返回操作结果(int数据)
     */
    public int update(Datas datas) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //执行修改操作
        int retResult = mapper.update(datas);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户信息表查询操作
     * @param datasId 用户名
     * @return 返回 用户表实体类
     */
    public Datas get(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //执行查询操作，将查询结果自动封装成User返回
        Datas datas = mapper.get(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        //查找user属性的值并在datas中设置
        if(datas!=null){
            User user = new UserDao().get(datas.getUsername());
            datas.setUser(user);
        }
        return datas;
    }
    
    /**
     * 用户信息表查询所有操作(默认查询所有)
     * @return 返回 用户信息表实体类list集合
     */
    public List<Datas> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<Datas> listDatas = mapper.getAll("%");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        //查找user属性的值并在datas中设置
        User user;
        for (int i=0; i<listDatas.size(); i++) {
        	user = new UserDao().get(listDatas.get(i).getUsername());
        	listDatas.get(i).setUser(user);
        }
        return listDatas;
    }
    
    /**
     * 用户信息表查询所有操作(默认查询所有)
     * @return 返回 用户信息表实体类list集合
     */
    public List<Datas> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<Datas> listDatas = mapper.getAll(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        //查找user属性的值并在datas中设置
        User user;
        for (int i=0; i<listDatas.size(); i++) {
            user = new UserDao().get(listDatas.get(i).getUsername());
            listDatas.get(i).setUser(user);
        }
        return listDatas;
    }

}
