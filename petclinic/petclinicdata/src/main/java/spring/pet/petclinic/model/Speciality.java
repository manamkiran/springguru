package spring.pet.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "specialities")
@Getter
@Setter
@SuperBuilder
public class Speciality extends BaseEntity {

	private String description;

}
