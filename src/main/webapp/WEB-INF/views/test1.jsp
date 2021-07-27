<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>DB Connection Success</h1>

<script>
$(function(){
/*
var callback =
	$.ajax({
		url:'/test/T6'
	})
	//success
	.done( (data) => {
		alert(data);
	})
	//error
	.fail( (data) => {
		alert('fail');
	})
callback;
*/

var callback =
	$.ajax({
		url:'/test/T6'
	});

callback.done( (data) => {alert(data)} );
	
	
	
});





</script>
</body>
</html>