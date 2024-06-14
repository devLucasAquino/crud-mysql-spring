package br.senaisp.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senaisp.edu.model.Pastel;
import br.senaisp.edu.repository.PastelRepository;

@RestController
@RequestMapping("/pastelaria")
public class PastelController {
	
		
		@Autowired
		private PastelRepository repository;
		
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/inserir/{sabor}")
		public List<Pastel> InserirPastel(@PathVariable String sabor) {
		repository.insere(sabor);
			
		return ListaPasteis();
				
		}
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/lista")
		public List<Pastel> ListaPasteis() {
			return repository.lista();
		}
		
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/delete/{id}")
		public List<Pastel> deletePastel(@PathVariable Integer id) {
			repository.delete(id);
			
			return ListaPasteis();
		}
		
		@GetMapping("{id}")
		public Pastel procurarPorId(@PathVariable Integer id) {
			return repository.buscaPorId(id);
			
		}
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/update/{id}/{sabor}")
		public List<Pastel> updatePastel(@PathVariable String sabor, @PathVariable Integer id){
			repository.altera(id, sabor);
			
			return repository.lista();
		}

}
