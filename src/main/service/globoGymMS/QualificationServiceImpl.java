package globoGymMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import globoGymMS.Qualification;
import globoGymMS.QualificationDao;

@Service("qualificationService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public class QualificationServiceImpl {
	@Autowired
	private QualificationDao qualificationDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addQualification(Qualification qualification) {
		qualificationDao.addQualification(qualification);
	}
	
	public List<Qualification> listQualifications() {
		return qualificationDao.listQualifications();
	}
	
	public Qualification getQualification(int qualId) {
		return qualificationDao.getQualification(qualId);
	}
	
	public void deleteQualification(Qualification qualification) {
		qualificationDao.deleteQualification(qualification);
	}
}
