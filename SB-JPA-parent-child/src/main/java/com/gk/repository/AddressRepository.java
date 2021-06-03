package com.gk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	public Address findByUser_Id(Long id);

}
