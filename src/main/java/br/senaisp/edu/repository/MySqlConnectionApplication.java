package br.senaisp.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlConnectionApplication {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(MySqlConnectionApplication.class, args);
    }
 
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO pastel (sabor) VALUES (?)";
         
        int result = jdbcTemplate.update(sql, "Mussarela");
         
        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
         
    }

}
