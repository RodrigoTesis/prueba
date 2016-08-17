package practica;

import java.io.InputStream;
import java.util.Properties;

public class Ejecuta {
	public static void main(String args[]){
//		Documento documentoHtml = new DocumentoHTML();		
//		Documento documentoPlano = new DocumentoPlano();
//		
//		documentoHtml.imprimir();
//		documentoPlano.imprimir();
//		
		Properties properties = new Properties();
		InputStream entrada = null;
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if(cl == null){
				cl = ClassLoader.getSystemClassLoader();
			}			
			entrada = cl.getResourceAsStream("../../WebContent/META-INF/conf.properties");
//			entrada = cl.getResourceAsStream("properties/conf.properties");
			System.out.println("la entrada es "+entrada);
			properties.load(entrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}

