package com.lgwind.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lgwind.dao.DatasDao;
import com.lgwind.domain.Datas;

public class DatasDaoTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testAdd() {
		Datas datas=new Datas("2","2","2","2","2","2018-03-02","2018-03-02","2","2","2018-03-02");
		new DatasDao().add(datas);
	}

	@Test
	public void testDelete() {
		new DatasDao().delete("2");
	}

	@Test
	public void testUpdate() {
        Datas datas=new Datas("2","3","3","3","3","2018-03-03","2018-03-03","3","3","2018-03-03");
		new DatasDao().update(datas);
	}

	@Test
	public void testGet() {
		Datas datas=new DatasDao().get("2");
		System.out.println(datas);
	}

	@Test
	public void testGetAll() {
		List<Datas> listDatas = new DatasDao().getAll();
		System.out.println(listDatas);
	}

}
