package com.bff.bsc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bff.bsc.dto.SituacionDTO;
import com.bff.bsc.dto.Bsc_temaDTO;
import com.bff.bsc.dto.DTOBscProyectoPedido;
import com.bff.bsc.dto.LugarDTO;
import com.bff.bsc.dto.ObjetivoDTO;
import com.bff.bsc.dto.Proyecto_ActividadDTO;
import com.bff.bsc.service.ServiceBsc;



@RestController
@RequestMapping("/v1/bsc")
public class BscController {

//ESTA VARIABLE SE OCUPA PARA TODOS LOS METODOS DEL CONTROLADOR ES GLOBAL PARA TODOS LOS MICROS.
	@Autowired
	ServiceBsc bsc;
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------BSC_PROYECTO_ACTIVIDAD -> TOMAS OSORIO - MYSQL--------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------	
	//OBTENER-GET http://localhost:8080/v1/bsc/bsc_proyecto_actividadFindAll
	@GetMapping(value = "/bsc_proyecto_actividadFindAll")
    public List<Proyecto_ActividadDTO> bsc_proyecto_actividadFindAll()
    {
		return bsc.bsc_proyecto_actividadfindAll(); 
    }
    //OBTENER-GET POR ID http://localhost:8080/v1/bsc/bsc_proyecto_actividadFindById/6
	@GetMapping(value = "/bsc_proyecto_actividadFindById/{id}")
    public Optional<Proyecto_ActividadDTO> bsc_proyecto_actividadFindById(@PathVariable("id") int id)
	{
		return bsc.bsc_proyecto_actividadfindById(id);
	}
    //BORRAR-DELETE POR ID http://localhost:8080/v1/bsc/bsc_proyecto_actividadDelete/5
    @ResponseBody @DeleteMapping("/bsc_proyecto_actividadDelete/{id}")
    public int bsc_proyecto_actividad_delete(@PathVariable("id") int id) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = bsc.bsc_proyecto_actividadfindById(id);
    	if (proyecto_actividad.isPresent()==true) {
    		bsc.bsc_proyecto_actividaddelete(id);
    		return 1;
    	}else return 0;
    }
    
	//GUARDAR-POST http://localhost:8080/v1/bsc/bsc_proyecto_actividadSave
	@ResponseBody @PostMapping("/bsc_proyecto_actividadSave")
	public Proyecto_ActividadDTO agregarProyectoActividad(@RequestBody Proyecto_ActividadDTO proyectoActividad) {
		return bsc.bsc_proyecto_actividadsave(proyectoActividad);
	}

	//ACTUALIZAR-PUT http://localhost:8080/v1/bsc/bsc_proyecto_actividadUpdate
    @ResponseBody 
    @PutMapping("/bsc_proyecto_actividadUpdate")
    public Proyecto_ActividadDTO updateProyecto_ActividadById(@Valid @NonNull @RequestBody Proyecto_ActividadDTO proyectoActividad) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = bsc.bsc_proyecto_actividadfindById(proyectoActividad.getId());
    	if (proyecto_actividad.isPresent()) {
    		return bsc.bsc_proyecto_actividadsave(proyectoActividad);
    	} else {
    		return null;
    	}
    }
    //ACTUALIZAR-PUT POR ID http://localhost:8080/v1/bsc/bsc_proyecto_actividadUpdate/6
    @ResponseBody @PutMapping(("/bsc_proyecto_actividadUpdate/{id}"))
    public Proyecto_ActividadDTO updateProyecto_ActividadById(@Valid @NonNull @RequestBody Proyecto_ActividadDTO proyectoActividad,@PathVariable("id") int id) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = bsc.bsc_proyecto_actividadfindById(id);
    	if (proyecto_actividad.isPresent()==true) {
    		proyectoActividad.setId(id);
    		return bsc.bsc_proyecto_actividadsave(proyectoActividad);
    	} else return null;
    }
