package com.bff.bsc.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.bsc.dto.SituacionDTO;
import com.bff.bsc.dto.Bsc_temaDTO;
import com.bff.bsc.dto.DTOBscProyectoPedido;
import com.bff.bsc.dto.Inventario_itemDTO;
import com.bff.bsc.dto.LugarDTO;
import com.bff.bsc.dto.ObjetivoDTO;
import com.bff.bsc.dto.ProyectoPersonaDTO;
import com.bff.bsc.dto.Proyecto_ActividadDTO;
import com.bff.bsc.dto.KpiMetaDTO;
import com.bff.bsc.dto.InventarioUnidadDTO;
import com.bff.bsc.dto.kapi_final_DTO;
import com.bff.bsc.dto.bsc_plan_de_cuentasDTO;
import com.bff.bsc.restclients.Bsc_situacion;
import com.bff.bsc.restclients.Bsc_lugar;
import com.bff.bsc.restclients.Bsc_objetivo;
import com.bff.bsc.restclients.Bsc_proyecto_actividad;
import com.bff.bsc.restclients.Bsc_proyecto_pedido;
import com.bff.bsc.restclients.Bsc_inventario_item;
import com.bff.bsc.restclients.Bsc_r_Proyecto_Persona;
import com.bff.bsc.restclients.Bsc_tema;
import com.bff.bsc.restclients.bsc_tipo_documento;
import com.bff.bsc.restclients.Bsc_proyecto;
import com.bff.bsc.restclients.bsc_kpiMetaMicro1;
import com.bff.bsc.restclients.bsc_inventario_unidad;
import com.bff.bsc.restclients.kapiMicro1;


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

@Autowired
Bsc_inventario_item inventario_item;

@Autowired
Bsc_r_Proyecto_Persona proyecto_persona;

@Autowired
Bsc_proyecto proyecto;

@Autowired
bsc_tipo_documento tipo_documento;

@Autowired
bsc_kpiMetaMicro1 kpi_meta;

@Autowired
bsc_inventario_unidad inventarioUnidad;

@Autowired
kapiMicro1 micro1;
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
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------BSC_INVENTARIO_ITEM-> MATIAS CORDOVA -> MYSQL--------------------------------------------------------
@Override
public List<Inventario_itemDTO> bsc_inventario_itemFindAll() {
	return inventario_item.findAll();
}

@Override
public Optional<Inventario_itemDTO> bsc_inventario_itemFindById(int id) {
	return inventario_item.findById(id);
}

@Override
public Inventario_itemDTO bsc_inventario_itemSave(Inventario_itemDTO Ii) {
	Inventario_itemDTO inventarioItem = inventario_item.save(Ii);
	return inventarioItem;
}
@Override
public Inventario_itemDTO bsc_inventario_itemUpdate(int id, Inventario_itemDTO inventario_item) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void bsc_inventario_itemDelete(int id) {
	lugar.delete(id);
	
}
//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------BSC_R_PROYECTO_PERSONA-> Joaquin Perez -> MYSQL--------------------------------------------------------
@Override
public List<ProyectoPersonaDTO> bsc_proyecto_personaFindAll() {
	// TODO Auto-generated method stub
    return proyecto_persona.findAll();
}

@Override
public Optional<ProyectoPersonaDTO> bsc_proyecto_personaFindById(int id) {
	// TODO Auto-generated method stub
    return proyecto_persona.findById(id);
}

@Override
public ProyectoPersonaDTO bsc_proyecto_personaSave(ProyectoPersonaDTO proyectoPersonaDTO) {
	// TODO Auto-generated method stub
    return proyecto_persona.save(proyectoPersonaDTO);
}

@Override
public ProyectoPersonaDTO bsc_proyecto_personaUpdate(int id, ProyectoPersonaDTO proyectoPersonaDTO) {
	// TODO Auto-generated method stub
    return proyecto_persona.update(id, proyectoPersonaDTO);
}

@Override
public void bsc_proyecto_personaDelete(int id) {
	// TODO Auto-generated method stub
	proyecto_persona.delete(id);
}
//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------BSC_Lugar-> Pablo Valenzuela -> MYSQL--------------------------------------------------------
@Override
public List<ProyectoDTO> bsc_proyectofindAll() {
	return proyecto.findAll();
}

@Override
public Optional<ProyectoDTO> bsc_proyectofindById(int id) {
	return proyecto.findById(id);
}

@Override
public ProyectoDTO bsc_proyectosave(ProyectoDTO p) {
	ProyectoDTO Proyecto = proyecto.save(p);
	return Proyecto;
}

@Override
public void bsc_proyectodelete(int id) {
	lugar.delete(id);
	
}

