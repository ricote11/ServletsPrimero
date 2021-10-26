package carpetaServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import principal.Principal;

/**
 * Servlet implementation class UsoServlets
 */
@WebServlet("/UsoServlets")
public class UsoServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(Principal.class);
    /**
     * Default constructor. 
     */
    public UsoServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parameter = request.getParameter("table");
		if(parameter!=null)
		{
			if(parameter.equals("departamento"))
			{
				request.getRequestDispatcher("/MostrarDepartamentosServ").forward(request, response);
				logger.info("redireccionando a la consulta de departamentos");
				
			}
			if(parameter.equals("empleado"))
			{
				
				request.getRequestDispatcher("/MostrarEmpleadosServ").forward(request, response);
				logger.info("redireccionando a la consulta de empleados");
			}
			
			
			
		}
		else {
			logger.info("ningún parametro permitido");
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
