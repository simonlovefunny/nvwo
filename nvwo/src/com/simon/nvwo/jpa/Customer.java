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
 * JPA�־û�ʵ����
 * @author ����
 *
 */

@Table(name="jpa_customers")  //ӳ�����
@Entity  //��ʾʵ����
public class Customer {
	
	private Integer id;
	
	private Integer age;
	
	private String firstName;
	
	private String lastName;
	
	private Date createdTime;
	
	private Date updateTime;
	


	//��@see com.simon.nvwo.jpa.map.Good�ĵ���һ�Զ�ӳ���ϵ
	private Set<Order> orders=new HashSet<Order>();
	

	// @OneToMany ӳ��һ�Զ��ϵ
	// @JoinColumn ӳ������е�����
	// @OneToMany(fetch=FetchType.EAGER)�ر������ط�ʽ����һ�Զ��ϵ����Ҫʹ�����ּ��ز���
	//@JoinColumn(name="CUSTOMER_ID") //˫����һʱ��Ҫ�� com.simon.nvwo.jpa.map.Order.getCustomer()���õ����Ա���һ��
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.REMOVE},mappedBy="customer") //����ά�����һ��ϵ������orderȥά��,��ʱ��Ҫע�͵�@JoinColumn
	public Set<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	/*	//�������ɲ��ԣ��ɱ�jpa_id_generators��ȷ����ֻ���ڳ������ɱ�ʱ��Ч��ÿ������100
	@TableGenerator(name="ID_GENERAOR",
			table="jpa_id_generators",
			pkColumnName="PK_NAME",
			valueColumnName="PK_VALUE",
			allocationSize=100)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ID_GENERAOR") //���ɲ���
*/	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id	//ָ��Ϊid
	public Integer getId() {
		return id;
	}
	//��ȷָ��ʱ�������
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	//��ȷָ��ʱ�������
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
	@Column(name="first_name")  //���ݿ�洢���޸ĵ��ֶ���Ҫ��ע��
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="last_name")  //���ݿ�洢���޸ĵ��ֶ���Ҫ��ע��
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//����Ҫӳ��
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
