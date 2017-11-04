package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Equipment;

@Repository
public class EquipmentDaoImpl implements EquipmentDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().saveOrUpdate(equipment);
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
	public void deleteEquipment(int equipmentId) {
		Equipment eq = (Equipment) sessionFactory.getCurrentSession().load(Equipment.class, new Integer(equipmentId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
