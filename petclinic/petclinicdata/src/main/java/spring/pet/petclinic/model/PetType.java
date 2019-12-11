package spring.pet.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "types")
@Getter
@Setter
@SuperBuilder
public class PetType extends BaseEntity{
	
	private String name;

}
