package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;

public interface TechnologyService {
	
	List<GetAllTechnologyResponse> getAll();
	void add(CreateTechnologyRequest request)throws Exception;
	void delete(int id);
	void update(UpdateTechnologyRequest request, int id)throws Exception;
}
