package com.bff.bsc.service;

import java.util.List;
import java.util.Optional;

import com.bff.bsc.dto.SituacionDTO;

import com.bff.bsc.dto.bsc_plan_de_cuentasDTO;
import com.bff.bsc.dto.ideasDTO;
import com.bff.bsc.dto.Bsc_temaDTO;
import com.bff.bsc.dto.DTOBscProyectoPedido;
import com.bff.bsc.dto.LugarDTO;
import com.bff.bsc.dto.ObjetivoDTO;
import com.bff.bsc.dto.Inventario_itemDTO;
import com.bff.bsc.dto.ProyectoPersonaDTO;
import com.bff.bsc.dto.Proyecto_ActividadDTO;
import com.bff.bsc.dto.ProyectoDTO;
import com.bff.bsc.dto.TipoDocumentoDTO;
import com.bff.bsc.dto.KpiMetaDTO;
import com.bff.bsc.dto.InventarioUnidadDTO;
import com.bff.bsc.dto.kapi_final_DTO;
import com.bff.bsc.dto.proveedorDTO;
import com.bff.bsc.dto.Proyecto_inventario_recursosDTO;
import com.bff.bsc.dto.ProyectoActividad_TipoActividadDTO;

public interface ServiceBsc {
	
//BSC_PROYECTO_ACTIVIDAD -> TOMAS OSORIO - MYSQL
  	public List<Proyecto_ActividadDTO> bsc_proyecto_actividadfindAll();
    public Optional<Proyecto_ActividadDTO> bsc_proyecto_actividadfindById(int id);
    public Proyecto_ActividadDTO bsc_proyecto_actividadsave(Proyecto_ActividadDTO proyecto_actividad);
    public void bsc_proyecto_actividaddelete(int id);
   
//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------------------------------------------------------------------------------------------------------------------------------    
//BSC_TEMA -> NICOLAS NANJARI - MYSQL
    public List<Bsc_temaDTO> bsc_temafindAll();
    public Optional<Bsc_temaDTO> bsc_temafindById(int id);
    public Bsc_temaDTO bsc_temasave(Bsc_temaDTO tema);
    public void bsc_tema_delete(int id);
    
//-----------------------------------------------------------------------------------------------------------------------------   
//------------------------------------------------------------------------------------------------------------------------------------------------    
//BSC_SITUACION_DEPARTAMENTO_IDEA_PROYECTO -> JUAN JOSE LARA -> MYSQL
    public List<SituacionDTO> bsc_situacionfindAll();
    public Optional<SituacionDTO> bsc_situacionfindById(int id);
    public SituacionDTO bsc_situacionsave(SituacionDTO situacion);
    public void bsc_situaciondelete(int id);

    
//-----------------------------------------------------------------------------------------------------------------------------   
//------------------------------------------------------------------------------------------------------------------------------------------------    
//BSC_PROYECTO_PEDIDO-> VICTOR MARIÑAN -> MYSQL
    public List<DTOBscProyectoPedido> bsc_proyecto_pedidofindAll();
    public Optional<DTOBscProyectoPedido> bsc_proyecto_pedidofindById(int id);
    public DTOBscProyectoPedido bsc_proyecto_pedidosave(DTOBscProyectoPedido bpp);
    public void bsc_proyecto_pedidodelete(int id);
   
//-----------------------------------------------------------------------------------------------------------------------------   
//------------------------------------------------------------------------------------------------------------------------------------------------  
//BSC_OBJETIVO> Alexis Mendoza -> MYSQL
    public List<ObjetivoDTO> bsc_objetivofindAll();
    public Optional<ObjetivoDTO> bsc_objetivofindById(int id);
    public ObjetivoDTO bsc_objetivosave(ObjetivoDTO bpp);
    public void bsc_objetivodelete(int id);
    
  //-----------------------------------------------------------------------------------------------------------------------------   
  //------------------------------------------------------------------------------------------------------------------------------------------------  
  //BSC_LUGAR> Eitan Candia -> MYSQL
      public List<LugarDTO> bsc_lugarfindAll();
      public Optional<LugarDTO> bsc_lugarfindById(int id);
      public LugarDTO bsc_lugarsave(LugarDTO bpp);
      public void bsc_lugardelete(int id);
    //-----------------------------------------------------------------------------------------------------------------------------   
    //------------------------------------------------------------------------------------------------------------------------------------------------  
    //BSC_INVENTARIO_ITEM -> MATIAS CORDOVA -> MYSQL    
        
        public List<Inventario_itemDTO> bsc_inventario_itemFindAll();
        public Optional<Inventario_itemDTO> bsc_inventario_itemFindById(int id);
        public Inventario_itemDTO bsc_inventario_itemSave(Inventario_itemDTO inventario_item);
        public Inventario_itemDTO bsc_inventario_itemUpdate(int id, Inventario_itemDTO inventario_item);
        public void bsc_inventario_itemDelete(int id);
//-----------------------------------------------------------------------------------------------------------------------------   
//------------------------------------------------------------------------------------------------------------------------------------------------  
//BSC_R_Proyecto_Persona> Joaquin Perez -> MYSQL    
    
    public List<ProyectoPersonaDTO> bsc_proyecto_personaFindAll();
    public Optional<ProyectoPersonaDTO> bsc_proyecto_personaFindById(int id);
    public ProyectoPersonaDTO bsc_proyecto_personaSave(ProyectoPersonaDTO persona);
    public ProyectoPersonaDTO bsc_proyecto_personaUpdate(int id, ProyectoPersonaDTO persona);
    public void bsc_proyecto_personaDelete(int id);
      //-----------------------------------------------------------------------------------------------------------------------------   
  //------------------------------------------------------------------------------------------------------------------------------------------------  
  //BSC_PROYECTO> Pablo Valenzuela -> MYSQL
    