//------------------------------------------------------------------------------------------------------------------------------   
// -----------------------------------------------------------------------------------------------------------------------------   
// -----------------------------------------------------------------------------------------------------------------------------     
// -----------------------------------------------------------------------------------------------------------------------------     
// -----------------------------------------------------------------------------------------------------------------------------     
//---------------------------------BSC_TEMA -> NICOLAS NANJARI - MYSQL ---------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------
    //OBTENER-GET http://localhost:8080/v1/bsc/bsc_temaFindAll
	@GetMapping(value = "/bsc_temaFindAll")
    public List<Bsc_temaDTO> bsc_temaFindAll()
    {
		return bsc.bsc_temafindAll(); 
    }
    //OBTENER-GET POR ID http://localhost:8080/v1/bsc/bsc_temaFindById/3
	@GetMapping(value = "/bsc_temaFindById/{id}")
    public Optional<Bsc_temaDTO> bsc_temaFindById(@PathVariable("id") int id)
	{
		return bsc.bsc_temafindById(id);
	}
    //BORRAR-DELETE http://localhost:8080/v1/bsc/bsc_temaDelete/2
    @ResponseBody @DeleteMapping("/bsc_temaDelete/{id}")
    public int bsc_tema_delete(@PathVariable("id") int id) {
    	Optional<Bsc_temaDTO> tema = bsc.bsc_temafindById(id);
    	if (tema.isPresent()==true) {
    		bsc.bsc_tema_delete(id);
    		return 1;
    	}else return 0;
    }
    //GUARDAR-POST  http://localhost:8080/v1/bsc/bsc_temaSave
	@ResponseBody @PostMapping("/bsc_temaSave")
	public Bsc_temaDTO agregarTema(@RequestBody Bsc_temaDTO tema) {
		return bsc.bsc_temasave(tema);
	}
	//ACTUALIZAR-PUT http://localhost:8080/v1/bsc/bsc_temaUpdate
	@ResponseBody @PutMapping(("/bsc_temaUpdate"))
    public Bsc_temaDTO updateTemaById(@Valid @NonNull @RequestBody Bsc_temaDTO tema) {
        Optional<Bsc_temaDTO> p = bsc.bsc_temafindById(tema.getId());
        if (p.isPresent()==true) {
            return bsc.bsc_temasave(tema);
        } else return null;
    }
	//ACTUALIZAR-PUT POR ID http://localhost:8080/v1/bsc/bsc_temaUpdate/3
	@ResponseBody @PutMapping(("/bsc_temaUpdate/{id}"))
	    public Bsc_temaDTO updateTemaById(@Valid @NonNull @RequestBody Bsc_temaDTO tema, @PathVariable("id") int id) {
	        Optional<Bsc_temaDTO> p = bsc.bsc_temafindById(id);
	        if (p.isPresent()==true) {
	        	tema.setId(id);
	            return bsc.bsc_temasave(tema);
	        } else return null;
	    }
    
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------BSC_SITUACION_DEPARTAMENTO_IDEA_PROYECTO -> JUAN JOSE LARA - MYSQL --------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
	
	//OBTENER-GET
	@GetMapping(value= "/bsc_situacionfindAll")
	public List<SituacionDTO> bsc_situacionfindAll(){
		return bsc.bsc_situacionfindAll();
	}
	
	//OBTENER-GET POR ID
	@GetMapping(value= "/bsc_situacionfindById/{id}")
	public Optional<SituacionDTO> bsc_situacionfindById(@PathVariable("id") int id){
		return bsc.bsc_situacionfindById(id);
	}

	//BORRAR-DELETE
	@ResponseBody @DeleteMapping("/bsc_situaciondelete/{id}")
	public int bsc_situaciondelete(@PathVariable("id") int id) {
		Optional<SituacionDTO> situacion = bsc.bsc_situacionfindById(id);
		if (situacion.isPresent()==true) {
			bsc.bsc_situaciondelete(id);
			return 1;
		} else return 0;
	}
	
	//GUARDAR-POST
	@ResponseBody @PostMapping("/bsc_situacionsave")
	public SituacionDTO agregarTema(@RequestBody SituacionDTO situacion) {
		return bsc.bsc_situacionsave(situacion);
	}
	
	//ACTUALIZAR-PUT
	@ResponseBody @PutMapping(("/bsc_situacionUpdate"))
	public SituacionDTO updateSituacionById(@Valid @NonNull @RequestBody SituacionDTO situacion) {
		Optional<SituacionDTO> s = bsc.bsc_situacionfindById(situacion.getBsc_r_situacion_departamento_id());
		if (s.isPresent()==true) {
			return bsc.bsc_situacionsave(situacion);
		} else return null;
	}
	
	@ResponseBody @PutMapping(("/bsc_situacionUpdate/{id}"))
	public SituacionDTO updateSituacionById(@Valid @NonNull @RequestBody SituacionDTO situacion, @PathVariable("id") int id) {
		Optional<SituacionDTO> s = bsc.bsc_situacionfindById(id);
		if (s.isPresent()==true) {
			situacion.setId_bsc_situacion_departamento_idea_proyecto(id);
			return bsc.bsc_situacionsave(situacion);
		} else return null;
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------	
	//------------------------------------------------------------------------------------------------------------------------------------------------	
	//------------------BSC_PROYECTO_PEDIDO -> VICTOR MARIÑAN - MYSQL--------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------	
	@GetMapping(value= "/bsc_proyecto_pedidofindAll")
	public List<DTOBscProyectoPedido> bsc_proyecto_pedidofindAll(){
		return bsc.bsc_proyecto_pedidofindAll();
	}
	@GetMapping(value= "/bsc_proyecto_pedidofindById/{id}") //READ-GET/id
	public Optional<DTOBscProyectoPedido> bsc_proyecto_pedidofindById(@PathVariable("id") int id) {
	        return bsc.bsc_proyecto_pedidofindById(id);
	    }

	//BORRAR-DELETE
		@ResponseBody @DeleteMapping("/bsc_proyecto_pedidodelete/{id}")
		public int bsc_proyecto_pedidodelete(@PathVariable("id") int id) {
			Optional<DTOBscProyectoPedido> dtobpp = bsc.bsc_proyecto_pedidofindById(id);
			if (dtobpp.isPresent()==true) {
				bsc.bsc_proyecto_pedidodelete(id);
				return 1;
			} else return 0;
		}
		
		
		//GUARDAR-POST
		@ResponseBody @PostMapping("/bsc_proyecto_pedidosave")
		public DTOBscProyectoPedido save(@RequestBody DTOBscProyectoPedido dtobpp) {
			return bsc.bsc_proyecto_pedidosave(dtobpp);
		}
		
		//ACTUALIZAR-PUT
		@ResponseBody @PutMapping(("/bsc_proyecto_pedidoUpdate"))
		public DTOBscProyectoPedido updateProyectoPedido(@Valid @NonNull @RequestBody DTOBscProyectoPedido dtobpp) {
			Optional<DTOBscProyectoPedido> s = bsc.bsc_proyecto_pedidofindById(dtobpp.getId());
			if (s.isPresent()==true) {
				return bsc.bsc_proyecto_pedidosave(dtobpp);
			} else return null;
		}
		//ACTUALIZAR-PUT
		@ResponseBody @PutMapping(("/bsc_proyecto_pedidoUpdateById/{id}"))
		
		public DTOBscProyectoPedido updateProyectoPedidoById(@Valid @NonNull @RequestBody DTOBscProyectoPedido dtobpp, @PathVariable("id")int id) {
			Optional<DTOBscProyectoPedido> s = bsc.bsc_proyecto_pedidofindById(id);
			if (s.isPresent()==true) {
				dtobpp.setId(id);
				return bsc.bsc_proyecto_pedidosave(dtobpp);
			} else return null;
		}

		//------------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------------------------------------------	
		//------------------BSC_Objetivo -> Alexis Mendoza - MYSQL--------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------	

		@GetMapping(value= "/bsc_objetivofindAll")
		public List<ObjetivoDTO> bsc_objetivofindAll(){
			return bsc.bsc_objetivofindAll();
		}
		@GetMapping(value= "/bsc_objetivofindById/{id}") //READ-GET/id
		public Optional<ObjetivoDTO> bsc_objetivoById(@PathVariable("id") int id) {
		        return bsc.bsc_objetivofindById(id);
		    }
		
		//BORRAR-DELETE
		@ResponseBody @DeleteMapping("/bsc_objetivodelete/{id}")
		public int bsc_objetivodelete(@PathVariable("id") int id) {
			Optional<ObjetivoDTO> pa = bsc.bsc_objetivofindById(id);
			if (pa.isPresent()==true) {
				bsc.bsc_objetivodelete(id);
				return 1;
			} else return 0;
		}
		
		//GUARDAR-POST
				@ResponseBody @PostMapping("/bsc_objetivosave")
				public ObjetivoDTO save(@RequestBody ObjetivoDTO pa) {
					return bsc.bsc_objetivosave(pa);
				}
				
				//ACTUALIZAR-PUT
				@ResponseBody @PutMapping(("/bsc_objetivoUpdate"))
				public ObjetivoDTO updateProyectoPedido(@Valid @NonNull @RequestBody ObjetivoDTO pa) {
					Optional<ObjetivoDTO> o = bsc.bsc_objetivofindById(pa.getId());
					if (o.isPresent()==true) {
						return bsc.bsc_objetivosave(pa);
					} else return null;
				}
				
				//ACTUALIZAR-PUT
				@ResponseBody @PutMapping(("/bsc_objetivoUpdateById/{id}"))
				
				public ObjetivoDTO updateObjetivoById(@Valid @NonNull @RequestBody ObjetivoDTO pa, @PathVariable("id")int id) {
					Optional<ObjetivoDTO> o = bsc.bsc_objetivofindById(id);
					if (o.isPresent()==true) {
						pa.setId(id);
						return bsc.bsc_objetivosave(pa);
					} else return null;
				}
				//------------------------------------------------------------------------------------------------------------------------------------------------	
				//------------------------------------------------------------------------------------------------------------------------------------------------	
				//------------------BSC_LUGAR -> EITAN CANDIA - MYSQL--------------------------------------------------------------------------------
				//------------------------------------------------------------------------------------------------------------------------------------------------	
					//OBTENER-GET http://localhost:8080/v1/bsc/bsc_lugarFindAll
					@GetMapping(value = "/bsc_lugarFindAll")
				    public List<LugarDTO> bsc_lugarFindAll()
				    {
						return bsc.bsc_lugarfindAll(); 
				    }
				    //OBTENER-GET POR ID http://localhost:8080/v1/bsc/bsc_lugarFindById/6
					@GetMapping(value = "/bsc_lugarFindById/{id}")
				    public Optional<LugarDTO> bsc_lugarFindById(@PathVariable("id") int id)
					{
						return bsc.bsc_lugarfindById(id);
					}
				    //BORRAR-DELETE POR ID http://localhost:8080/v1/bsc/bsc_proyecto_actividadDelete/5
				    @ResponseBody @DeleteMapping("/bsc_lugarDeleteById/{id}")
				    public int bsc_lugarDelete(@PathVariable("id") int id) {
				    	Optional<LugarDTO> lugar = bsc.bsc_lugarfindById(id);
				    	if (lugar.isPresent()==true) {
				    		bsc.bsc_lugardelete(id);
				    		return 1;
				    	}else return 0;
				    }
				    
					//GUARDAR-POST http://localhost:8080/v1/bsc/bsc_proyecto_actividadSave
					@ResponseBody @PostMapping("/bsc_lugarSave")
					public LugarDTO agregarLugar(@RequestBody LugarDTO lugar) {
						return bsc.bsc_lugarsave(lugar);
					}

					//ACTUALIZAR-PUT http://localhost:8080/v1/bsc/bsc_proyecto_actividadUpdate
				    @ResponseBody 
				    @PutMapping("/bsc_lugarUpdate")
				    public LugarDTO updateLugarById(@Valid @NonNull @RequestBody LugarDTO Lugar) {
				    	Optional<LugarDTO> lugar = bsc.bsc_lugarfindById(Lugar.getId());
				    	if (lugar.isPresent()) {
				    		return bsc.bsc_lugarsave(Lugar);
				    	} else {
				    		return null;
				    	}
				    }
				    //ACTUALIZAR-PUT POR ID http://localhost:8080/v1/bsc/bsc_proyecto_actividadUpdate/6
				    @ResponseBody @PutMapping(("/bsc_lugarUpdateById/{id}"))
				    public LugarDTO updateLugarById(@Valid @NonNull @RequestBody LugarDTO Lugar,@PathVariable("id") int id) {
				    	Optional<LugarDTO> lugar = bsc.bsc_lugarfindById(id);
				    	if (lugar.isPresent()==true) {
				    		Lugar.setId(id);
				    		return bsc.bsc_lugarsave(Lugar);
				    	} else return null;
				    }		
}
