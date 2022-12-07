import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class ListEmployeeCriterion {
	
	public static void main(String[] args) {
		
	
		
		try {
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Loaded...");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Criteria criteria=s.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("dept","IT"));
		criteria.add(Restrictions.ge("doj","2019-01-01"));
		
		List<Employee> list=criteria.list();
		
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
