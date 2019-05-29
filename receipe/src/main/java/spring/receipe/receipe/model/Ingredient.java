package spring.receipe.receipe.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Double amount;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	
	@ManyToOne
	private Recipe receipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}

	public Recipe getReceipe() {
		return receipe;
	}

	public void setReceipe(Recipe receipe) {
		this.receipe = receipe;
	}
	
	

}
