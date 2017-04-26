package com.simon.nvwo.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.simon.nvwo.jpa.map.Order;

/**
 * JPA持久化实例类
 * @author 昭毅
 *
 */

@Table(name="jpa_customers")  //映射表名
@Entity  //表示实体类
public class Customer {
	
	private Integer id;
	
	private Integer age;
	
	private String firstName;
	
	private String lastName;
	
	private Date createdTime;
	
	private Date updateTime;
	


	//和@see com.simon.nvwo.jpa.map.Good的单向一对多映射关系
	private Set<Order> orders=new HashSet<Order>();
	

	// @OneToMany 映射一对多关系
	// @JoinColumn 映射外键列的名称
	// @OneToMany(fetch=FetchType.EAGER)关闭懒加载方式，在一对多关系中需要使用这种加载策略
	//@JoinColumn(name="CUSTOMER_ID") //双向多对一时需要和 com.simon.nvwo.jpa.map.Order.getCustomer()设置的属性保持一致
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.REMOVE},mappedBy="customer") //放弃维护多对一关系，交给order去维护,此时需要注释掉@JoinColumn
	public Set<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	/*	//主键生成策略，由表jpa_id_generators来确定，只有在初次生成表时生效，每次增加100
	@TableGenerator(name="ID_GENERAOR",
			table="jpa_id_generators",
			pkColumnName="PK_NAME",
			valueColumnName="PK_VALUE",
			allocationSize=100)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ID_GENERAOR") //生成策略
*/	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id	//指定为id
	public Integer getId() {
		return id;
	}
	//精确指定时间戳类型
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	//精确指定时间戳类型
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="first_name")  //数据库存储名修改的字段需要加注解
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="last_name")  //数据库存储名修改的字段需要加注解
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//不需要映射
	@Transient
	public String getInfo(){
		
		return firstName+","+lastName;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer[id="+id+",firstName="+firstName+",lastName="+lastName+",age="
				+age+",createdTime="+createdTime+",updateTime="+updateTime+"]";
	}
	
	
}
