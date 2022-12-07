import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class ListEmployee {
	
	public static void main(String[] args) {
		
	
		
		try {
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Loaded...");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		String hql="from Employee where dept='IT'";
		
		Query<Employee> query=s.createQuery(hql);
		
		List<Employee> list=query.list();
		
		for(Employee e:list) {
			System.out.println(e);
		}
		
		
		
		
		
		s.close();
		
		System.out.println("Employee Loaded");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
