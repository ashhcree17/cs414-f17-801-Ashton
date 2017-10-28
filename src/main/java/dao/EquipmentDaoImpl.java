package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Equipment;

@Repository
public class EquipmentDaoImpl implements EquipmentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().persist(equipment);
	}

	@Override
	public void updateEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().update(equipment);		
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Equipment> listInventory() {
		return (List<Equipment>) sessionFactory.getCurrentSession()
				.createQuery("from Equipment").list();
	}
	
	@Override
	public Equipment getEquipment(int equipmentId) {
		return (Equipment) sessionFactory.getCurrentSession().get(Equipment.class, equipmentId);
	}
	
	@Override
	public void deleteEquipment(Equipment equipment) {
		Equipment eq = (Equipment) sessionFactory.getCurrentSession().load(Equipment.class, new Integer(equipment.getEquipmentId()));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
