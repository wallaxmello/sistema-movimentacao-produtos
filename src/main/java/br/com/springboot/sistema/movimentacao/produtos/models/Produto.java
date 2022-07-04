package br.com.springboot.sistema.movimentacao.produtos.models

-movimentacao-produtos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="cod_produto", length = 4)
	private String codigoProduto;
	@Column(name="des_produto", length = 30)
	private String descricaoProduto;
	@Column(name="sta_status", length = 1)
	private Character situacaoStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Character getSituacaoStatus() {
		return situacaoStatus;
	}

	public void setSituacaoStatus(Character situacaoStatus) {
		this.situacaoStatus = situacaoStatus;
	}

}
