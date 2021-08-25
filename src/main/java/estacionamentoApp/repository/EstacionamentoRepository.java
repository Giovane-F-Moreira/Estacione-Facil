package estacionamentoApp.repository;

import org.springframework.data.repository.CrudRepository;
import estacionamentoApp.model.Estacionamento;

public interface EstacionamentoRepository extends CrudRepository<Estacionamento, String>{
	Estacionamento findById(long Id);
}