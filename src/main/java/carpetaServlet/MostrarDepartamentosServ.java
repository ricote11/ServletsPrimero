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
import org.hibernate.Transaction;

import ejercicioHibernate.Departamento;
import hibernateDAO.DepartamentoDAO;

import principal.Principal;
import utils.HibernateUtil;

/**
 * Servlet implementation class MostrarDepartamentosServ
 */
@WebServlet("/MostrarDepartamentosServ")
public class MostrarDepartamentosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(Principal.class);
	static SessionFactory sessionFactory;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDepartamentosServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
		    
	     DepartamentoDAO dep = new DepartamentoDAO();
	  
		List<Departamento> departamentos = dep.getDepartamentos(session);
		if(departamentos!=null)
		{
			out.println ("<!DOCTYPE HTML PUBLIC \""+
		             "-//W3C//DTD HTML 4.0 " + 
		             "Transitional//EN\">");
			out.println ("<HTML>");
			out.println ("<BODY>");
			out.println ("<h1>Lista de departamentos</h1>");

		    for (Departamento departamento : departamentos) {
		    	out.println (departamento.getCodigo());
		    	
		    	out.println (departamento.getNombre());
		    	
		    	out.println (departamento.getCodResponsable());
		    	out.println ("<br>");
			
		    	out.println ("</BODY>");
				out.println ("</HTML>");
			
		 	}
		}
		else {
			
			
		}

		logger.info("no quedan departamentos");
		
	
	
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
