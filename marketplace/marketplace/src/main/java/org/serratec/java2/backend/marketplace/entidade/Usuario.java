package org.serratec.java2.backend.marketplace.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min= 10, max = 100)
	@Column(name="nome_cliente", nullable = false, length = 100)
	private String nomeCliente;
	
	@NotNull
	@Size(min= 5, max = 20)
	@Column(name="nick_name", nullable = false, length = 20)
	private String nickName;
	
	@NotNull
	@Size(min= 14, max = 14)
	@Column(name="cpf", nullable = false, length = 14)
	private String cpf;
	
	@NotNull
	@Size(min= 10, max = 50)
	@Column(name="email", nullable = false, length = 50)
	private String email;
	
	@NotNull
	@Column(name="data_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyy", timezone = "America/Sao_Paulo")
	private Date dataNascimento;

	@NotNull
	@Size(min= 9, max = 9)
	@Column(name="cep", nullable = false, length = 9)
	private String cep;
	
	@NotNull
	@Size(min= 5, max = 30)
	@Column(name="rua", nullable = false, length = 30)
	private String rua;
	
	@NotNull
	@Column(name="numero", nullable = false)
	private Integer numero;
	
	@NotNull
	@Size(min= 5, max = 20)
	@Column(name="bairro", nullable = false, length = 20)
	private String bairro;
	
	@NotNull
	@Size(min= 5, max = 20)
	@Column(name="cidade", nullable = false, length = 20)
	private String cidade;
	
	@NotNull
	@Size(min= 2, max = 2)
	@Column(name="estado", nullable = false, length = 2)
	private String estado;
	
	@NotNull
	@Column(name="ddd", nullable = false, length = 4)
	private String ddd;
	
	@NotNull
	@Size(min=10,max=14)
	@Column(name="telefone", nullable = false, length = 14)
	private String telefone;
	
	@NotNull
	@Size(min=2,max=10)
	@Column(name="tipo", nullable = false, length = 10)
	private String tipo;

	public Usuario() {
		super();
	}

	public Usuario(String nomeCliente, String nickName,  String cpf, String email,Date dataNascimento,
		String cep, String rua, Integer numero,String bairro, String cidade,  String estado,
		String ddd,  String telefone,String tipo) {
		super();
		this.nomeCliente = nomeCliente;
		this.nickName = nickName;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.ddd = ddd;
		this.telefone = telefone;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
		
}	