package br.com.springboot.sistema.movimentacao.produtos.models

-movimentacao-produtos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto_cosif")
public class ProdutoCosif implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="cod_cosif", length = 11)
	private String codigoCosif;
	@Column(name="cod_produto", length = 4)
	private String codigoProduto;
	@Column(name="cod_classificacao", length = 6)
	private String codigoClassificacao;
	@Column(name="sta_status", length = 1)
	private Character situacaoStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoCosif() {
		return codigoCosif;
	}

	public void setCodigoCosif(String codigoCosif) {
		this.codigoCosif = codigoCosif;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getCodigoClassificacao() {
		return codigoClassificacao;
	}

	public void setCodigoClassificacao(String codigoClassificacao) {
		this.codigoClassificacao = codigoClassificacao;
	}

	public Character getSituacaoStatus() {
		return situacaoStatus;
	}

	public void setSituacaoStatus(Character situacaoStatus) {
		this.situacaoStatus = situacaoStatus;
	}

}
