<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script src="/js/comm.js"></script>
 <title>Insert title here</title>
</head>
<body>
<h1>ajax Test</h1>

<script>
$(function(){
	
	let data = {};
	data.d1 = 'val1';
	data.d2 = 'val2';
	
	let callback = ajaxcomm('/test/T7', data, "", "");
	callback.done( (data) => alert(data.key1) );

})



</script>
</body>
</html>