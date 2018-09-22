package com.niit.fairdealbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.fairdealbackend.dao.ProductDAO;
import com.niit.fairdealbackend.dto.Product;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
		context.scan("com.niit.fairdealbackend");
		context.refresh();
		
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void getAllProductsTestCase()
	{
		int recordFromDB = productDAO.getAllProducts().size();
		
		assertEquals("getAllProductsTestCase", 3, recordFromDB);
	}
	@Ignore
	@Test
	public void createProductTestCase()
	{
		product.setName("Handbag");
		product.setPrice(2500);
		product.setDescription("This is Handbag");
		product.setCategory_id(14);
		product.setSupplier_id(37);
		
		boolean flag = productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
	
		product.setName("Kurti");
		product.setPrice(500);
		product.setDescription("Navy blue colored Kurti");
		product.setCategory_id(14);
		product.setSupplier_id(37);
		
		boolean pro = productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, pro);
		
		product.setName("Sports Shoes");
		product.setPrice(1500);
		product.setDescription("Super comfortable addidas shoes");
		product.setCategory_id(13);
		product.setSupplier_id(36);
		
		boolean pro2 = productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, pro2);
		
		product.setName("Cat Dab");
		product.setPrice(2500);
		product.setDescription("Cat dabbing cool print");
		product.setCategory_id(16);
		product.setSupplier_id(40);
		
		
		boolean pro3 = productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, pro3);
		
		product.setName("Lenovo Laptop");
		product.setPrice(40000);
		product.setDescription("Laptop with lot of functions");
		product.setCategory_id(17);
		product.setSupplier_id(38);
		
		boolean pro4 = productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, pro4);
		
		product.setName("Mixer");
		product.setPrice(3000);
		product.setDescription("Bajaj Mixer makes your work easy");
		product.setCategory_id(15);
		product.setSupplier_id(39);
		
		boolean pro5 = productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, pro5);
	}
	@Ignore
	@Test
	public void updateProductTestCase()
	{
		product.setName("Lenovo k3");
		product.setDescription("This is Lenovo mobile brand");
		product.setPrice(10000);
		product.setCategory_id(03);
		product.setSupplier_id(02);
		 
		boolean flag = productDAO.updateProduct(product);
		
		assertEquals("updateProductTestCase", true, flag);
	}
	@Ignore
	@Test
	public void deleteProductTestCase()
	{
		product.setId(04);
		
		boolean flag = productDAO.deleteProduct(product);
		
		assertEquals("deleteProductTestCase", true, flag);
	}
	
	@Ignore
@Test	
	public void getProductByIDTestCase()
	{
		product = productDAO.getProductByID(51);
		
		
		assertEquals("getProductByIDTestCase", null, product);
	}
	@Ignore

	@Test
	public void getProductByNameTestCase()
	{
		product = productDAO.getProductByName("Handbag");
		
		assertEquals("getProductByNameTestCase", null, product);
	}
}