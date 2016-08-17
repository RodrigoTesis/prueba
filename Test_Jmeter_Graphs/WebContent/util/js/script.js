function abrir(input){	
	var entrada = input.log_resultados.value;
	if(entrada != ""){
		extension = "la entrada es "+entrada.substring(entrada.lastIndexOf(".")).toLowerCase()
		if(extension.match(".csv")){			
			var ancho = screen.availWidth /1.50;
			var alto  = screen.availHeight/1.50;
			var posicion_x = (screen.availWidth/2)-(ancho/2);
			var posicion_y = (screen.availHeight/2)-(alto/2); 
			window.open('','graficos','width='+ancho+',height='+alto+',left='+posicion_x+',top='+posicion_y+'');
			input.target = 'graficos';			
			return true;
		}else{
			alert("el archivo no presenta extension csv");
			return false;
		}		
	}else{		
		alert("Recuerde cargar un archivo con extension .csv");
		return false;
	}
}