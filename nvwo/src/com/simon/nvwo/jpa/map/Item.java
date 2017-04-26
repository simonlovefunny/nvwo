package com.simon.nvwo.jpa.map;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="jpa_item")
@Entity
public class Item {
	
	private int id;
	
	private String itemName;
	
	private  Set<Category> categorys=new HashSet<Category>();

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

	/**
	 * @return the itemName
	 */
	@Column(name="item_name")
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the categorys
	 */
	//@ManyToMany 多对多关联
	//@JoinTable使用中间表，第一个ID指向了Item的id，第二个ID指向了category的id
	//关联当前表的id和cateroty的id
	@JoinTable(name="jpa_item_category",joinColumns={@JoinColumn(name="ITEM_ID",referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="CATEGORY_ID",referencedColumnName="ID")})
	@ManyToMany
	public Set<Category> getCategorys() {
		return categorys;
	}

	/**
	 * @param categorys the categorys to set
	 */
	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}
	
}
