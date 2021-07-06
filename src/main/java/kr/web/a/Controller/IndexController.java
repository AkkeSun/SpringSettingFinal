package kr.web.a.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(value="/")
	public String main() {
		log.info("Test");
		return "main";
	}
}