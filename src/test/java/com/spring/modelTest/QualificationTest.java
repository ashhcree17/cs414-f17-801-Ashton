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
import com.spring.model.Qualification;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class QualificationTest {
	
	@Autowired
    private Qualification qualification;
    
    @Test
    public void verifyBeansConfigured() {
    		Assert.assertNotNull(qualification); 
    }
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Qualification.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Qualification.class, "qualId", Id.class, 
				GeneratedValue.class);
		AssertAnnotations.assertField(Qualification.class, "name", Column.class);
		AssertAnnotations.assertField(Qualification.class, "trainers", Column.class,
				ManyToMany.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Qualification.class, "getQualId");
		AssertAnnotations.assertMethod(Qualification.class, "getName");
		AssertAnnotations.assertMethod(Qualification.class, "getTrainers");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Qualification.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Qualification.class, Table.class);
		Assert.assertEquals("Qualification", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Qualification.class, 
				"getQualId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getMethodAnnotation(Qualification.class, 
				"getName", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void trainers() {
		ManyToMany manyToMany = ReflectTool.getMethodAnnotation(Customer.class, 
				"getTrainers", ManyToMany.class);
		Assert.assertEquals(CascadeType.ALL, manyToMany.cascade());
	}
}