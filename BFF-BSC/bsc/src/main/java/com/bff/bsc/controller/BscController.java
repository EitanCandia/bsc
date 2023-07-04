package com.bff.bsc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


import com.bff.bsc.dto.ideasDTO;
import com.bff.bsc.dto.bsc_plan_de_cuentasDTO;
import com.bff.bsc.dto.Bsc_temaDTO;
import com.bff.bsc.dto.DTOBscProyectoPedido;
import com.bff.bsc.dto.LugarDTO;
import com.bff.bsc.dto.ObjetivoDTO;
import com.bff.bsc.dto.ProyectoActividad_TipoActividadDTO;
import com.bff.bsc.dto.ProyectoPersonaDTO;
import com.bff.bsc.dto.Inventario_itemDTO;
import com.bff.bsc.dto.Proyecto_ActividadDTO;
import com.bff.bsc.dto.Proyecto_inventario_recursosDTO;
import com.bff.bsc.service.ServiceBsc;
import com.bff.bsc.dto.TipoDocumentoDTO;
import com.bff.bsc.dto.ProyectoDTO;
import com.bff.bsc.dto.KpiMetaDTO;
import com.bff.bsc.dto.InventarioUnidadDTO;
import com.bff.bsc.dto.kapi_final_DTO;

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
				    
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------BSC_INVENTARIO_ITEM -> MATIAS CORDOVA - MYSQL--------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------		
				    @GetMapping(value= "/bsc_inventario_itemFindAll")
					public List<Inventario_itemDTO> bsc_inventario_itemFindAll(){
						return bsc.bsc_inventario_itemFindAll();
					}
					@GetMapping(value= "/bsc_inventario_itemFindById/{id}") //READ-GET/id
					public Optional<Inventario_itemDTO> bsc_inventario_itemFindById(@PathVariable("id") int id) {
					        return bsc.bsc_inventario_itemFindById(id);
					    }

					
						
						
						//GUARDAR-POST
						@ResponseBody @PostMapping("/bsc_inventario_itemSave")
						public Inventario_itemDTO bsc_inventario_itemSave(@RequestBody Inventario_itemDTO Ii) {
							return bsc.bsc_inventario_itemSave(Ii);
						}
						
						//ACTUALIZAR-PUT
						@PutMapping(value = "/bsc_inventario_itemUpdate/{id}")
					    public Inventario_itemDTO bsc_inventario_itemUpdate(@PathVariable("id") int id, @RequestBody Inventario_itemDTO Ii) {
					        return bsc.bsc_inventario_itemUpdate(id, Ii);
					    }
						//BORRAR-DELETE POR ID 
					    @DeleteMapping(value = "/bsc_inventario_itemDelete/{id}")
					    public ResponseEntity<Void> bsc_inventario_itemDelete(@PathVariable("id") int id) {
					        bsc.bsc_inventario_itemDelete(id);
					        return ResponseEntity.noContent().build();
					    }
			    

