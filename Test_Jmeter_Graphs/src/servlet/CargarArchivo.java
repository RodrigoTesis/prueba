package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import test.ExportaResultadosGraficos;

/**
 * Servlet implementation class GeneraGrafico
 */
@WebServlet("/CargarArchivo")
public class CargarArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarArchivo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.print("Hola ");
			
		String ruta = System.getProperty("catalina.home");
		ruta += "/temp/resultados";
		File repositorio = new File(ruta);
		if(!repositorio.exists()){
			repositorio.mkdirs();
		}
		
		ServletRequestContext src = new ServletRequestContext(request);
		if(ServletFileUpload.isMultipartContent(src)){
			//genera el repositorio
			DiskFileItemFactory factory = new DiskFileItemFactory((1024*1024), repositorio);
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				java.util.List lista = upload.parseRequest(src);
				File log = null;
				java.util.Iterator it = lista.iterator();
				
				while(it.hasNext()){
					FileItem item = (FileItem)it.next();
					if(!item.isFormField()){
						log = new File(item.getName());
						item.write(new File(repositorio, log.getName()));						
					}//else en caso que la variable item sea un campo no file del formulario desde el .jsp
				}
				
				String ruta_log_resultado = repositorio+"/"+log.getName(); 
				ExportaResultadosGraficos exportaGraficos = new ExportaResultadosGraficos();
				String carpetaSalida = exportaGraficos.generaResultadosEnGraficos(ruta_log_resultado);
				response.sendRedirect("graphs/"+carpetaSalida);
				
				System.out.println("ruta absoluta "+this.getServletContext().getRealPath(this.getClass().toGenericString()));				
			} catch (Exception e) {				
				e.printStackTrace();
			}	
		}		
	}
}
