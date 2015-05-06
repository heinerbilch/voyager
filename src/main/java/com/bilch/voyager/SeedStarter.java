package com.bilch.voyager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class SeedStarter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Date datePlanted;
	private Boolean covered;
	@Enumerated(EnumType.STRING)
	private Type type = Type.PLASTIC;
	@Lob
	private Feature[] features;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ROW_ID")
	private List<Row> rows = new ArrayList<Row>();

	protected SeedStarter() {
		super();
	}

	public SeedStarter(String name, Date datePlanted, Boolean covered, Type type) {
		super();
		this.name = name;
		this.datePlanted = datePlanted;
		this.covered = covered;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatePlanted() {
		return datePlanted;
	}

	public void setDatePlanted(Date time) {
		this.datePlanted = time;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getCovered() {
		return covered;
	}

	public void setCovered(Boolean covered) {
		this.covered = covered;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRow(Row row) {
		rows.add(row);
	}

	@Override
	public String toString() {
		return "SeedStarter [name=" + name + ", datePlanted=" + datePlanted
				+ ", covered=" + covered + ", type=" + type + "]";
	}

}
