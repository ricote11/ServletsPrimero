package carpetaServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ejercicioHibernate.Departamento;
import ejercicioHibernate.Empleado;
import hibernateDAO.DepartamentoDAO;
import hibernateDAO.EmpleadoDAO;
import principal.Principal;
import utils.HibernateUtil;

/**
 * Servlet implementation class MostrarEmpleadosServ
 */
@WebServlet("/MostrarEmpleadosServ")
public class MostrarEmpleadosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(Principal.class);
	static SessionFactory sessionFactory;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEmpleadosServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
		    
	     EmpleadoDAO empleado = new EmpleadoDAO();
	  
		List<Empleado> emp = empleado.getEmpleados(session);
		if(emp!=null)
		{
			out.println ("<!DOCTYPE HTML PUBLIC \""+
		             "-//W3C//DTD HTML 4.0 " + 
		             "Transitional//EN\">");
			out.println ("<HTML>");
			out.println ("<BODY>");
			out.println ("<h1>Lista de departamentos</h1>");

		    for (Empleado empleado2 : emp) {
				
			
		    	out.println (empleado2.getCodigo());
		    	
		    	out.println (empleado2.getNombre());
		    	
		    	out.println (empleado2.getApellido1());
		    	
		    	out.println (empleado2.getApellido2());
		    	
		    	out.println (empleado2.getDireccion());
		    	
		    	out.println (empleado2.getPuesto());
		    	
		    	out.println (empleado2.getFechaNacimiento());
		    	
		    	out.println (empleado2.getLugarNacimiento());
		    	
		    	out.println (empleado2.getTelefono());
		    	
		    	out.println (empleado2.getCodDepartamento());
		    	out.println ("<br>");
			
		    	out.println ("</BODY>");
				out.println ("</HTML>");
			
		 	}
		}
		else {
			
			
		

		logger.info("no quedan empleados");
		
	
	
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
