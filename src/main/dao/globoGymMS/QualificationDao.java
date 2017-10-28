package main.dao.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Qualification;

public interface QualificationDao {
	public void addQualification(Qualification qualification);
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualificationId);
	public void deleteQualification(Qualification qualification);
}
