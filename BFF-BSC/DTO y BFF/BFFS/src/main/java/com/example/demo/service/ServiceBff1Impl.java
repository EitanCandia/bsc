package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ideasDTO;
import com.example.demo.restclients.microideas;


@Service
public class ServiceBff1Impl implements ServiceBff1 {
	

	@Autowired
	microideas micro1;
	
	//@Autowired
	//Micro2 micro2;
	
	
	@Override
	public List<ideasDTO> micro1FindAll() {
		// TODO Auto-generated method stub
		return micro1.findAll();
	}

	@Override
	public Optional<ideasDTO> micro1FindById(int id) {
		// TODO Auto-generated method stub
		return micro1.findById(id);
	}

	/*
	@Override
	public ideasDTO micro1Save(ideasDTO persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void micro1Delete(int id) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	/*
	@Override
	public List<ideasDTO> micro2FindAll() {
		// TODO Auto-generated method stub
		return micro2.findAll();
	}

	@Override
	public Optional<ideasDTO> micro2FindById(int id) {
		// TODO Auto-generated method stub
		return micro2.findById(id);
	}
	*/

	/*
	@Override
	public ideasDTO micro2Save(ideasDTO persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void micro2Delete(int id) {
		// TODO Auto-generated method stub
		
	}
	*/

}
