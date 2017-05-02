package com.simon.nvwo.test;

public class DTO {
	//号段
	private String num;
	//省份
	private String prov;
	//0为成功，其他失败。失败时不扣点数
	private String ret_code;
	//区号
	private String areaCode;
	//运营商名称
	private String name;
	//邮编
	private String postCode;
	//此地区身份证号开头几位
	private String provCode;
	 //1移动    2电信    3联通
	private String type;
	 //城市
	private String city;

	/* 
	* @see java.lang.Object#toString()
	*/ 
	@Override
	public String toString() {
		return "DTO [num=" + num + ", prov=" + prov + ", ret_code=" + ret_code + ", areaCode=" + areaCode + ", name="
				+ name + ", postCode=" + postCode + ", provCode=" + provCode + ", type=" + type + ", city=" + city
				+ "]";
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return the prov
	 */
	public String getProv() {
		return prov;
	}

	/**
	 * @param prov the prov to set
	 */
	public void setProv(String prov) {
		this.prov = prov;
	}

	/**
	 * @return the ret_code
	 */
	public String getRet_code() {
		return ret_code;
	}

	/**
	 * @param ret_code the ret_code to set
	 */
	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the provCode
	 */
	public String getProvCode() {
		return provCode;
	}

	/**
	 * @param provCode the provCode to set
	 */
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
