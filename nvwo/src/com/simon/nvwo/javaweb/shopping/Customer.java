package com.simon.nvwo.javaweb.shopping;

/**
 * 
* @ClassName: Customer
* @Description: 购物车顾客信息实体类
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月5日 下午7:33:51
*
 */
public class Customer {
	
	private String name;
	
	private String address;
	
	private String cardType;
	
	private String card;
	
	
	
	public Customer(String name, String address, String cardType, String card) {
		this.name = name;
		this.address = address;
		this.cardType = cardType;
		this.card = card;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the card
	 */
	public String getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(String card) {
		this.card = card;
	}
	
	

}
