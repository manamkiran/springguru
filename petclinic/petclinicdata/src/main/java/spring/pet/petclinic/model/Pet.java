package spring.pet.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "pets")
@Getter
@Setter
@SuperBuilder
public class Pet extends BaseEntity {

	private String name;

	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "pet_type_id")
	private PetType petType;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pet")
	private Set<Visit> visits = new HashSet<Visit>();

}
