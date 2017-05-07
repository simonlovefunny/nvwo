package com.simon.nvwo.test;

import com.simon.nvwo.excel.ExcelCell;

public class Mobile {
	
    /**
	 * 姓名
	 */
	 @ExcelCell(index = 0)
	private String name;
	/**
	 * 电话号码
	 */	
	 @ExcelCell(index = 1)
	private String phone;
	
	/**
	 * 省
	 */
	 @ExcelCell(index = 2)
	private String province;
	
	/**
	 * 市
	 */
	 @ExcelCell(index = 3)
	private String city;
	




	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
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

    public Mobile(String name, String phone, String province, String city) {
        super();
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.city = city;
    }

    public Mobile() {
        super();
    }

    /* 
     * Description:
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Mobile [name=" + name + ", phone=" + phone + ", province=" + province + ", city=" + city + "]";
    }



	
	
	
}
