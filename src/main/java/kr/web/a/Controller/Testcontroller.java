package kr.web.a.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.web.a.Service.TestService;
import kr.web.a.Vo.TestVo;

@Controller
public class Testcontroller {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	TestService tService;
	
	@GetMapping("/Test1")
	public String Test() {
		
		List<TestVo> list = tService.test1();
		for (TestVo testVo : list) 
			log.info(testVo.toString());
			
		return "test1";
	}
}