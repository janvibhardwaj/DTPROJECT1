package com.niit.fairdealbackend.dao;

import com.niit.fairdealbackend.dto.Address;

public interface AddressDAO {

	public void insertAddress(Address address);
	public Address getAddressById(int addressId);
	public void updateAddress(Address address);
	public void deleteAddress(int addressId);
}
