package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepositoryDao;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepositoryDao repositoryDao;
	
	@Autowired
	public LanguageManager(LanguageRepositoryDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return repositoryDao.getAll();
	}

	@Override
	public void add(ProgrammingLanguage language) throws Exception {
		
		if(language.getName().isBlank()) {
			throw new Exception("Please enter a name");
		}else {
			for(ProgrammingLanguage languages : repositoryDao.getAll()) {
				
				if(languages.getName().equalsIgnoreCase(language.getName())) {
					
					throw new Exception("This name is already exists");
				}
			}
		}
			repositoryDao.add(language);
	}

	@Override
	public void delete(int id) {
		repositoryDao.delete(id);
		
	}

	@Override
	public void update(int id, String newName) throws Exception {
		
		for(ProgrammingLanguage language : repositoryDao.getAll()) {
			
			if(newName == language.getName() || newName == null) {
				throw new Exception("Please enter a new name");
			}else {
				repositoryDao.update(id, newName);
			}
		}
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return repositoryDao.getById(id);
	}

}
