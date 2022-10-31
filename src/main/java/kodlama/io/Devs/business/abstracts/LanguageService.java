package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageService {

	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage language) throws Exception;
	void delete(int id);
	void update(int id,String newName) throws Exception;
	ProgrammingLanguage getById(int id);
}
