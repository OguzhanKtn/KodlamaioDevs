package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/post")
	void add(CreateLanguageRequest language) throws Exception {
		languageService.add(language);
	}
	
	@DeleteMapping("/delete")
	void delete(int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/update")
	void update(UpdateLanguageRequest request, int id) throws Exception {
		languageService.update(request,id);
	}
	
	@GetMapping("/getById")
	ProgrammingLanguage getById(int id) {
		return languageService.getById(id);
	}
}