//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------BSC_R_PROYECTO_PERSONA -> JOAQUIN PEREZ - MYSQL--------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------	
				    //OBTENER-GET http://localhost:8080/v1/bsc/ProyectoFindAll
    @GetMapping(value = "/ProyectoFindAll")
    public List<ProyectoPersonaDTO> ProyectoFindAll() {
        return bsc.bsc_proyecto_personaFindAll();
    }

	//OBTENER-GET POR ID http://localhost:8080/v1/bsc/ProyectoFindById/7
    @GetMapping(value = "/ProyectoFindById/{id}")
    public Optional<ProyectoPersonaDTO> ProyectoFindById(@PathVariable("id") int id) {
        return bsc.bsc_proyecto_personaFindById(id);
    }

	//GUARDAR-POST http://localhost:8080/v1/bsc/ProyectoSave
    @PostMapping(value = "/ProyectoSave")
    public ProyectoPersonaDTO ProyectoSave(@RequestBody ProyectoPersonaDTO proyectoPersonaDTO) {
        return bsc.bsc_proyecto_personaSave(proyectoPersonaDTO);
    }
	//ACTUALIZAR-PUT http://localhost:8080/v1/bsc/ProyectoUpdate/7
    @PutMapping(value = "/ProyectoUpdate/{id}")
    public ProyectoPersonaDTO ProyectoUpdate(@PathVariable("id") int id, @RequestBody ProyectoPersonaDTO proyectoPersonaDTO) {
        return bsc.bsc_proyecto_personaUpdate(id, proyectoPersonaDTO);
    }
	//BORRAR-DELETE POR ID http://localhost:8080/v1/bsc/ProyectoDelete/7
    @DeleteMapping(value = "/ProyectoDelete/{id}")
    public ResponseEntity<Void> ProyectoDelete(@PathVariable("id") int id) {
        bsc.bsc_proyecto_personaDelete(id);
        return ResponseEntity.noContent().build();
    }
	//------------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------------------------------------------	
		//------------------BSC_proyecto -> Pablo Valenzuela - MYSQL--------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------	
	
	//OBTENER-GET
	@GetMapping(value= "/bsc_proyectofindAll")
	public List<ProyectoDTO> bsc_proyectofindAll(){
		return bsc.bsc_proyectofindAll();
	}

	//OBTENER-GET POR ID
	@GetMapping(value= "/bsc_proyectofindById/{id}")
	public Optional<ProyectoDTO> bsc_proyectofindById(@PathVariable("id") int id){
		return bsc.bsc_proyectofindById(id);
	}

	//BORRAR-DELETE
	@ResponseBody @DeleteMapping("/bsc_proyectodelete/{id}")
	public int bsc_proyectodelete(@PathVariable("id") int id) {
		Optional<ProyectoDTO> proyecto = bsc.bsc_proyectofindById(id);
		if (proyecto.isPresent()==true) {
			bsc.bsc_proyectodelete(id);
			return 1;
		} else return 0;
	}
	
	//GUARDAR-POST
	@ResponseBody @PostMapping("/bsc_proyectosave")
	public ProyectoDTO agregarTema(@RequestBody ProyectoDTO proyecto) {
		return bsc.bsc_proyectosave(proyecto);
	}
	
	//ACTUALIZAR-PUT
	@ResponseBody @PutMapping(("/bsc_proyectoUpdate"))
	public ProyectoDTO updateSituacionById(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
		Optional<ProyectoDTO> p = bsc.bsc_proyectofindById(proyecto.getId());
		if (p.isPresent()==true) {
			return bsc.bsc_proyectosave(proyecto);
		} else return null;
	}
	
	@ResponseBody @PutMapping(("/bsc_proyectoUpdate/{id}"))
	public ProyectoDTO updateSituacionById(@Valid @NonNull @RequestBody ProyectoDTO proyecto, @PathVariable("id") int id) {
		Optional<ProyectoDTO> p = bsc.bsc_proyectofindById(id);
		if (p.isPresent()==true) {
			proyecto.setId(id);
			return bsc.bsc_proyectosave(proyecto);
		} else return null;

	}
	
	//------THOMAS TAPIA
	
	@PostMapping("/bsctipodocumento")
	public TipoDocumentoDTO createTipoDocumento(@RequestBody TipoDocumentoDTO tipo_documento) {

			return bsc.bsc_tipo_documentosave(tipo_documento);
	}	
	@GetMapping("/bsctipodocumento")
	List<TipoDocumentoDTO> all() {
		    return bsc.bsc_tipo_documentofindAll();
		  }
	
	@GetMapping("/bsctipodocumento/{id}")
	public Optional<TipoDocumentoDTO> getTipoDocumento(@PathVariable Long id) {
		return bsc.bsc_tipo_documentofindById(id);
	}
	
	@DeleteMapping("/bsctipodocumento/{id}")
	public String deleteTipoDocumento(@PathVariable Long id) {
		Optional<TipoDocumentoDTO> proyecto = bsc.bsc_tipo_documentofindById(id);
		if (proyecto.isPresent()==true) {
			bsc.bsc_tipo_documentodelete(id);
			return "tipo documento eliminado";
		} else return "error al eliminar tipo documento";
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------------------------------------------	
		//------------------BSC_KPI_META -> MOISES CONTRERAS - MYSQL--------------------------------------------------------------------------------
		//----
    @GetMapping(value = "/kpiMetaFindAll")
    public List<KpiMetaDTO> kpiMetaFindAll()
    {
		return bsc.kpiMetaFindAll(); 
    }
	
    @GetMapping(value = "/kpiMetaFindById/{id}")
    public Optional<KpiMetaDTO> kpiMetaFindById(@PathVariable("id") int id)
	{
		return bsc.kpiMetaFindById(id);
	}



    @PostMapping(value = "/kpiMetaSave")
    public KpiMetaDTO kpiMetaSave(@RequestBody KpiMetaDTO kpiMeta) 
    {
    return bsc.kpiMetaSave(kpiMeta);}
	
    @DeleteMapping("/kpiMetaDelete/{id}")
    public void kpiMetadelete(@PathVariable int id) {
        bsc.kpiMetadelete(id);
    }

    @PutMapping(value = "/kpiMetaUpdate/{id}")
    public KpiMetaDTO kpiMetaUpdate(@PathVariable("id") int id, @RequestBody KpiMetaDTO kpiMeta) {
    return bsc.kpiMetaUpdate(id, kpiMeta);
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------BSC_inventario_unidad -> Miguel Belmar -
	// MYSQL--------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------

	// OBTENER-GET
	@GetMapping(value = "/bsc_inventario_unidadFindAll")
	public List<InventarioUnidadDTO> bsc_inventario_unidadFindAll() {
		return bsc.bsc_inventario_unidadFindAll();
	}

	// OBTENER-GET POR ID
	@GetMapping(value = "/bsc_inventario_unidadFindById/{id}")
	public Optional<InventarioUnidadDTO> bsc_inventario_unidadFindById(@PathVariable("id") int id) {
		return bsc.bsc_inventario_unidadFindById(id);
	}

	// BORRAR-DELETE
	@ResponseBody
	@DeleteMapping("/bsc_inventario_unidadDelete/{id}")
	public int bsc_inventario_unidadDelete(@PathVariable("id") int id) {
		Optional<InventarioUnidadDTO> inventarioUnidad = bsc.bsc_inventario_unidadFindById(id);
		if (inventarioUnidad.isPresent() == true) {
			bsc.bsc_inventario_unidadDelete(id);
			return 1;
		} else
			return 0;
	}

	// GUARDAR-POST
	@ResponseBody
	@PostMapping("/bsc_inventario_unidadSave")
	public InventarioUnidadDTO agregarInventarioUnidad(@RequestBody InventarioUnidadDTO inventarioUnidad) {
		return bsc.bsc_inventario_unidadSave(inventarioUnidad);
	}

	// ACTUALIZAR-PUT
	@ResponseBody
	@PutMapping(("/bsc_inventario_unidadUpdate"))
	public InventarioUnidadDTO updateInventarioUnidad(
			@Valid @NonNull @RequestBody InventarioUnidadDTO inventarioUnidad) {
		Optional<InventarioUnidadDTO> iu = bsc.bsc_inventario_unidadFindById(inventarioUnidad.getId());
		if (iu.isPresent() == true) {
			return bsc.bsc_inventario_unidadSave(inventarioUnidad);
		} else
			return null;
	}

	@ResponseBody
	@PutMapping(("/bsc_inventario_unidadUpdate/{id}"))
	public InventarioUnidadDTO updateInventarioUnidad(@Valid @NonNull @RequestBody InventarioUnidadDTO inventarioUnidad,
			@PathVariable("id") int id) {
		Optional<InventarioUnidadDTO> iu = bsc.bsc_inventario_unidadFindById(id);
		if (iu.isPresent() == true) {
			inventarioUnidad.setId(id);
			return bsc.bsc_inventario_unidadSave(inventarioUnidad);
		} else
			return null;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------	
	//------------------------------------------------------------------------------------------------------------------------------------------------	
	//------------------BSC_PROYECTO_ACTIVIDAD_TIPOACTIVIDAD -> ALEJANDRO VILLALOBOS - MYSQL--------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	  // OBTENER http://localhost:8080/v1/bsc/micro1FindAll
		@GetMapping(value = "/micro1FindAll")
	    public List<ProyectoActividad_TipoActividadDTO> micro1FindAll()
	    {
			return bsc.micro1FindAll(); 
	    }
		
		 // OBTENER POR ID http://localhost:8080/v1/bsc/micro1FindById/3
		@GetMapping(value = "/micro1FindById/{id}")
	    public Optional<ProyectoActividad_TipoActividadDTO> micro1FindById(@PathVariable("id") int id)
		{
			return bsc.micro1FindById(id);
		}
		
		 //BORRAR-DELETE POR ID http://localhost:8080/v1/bsc/bsc_proyecto_actividad_tipoactividadDelete/3
	    @ResponseBody @DeleteMapping("/bsc_proyecto_actividad_tipoactividadDelete/{id}")
	    public int bsc_proyecto_actividad_tipoactividadDelete(@PathVariable("id") int id) {
	    	Optional<ProyectoActividad_TipoActividadDTO> proyecto_actividadtipo = bsc.micro1FindById(id);
	    	if (proyecto_actividadtipo.isPresent()==true) {
	    		bsc.micro1Delete(id);
	    		return 1;
	    	}else return 0;
	    }
	    
	    
		//GUARDAR-POST http://localhost:8080/v1/bsc/bsc_proyecto_actividad_tipoactividadSave
		@ResponseBody @PostMapping("/bsc_proyecto_actividad_tipoactividadSave")
		public ProyectoActividad_TipoActividadDTO agregarProyectoActividadtipo(@RequestBody ProyectoActividad_TipoActividadDTO proyectoActividad) {
			return bsc.micro1Save(proyectoActividad);
		}
		
		
		//ACTUALIZAR-PUT http://localhost:8080/v1/bsc/bsc_proyecto_actividad_tipoactividadUpdate
	    @ResponseBody 
	    @PutMapping("/bsc_proyecto_actividad_tipoactividadUpdate")
	    public ProyectoActividad_TipoActividadDTO updateProyecto_ActividadById(@Valid @NonNull @RequestBody ProyectoActividad_TipoActividadDTO proyectoActividad) {
	    	Optional<ProyectoActividad_TipoActividadDTO> proyecto_actividad = bsc.micro1FindById(proyectoActividad.getId());
	    	if (proyecto_actividad.isPresent()) {
	    		return bsc.micro1Save(proyectoActividad);
	    	} else {
	    		return null;
	    	}
	    }
	
	
	
	
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------BSC_kapi -> TOMAS MELLA - MYSQL--------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
	@GetMapping(value = "/kapiFindAll")
    public List<kapi_final_DTO> kapiFindAll()
    {
		return bsc.kapiFindAll(); 
    }
	
	@GetMapping(value = "/kapiFindById/{id}")
    public Optional<kapi_final_DTO> kapiFindById(@PathVariable("id") int id)
	{
		return bsc.kapiFindById(id);
	}
	
    @PostMapping(value = "/kapisave")
    public kapi_final_DTO kapisave(@RequestBody kapi_final_DTO kapi)
    {
    	return bsc.kapisave(kapi);
    }

    @DeleteMapping(value = "/kapidelete/{id}")
    public void kapidelete(@PathVariable int id)
    {
    	bsc.kapidelete(id);
    }
	
    @PutMapping(value = "/kapiupdate/{id}")
    public kapi_final_DTO kapiupdate(@PathVariable ("id") int id,@RequestBody kapi_final_DTO kapi)
    {
    	return bsc.kapiupdate(id, kapi);
    }
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------bsc_proyecto_inventario_recursos -> Sebastián Riquelme - MYSQL
// MYSQL--------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
@GetMapping("/proyecto_inventario_recursosFindAll")
    public List<Proyecto_inventario_recursosDTO> proyectoInventarioRecursosFindAll() {
        return bsc.bsc_proyecto_inventario_recursosFindAll();
    }

    @GetMapping("/proyecto_inventario_recursosFindById/{id}")
    public Optional<Proyecto_inventario_recursosDTO> proyectoInventarioRecursosFindById(@PathVariable("id") int id) {
        return bsc.bsc_proyecto_inventario_recursosFindById(id);
    }

    @PostMapping("/proyecto_inventario_recursosSave")
    public Proyecto_inventario_recursosDTO proyectoInventarioRecursosSave(@RequestBody Proyecto_inventario_recursosDTO dto) {
        return bsc.bsc_proyecto_inventario_recursosSave(dto);
    }

    @PutMapping("/proyecto_inventario_recursosUpdate/{id}")
    public Proyecto_inventario_recursosDTO proyectoInventarioRecursosUpdate(@PathVariable("id") int id, @RequestBody Proyecto_inventario_recursosDTO dto) {
        Optional<Proyecto_inventario_recursosDTO> data = bsc.bsc_proyecto_inventario_recursosFindById(id);
        if(data.isPresent()) {
            dto.setId(id);
            return bsc.bsc_proyecto_inventario_recursosSave(dto);
        }
        return null;
    }

    @DeleteMapping("/proyecto_inventario_recursosDelete/{id}")
    public ResponseEntity<Void> proyectoInventarioRecursosDelete(@PathVariable("id") int id) {
        Optional<Proyecto_inventario_recursosDTO> data = bsc.bsc_proyecto_inventario_recursosFindById(id);
        if (data.isPresent()) {
            bsc.Proyecto_inventario_recursosDelete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------bsc_plan_de_cuentas -> MATIAS MAULEN - MYSQL--------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------		
				    @GetMapping(value= "/bsc_plan_de_cuentasFindAll")
					public List<bsc_plan_de_cuentasDTO> bsc_plan_de_cuentasFindAll(){
						return bsc.bsc_plan_de_cuentasFindAll();
					}
					@GetMapping(value= "/bsc_plan_de_cuentasFindById/{id}") //READ-GET/id
					public Optional<bsc_plan_de_cuentasDTO> bsc_plan_de_cuentasFindById(@PathVariable("id") int id) {
					        return bsc.bsc_plan_de_cuentasFindById(id);
					    }

					
						
					
					//GUARDAR-POST
					@ResponseBody @PostMapping("/bsc_plan_de_cuentasSave")
					public bsc_plan_de_cuentasDTO bsc_plan_de_cuentasSave(@RequestBody bsc_plan_de_cuentasDTO pc) {
						return bsc.bsc_plan_de_cuentasSave(pc);
					}
						
					//ACTUALIZAR-PUT
					@PutMapping(value = "/bsc_plan_de_cuentasUpdate/{id}")
					public bsc_plan_de_cuentasDTO bsc_plan_de_cuentasUpdate(@PathVariable("id") int id, @RequestBody bsc_plan_de_cuentasDTO pc) {
					    return bsc.bsc_plan_de_cuentasUpdate(id, pc);
					}
					//BORRAR-DELETE POR ID 
					@DeleteMapping(value = "/bsc_plan_de_cuentasDelete/{id}")
					public ResponseEntity<Void> bsc_plan_de_cuentasDelete(@PathVariable("id") int id) {
					    bsc.bsc_plan_de_cuentasDelete(id);
					    return ResponseEntity.noContent().build();
					    }



	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------------------------------------
	// ------------------BSC_Ideas -> Sebastian Sanhueza -
	// MYSQL--------------------------------------------------------------------------------
	// --------
	
@GetMapping(value = "/ideasFindAll")
    public List<ideasDTO> ideasFindAll()
    {
		return bsc.bsc_ideasFindAll(); 
    }
	
	@GetMapping(value = "/ideasFindById/{id}")
    public Optional<ideasDTO> ideasFindById(@PathVariable("id") int id)
	{
		return bsc.bsc_ideasFindById(id);
	}

    @PostMapping(value = "/ideasSave")
    public ideasDTO ideasSave(@RequestBody ideasDTO ideas) 
    {
    return bsc.bsc_ideasSave(ideas);}
	
    @DeleteMapping("/ideasDelete/{id}")
    public void ideasdelete(@PathVariable int id) {
        bsc.bsc_ideasDelete(id);
    }

    @ResponseBody
@PutMapping(("/ideasUpdate"))
public ideasDTO updateIdeas(
        @Valid @NonNull @RequestBody ideasDTO ideas) {
    Optional<ideasDTO> iu = bsc.bsc_ideasFindById(ideas.getId());
    if (iu.isPresent() == true) {
        return bsc.bsc_ideasSave(ideas);
    } else
        return null;
}

@ResponseBody
@PutMapping(("/ideasUpdate/{id}"))
public ideasDTO updateIdeas(@Valid @NonNull @RequestBody ideasDTO ideas,
        @PathVariable("id") int id) {
    Optional<ideasDTO> iu = bsc.bsc_ideasFindById(id);
    if (iu.isPresent() == true) {
        ideas.setId(id);
        return bsc.bsc_ideasSave(ideas);
    } else
        return null;
}
						
}
