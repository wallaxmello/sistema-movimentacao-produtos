package br.com.springboot.sistema-movimentacao-produtos.dtos;

public class MovimentoManualDTO {

	private Integer dataMes;
	private Integer dataAno;
	private String codigoProduto;
	private String codigoCosif;
	private String descricao;
	private Double valorProduto;

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

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
}
