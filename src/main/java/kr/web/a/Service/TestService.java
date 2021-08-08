package kr.web.a.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.web.a.Dao.TestDao;
import kr.web.a.Vo.TestVo;

@Service
public class TestService {
	
	@Autowired
	TestDao dao;
	
	public List<?> selectList(HashMap<String, Object> param, String namespace, String DB) throws Exception {
		return dao.selectList(param, namespace, DB);
	}

}
