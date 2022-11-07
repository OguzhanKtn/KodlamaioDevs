package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageService {

	List<GetAllLanguageResponse> getAll();
	void add(CreateLanguageRequest language) throws Exception;
	void delete(int id);
	void update(UpdateLanguageRequest request, int id) throws Exception;
	ProgrammingLanguage  getById(int id);
}
