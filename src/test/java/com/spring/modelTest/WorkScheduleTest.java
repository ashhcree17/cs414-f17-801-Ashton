package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.model.WorkSchedule;

public class WorkScheduleTest {
	
	@Autowired
    private WorkSchedule workSchedule;
    
    @Test
    public void verifyBeansConfigured() {
    		Assert.assertNotNull(workSchedule); 
    }
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(WorkSchedule.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(WorkSchedule.class, "workScheduleId", Id.class, 
				GeneratedValue.class);
		AssertAnnotations.assertField(WorkSchedule.class, "day", Column.class);
		AssertAnnotations.assertField(WorkSchedule.class, "startTime", Column.class);
		AssertAnnotations.assertField(WorkSchedule.class, "endTime", Column.class);
		AssertAnnotations.assertField(WorkSchedule.class, "trainer", Column.class,
				ManyToOne.class, JoinColumn.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(WorkSchedule.class, "getWorkScheduleId");
		AssertAnnotations.assertMethod(WorkSchedule.class, "getDay");
		AssertAnnotations.assertMethod(WorkSchedule.class, "getStartTime");
		AssertAnnotations.assertMethod(WorkSchedule.class, "getEndTime");
		AssertAnnotations.assertMethod(WorkSchedule.class, "getTrainer");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(WorkSchedule.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(WorkSchedule.class, Table.class);
		Assert.assertEquals("WorkSchedule", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(WorkSchedule.class, 
				"getWorkScheduleId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void day() {
		Column column = ReflectTool.getMethodAnnotation(WorkSchedule.class, 
				"getDay", Column.class);
		Assert.assertEquals("day", column.name());
	}
	
	@Test
	public void trainer() {
		ManyToOne manyToOne = ReflectTool.getMethodAnnotation(WorkSchedule.class, 
				"getTrainer", ManyToOne.class);
		Assert.assertEquals("customerId", manyToOne.targetEntity());
	}
}