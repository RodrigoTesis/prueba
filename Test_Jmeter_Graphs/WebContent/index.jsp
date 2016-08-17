<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.io.PrintWriter"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generar Resultados</title>
<link rel="stylesheet" type="text/css" href="util/css/style.css" />
<!--script type="text/javascript" src="//code.jquery.com/jquery-3.1.0.min.js"></script-->
<script type="text/javascript" src="util/js/script.js"></script>
</head>
<body>	
	<div class="container">
		<div class="content">
			<form action="CargarArchivo" method="POST" enctype="multipart/form-data" onsubmit="return abrir(this)">
				<label>Suba un archivo</label>
				<input type="file" name="log_resultados" id="log_resultados"/>
				<div class="content-btn">
					<input type="submit" name="enviar_resulados" class="btn"/>
					<input type="reset" value="Limpiar" class="btn"/>
				</div>
			</form>	
		</div>
	</div>			
</body>
</html>