package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepositoryDao;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class LanguageRepository implements LanguageRepositoryDao{

	List<ProgrammingLanguage> languages;
	
	
	public LanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1,"GO"));
		languages.add(new ProgrammingLanguage(2,"R"));
		languages.add(new ProgrammingLanguage(3,"C#"));
		languages.add(new ProgrammingLanguage(4,"JAVA"));
		languages.add(new ProgrammingLanguage(5,"PHP"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return languages;
	}

	@Override
	public void add(ProgrammingLanguage language) {
		languages.add(language);
		
	}

	@Override
	public void delete(int id) {
		
		for(int i = 0; i < languages.size(); i++) {
			if(languages.get(i).getId() == id) {
				
				languages.remove(languages.get(i));
			}
		}
	}

	@Override
	public void update(int id, String newName) {
		
		for(ProgrammingLanguage language : languages) {
			if(language.getId() == id) {
				language.setName(newName);
			}
		}
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		for(ProgrammingLanguage language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}

}
