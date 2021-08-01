	
	let ajaxComm = (goUrl, data, dataType, Type) => {

		if(data == "") data = "";
  		if(dataType == "") dataType = 'json';
  		if(Type == "" ) Type='post';

		$.ajax({
			url=goUrl,
	    	data=data,
	    	datatype=dataType,
			type=type
		});
	}	

