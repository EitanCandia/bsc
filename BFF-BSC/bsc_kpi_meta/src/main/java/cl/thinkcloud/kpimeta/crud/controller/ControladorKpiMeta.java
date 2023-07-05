package cl.thinkcloud.kpimeta.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.thinkcloud.kpimeta.crud.dto.KpiMetaDTO;
import cl.thinkcloud.kpimeta.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/kpi-meta")
public class ControladorKpiMeta {

	public final Logger logger = LoggerFactory.getLogger(ControladorKpiMeta.class);

	@Autowired
	private ICrudService servicio;

	@Operation(summary = "agregarKpiMeta")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@PostMapping("REST") // CREATE-POST
	public KpiMetaDTO agregarKpiMeta(@Valid @NonNull @RequestBody KpiMetaDTO kpiMeta) {
		logger.info("Controlador-agregarKpiMeta");
		return servicio.save(kpiMeta);
	}

	@Operation(summary = "getAllKpiMetas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@GetMapping("REST") // READ-GET
	public List<KpiMetaDTO> getAllKpiMetas() {
		logger.info("Controlador-getAllKpiMetas");
		return servicio.findAll();
	}

	@Operation(summary = "getKpiMeta by Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@GetMapping("REST/{id}") // READ-GET/id
	public KpiMetaDTO getKpiMeta(@PathVariable("id") int id) {
		KpiMetaDTO kpiMetaDTO = servicio.findById(id).orElse(null);
		return kpiMetaDTO;
	}

	@Operation(summary = "updateKpiMetaById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@PutMapping(("REST")) // UPDATE-PUT
	public KpiMetaDTO updateKpiMetaById(@Valid @NonNull @RequestBody KpiMetaDTO kpiMeta) {
		Optional<KpiMetaDTO> optionalKpiMeta = servicio.findById(kpiMeta.getId());
		if (optionalKpiMeta.isPresent()) {
			return servicio.save(kpiMeta);
		} else {
			return null;
		}
	}

	@Operation(summary = "updateKpiMetaBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@PutMapping(("REST/{id}")) // UPDATE-PUT
	public KpiMetaDTO updateKpiMetaById(@Valid @NonNull @RequestBody KpiMetaDTO kpiMeta,
			@PathVariable("id") int id) {
		Optional<KpiMetaDTO> optionalKpiMeta = servicio.findById(id);
		if (optionalKpiMeta.isPresent()) {
			kpiMeta.setId(id);
			return servicio.save(kpiMeta);
		} else {
			return null;
		}
	}

	@Operation(summary = "deleteKpiMeta")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@DeleteMapping("REST") // DELETE-DELETE
	public KpiMetaDTO deleteKpiMetaById(@Valid @NonNull @RequestBody KpiMetaDTO kpiMeta) {
		Optional<KpiMetaDTO> optionalKpiMeta = servicio.findById(kpiMeta.getId());
		if (optionalKpiMeta.isPresent()) {
			servicio.delete(kpiMeta.getId());
			return kpiMeta;
		} else {
			return null;
		}
	}

	@Operation(summary = "deleteKpiMetaBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@DeleteMapping("REST/{id}") // DELETE-DELETE
	public int deleteKpiMetaById(@PathVariable("id") int id) {
		Optional<KpiMetaDTO> optionalKpiMeta = servicio.findById(id);
		if (optionalKpiMeta.isPresent()) {
			servicio.delete(id);
			return 1;
		} else {
			return 0;
		}
	}

}
