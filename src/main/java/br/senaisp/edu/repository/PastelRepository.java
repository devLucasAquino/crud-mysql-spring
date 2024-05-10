package br.senaisp.edu.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senaisp.edu.repository.MySqlConnectionApplication;
import br.senaisp.edu.model.Pastel;

@Repository
public class PastelRepository {
	
	private String qrSelectAll = 
			"SELECT id, sabor FROM pastel";
	
	private String insertRow = 
			"INSERT INTO pastel (sabor) VALUES (?)";
	
	private String deleteRow = 
			"DELETE FROM pastel WHERE id = ?";
	
	private String qrSelectById =
			"SELECT * FROM pastel WHERE id = ?";
	
	private String updateRow = 
			"UPDATE pastel SET sabor = ? WHERE id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	public List<Pastel> lista() {
		
		return jdbcTemplate.query(qrSelectAll, 
				(rs, rowNum) -> {		
			return new Pastel(rs.getInt("id"), 
						rs.getString("sabor"));
		});
	}

	@SuppressWarnings("deprecation")
	public Pastel buscaPorId(int id) {
		 Object[] params = {id};

	        return jdbcTemplate.queryForObject(qrSelectById,
	                params,
	                (rs, rowNum) -> {
	            return new Pastel(rs.getInt("id"),
	                    rs.getString("sabor"));
	        });
	}

	public void altera(int id, String sabor) {
		
		Pastel setPastel = buscaPorId(id);
		
		setPastel.setSabor(sabor);
		
		Object[] params = {setPastel.getSabor(), id};
		
		jdbcTemplate.update(updateRow, params);
		
		 
	}

	public void insere(String sabor) {
		jdbcTemplate.update(insertRow, sabor);
	}

	public void delete(int id) {
		jdbcTemplate.update(deleteRow, id); 
	}

}
