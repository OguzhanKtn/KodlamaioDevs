package kodlama.io.Devs.business.responses;

import kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
	
	private String name;
	private Technology technologies;

}
