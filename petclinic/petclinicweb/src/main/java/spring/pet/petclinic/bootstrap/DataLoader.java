package spring.pet.petclinic.bootstrap;

import java.time.LocalDate;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.model.Pet;
import spring.pet.petclinic.model.PetType;
import spring.pet.petclinic.model.Speciality;
import spring.pet.petclinic.model.Vet;
import spring.pet.petclinic.model.Visit;
import spring.pet.petclinic.services.OwnerService;
import spring.pet.petclinic.services.PetTypeService;
import spring.pet.petclinic.services.SpecialityService;
import spring.pet.petclinic.services.VetService;
import spring.pet.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		if (petTypeService.findAll().size() == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("dog");
		petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("cat");
		petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");

		specialityService.save(radiology);
		specialityService.save(surgery);
		specialityService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setLastName("Manam");
		owner1.setFirstName("Kiran");
		owner1.setAddress("Hi");
		owner1.setCity("Hyd");
		owner1.setTelephone("123456");

		Pet dummy = new Pet();
		dummy.setName("Name");
		dummy.setBirthDate(LocalDate.now());
		dummy.setPetType(cat);
		dummy.setOwner(owner1);
		owner1.getPets().add(dummy);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setLastName("Banu");
		owner2.setFirstName("Priya");
		owner2.setAddress("Hello");
		owner2.setCity("Hyd");
		owner2.setTelephone("7890");

		Pet mooncy = new Pet();
		mooncy.setName("Mooncy");
		mooncy.setPetType(dog);
		mooncy.setBirthDate(LocalDate.now());
		mooncy.setOwner(owner2);

		owner2.getPets().add(mooncy);
		ownerService.save(owner2);

		System.out.println("Owners Loaded");

		Vet vet1 = new Vet();
		vet1.setLastName("ManamVet");
		vet1.setFirstName("Kiran");
		vet1.getSpecialities().add(radiology);
		vet1.getSpecialities().add(dentistry);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setLastName("BanuVet");
		vet2.setFirstName("Priya");
		vet2.getSpecialities().add(surgery);

		vetService.save(vet2);
		System.out.println("Vets Loaded");

		Visit catVisit = new Visit();
		catVisit.setPet(dummy);
		catVisit.setDate(LocalDate.now());
		visitService.save(catVisit);
		System.out.println("Visits Loaded");
	}

}
