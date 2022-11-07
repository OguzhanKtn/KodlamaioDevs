package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	
	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getAll")
	List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
	@PostMapping("/post")
	void add(CreateTechnologyRequest technology) throws Exception{
		technologyService.add(technology);
	}
	
	@DeleteMapping("/delete")
	void delete(int id) {
		technologyService.delete(id);
	}
	
	@PutMapping("/update")
	void update(int id,UpdateTechnologyRequest request) throws Exception {
		technologyService.update(request, id);
	}

}
