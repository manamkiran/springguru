package spring.pet.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "visits")
@Getter
@Setter
@SuperBuilder
public class Visit extends BaseEntity {

	private LocalDate date;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;

}
