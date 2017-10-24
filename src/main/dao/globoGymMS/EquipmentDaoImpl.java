package globoGymMS;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import globoGymMS.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().saveOrUpdate(equipment);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Equipment> listInventory() {
		return (List<Equipment>) sessionFactory.getCurrentSession()
				.createCriteria(Equipment.class).list();
	}
	
	public Equipment getEquipment(int equipmentId) {
		return (Equipment) sessionFactory.getCurrentSession().get(Equipment.class, equipmentId);
	}
	
	public void deleteEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Equipment WHERE id = "+equipment.getEquipmentId());
	}
}
