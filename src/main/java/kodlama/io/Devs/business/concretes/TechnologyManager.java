package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepositoryDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.*;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private LanguageRepositoryDao languageRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository,LanguageRepositoryDao languageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> techResponse = new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology technology : technologies) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setName(technology.getName());
			techResponse.add(response);
		}
		return techResponse;
	}

	@Override
	public void add(CreateTechnologyRequest technologyRequest) throws Exception {
		Technology technology = new Technology();
		
		
		if(technologyRequest.getName().isBlank()) {
			throw new Exception("Please enter a name");
		}else{
			for(Technology technologies : technologyRepository.findAll()) {
				if(technologies.getName().equalsIgnoreCase(technologyRequest.getName())) {
					throw new Exception("This name is already exist.");
				}else {
					
				}		technology.setName(technologyRequest.getName());	
						
				for(ProgrammingLanguage language : languageRepository.findAll()) {
					
					if(language.getName().equalsIgnoreCase(technologyRequest.getLanguageName())) {
						technology.setLanguage(language);
					}else {
						throw new Exception("This language doesn't exist.");
					}
				}			
			}
				technologyRepository.save(technology);
		}
		
	}

	@Override
	public void delete(int id) {
		
		technologyRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateTechnologyRequest request,int id) throws Exception {
		
		Technology technology = technologyRepository.findById(id);
		
		technology.setName(request.getName());
		
		for(ProgrammingLanguage language : languageRepository.findAll()) {
			if(language.getName().equalsIgnoreCase(request.getLanguageName())) {
				technology.setLanguage(language);
			}
		}
		
		technologyRepository.save(technology);
		
		
	}

}
