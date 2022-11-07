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

	private TechnologyRepository techRepository;
	private LanguageRepositoryDao languageRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository techRepository,LanguageRepositoryDao languageRepository) {
		super();
		this.techRepository = techRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies = techRepository.findAll();
		List<GetAllTechnologyResponse> techResponse = new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology tech : technologies) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setName(tech.getName());
			techResponse.add(response);
		}
		return techResponse;
	}

	@Override
	public void add(CreateTechnologyRequest technology) throws Exception {
		Technology tech = new Technology();
		
		
		if(technology.getName().isBlank()) {
			throw new Exception("Please enter a name");
		}else{
			for(Technology techs : techRepository.findAll()) {
				if(technology.getName() == techs.getName()) {
					throw new Exception("This name is already exist.");
				}else {
					
				}		tech.setName(technology.getName());	
						
				for(ProgrammingLanguage language : languageRepository.findAll()) {
					
					if(language.getName()== technology.getLanguageName()) {
						tech.setLanguage(language);
					}
				}			
			}
				techRepository.save(tech);
		}
		
	}

	@Override
	public void delete(int id) {
		
		techRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateTechnologyRequest request,int id) throws Exception {
		
		Technology technology = techRepository.findById(id);
		
		technology.setName(request.getName());
		
		for(ProgrammingLanguage language : languageRepository.findAll()) {
			if(language.getName() == request.getLanguageName()) {
				technology.setLanguage(language);
			}
		}
		
		techRepository.save(technology);
		
		
	}

}
