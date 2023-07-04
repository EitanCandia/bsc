package cl.thinkcloud.boxplanner.crud.controller;

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

import cl.thinkcloud.boxplanner.crud.dto.proveedorDTO;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/proveedor")
public class Controladorproveedor {

	public final Logger logger = LoggerFactory.getLogger(Controladorproveedor.class);

	@Autowired
	private ICrudService servicio;

	@Operation(summary = "agregarproveedor")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@PostMapping("REST") // CREATE-POST
	public proveedorDTO agregarproveedor(@Valid @NonNull @RequestBody proveedorDTO proveedor) {
		logger.info("Controlador-agregarproveedor");
		return servicio.save(proveedor);
	}

	@Operation(summary = "getAllproveedors")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@GetMapping("REST") // READ-GET
	public List<proveedorDTO> getAllproveedors() {
		logger.info("Controlador-getAllproveedors");
		return servicio.findAll();
	}

	@Operation(summary = "getproveedor by Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@GetMapping("REST/{id}") // READ-GET/id
	public proveedorDTO getproveedor(@PathVariable("id") int id) {
		proveedorDTO proveedorDTO = servicio.findById(id).orElse(null);
		return proveedorDTO;
	}

	@Operation(summary = "updateproveedorById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@PutMapping(("REST")) // UPDATE-PUT
	public proveedorDTO updateproveedorById(@Valid @NonNull @RequestBody proveedorDTO proveedor) {
		Optional<proveedorDTO> optionalproveedor = servicio.findById(proveedor.getId());
		if (optionalproveedor.isPresent()) {
			return servicio.save(proveedor);
		} else {
			return null;
		}
	}

	@Operation(summary = "updateproveedorBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@PutMapping(("REST/{id}")) // UPDATE-PUT
	public proveedorDTO updateproveedorById(@Valid @NonNull @RequestBody proveedorDTO proveedor,
			@PathVariable("id") int id) {
		Optional<proveedorDTO> optionalproveedor = servicio.findById(id);
		if (optionalproveedor.isPresent()) {
			proveedor.setId(id);
			return servicio.save(proveedor);
		} else {
			return null;
		}
	}

	@Operation(summary = "deleteproveedor")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@DeleteMapping("REST") // DELETE-DELETE
	public proveedorDTO deleteproveedorById(@Valid @NonNull @RequestBody proveedorDTO proveedor) {
		Optional<proveedorDTO> optionalproveedor = servicio.findById(proveedor.getId());
		if (optionalproveedor.isPresent()) {
			servicio.delete(proveedor.getId());
			return proveedor;
		} else {
			return null;
		}
	}

	@Operation(summary = "deleteproveedorBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody
	@DeleteMapping("REST/{id}") // DELETE-DELETE
	public int deleteproveedorById(@PathVariable("id") int id) {
		Optional<proveedorDTO> optionalproveedor = servicio.findById(id);
		if (optionalproveedor.isPresent()) {
			servicio.delete(id);
			return 1;
		} else {
			return 0;
		}
	}

}
