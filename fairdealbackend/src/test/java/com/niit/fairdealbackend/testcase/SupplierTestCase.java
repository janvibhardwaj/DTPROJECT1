package com.niit.fairdealbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.fairdealbackend.dao.SupplierDAO;
import com.niit.fairdealbackend.dto.Supplier;



public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	
	
	@Test
	@Ignore
	public void getAllSuppliersTestCase() {
		
		int recordsFromDB = supplierDAO.getAllSuppliers().size();

		assertEquals("getAllSuppliersTestCase", 3, recordsFromDB);
	}
	@Ignore
	@Test
	public void createSupplierTestCase() {
		
		supplier.setName("Kushal");
		supplier.setAddress("kurnool");
		
		boolean flag = supplierDAO.createSupplier(supplier);
		
		assertEquals("createSupplierTestCase", true, flag);
	}
@Ignore
	@Test
	public void updateSupplierTestCase() {

		supplier.setName("Pradeep");
		supplier.setAddress("KPHB");

		boolean flag = supplierDAO.updateSupplier(supplier);

		assertEquals("updateSupplierTestCase", true, flag);
	}
@Ignore
	@Test
	public void deleteSupplierTestCase()
	{
		supplier.setId(01);
		
		boolean flag = supplierDAO.deleteSupplier(supplier);
		
		assertEquals("deleteSupplierTestCase", true, flag);
	}
@Ignore
	@Test
	public void getSupplierByIDTestCase()
	{
		supplier = supplierDAO.getSupplierByID(02);
		
		assertEquals("getSupplierByIDTestCase", null, supplier);
	}
	
@Ignore	
@Test
	public void getSupplierByNameTestCase()
	{
		supplier = supplierDAO.getSupplierByName("Imran");
		
		assertEquals("getSupplierByNameTestCase", null, supplier);
	}
}
