package com.bff.bsc.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.bsc.dto.SituacionDTO;
import com.bff.bsc.dto.Bsc_temaDTO;
import com.bff.bsc.dto.DTOBscProyectoPedido;
import com.bff.bsc.dto.LugarDTO;
import com.bff.bsc.dto.ObjetivoDTO;
import com.bff.bsc.dto.Proyecto_ActividadDTO;

import com.bff.bsc.restclients.Bsc_situacion;
import com.bff.bsc.restclients.Bsc_lugar;
import com.bff.bsc.restclients.Bsc_objetivo;
import com.bff.bsc.restclients.Bsc_proyecto_actividad;
import com.bff.bsc.restclients.Bsc_proyecto_pedido;
import com.bff.bsc.restclients.Bsc_tema;


@Service
public class ServiceBscImpl implements ServiceBsc {
	
//ASIGNAMOS LOS RESTCLIENTS A UNA VARIABLE CON LA ANOTACION AUTOWIRED..	


@Autowired
Bsc_proyecto_actividad proyecto_actividad;

@Autowired
Bsc_tema tema;

@Autowired
Bsc_situacion situacion;

@Autowired
Bsc_proyecto_pedido proyecto_pedido;

@Autowired
Bsc_objetivo objetivo;

@Autowired
Bsc_lugar lugar;
//-------------------------------------------------------------------------------------------------------------------------------

//------------------------BSC_PROYECTO_ACTIVIDAD -> TOMAS OSORIO - MYSQL---------------------------------------------------------

//OBTENER-GET
@Override
public List<Proyecto_ActividadDTO> bsc_proyecto_actividadfindAll() {
	// TODO Auto-generated method stub
	return proyecto_actividad.findAll();
}

//OBTENER-GET
@Override
public Optional<Proyecto_ActividadDTO> bsc_proyecto_actividadfindById(int id) {
	// TODO Auto-generated method stub
	return proyecto_actividad.findById(id);
}
//GUARDAR-ACTUALIZAR POST-PUT
@Override
public Proyecto_ActividadDTO bsc_proyecto_actividadsave(Proyecto_ActividadDTO pa) {
	Proyecto_ActividadDTO proyectoactividad = proyecto_actividad.save(pa);
	return proyectoactividad;
}

//BORRAR-DELETE
@Override
public void bsc_proyecto_actividaddelete(int id) {
	proyecto_actividad.delete(id);
}

//----------------------------------------------------------------------------------------------------------------------------- 

//-----------------BSC_TEMA -> NICOLAS NANJARI - MYSQL-------------------------------------------------------------------------

//OBTENER-GET
@Override
public List<Bsc_temaDTO> bsc_temafindAll() {
	// TODO Auto-generated method stub
	return tema.findAll();
}
//OBTENER-GET
@Override
public Optional<Bsc_temaDTO> bsc_temafindById(int id) {
	// TODO Auto-generated method stub
	return tema.findById(id);
}
//GUARDAR-ACTUALIZAR POST-PUT
@Override
public Bsc_temaDTO bsc_temasave(Bsc_temaDTO TEMA) {
	Bsc_temaDTO te = tema.save(TEMA);
	return te;
}

//BORRAR-DELETE
@Override
public void bsc_tema_delete(int id) {
	tema.delete(id);
}

//-----------------------------------------------------------------------------------------------------------------------------

//-----------------------BSC_SITUACION_DEPARTAMENTO_IDEA_PROYECTO -> JUAN JOSE LARA - MYSQL -----------------------------------
@Override
public List<SituacionDTO> bsc_situacionfindAll() {
	// TODO Auto-generated method stub
	return situacion.findAll();
}

@Override
public Optional<SituacionDTO> bsc_situacionfindById(int id) {
	// TODO Auto-generated method stub
	return situacion.findById(id);
}

@Override
public SituacionDTO bsc_situacionsave (SituacionDTO SITUACION) {
	SituacionDTO si = situacion.save(SITUACION);
	return si;
}

@Override
public void bsc_situaciondelete (int id) {
	situacion.delete(id);
}



//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------BSC_PROYECTO_PEDIDO-> VICTOR MARIÑAN -> MYSQL--------------------------------------------------------

@Override
public List<DTOBscProyectoPedido> bsc_proyecto_pedidofindAll() {
	// TODO Auto-generated method stub
	return proyecto_pedido.findAll();
}

@Override
public Optional<DTOBscProyectoPedido>bsc_proyecto_pedidofindById(int id) {
	// TODO Auto-generated method stub
	return proyecto_pedido.findById(id);
}

@Override
public DTOBscProyectoPedido bsc_proyecto_pedidosave(DTOBscProyectoPedido dtobpp) {
	// TODO Auto-generated method stub
	DTOBscProyectoPedido proyectopedido = proyecto_pedido.save(dtobpp);
	return proyectopedido;
}


@Override
public void bsc_proyecto_pedidodelete(int id) {
	// TODO Auto-generated method stub
	proyecto_pedido.delete(id);
}

//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------BSC_Objetivo-> Alexis Mendoza -> MYSQL--------------------------------------------------------

@Override
public List<ObjetivoDTO> bsc_objetivofindAll() {
	// TODO Auto-generated method stub
	return objetivo.findAll();
}

@Override
public Optional<ObjetivoDTO> bsc_objetivofindById(int id) {
	// TODO Auto-generated method stub
	return objetivo.findById(id);
}

@Override
public ObjetivoDTO bsc_objetivosave(ObjetivoDTO pa) {
	// TODO Auto-generated method stub
	ObjetivoDTO Objetivo = objetivo.save(pa);
	return Objetivo;
}

@Override
public void bsc_objetivodelete(int id) {
	// TODO Auto-generated method stub
	objetivo.delete(id);
}
//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------BSC_Lugar-> Eitan Candia -> MYSQL--------------------------------------------------------
@Override
public List<LugarDTO> bsc_lugarfindAll() {
	return lugar.findAll();
}

@Override
public Optional<LugarDTO> bsc_lugarfindById(int id) {
	return lugar.findById(id);
}

@Override
public LugarDTO bsc_lugarsave(LugarDTO lubpp) {
	LugarDTO Lugar = lugar.save(lubpp);
	return Lugar;
}

@Override
public void bsc_lugardelete(int id) {
	lugar.delete(id);
	
}

//-----------------------------------------------------------------------------------------------------------------------------

}
