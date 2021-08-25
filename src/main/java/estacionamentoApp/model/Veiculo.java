package estacionamentoApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String proprietario;
	private String cpfProprietario;
	private String tipo;
	private String placa;
	private String modelo;
	private String cor;
	private Estacionamento estacionamento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getCpfProprietario() {
		return cpfProprietario;
	}
	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//@JoinColumn(name="estacionamento.id")
	@ManyToOne
	public Estacionamento getEstacionamento() {
		return estacionamento;
	}
	
	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
}
