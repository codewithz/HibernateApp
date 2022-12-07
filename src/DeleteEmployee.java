import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DeleteEmployee {
	
	public static void main(String[] args) {
		
	
		
		try {
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Loaded...");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Employee employee=s.get(Employee.class,new Integer(2000));
		
		
		System.out.println(employee);
		
		employee.setName("Thomas");
		employee.setSalary(40000.00f);
		
		Transaction tx=s.beginTransaction();
		s.delete(employee);
		tx.commit();
		
		s.close();
		
		System.out.println("Employee Deleted");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
