package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.Datas;
import com.lgwind.domain.User;
import com.lgwind.mapping.DatasMapperI;

public class DatasDao {
	
	//����sql�Ự
	SqlSession sqlSession;
	//��ȡmapper�ļ���Ϣ
	DatasMapperI mapper;

    public DatasDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * �û���Ϣ����Ӳ���
     * @param datas �û�ʵ����
     * @return ���ز������(int����)
     */
    public int add(Datas datas) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //ִ����Ӳ���
        int retResult = mapper.add(datas);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û���Ϣ��ɾ������
     * @param datasId �û���
     * @return ���ز������(int����)
     */
    public int delete(String  username) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.delete(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û���Ϣ����²���
     * @param datas �û���ʵ����
     * @return ���ز������(int����)
     */
    public int update(Datas datas) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //ִ���޸Ĳ���
        int retResult = mapper.update(datas);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û���Ϣ���ѯ����
     * @param datasId �û���
     * @return ���� �û���ʵ����
     */
    public Datas get(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��User����
        Datas datas = mapper.get(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        //����user���Ե�ֵ����datas������
        if(datas!=null){
            User user = new UserDao().get(datas.getUsername());
            datas.setUser(user);
        }
        return datas;
    }
    
    /**
     * �û���Ϣ���ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� �û���Ϣ��ʵ����list����
     */
    public List<Datas> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<Datas> listDatas = mapper.getAll("%");
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        //����user���Ե�ֵ����datas������
        User user;
        for (int i=0; i<listDatas.size(); i++) {
        	user = new UserDao().get(listDatas.get(i).getUsername());
        	listDatas.get(i).setUser(user);
        }
        return listDatas;
    }
    
    /**
     * �û���Ϣ���ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� �û���Ϣ��ʵ����list����
     */
    public List<Datas> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DatasMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<Datas> listDatas = mapper.getAll(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        //����user���Ե�ֵ����datas������
        User user;
        for (int i=0; i<listDatas.size(); i++) {
            user = new UserDao().get(listDatas.get(i).getUsername());
            listDatas.get(i).setUser(user);
        }
        return listDatas;
    }

}
