package dao;

import java.util.List;
import model.Qualification;

public interface QualificationDao {
	public void addQualification(Qualification qualification);
	public void updateQualification(Qualification qualification);	
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualificationId);
	public void deleteQualification(Qualification qualification);
}