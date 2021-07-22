<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<h1>JSON FOR JAVASCRIPT</h1>

<script>
// --------------- json 파일로드 기본 셋업 ----------------------------
let xhttp = new XMLHttpRequest(); 
xhttp.onreadystatechange = function () {
	if(xhttp.readyState == 4 && xhttp.status == 200){
		jsonFunc(this.responseText); 
	}
}                
xhttp.open("GET", "../json/jsonTest.json", true);
xhttp.send();

// --------------- respText : 문자열로 결과값을 받아온다 -----------------
function jsonFunc( respText ) {
	let jsonObj = JSON.parse(respText); // String -> Json
	// JSON.stringify(jsonObj); 		// Json -> String
	alert(jsonObj.a[0].name);
	
	$.ajax({
		url:"/test/T5",
		type:'get',
		data: jsonObj,     
		success:function(data){
		},
		error:function(){
			alert('json ajax error');
		}
	})
}	
</script>

</body>
</html>