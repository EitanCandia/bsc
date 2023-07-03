package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.kapi_final_DTO;
import com.example.demo.restclients.kapiMicro1;


@Service
public class kapiServiceBff1Impl implements kapiServiceBff1 {
	

	@Autowired
	kapiMicro1 micro1;
	
	@Override
	public List<kapi_final_DTO> micro1FindAll() {
		// TODO Auto-generated method stub
		return micro1.findAll();
	}

	@Override
	public Optional<kapi_final_DTO> micro1FindById(int id) {
		// TODO Auto-generated method stub
		return micro1.findById(id);
	}

	@Override
	public kapi_final_DTO kapisave(kapi_final_DTO kapi) {
		// TODO Auto-generated method stub
		return micro1.kapisave(kapi);
	}

	@Override
	public void kapidelete(int id) {
		// TODO Auto-generated method stub
		micro1.kapidelete(id);
	}

	@Override
	public kapi_final_DTO kapiupdate(int id, kapi_final_DTO kapi) {
		// TODO Auto-generated method stub
		return micro1.kapiupdate(id, kapi);
	}
}
