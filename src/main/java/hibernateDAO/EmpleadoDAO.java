package hibernateDAO;


import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import ejercicioHibernate.Empleado;
import utils.HibernateUtil;



public class EmpleadoDAO {


	  public static void insertEmpleados(Session s, int numClients) {
		    for (int id = 10; id <= numClients; id++) {
		    	insertEmpleado(s, id);
		    }
		  }
		  
			public static void insertEmpleado(Session s, int id) {
			
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("introduce un codigo"));
				String nombre = JOptionPane.showInputDialog("Introducir nombre");
				String apellido1 = JOptionPane.showInputDialog("Introducir apellido");
				String apellido2 = JOptionPane.showInputDialog("Introducir apellido2");
				String lugarNacimiento = JOptionPane.showInputDialog("Introducir lugar nacimiento");
				String fechaNacimiento = JOptionPane.showInputDialog("Introduccion fecha nacimiento");
				String direccion = JOptionPane.showInputDialog("Intrtroducir direccion");
				String telefono = JOptionPane.showInputDialog("Introducir tlf");
				String puesto = JOptionPane.showInputDialog("Introducir puesto");
				int codDepartamento = Integer.parseInt(JOptionPane.showInputDialog("introduce un codigo de departamento"));
				
				Empleado empleado = new Empleado(codigo,nombre,apellido1,apellido2,lugarNacimiento,fechaNacimiento,direccion,telefono,puesto,codDepartamento);
				s.save(empleado);
			}

			// hql queries
			public static List<Empleado> getAllEmpleados() {
				return getAllEmpleado(HibernateUtil.retrieveSession());
			}
			
			public static List<Empleado> getAllEmpleado(Session s) {
				String hQuery = "from Empleado";
				List<Empleado> empleados = s.createQuery(hQuery, Empleado.class)
						   	   			           .list();
				return empleados;
			}
			
			/*public static Departamento getClient(Session s, int codigo) {
			  String hQuery = " from Departamento d " +
			                  " where d.codigo = :codigo";
			  Departamento departamento = s.createQuery(hQuery, Departamento.class)
			                   .setParameter("codigo", codigo)
			                   .setMaxResults(1)
			                   .uniqueResult();
		    return departamento;
			}
			*/
			public static Empleado gotEmpleado(Session s, int codigo) {
				  
			    return s.get(Empleado.class, codigo);
		
			}	
			public Empleado getEmpleado(Session miSesion, int codigo) {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				Criteria criteria = miSesion.createCriteria(Empleado.class);
				Empleado empleado = (Empleado)criteria.add(Restrictions.eq("cod_departamento", codigo)).setMaxResults(1).uniqueResult();
				return empleado;
			}
			public List<Empleado> getEmpleados(Session miSesion) {
						
				Query<Empleado> miConsulta = miSesion.createQuery("from Empleado", Empleado.class);
						
				List<Empleado> empleados = miConsulta.getResultList();
						
				return empleados;
			}
}
