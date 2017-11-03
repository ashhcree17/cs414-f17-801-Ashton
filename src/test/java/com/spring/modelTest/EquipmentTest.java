package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.spring.model.Customer;
import com.spring.model.Equipment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EquipmentTest {
	
	@Autowired
    private Equipment equipment;
    
    @Test
    public void verifyBeansConfigured() {
    		Assert.assertNotNull(equipment); 
    }
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Equipment.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Equipment.class, "equipmentId", Id.class, 
				GeneratedValue.class);
		AssertAnnotations.assertField(Equipment.class, "name", Column.class);
//		AssertAnnotations.assertField(Equipment.class, "picture", Column.class);
		AssertAnnotations.assertField(Equipment.class, "quantity", Column.class);
		AssertAnnotations.assertField(Equipment.class, "exercises", Column.class,
				ManyToMany.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Equipment.class, "getEquipmentId");
		AssertAnnotations.assertMethod(Equipment.class, "getName");
//		AssertAnnotations.assertMethod(Equipment.class, "getPicture");
		AssertAnnotations.assertMethod(Equipment.class, "getQuantity");
		AssertAnnotations.assertMethod(Equipment.class, "getExercises");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Equipment.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Equipment.class, Table.class);
		Assert.assertEquals("Equipment", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Equipment.class, 
				"getEquipmentId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getMethodAnnotation(Equipment.class, 
				"getName", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void duration() {
		Column column = ReflectTool.getMethodAnnotation(Equipment.class, 
				"getDuration", Column.class);
		Assert.assertEquals("duration", column.name());
	}
	
	@Test
	public void exercises() {
		ManyToMany manyToMany = ReflectTool.getMethodAnnotation(Customer.class, 
				"getExercises", ManyToMany.class);
		Assert.assertEquals(CascadeType.ALL, manyToMany.cascade());
	}
}