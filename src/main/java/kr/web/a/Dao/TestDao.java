package kr.web.a.Dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestDao {
	
	@Resource(name="oracleSql")
	SqlSessionTemplate oracleSql;
	
	@Resource(name="mariaSql")
	SqlSessionTemplate mariaSql;
	
	public SqlSession getDao(String DB) {
		SqlSession JDBC = null;
		if(DB.toLowerCase().equals("oracle")) {
			JDBC=oracleSql;
		}
		else if(DB.toLowerCase().equals("maria")) {
			JDBC=mariaSql;
		}
		return JDBC;
	}
	
	@Transactional
	public List<?> selectList(HashMap<String, Object> param, String namespace, String DB) throws Exception {
		return getDao(DB).selectList(namespace, param);
	}
}
