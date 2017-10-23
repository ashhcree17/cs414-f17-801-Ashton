package globoGymMS;

import java.util.List;
import globoGymMS.Manager;

public interface ManagerDao {
	public void addManager(Manager manager);
	public List<Manager> listManagers();
	public Manager getManager(int id);
	public void deleteManager(Manager manager);
}
