package com.simon.nvwo.jpa.map;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="jpa_category")
@Entity
public class Category {
	
	private int id;
	
	private String catetoryName;
	
	private Set<Item> items=new HashSet<Item>();

	/**
	 * @return the id
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	@Column(name="category_name")
	public String getCatetoryName() {
		return catetoryName;
	}

	/**
	 * @param catetoryName the catetoryName to set
	 */
	public void setCatetoryName(String catetoryName) {
		this.catetoryName = catetoryName;
	}

	/**
	 * @return the items
	 */
	//@ManyToMany 多对多映射，映射关系交给  com.simon.nvwo.jpa.map.Item.categorys来维护
	@ManyToMany(mappedBy="categorys")
	public Set<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	

}
