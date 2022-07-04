package br.com.springboot.sistema-movimentacao-produtos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "movimento_manual")
public class MovimentoManual implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="dat_mes", length = 2)
	private Integer dataMes;
	@Column(name="dat_ano", length = 4)
	private Integer dataAno;
	@Column(name="num_lancamento", length = 18)
	private Integer numeroLancamento;
	@Column(name="cod_produto", length = 4)
	private String codigoProduto;
	@Column(name="cod_cosif", length = 11)
	private String codigoCosif;
	@Column(name="des_descricao", length = 50)
	private String descricao;
	@Column(name="dat_movimento")
	private Timestamp dataMovimento;
	@Column(name="cod_usuario", length = 15)
	private String codigoUsuario;
	@Column(name="val_valor", length = 18)
	private Double valorProduto;

	@Transient
	private String descricaoProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDataMes() {
		return dataMes;
	}

	public void setDataMes(Integer dataMes) {
		this.dataMes = dataMes;
	}

	public Integer getDataAno() {
		return dataAno;
	}

	public void setDataAno(Integer dataAno) {
		this.dataAno = dataAno;
	}

	public Integer getNumeroLancamento() {
		return numeroLancamento;
	}

	public void setNumeroLancamento(Integer numeroLancamento) {
		this.numeroLancamento = numeroLancamento;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getCodigoCosif() {
		return codigoCosif;
	}

	public void setCodigoCosif(String codigoCosif) {
		this.codigoCosif = codigoCosif;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Timestamp dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
}
