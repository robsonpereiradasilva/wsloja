package loja.controller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import loja.model.Departamento;
import loja.model.DepartamentoService;

@RestController
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	@GetMapping("/departamentos")
	public List<Departamento> getListDepartamentos() {
		return service.getListDepartamentos();
	}

	@GetMapping("/departamento/{id}")
	public Departamento getDepartamento(@PathVariable String id) {
		return service.getDepartamento(id);
	}
	/*
	@PostMapping("/departamentos")
	public boolean addDepartamento(@RequestBody Departamento departamento) {
		return service.addDepartamento(departamento);
	}
	*/
	@PostMapping("/departamentos")
	public boolean addDepartamento(@RequestParam String id, @RequestParam String nome) {
		return service.addDepartamento( new Departamento(id, nome));
	}
	
	@PutMapping("/departamentos/{id}")
		public boolean updateDepartamento (@RequestBody Departamento departamento,@PathVariable String id) {
			return service.updateDepartamento(id, departamento);
		}
	@DeleteMapping("/departamento/{id}")
	public boolean deleteDepartamento(@PathVariable String id) {
		return service.deleteDepartamento(id);
	}
		

}
