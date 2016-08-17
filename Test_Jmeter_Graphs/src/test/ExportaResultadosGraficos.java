package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import util.ArchivoConfiguracion; 
import java.util.logging.*;

public class ExportaResultadosGraficos {	
	private static final Logger LOGGER = Logger.getLogger(ExportaResultadosGraficos.class.getName());
	
	public String generaResultadosEnGraficos (String ruta_log_resultado){		
		String hora_creacion = "";
		ArchivoConfiguracion conf = null;
		Process proceso = null;
		try {
			conf = new ArchivoConfiguracion();
			String salida_grafico = conf.getSalida_grafico();								
			Date fecha = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("HH_mm_ss");		
			hora_creacion = (String)formato.format(fecha);
			salida_grafico += "/"+hora_creacion;
			File carpeta = new File(salida_grafico);		
			if(!carpeta.exists()){
				carpeta.mkdirs();
			}
			//Hacemos la llamada a la funcion de jmeter 3.0 para generar un dashboard a partir de su ejecucion
			String[] cmd =  {""+conf.getRuta_jmeter()+""+ruta_log_resultado+" -o "+salida_grafico+""};
//			Runtime.getRuntime().exec(cmd[0]);
			proceso = Runtime.getRuntime().exec(cmd[0]);
			//mostramos la salida por consola del comando
			BufferedReader in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea = null;
			while((linea = in.readLine()) !=null){
				LOGGER.log(Level.INFO, linea);
				if(linea.contains("error")){
					throw new IOException();
				}
			}			
		} catch (IOException e) {			
			LOGGER.log(Level.SEVERE, e.toString(), e);			
		}
		return hora_creacion;
	}
}
