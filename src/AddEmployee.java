import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AddEmployee {
	
	public static void main(String[] args) {
		
		Employee employee=new Employee();
		employee.setId(300);
		employee.setName("Mike");
		employee.setDept("IT");
		employee.setDesignation("Developer");
		employee.setSalary(30000.00f);
		employee.setDoj("2021-09-12");
		
		try {
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Loaded...");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(employee);
		
		tx.commit();
		
		s.close();
		
		System.out.println("Employee Stored");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
