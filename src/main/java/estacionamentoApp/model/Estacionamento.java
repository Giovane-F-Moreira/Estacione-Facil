package estacionamentoApp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long Id;
	private String nome;
	private String uf;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String telefone;
	private float valorCarro;
	private float valorMoto;
	private String descricaoDiasEHorarios;
	private List<Veiculo> veiculos;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	public String getDescricaoDiasEHorarios() {
		return descricaoDiasEHorarios;
	}
	public void setDescricaoDiasEHorarios(String descricaoDiasEHorarios) {
		this.descricaoDiasEHorarios = descricaoDiasEHorarios;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getValorCarro() {
		return valorCarro;
	}
	public void setValorCarro(float valorCarro) {
		this.valorCarro = valorCarro;
	}
	public float getValorMoto() {
		return valorMoto;
	}
	public void setValorMoto(float valorMoto) {
		this.valorMoto = valorMoto;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//@OneToMany(targetEntity=Veiculo.class, mappedBy="estacionamento", cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@OneToMany
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
