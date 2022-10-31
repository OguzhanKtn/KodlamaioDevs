package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import kodlama.io.Devs.business.abstracts.LanguageService;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/post")
	void add(ProgrammingLanguage language) throws Exception {
		languageService.add(language);
	}
	
	@DeleteMapping("/delete")
	void delete(int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/update")
	void update(int id, String newName) throws Exception {
		languageService.update(id, newName);
	}
	
	@GetMapping("/getById")
	ProgrammingLanguage getById(int id) {
		return languageService.getById(id);
	}
}
