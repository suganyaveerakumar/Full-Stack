/**
 * 
 */
package com.suganya.rentapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suganya.rentapplication.model.Rent;

/**
 * @author SN
 *
 */
public interface RentRepository extends JpaRepository<Rent, Long> {

	Optional<Rent> findByTenantName(String tenantName);
	Optional<Rent> findByRentalHouseId(long rentalHouseId);
	List<Rent> findByRentalHouseName(String rentalHouseName);
	
}
