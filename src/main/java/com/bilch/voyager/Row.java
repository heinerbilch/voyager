package com.bilch.voyager;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Row {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "VARIETY_ID")
	private Variety variety;
	private Integer seedsPerCell;

	public Row() {
		super();
	}

	public Row(Variety variety, Integer seedsPerCell) {
		super();
		this.variety = variety;
		this.seedsPerCell = seedsPerCell;
	}

	public Integer getSeedsPerCell() {
		return seedsPerCell;
	}

	public void setSeedsPerCell(Integer seedsPerCell) {
		this.seedsPerCell = seedsPerCell;
	}

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	@Override
	public String toString() {
		return "Row [seedsPerCell=" + seedsPerCell + "]";
	}
}
