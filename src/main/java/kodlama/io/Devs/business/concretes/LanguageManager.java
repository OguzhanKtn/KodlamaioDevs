package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepositoryDao;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepositoryDao languageRepository;
	
	
	
	@Autowired
	public LanguageManager(LanguageRepositoryDao languageRepository) {
		super();
		this.languageRepository = languageRepository;
		
	}

	public LanguageManager() {
		
	}
	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
		
		for(ProgrammingLanguage language : languages) {
			
			GetAllLanguageResponse languageResponse1 = new GetAllLanguageResponse();
			languageResponse1.setName(language.getName());
			languageResponse1.setTechnologies(language.getTechnologies());
			languageResponse.add(languageResponse1);
	}		
		return languageResponse;
  }
	@Override
	public void add(CreateLanguageRequest request) throws Exception {
		ProgrammingLanguage language = new ProgrammingLanguage();
		
		if(request.getName().isBlank()) {
			throw new Exception("Please enter a name");
		}else {
			for(ProgrammingLanguage languages : languageRepository.findAll()) {
				
				if(languages.getName().equalsIgnoreCase(request.getName())) {
					
					throw new Exception("This name is already exists");
				}else {
					
					
					language.setName(request.getName());	
				}	
			}
			languageRepository.save(language);
		}
			
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest request, int id) throws Exception {
		
		for(ProgrammingLanguage language : languageRepository.findAll()) {
			
			if(request.getName() == language.getName() || request.getName() == null) {
				throw new Exception("Please enter a new name");
			}else if(language.getId() == id){
				
				language.setName(request.getName());
			
				languageRepository.save(language);
			}
		}
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return languageRepository.findById(id);
	}


}
