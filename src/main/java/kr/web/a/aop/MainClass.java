package kr.web.a.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.web.a.Vo.TestVo;

public class MainClass {
	public static void main(String[] args) {
		
		//bean을 설정한 xml파일이 있는 위치를 지정하여 설정파일을 얻어옴
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCtx.xml");
		
		//설정파일에서 bean을 가져옴
		TestVo test = ctx.getBean("test", TestVo.class);
		
		test.getCatsInfo();
	}
}