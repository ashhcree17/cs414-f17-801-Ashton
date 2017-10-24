package globoGymMS;

import java.util.List;
import globoGymMS.Qualification;

public interface QualificationService {
	public void addQualification(Qualification qualification);
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualificationId);
	public void deleteQualification(Qualification qualification);
}
