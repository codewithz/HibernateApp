import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class MaxSalary {
	
	public static void main(String[] args) {
		
	
		
		try {
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Loaded...");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Criteria criteria=s.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("dept","IT"));
		
		criteria.setProjection(Projections.max("salary"));
		
		float maxSalary=(Float)criteria.uniqueResult();
		
		System.out.println("Max Salary in IT is:"+maxSalary);
		
		
		
		
		
		
		
		
		s.close();
		
		System.out.println("Employee Loaded");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
