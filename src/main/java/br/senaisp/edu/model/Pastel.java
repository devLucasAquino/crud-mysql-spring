package br.senaisp.edu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "PASTEL")
public class Pastel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String sabor;		
		
		
		public Pastel() {
		}
		
		

		public Pastel(Integer id, String sabor) {
			this.id = id;
			this.sabor = sabor;
		}



		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public String getSabor() {
			return sabor;
		}



		public void setSabor(String sabor) {
			this.sabor = sabor;
		}
		
		

}
