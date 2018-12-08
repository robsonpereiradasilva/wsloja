package loja.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {
	private List<Departamento> departamentos = new ArrayList<>(Arrays.asList(
				new Departamento("INFO", "Informática"),
				new Departamento("ELETRO", "Eletronicos"),
				new Departamento ("CASA", "Mesa e Banho"),
				new Departamento ("Livros", "Livros e eBooks")
			));
	
	public List<Departamento> getListDepartamentos(){
		return departamentos;
	}
	
	public Departamento getDepartamento(String id) {
		for(Departamento departamento: departamentos) 
			if(departamento.getId().equalsIgnoreCase(id))
				return departamento;
						
		
		return null;
	}
	
	public boolean addDepartamento (Departamento departamento) {
		try {
			departamentos.add(departamento);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean updateDepartamento(String id, Departamento departamento) {
		for(int i = 0; i < departamentos.size(); i++)
			if(departamentos.get(i).getId().equalsIgnoreCase(id)){
				departamentos.set(i, departamento);
				return true;
			}
		return false;
		
	}
	
	public boolean deleteDepartamento(String id) {
		return departamentos.remove(getDepartamento(id));
	}
	
			
}
