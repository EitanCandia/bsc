package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

import com.example.demo.crud.dto.DTOBscProyectoPedido;
import com.example.demo.entity.EntityBscProyectoPedido;
import com.example.demo.repository.RepositoryBscProyectoPedido;
import com.example.demo.service.CrudBscProyectoPedidoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
@Service

public class CrudBscProyectoPedidoImpl implements ICrudService {

	public final Logger logger = LoggerFactory.getLogger(CrudBscProyectoPedidoImpl.class);
	
	 	@Autowired
	    private RepositoryBscProyectoPedido data;

	public EntityBscProyectoPedido DTOB2EntityBscProyectoPedido(DTOBscProyectoPedido dtobpp) {
		
		logger.info("Servicer-DTOB2EntityBscProyectoPedido");
		EntityBscProyectoPedido entitybpp = new EntityBscProyectoPedido();
		entitybpp.setId(dtobpp.getId());
		entitybpp.setFecha_registro(dtobpp.getFecha_registro());
		entitybpp.setFecha_proceso(dtobpp.getFecha_proceso());
		entitybpp.setFecha_cierre(dtobpp.getFecha_cierre());
		entitybpp.setDescripcion(dtobpp.getDescripcion());
		entitybpp.setObservaciones(dtobpp.getObservaciones());
		
		return entitybpp;
	}
	
	public DTOBscProyectoPedido entity2dtoBscProyectoPedido(EntityBscProyectoPedido Ebpp) {
		
		logger.info("Servicer-entity2dtoBscProyectoPedido");
		DTOBscProyectoPedido dtobpp = new DTOBscProyectoPedido();
		dtobpp.setId(Ebpp.getId());
		dtobpp.setFecha_registro(Ebpp.getFecha_registro());
		dtobpp.setFecha_proceso(Ebpp.getFecha_proceso());
		dtobpp.setFecha_cierre(Ebpp.getFecha_cierre());
		dtobpp.setDescripcion(Ebpp.getDescripcion());
		dtobpp.setObservaciones(Ebpp.getObservaciones());
		
		
		return dtobpp;
	}
	
	@Override	
	public List<DTOBscProyectoPedido> findAll() {
		logger.info("Servicer-list-findall");
		List<DTOBscProyectoPedido> ldtobpp = new ArrayList<DTOBscProyectoPedido>();
			
		Iterable<EntityBscProyectoPedido> itebpp = data.findAll();
		Iterator<EntityBscProyectoPedido> it = itebpp.iterator();
		while (it.hasNext()) {
			
			EntityBscProyectoPedido Ebpp = it.next();
			DTOBscProyectoPedido dtobpp = entity2dtoBscProyectoPedido(Ebpp);
			ldtobpp.add(dtobpp);
			
		}
		
		 return ldtobpp;
	}

	@Override
	public Optional<DTOBscProyectoPedido> findById(int id) {
		logger.info("Servicer-optional-findbyid");
		Optional<EntityBscProyectoPedido> oebpp = data.findById(id);
		
		if(oebpp.isPresent()) {
			EntityBscProyectoPedido Ebpp = oebpp.get();
			DTOBscProyectoPedido dtobpp = entity2dtoBscProyectoPedido(Ebpp);
			Optional<DTOBscProyectoPedido> odtobpp = Optional.ofNullable(dtobpp);
		
		return odtobpp;
			
		}else {
		return Optional.empty();
		}
		
		
	}

	 @Override
	    public DTOBscProyectoPedido save(DTOBscProyectoPedido p) {
		 logger.info("Servicer-save");
		 EntityBscProyectoPedido Ebpp = DTOB2EntityBscProyectoPedido(p);
		 Ebpp= data.save(Ebpp);
		 DTOBscProyectoPedido dtobpp = this.entity2dtoBscProyectoPedido(Ebpp);
		
	        return dtobpp;
	    }	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		logger.info("Servicer-deletebyid");
		data.deleteById(id);
	}
	

}
