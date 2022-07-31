/**
 * 
 */
package com.suganya.rentapplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suganya.rentapplication.model.Rent;
import com.suganya.rentapplication.repository.RentRepository;

/**
 * @author SN
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class RentController {
	
	@Autowired
	RentRepository rentRepository;
	
	@GetMapping("/allRentDetails") //read/retrieve all rent data //working
	public ResponseEntity<List<Rent>> getAllHouseRentData(@RequestParam(required = false) String rentalHouseName) {
		try {
			List<Rent> rentDao = new ArrayList<Rent>();
			if(rentalHouseName == null) {
				rentRepository.findAll().forEach(rentDao::add);
			}
			else {
				rentRepository.findByRentalHouseName(rentalHouseName).forEach(rentDao::add);
			}
			if(rentDao.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(rentDao, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	 @PostMapping("/addNewRental") // create new rent data - working as expected
	 public ResponseEntity<Rent> createRent(@RequestBody Rent rentDao) {
		 try {
			 Rent rent = rentRepository.save(new Rent(rentDao.getRentalHouseName(),
					 rentDao.getTenantName(),rentDao.getDescription(), rentDao.getCurrentMonthRentDetails(),
					 rentDao.getCurrentMonthUnitValue()));
			 return new ResponseEntity<>(rent, HttpStatus.CREATED);
		 }
		 catch (Exception e) {
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
	 
	 //search by tenantname - not working
	 @PutMapping("/allRentDetails/{tenantName}")
	 public ResponseEntity<Rent> updateRentDetailsByTenantName(@PathVariable("tenantName") String tenantName, @RequestBody Rent rentDao){
		 Optional<Rent> rent = rentRepository.findByTenantName(tenantName);
		 if(rent.isPresent()) {
			 Rent rentObj = (Rent) rent.get();
			 rentObj.setTenantName(rentDao.getTenantName());
			 rentObj.setDescription(rentDao.getDescription());
			 rentObj.setCurrentMonthRentDetails(rentDao.getCurrentMonthRentDetails());
			 rentObj.setCurrentMonthUnitValue(rentDao.getCurrentMonthUnitValue());
			 return new ResponseEntity<>(rentRepository.save(rentObj), HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 //search by rentalhouseid
	 @PutMapping("/allRentDetails/{rentalHouseId}") //working as expected
	 public ResponseEntity<Rent> updateRentDetailsByRentalHouseId(@PathVariable("rentalHouseId") long rentalHouseId, @RequestBody Rent rentDao){
		 Optional<Rent> rent = rentRepository.findByRentalHouseId(rentalHouseId);
		 if(rent.isPresent()) {
			 Rent rentObj = (Rent) rent.get();
			 rentObj.setDescription(rentDao.getDescription());
			 rentObj.setCurrentMonthRentDetails(rentDao.getCurrentMonthRentDetails());
			 rentObj.setCurrentMonthUnitValue(rentDao.getCurrentMonthUnitValue());
			 return new ResponseEntity<>(rentRepository.save(rentObj), HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 //search by rentalhousename
//	 @PutMapping("/allRentDetails/{rentalHouseName}") //working as expected
//	 public ResponseEntity<Rent> updateRentDetailsByRentalHouseName(@PathVariable("rentalHouseName") String rentalHouseName, @RequestBody Rent rentDao){
//		 List<Rent> rent = rentRepository.findByRentalHouseName(rentalHouseName);
//		 if(rent.isEmpty()) {
//			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		 }
//		 else
//		 {
////			 Rent rentObj = rent.get("rentalHouseName");
//			 Rent rentObj = rent.
//			 rentObj.setDescription(rentDao.getDescription());
//			 rentObj.setCurrentMonthRentDetails(rentDao.getCurrentMonthRentDetails());
//			 rentObj.setCurrentMonthUnitValue(rentDao.getCurrentMonthUnitValue());
//			 return new ResponseEntity<>(rentRepository.save(rentObj), HttpStatus.OK);
//			 
//		 }
//	 }
	 
	 @DeleteMapping("/allRentDetails/{rentalHouseId}") //working
	 public ResponseEntity<HttpStatus> deleteRentDetails(@PathVariable("rentalHouseId") long rentalHouseId){
		 try {
			 rentRepository.deleteById(rentalHouseId);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
		 catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
}
