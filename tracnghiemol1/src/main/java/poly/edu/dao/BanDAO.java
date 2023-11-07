package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.model.Ban;

public interface BanDAO extends JpaRepository<Ban, String> {

}
