package kr.web.a.Controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.web.a.Service.TestService;
import kr.web.a.Vo.TestVo;

@Controller
@RequestMapping("/test")
public class Testcontroller {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	TestService tService;
	
	//-------------------- DB에서 값 꺼내기 ---------------------------------
	@GetMapping("/T1")
	public String makeJson() {
		
		List<TestVo> list = tService.test1();
		for (TestVo testVo : list) 
			log.info(testVo.toString());
			
		return "test1";
	}
	
	//----------------- JSON 파일 생성 (json-simple 의존성 필요) -----------------------
	@GetMapping("/T2")
	public String Test1(Model model) {
		
		// 최종 완성될 JSON 객채
        JSONObject masterJson = new JSONObject();
        // json을 담을 배열
        JSONArray personArray = new JSONArray();
        // 한개의 정보가 들어갈 JSON 객채
        JSONObject subJson = new JSONObject();
        
        // masterJson.a[0] 정보저장
        subJson.put("name", "박선양");
        subJson.put("age", "31");
        subJson.put("gender", "남자");
        personArray.add(subJson); 

        // subJson 초기화
        subJson = new JSONObject();      
        
        // masterJson.a[1] 정보저장
        subJson.put("name", "구예지");
        subJson.put("age", "31");
        subJson.put("gender", "여자");
        personArray.add(subJson); 
        
        // masterJson에 저장
        masterJson.put("a", personArray);
        
        // masterJson.b[0] 정보저장
        // 초기화
        subJson = new JSONObject(); 
        personArray = new JSONArray();
        subJson.put("name", "박선양");
        subJson.put("age", "23");
        subJson.put("gender", "남자");
        personArray.add(subJson); 

        // subJson 초기화
        subJson = new JSONObject();      
        
        // masterJson.b[1] 정보저장
        subJson.put("name", "구예지");
        subJson.put("age", "23");
        subJson.put("gender", "여자");
        personArray.add(subJson); 
        
        // masterJson에 저장
        masterJson.put("b", personArray);
        
        
        // JSON -> String
        String jsonString = masterJson.toString();
        
        // 파일 생성
        /* 
         java.io.FileNotFoundException: C:\jsonTest.json (액세스가 거부되었습니다) 
         -> 이클립스 우클릭 :  관리자권한으로 실행
         */
        try {
        	 
    		FileWriter file = new FileWriter("C:\\jsonTest.json");
    		file.write(jsonString); // JSON String 객채
    		file.flush();
    		file.close();
     
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

        model.addAttribute("json", masterJson);
		return "test2";
	}

	
	// --------------------------- 외부 JSON 파일 로드 ---------------------------------
	@GetMapping("/T3")
	public String loadJsonAtJava() {
		
		JSONParser jsonParser = new JSONParser();

		try {
        	 
			// 파일 로드해서 json으로 저장
    		Object obj = jsonParser.parse(new FileReader("c:\\jsonTest.json"));
    		JSONObject jsonObject = (JSONObject) obj;	
    		
    		// 필요한 정보 추출 (Array의 경우 JSONArray 사용)
    		JSONArray msg = (JSONArray) jsonObject.get("a");
    		Map <String, String> map = (Map<String, String>) msg.get(0);
    		String name = map.get("name");
    		log.info("KEY a : " + msg);
    		log.info("KEY a(0) : " + map);
    		log.info("KEY a(0).name : " + name);
     
    	} catch (IOException e) {
    		e.printStackTrace();
    	} catch (ParseException e) {
			e.printStackTrace();
		}

		return "test3";
	}
	
	// ------------------------ Js에서 JSON파일 처리 ---------------------------
	@GetMapping("/T4")
	public String goJS() {
		return "test4";
	}
	
	@ResponseBody
	@GetMapping("/T5")
	public String loadJsonAtJS(@RequestParam Map<String, Object> javaList) {
		log.info(javaList+"");
		return "test4";
	}
}