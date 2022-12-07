import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AddCar {
	
	public static void main(String[] args) {
		
		Car c=new Car();
		c.setId(1000);
		c.setName("Nexon");
		c.setCompany("Tata");
		c.setColor("Black");
		c.setHp(15.0f);
		c.setPrice(1250000.0f);
		
		
		
		try {
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Loaded...");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(c);
		
		tx.commit();
		
		s.close();
		
		System.out.println("Car Stored");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
