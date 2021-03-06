package org.springframework.data.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.mybatis.domain.Customer;

public interface CustomerRepository extends
		MyBatisRepository<Customer, Integer> {

	public List<Customer> findByFirstName(String firstName);

	@Select("SELECT customer.id id, customer.first_name first_name, customer.last_name last_name, customer.email_address email_adress, address.id address_id, address.street address_street, address.city address_city, address.country address_country FROM customer customer, address address WHERE customer.id = address.customer_id AND customer.last_name = #{lastName}")
	public List<Customer> findByLastName(String lasttName);
}