  public List<ProyectoDTO> bsc_proyectofindAll();
  public Optional<ProyectoDTO> bsc_proyectofindById(int id);
  public ProyectoDTO bsc_proyectosave(ProyectoDTO bpp);
  public void bsc_proyectodelete(int id);
  //-----------------------------------------------------------------------------------------------------------------------------   
  //------------------------------------------------------------------------------------------------------------------------------------------------  
  //BSC_TIPO_DOCUMENTO> Thomas Tapia -> MYSQL
  public List<TipoDocumentoDTO> bsc_tipo_documentofindAll();
  public Optional<TipoDocumentoDTO> bsc_tipo_documentofindById(long id);
  public TipoDocumentoDTO bsc_tipo_documentosave(TipoDocumentoDTO tipo_documento);
  public void bsc_tipo_documentodelete(long id);



  //-----------------------------------------------------------------------------------------------------------------------------   
  //------------------------------------------------------------------------------------------------------------------------------------------------  
  //BSC_kpi_meta> Moises Contreras -> MYSQL
    public List<KpiMetaDTO> kpiMetaFindAll();
    public Optional<KpiMetaDTO> kpiMetaFindById(int id);
    public KpiMetaDTO kpiMetaSave(KpiMetaDTO kpiMeta);
    public void kpiMetadelete(int id);
    public KpiMetaDTO kpiMetaUpdate(int id, KpiMetaDTO kpiMeta);
//-----------------------------------------------------------------------------------------------------------------------------   
  //------------------------------------------------------------------------------------------------------------------------------------------------  
   // BSC-proyecto inventario unidad Miguel Belmar -> MYSQL

    public List<InventarioUnidadDTO> bsc_inventario_unidadFindAll();

    public Optional<InventarioUnidadDTO> bsc_inventario_unidadFindById(int id);

    public InventarioUnidadDTO bsc_inventario_unidadSave(InventarioUnidadDTO inventarioUnidad);

    public void bsc_inventario_unidadDelete(int id);

    public InventarioUnidadDTO bsc_inventario_unidadUpdate(int id, InventarioUnidadDTO inventarioUnidad);
    
  //BSC_PROYECTO_ACTIVIDAD_TIPOACTIVIDAD -> ALEJANDRO VILLALOBOS - MYSQL
    
    public List<ProyectoActividad_TipoActividadDTO> micro1FindAll();
    public Optional<ProyectoActividad_TipoActividadDTO> micro1FindById(int id);
    public ProyectoActividad_TipoActividadDTO micro1Save(ProyectoActividad_TipoActividadDTO proyecto);
    public void micro1Delete(int id);
    
    

//-----------------------------------------------------------------------------------------------------------------------------    
//------------------------------------------------------------------------------------------------------------------------------------------------    
//BSC_KAPI -> TOMAS MELLA - MYSQL
    public List<kapi_final_DTO> kapiFindAll();
    public Optional<kapi_final_DTO> kapiFindById(int id);
    public kapi_final_DTO kapisave(kapi_final_DTO kapi);
    public void kapidelete(int id);
    public kapi_final_DTO kapiupdate(int id, kapi_final_DTO kapi);


//-----------------------------------------------------------------------------------------------------------------------------
//-----------------BSC_PROYECTO_INVENTARIO_RECURSOS -> SEBASTIÁN RIQUELME - MYSQL-------------------------------------------------------------------------


    public List<Proyecto_inventario_recursosDTO> bsc_proyecto_inventario_recursosFindAll();
    public Optional<Proyecto_inventario_recursosDTO> bsc_proyecto_inventario_recursosFindById(int id);
    public Proyecto_inventario_recursosDTO bsc_proyecto_inventario_recursosSave(Proyecto_inventario_recursosDTO bsc_proyecto_inventario_recursos);
    public void Proyecto_inventario_recursosDelete(int id);

  //-----------------------------------------------------------------------------------------------------------------------------   
    //------------------------------------------------------------------------------------------------------------------------------------------------  
    //bsc_plan_de_cuentasDelete -> MATIAS MAULEN -> MYSQL    
        
        public List<bsc_plan_de_cuentasDTO> bsc_plan_de_cuentasFindAll();
        public Optional<bsc_plan_de_cuentasDTO> bsc_plan_de_cuentasFindById(int id);
        public bsc_plan_de_cuentasDTO bsc_plan_de_cuentasSave(bsc_plan_de_cuentasDTO bsc_plan_de_cuentas);
        public bsc_plan_de_cuentasDTO bsc_plan_de_cuentasUpdate(int id, bsc_plan_de_cuentasDTO bsc_plan_de_cuentas);
        public void bsc_plan_de_cuentasDelete(int id);
   
	//-----------------------------------------------------------------------------------------------------------------------------   
  //------------------------------------------------------------------------------------------------------------------------------------------------  
   // BSC-proyecto IDEAS Sebastian Sanhueza -> MYSQL
public List<ideasDTO> bsc_ideasFindAll();
public Optional<ideasDTO> bsc_ideasFindById(int id);
public ideasDTO bsc_ideasSave(ideasDTO ideas);
public ideasDTO bsc_ideasUpdate(int id, ideasDTO ideas);
public void bsc_ideasDelete(int id);





  public List<proveedorDTO> proveedorFindAll();
    public Optional<proveedorDTO> proveedorFindById(int id);
    public proveedorDTO proveedorSave(proveedorDTO proveedor);
    public void proveedordelete(int id);
    public proveedorDTO proveedorUpdate(int id, proveedorDTO proveedor);
}

