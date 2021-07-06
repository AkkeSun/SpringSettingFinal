package kr.web.a.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.web.a.Dao.TestDao;
import kr.web.a.Vo.TestVo;

@Service
public class TestService {
	
	@Autowired
	TestDao dao;
	
	public List<TestVo> test1() {
		return dao.test1();
	}

}
