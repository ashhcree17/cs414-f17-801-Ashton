package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl implements EquipmentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().persist(equipment);
	}

	@Override
	public void updateEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().update(equipment);		
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Equipment> listInventory() {
		return (List<Equipment>) sessionFactory.getCurrentSession()
				.createCriteria(Equipment.class).list();
	}
	
	public Equipment getEquipment(int equipmentId) {
		return (Equipment) sessionFactory.getCurrentSession().get(Equipment.class, equipmentId);
	}
	
	public void deleteEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Equipment WHERE equipmentId = "+equipment.getEquipmentId());
	}
}
