package com.niit.fairdealbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.fairdealbackend.dao.CategoryDAO;
import com.niit.fairdealbackend.dto.Category;



public class CategoryTestCase {

	@Autowired
	private static Category category;
	@Autowired
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void initialize() {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.fairdealbackend");
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	// TEST CASES
	@Ignore
	@Test
	public void getAllCategoriesTestCase() {
		int recordsFromDB = categoryDAO.getAllCategories().size();

		assertEquals("getAllCategoriesTestCase", 12, recordsFromDB);
	}
	@Ignore
	@Test
	public void createCategoryTestCase() {
	
		category.setName("Shoes Category");
		category.setDescription("This is Shoes Category");

		boolean flag = categoryDAO.createCategory(category);

		// compare what you are expecting VS what you are getting from the save
		// method
		assertEquals("createCategoryTestCase", true, flag);
	}
@Ignore
	@Test
	public void updateCategoryTestCase() {

		category.setName("Jewellery Category");
		category.setDescription("This is Jewellery Category");

		boolean flag = categoryDAO.updateCategory(category);

		assertEquals("updateCategoryTestCase", true, flag);
	}

	@Test
	@Ignore
	public void deleteCategoryTestCase()
	{	
		boolean flag = categoryDAO.deleteCategory(category);
		
		assertEquals("deleteCategoryTestCase", true, flag);
	}
	
	@Test
	@Ignore
	public void getCategoryByIDTestCase()
	{
		category = categoryDAO.getCategoryByID(02);
		
		assertEquals("getCategoryByIDTestCase", null, category);
	}
	
	@Test
	@Ignore
	public void getCategoryByNameTestCase()
	{
		category = categoryDAO.getCategoryByName("Women Category");
		
		assertEquals("getCategoryByNameTestCase", null, category);
	}
}