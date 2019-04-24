package spring.pet.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.model.Vet;
import spring.pet.petclinic.services.OwnerService;
import spring.pet.petclinic.services.VetService;
import spring.pet.petclinic.services.map.OwnerServiceMap;
import spring.pet.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setLastName("Manam");
		owner1.setFirstName("Kiran");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setLastName("Banu");
		owner2.setFirstName("Priya");
		
		ownerService.save(owner2);
		
		System.out.println("Owners Loaded");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setLastName("ManamVet");
		vet1.setFirstName("Kiran");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setLastName("BanuVet");
		vet2.setFirstName("Priya");
		
		vetService.save(vet2);
		System.out.println("Vets Loaded");
	}

}
