package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.model.NguoiDung;

public interface NguoiDungDAO extends JpaRepository<NguoiDung, String> {
	NguoiDung findByEmail(String email);
	  boolean existsByEmail(String email);
	  boolean existsById(String Id);
	  
}
