package pe.edu.upeu.sprintemplate.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sprintemplate.entity.Cliente;

public interface ClienteDao {
	int create(Cliente u);
	int update(Cliente u);
	int delete(int id);
	Cliente read(int id);
	List<Map<String, Object>> readAll();
}
