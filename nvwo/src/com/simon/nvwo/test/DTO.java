package com.simon.nvwo.test;

public class DTO {
	//�Ŷ�
	private String num;
	//ʡ��
	private String prov;
	//0Ϊ�ɹ�������ʧ�ܡ�ʧ��ʱ���۵���
	private String ret_code;
	//����
	private String areaCode;
	//��Ӫ������
	private String name;
	//�ʱ�
	private String postCode;
	//�˵������֤�ſ�ͷ��λ
	private String provCode;
	 //1�ƶ�    2����    3��ͨ
	private String type;
	 //����
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