//-----------------------------------------------------------------------------------------------------------------------------
@Override
public List<TipoDocumentoDTO> bsc_tipo_documentofindAll() {
	return tipo_documento.findAll();
}

@Override
public Optional<TipoDocumentoDTO> bsc_tipo_documentofindById(long id) {
	return tipo_documento.findById(id);
}

@Override
public TipoDocumentoDTO bsc_tipo_documentosave(TipoDocumentoDTO td) {
	TipoDocumentoDTO tipodocumento = tipo_documento.save(td);
	return tipodocumento;
}

@Override
public void bsc_tipo_documentodelete(long id) {
	tipo_documento.delete(id);
}

//----------------------------------------------------------------------------------------------------------------------------- 

//-----------------BSC_KPI_META -> MOISES CONTRERAS - MYSQL-------------------------------------------------------------------------

    @Override
    public List<KpiMetaDTO> kpiMetaFindAll() {
        // TODO Auto-generated method stub
        return kpi_meta.findAll();
    }

    @Override
    public Optional<KpiMetaDTO> kpiMetaFindById(int id) {
        // TODO Auto-generated method stub
        return kpi_meta.findById(id);
    }

    @Override
    public KpiMetaDTO kpiMetaSave(KpiMetaDTO kpiMeta) {
        // TODO Auto-generated method stub
        return kpi_meta.kpiMetaSave(kpiMeta);
    }

    @Override
    public void kpiMetadelete(int id) {
        kpi_meta.kpiMetadelete(id);
    }

    @Override
    public KpiMetaDTO kpiMetaUpdate(int id, KpiMetaDTO kpiMeta) {
        // TODO Auto-generated method stub
        return kpi_meta.kpiMetaUpdate(id, kpiMeta);
    }
// -----------------------------------------------------------------------------------------------------------------------------
	// ------------------------BSC_INVENTARIO_UNIDAD -> Miguel Belmar ->
	// MYSQL--------------------------------------------------------

	@Override
	public List<InventarioUnidadDTO> bsc_inventario_unidadFindAll() {
		return bsc_inventario_unidadFindAll();
	}

	@Override
	public Optional<InventarioUnidadDTO> bsc_inventario_unidadFindById(int id) {
		return bsc_inventario_unidadFindById(id);
	}

	@Override
	public InventarioUnidadDTO bsc_inventario_unidadSave(InventarioUnidadDTO inventarioUnidad) {
		InventarioUnidadDTO inventarioUnidadDTO = bsc_inventario_unidadSave(inventarioUnidad);
		return inventarioUnidadDTO;
	}

	@Override
	public InventarioUnidadDTO bsc_inventario_unidadUpdate(int id, InventarioUnidadDTO inventarioUnidad) {
		Optional<InventarioUnidadDTO> optionalInventarioUnidad = bsc_inventario_unidadFindById(id);
		;
		if (optionalInventarioUnidad.isPresent()) {
			inventarioUnidad.setId(id);
			InventarioUnidadDTO inventarioUnidadDTO = bsc_inventario_unidadSave(inventarioUnidad);
			return inventarioUnidadDTO;
		} else {
			return null;
		}
	}

	@Override
	public void bsc_inventario_unidadDelete(int id) {
		bsc_inventario_unidadDelete(id);
	}
//-------------------------------------------------------------------------------------------------------------------------------

//------------------------BSC_KAPI -> TOMAS MELLA - MYSQL---------------------------------------------------------
	@Override
	public List<kapi_final_DTO> kapiFindAll() {
		// TODO Auto-generated method stub
		return micro1.findAll();
	}

	@Override
	public Optional<kapi_final_DTO> kapiFindById(int id) {
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
	


//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------bsc_plan_de_cuentas-> MATIAS MAULEN -> MYSQL--------------------------------------------------------
@Override
public List<bsc_plan_de_cuentasDTO> bsc_plan_de_cuentasFindAll() {
	return bsc_plan_de_cuentas.findAll();
}

@Override
public Optional<bsc_plan_de_cuentasDTO> bsc_plan_de_cuentasFindById(int id) {
	return bsc_plan_de_cuentas.findById(id);
}

@Override
public bsc_plan_de_cuentasDTO bsc_inventario_itemSave(bsc_plan_de_cuentasDTO pc) {
	bsc_plan_de_cuentasDTO bsc_plan_de_cuentas = bsc_plan_de_cuentas.save(pc);
	return inventarioItem;
}
@Override
public bsc_plan_de_cuentasDTO bsc_plan_de_cuentasUpdate(int id, bsc_plan_de_cuentasDTO bsc_plan_de_cuentas) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void bsc_plan_de_cuentasDelete(int id) {
	lugar.delete(id);
	
}


}
