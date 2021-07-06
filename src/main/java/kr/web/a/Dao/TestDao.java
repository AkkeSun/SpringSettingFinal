package kr.web.a.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.web.a.Vo.TestVo;

@Repository
public class TestDao {
	@Autowired
	SqlSession sqlsessin;
		
	String namespace="T.";
	
	public List<TestVo> test1() {
		return sqlsessin.selectList(namespace+"test1");
	}	
	
}
