package org.serratec.java2.backend.marketplace.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=1,max=20)
	@Column(name="nome_produto", nullable = false, length = 20)
	private String nomeProduto;
	
	@NotNull
	@Size(min=1,max=100)
	@Column(name="desc_Prod", nullable = false, length = 100)
	private String descricaoProduto;
	
	@NotNull
	@Size(min=1,max=100)
	@Column(name="nome_vendedor", nullable = false, length = 100)
	private String nomeVendedor;
		
	@NotNull
	@Column(name="valor_Unit", nullable = false)
	private Double valorUnitario;
	
	@NotNull
	@Column(name="qtd_Prod", nullable = false)
	private Integer quantidadeProduto;
	
	@NotNull
	@Column(name="data_Fabric", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyy", timezone = "America/Sao_Paulo")
	private Date dataFabricacao;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(String nomeProduto, String descricaoProduto, String nomeVendedor, Double valorUnitario,
			Integer quantidadeProduto,  Date dataFabricacao, Usuario usuario, Categoria categoria) {
		super();
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.nomeVendedor = nomeVendedor;
		this.valorUnitario = valorUnitario;
		this.quantidadeProduto = quantidadeProduto;
		this.dataFabricacao = dataFabricacao;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
		
}	
	
	