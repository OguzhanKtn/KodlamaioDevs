package kodlama.io.Devs.business.responses;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
	
	private String name;
	private List<Technology> technologies;
	
}
