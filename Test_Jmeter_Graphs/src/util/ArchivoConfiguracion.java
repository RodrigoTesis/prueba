package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;;

public class ArchivoConfiguracion {
	private String salida_grafico;
	private String ruta_jmeter;
	
	public ArchivoConfiguracion(){
		Properties properties = new Properties();
		InputStream entrada = null;
		try {	
			/*Esta forma nos permite cargar recursos desde cualquier sitio a través del método getResourceAsStream(), 
			esta forma de carga se utiliza principalmente en entornos web o donde los recursos están almacenados en 
			ficheros comprimidos (.war, .jar).*/
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if(cl == null){
				cl = ClassLoader.getSystemClassLoader();
			}			
			entrada = cl.getResourceAsStream("properties/conf.properties");
			properties.load(entrada);
		
		} catch (IOException e) {			
			e.printStackTrace();			
		}finally{
			if(entrada != null){
				try {
					this.salida_grafico = properties.getProperty("salida_grafico");
					this.ruta_jmeter = properties.getProperty("ruta_jmeter");
					entrada.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public String getSalida_grafico() {
		return salida_grafico;
	}

	public void setSalida_grafico(String salida_grafico) {
		this.salida_grafico = salida_grafico;
	}

	public String getRuta_jmeter() {
		return ruta_jmeter;
	}

	public void setRuta_jmeter(String ruta_jmeter) {
		this.ruta_jmeter = ruta_jmeter;
	}
}
