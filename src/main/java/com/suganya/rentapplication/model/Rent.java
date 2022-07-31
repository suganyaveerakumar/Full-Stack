/**
 * 
 */
package com.suganya.rentapplication.model;
import javax.persistence.*;

/**
 * @author SN
 *
 */
@Entity
@Table(name="rent")
public class Rent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rentalHouseId")
	private long rentalHouseId;
	@Column(name = "rentalHouseName")
	private String rentalHouseName;
	@Column(name = "tenantName")
	private String tenantName;
	@Column(name = "description")
	private String description;
	@Column(name = "lastMonthRentDetails")
	private long lastMonthRentDetails;
	@Column(name = "currentMonthRentDetails")
	private long currentMonthRentDetails;
	@Column(name = "lastMonthUnitValue")
	private long lastMonthUnitValue;
	@Column(name = "currentMonthUnitValue")
	private long currentMonthUnitValue;
	
	
	/**
	 * 
	 */
	public Rent() {
		super();
	}

	/**
	 * @param rentalHouseId
	 * @param rentalHouseName
	 * @param tenantName
	 * @param description
	 * @param lastMonthRentDetails
	 * @param currentMonthRentDetails
	 * @param lastMonthUnitValue
	 * @param currentMonthUnitValue
	 */
	public Rent(long rentalHouseId, String rentalHouseName, String tenantName, String description,
			long lastMonthRentDetails, long currentMonthRentDetails, long lastMonthUnitValue,
			long currentMonthUnitValue) {
		super();
		this.rentalHouseId = rentalHouseId;
		this.rentalHouseName = rentalHouseName;
		this.tenantName = tenantName;
		this.description = description;
		this.lastMonthRentDetails = lastMonthRentDetails;
		this.currentMonthRentDetails = currentMonthRentDetails;
		this.lastMonthUnitValue = lastMonthUnitValue;
		this.currentMonthUnitValue = currentMonthUnitValue;
	}
	
	public Rent(String rentalHouseName, String tenantName, String description, long currentMonthRentDetails,
			long currentMonthUnitValue ) {
		this.rentalHouseName = rentalHouseName;
		this.tenantName = tenantName;
		this.description = description;
		this.currentMonthRentDetails = currentMonthRentDetails;
		this.currentMonthUnitValue = currentMonthUnitValue;
	}

	public Rent( String description, long currentMonthRentDetails,
			long currentMonthUnitValue) {
		this.description = description;
		this.currentMonthRentDetails = currentMonthRentDetails;
		this.currentMonthUnitValue = currentMonthUnitValue;
	}
	public long getRentalHouseId() {
		return rentalHouseId;
	}

	public void setRentalHouseId(long rentalHouseId) {
		this.rentalHouseId = rentalHouseId;
	}

	public String getRentalHouseName() {
		return rentalHouseName;
	}

	public void setRentalHouseName(String rentalHouseName) {
		this.rentalHouseName = rentalHouseName;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getLastMonthRentDetails() {
		return lastMonthRentDetails;
	}

	public void setLastMonthRentDetails(long lastMonthRentDetails) {
		this.lastMonthRentDetails = lastMonthRentDetails;
	}

	public long getCurrentMonthRentDetails() {
		return currentMonthRentDetails;
	}

	public void setCurrentMonthRentDetails(long currentMonthRentDetails) {
		this.currentMonthRentDetails = currentMonthRentDetails;
	}

	public long getLastMonthUnitValue() {
		return lastMonthUnitValue;
	}

	public void setLastMonthUnitValue(long lastMonthUnitValue) {
		this.lastMonthUnitValue = lastMonthUnitValue;
	}

	public long getCurrentMonthUnitValue() {
		return currentMonthUnitValue;
	}

	public void setCurrentMonthUnitValue(long currentMonthUnitValue) {
		this.currentMonthUnitValue = currentMonthUnitValue;
	}

	@Override
	public String toString() {
		return "Rent [rentalHouseId=" + rentalHouseId + ", rentalHouseName=" + rentalHouseName + ", tenantName="
				+ tenantName + ", description=" + description + ", lastMonthRentDetails=" + lastMonthRentDetails
				+ ", currentMonthRentDetails=" + currentMonthRentDetails + ", lastMonthUnitValue=" + lastMonthUnitValue
				+ ", currentMonthUnitValue=" + currentMonthUnitValue + ", getRentalHouseId()=" + getRentalHouseId()
				+ ", getRentalHouseName()=" + getRentalHouseName() + ", getTenantName()=" + getTenantName()
				+ ", getDescription()=" + getDescription() + ", getLastMonthRentDetails()=" + getLastMonthRentDetails()
				+ ", getCurrentMonthRentDetails()=" + getCurrentMonthRentDetails() + ", getLastMonthUnitValue()="
				+ getLastMonthUnitValue() + ", getCurrentMonthUnitValue()=" + getCurrentMonthUnitValue()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



	
	
	
}
