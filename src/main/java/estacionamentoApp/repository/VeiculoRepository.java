package estacionamentoApp.repository;

import org.springframework.data.repository.CrudRepository;
import estacionamentoApp.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, String>{
	Veiculo findById(long id);
}