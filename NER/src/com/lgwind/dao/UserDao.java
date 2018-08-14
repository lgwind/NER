package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.User;
import com.lgwind.mapping.UserMapperI;

public class UserDao {
	
	//创建sql会话
	SqlSession sqlSession;
	//获取mapper文件信息
	UserMapperI mapper;

    public UserDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 用户表添加操作
     * @param user 用户实体类
     * @return 返回操作结果(int数据)
     */
    public int add(User user) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapperI.class);
        //执行添加操作
        int retResult = mapper.add(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表删除操作
     * @param username 用户名
     * @return 返回操作结果(int数据)
     */
    public int delete(String username) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapperI.class);
        //执行删除操作
        int retResult = mapper.delete(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表更新操作
     * @param user 用户表实体类
     * @return 返回操作结果(int数据)
     */
    public int update(User user) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapperI.class);
        //执行修改操作
        int retResult = mapper.update(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表查询操作(默认查询所有)
     * @param username 用户名
     * @return 返回 用户表实体类
     */
    public User get(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成User返回
        User user = mapper.get(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return user;
    }
    
    /**
     * 用户表查询多行操作(默认查询所有)
     * @return 返回 用户表实体类list集合
     */
    public List<User> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> listUser = mapper.getAll("%");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listUser;
    }
    
    /**
     * 用户表查询多行操作(按用户名查询)
     * @return 返回 用户表实体类list集合
     */
    public List<User> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> listUser = mapper.getAll(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listUser;
    }

}
