package com.niit.fairdealbackend.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.fairdealbackend.dao.AddressDAO;
import com.niit.fairdealbackend.dao.OrderDAO;
import com.niit.fairdealbackend.dto.Address;
import com.niit.fairdealbackend.dto.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int makeOrder(Order order) {
		return (int) getSession().save(order);
		
	}

}
