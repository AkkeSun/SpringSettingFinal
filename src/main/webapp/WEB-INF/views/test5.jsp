<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> 
<!-- <script src="/js/comm.js"></script> -->
 <title>Insert title here</title>
</head>
<body>
<h1>ajax Test</h1>

<script>
let ajaxData;
let ajaxcomm = (goUrl, data, dataType, type) => {
	
	ajaxData = ""; 
	let result = false;
 	if(dataType == "") dataType = 'json';
 	if(type == "" ) type='post';
	
 	let ajaxComm = $.ajax({
						url:goUrl,
				    	data:data,
				    	datatype:dataType,
						type:type,
						async:false
					});
 	
 	ajaxComm.done((data) => {
						 		ajaxData = data;
						 		result = true;
						 	 });
 	ajaxComm.fail( ()=>alert('ajax error') );
 	
	return result;
}


let callback = ajaxcomm('/test/T7', "", "", "");
if(callback){
	alert(ajaxData.key1);
}



</script>
</body>
</html>