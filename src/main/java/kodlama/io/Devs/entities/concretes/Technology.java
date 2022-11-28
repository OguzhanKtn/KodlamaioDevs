package kodlama.io.Devs.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="technologies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "language_id")
	private ProgrammingLanguage language;

}
