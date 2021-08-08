let ajaxcomm = (goUrl, data, dataType, type) => {
	
	ajaxData = ""; 
	let result = false;
 	if(dataType == "") dataType = 'json';
 	if(type == "" ) type='post';
	
	return $.ajax({
						url:goUrl,
				    	data:data,
				    	datatype:dataType,
						type:type,
						async:false
					});

}