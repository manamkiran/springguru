package spring.pet.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.model.Vet;
import spring.pet.petclinic.services.OwnerService;
import spring.pet.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setLastName("Manam");
		owner1.setFirstName("Kiran");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setLastName("Banu");
		owner2.setFirstName("Priya");

		ownerService.save(owner2);

		System.out.println("Owners Loaded");

		Vet vet1 = new Vet();
		vet1.setLastName("ManamVet");
		vet1.setFirstName("Kiran");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setLastName("BanuVet");
		vet2.setFirstName("Priya");

		vetService.save(vet2);
		System.out.println("Vets Loaded");
	}

}
