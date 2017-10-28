package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import dao.QualificationDao;
import model.Qualification;

@Service
public class QualificationServiceImpl implements QualificationService {
	@Autowired
	private QualificationDao qualificationDao;
	
	@Override
	@Transactional
	public void addQualification(Qualification qualification) {
		qualificationDao.addQualification(qualification);
	}

	@Override
	@Transactional
	public void updateQualification(Qualification qualification) {
		qualificationDao.updateQualification(qualification);
	}
	
	@Override
	@Transactional
	public List<Qualification> listQualifications() {
		return qualificationDao.listQualifications();
	}
	
	@Override
	@Transactional
	public Qualification getQualification(int qualId) {
		return qualificationDao.getQualification(qualId);
	}
	
	@Override
	@Transactional
	public void deleteQualification(Qualification qualification) {
		qualificationDao.deleteQualification(qualification);
	}
}
