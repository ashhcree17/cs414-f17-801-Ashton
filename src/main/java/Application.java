package globoGymMS;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import globoGymMS.Manager;
import globoGymMS.ManagerDao;

public class Application {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		ManagerDao managerDAO = context.getBean(ManagerDao.class);
		
		Manager Manager = new Manager();
//		Manager.setName("Pankaj"); Manager.setCountry("India");
		
//		ManagerDao.save(Manager);
		
		System.out.println("Manager::"+Manager);
		
//		List<Manager> list = ManagerDao.list();
		
//		for(Manager m : list){
//			System.out.println("Manager List::"+m);
//		}
		//close resources
		context.close();	
	}
}