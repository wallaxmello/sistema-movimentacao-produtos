var idMovimentosManuais = '';
var id = "";
var dataMes = "";
var dataAno = "";
var codigoProduto = "";
var codigoCosif = "";
var valorProduto = "";
var descricao = "";

$(document).ready( function () {
	  table = $('#tabelaMovimentosManuais').DataTable({
			"sAjaxSource": "/api/getMovimentosManuais",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      	{ "mData": "dataMes" },
					{ "mData": "dataAno" },
					{ "mData": "codigoProduto" },
					{ "mData": "descricaoProduto" },
					{ "mData": "numeroLancamento" },
					{ "mData": "descricao" },
					{ "mData": "valorProduto" }
			],
			"lengthMenu": [5,10,20],
			"deferRender": true,
            "scrollY": true,
            "scrollX": true,
            "scroller": true,
            "scrollCollapse": true,
            "searching": true,
            "paging": true,
			"language": {
            		
            		"emptyTable": "Nenhum registro encontrado",
				    "info": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
				    "infoEmpty": "Mostrando 0 até 0 de 0 registros",
				    "infoFiltered": "(Filtrados de _MAX_ registros)",
				    "infoThousands": ".",
				    "loadingRecords": "Carregando...",
				    "processing": "Processando...",
				    "zeroRecords": "Nenhum registro encontrado",
				    "lengthMenu": "Exibir _MENU_ resultados por página",
				    "search": "Pesquisar",
				    "paginate": {
				        "next": "Próximo",
				        "previous": "Anterior",
				        "first": "Primeiro",
				        "last": "Último"
            		}
            	}
	 });

table.on( 'click', 'tbody tr', function () {
        
		if ( $(this).hasClass('colorir') ) {
			
            $(this).removeClass('colorir');

        }else {
	
			table.$('tr.colorir').removeClass('colorir');
            $(this).toggleClass('colorir');
        }

		if(table.row(this).data().id == idMovimentosManuais){
                	
          	idMovimentosManuais = '';
			
        }else{
                    
         	idMovimentosManuais = table.row(this).data().id;
        }

});

table.on('dblclick','tbody tr td',function () {
            	
            	if(!($(this).text() == null || $(this).text().trim() == '')){
            		cell = $(this).text();
            	}

                $(this).addClass("cellEditing");
                $(this).html('<input type="text" value="'+cell+'" />');
                $(this).children().first().focus();

                $(this).children().first().keypress(function (e) {
                    if (e.which == 13) {
                        var newContent = $(this).val();
                        $(this).parent().text(newContent);
                        $(this).parent().removeClass("cellEditing");
                    }
                });

	            $(this).children().first().blur(function(){
	                $(this).parent().text(cell);
	                $(this).parent().removeClass("cellEditing");
	            });
	            
});

});

function getProdutos(){
	$.ajax({
			method: "GET",
			url: "/api/getProdutos",
	       // dataType: 'json',
	        success: function (response) {

            	var dados = "<option value='' selected>-- Selecione --</option>";

        	    for(var i = 0; i < response.length; i++){

        	    	dados += "<option value='"+response[i].codigoProduto+"'>"+response[i].descricaoProduto+"</option>";

                    $("#codigoProduto").html(dados);
				}

            }, error: function (xhr, status, errorThrown) {

		        	alert( "Erro ao buscar produtos: " + xhr.responseText);

		        }
	});
}

function getCodigosCosif(){
	$.ajax({
			method: "GET",
			url: "/api/getCodigosCosif",
	       // dataType: 'json',
	        success: function (response) {

            	var dados = "<option value='' selected>-- Selecione --</option>";

        	    for(var i = 0; i < response.length; i++){

        	    	dados += "<option value='"+response[i].codigoCosif+"'>"+response[i].codigoCosif+" - "+response[i].codigoClassificacao+"</option>";

                    $("#codigoCosif").html(dados);
				}

            }, error: function (xhr, status, errorThrown) {

		        	alert( "Erro ao buscar produtos: " + xhr.responseText);

		        }
	});
}

function salvarDados(){

    dataMes = $('#dataMes').val().toUpperCase().trim();
	dataAno = $('#dataAno').val().toUpperCase().trim();
	codigoProduto = $('#codigoProduto').val().toUpperCase().trim();
	codigoCosif = $('#codigoCosif').val().trim();
	valorProduto = $('#valorProduto').val().trim();
	descricao = $('#descricao').val().toUpperCase().trim();

	if(validaCampos()){
	    return;
	}

    if(confirm('Deseja realmente salvar esses dados ?')){

    	$.ajax({
    			method: "POST",
    			url: "/api/salvarDados",
    			data: JSON.stringify(
    			    {
    				dataMes : dataMes,
    				dataAno : dataAno,
    				codigoProduto : codigoProduto,
    				codigoCosif : codigoCosif,
    				valorProduto : valorProduto,
    				descricao : descricao
    			    }
    			),
    			contentType: "application/json; charset=utf-8",
    			success: function (response) {

    				alert("Dados salvos com sucesso, ID: " + response.id);

    				location.assign("/index");
    			}
    			}).fail(function (xhr, status, errorThrown) {

    				  alert( "Erro ao salvar dados: " + xhr.responseText);

    			});
    }

}

function validaCampos(){

    if(dataMes == null || dataMes.trim() == ''){

		alert("Campo mês em branco!");
		$('#dataMes').addClass('is-invalid');
		$('#dataMes').focus();

		return 1;

	}else{
	        if(!(dataMes.length == 2 && dataMes > 0 && dataMes < 13)){
			    alert("Campo mês inválido!");
			    $('#dataMes').addClass('is-invalid');
			    $('#dataMes').focus();
			    return 1;
			}

			$('#dataMes').removeClass('is-invalid');
	}

	if(dataAno == null || dataAno.trim() == ''){

    	alert("Campo ano em branco!");
    	$('#dataAno').addClass('is-invalid');
    	$('#dataAno').focus();

    	return 1;

    }else{

        var data = new Date();
        var anoAtual = data.getFullYear();
        var anoMinimo = anoAtual - 1;

        if(!(dataAno.length == 4 && dataAno >= anoMinimo && dataAno <= anoAtual)){
        	alert("Campo ano inválido!");
        	$('#dataAno').addClass('is-invalid');
        	$('#dataAno').focus();
        	return 1;
        }

    	$('#dataAno').removeClass('is-invalid');
    }

    if(codigoProduto == null || codigoProduto.trim() == ''){

        alert("Campo produto em branco!");
        $('#codigoProduto').addClass('is-invalid');
        $('#codigoProduto').focus();

        return 1;

    }else{
        	$('#codigoProduto').removeClass('is-invalid');
    }

    if(codigoCosif == null || codigoCosif.trim() == ''){

            alert("Campo cosif em branco!");
            $('#codigoCosif').addClass('is-invalid');
            $('#codigoCosif').focus();

            return 1;

    }else{
            	$('#codigoCosif').removeClass('is-invalid');
    }

    if(valorProduto == null || valorProduto.trim() == ''){

                alert("Campo valor em branco!");
                $('#valorProduto').addClass('is-invalid');
                $('#valorProduto').focus();

                return 1;

    }else{
                $('#valorProduto').removeClass('is-invalid');
    }

     if(descricao == null || descricao.trim() == ''){

                 alert("Campo descrição em branco!");
                 $('#descricao').addClass('is-invalid');
                 $('#descricao').focus();

                 return 1;

     }else{
                 $('#descricao').removeClass('is-invalid');
     }

}

function limparForm(){

    $('#formMovimentosManuais')[0].reset();
    $('input').removeClass('is-invalid');
    $('select').removeClass('is-invalid');

    idMovimentosManuais = '';
    id = "";
    dataMes = "";
    dataAno = "";
    codigoProduto = "";
    codigoCosif = "";
    valorProduto = "";
    descricao = "";

    desabilitaInput();

}

function habilitarInput(){

    $("#btnNovo").prop('disabled', true);

    $("#btnIncluir").prop('disabled', false);
    $("#btnLimpar").prop('disabled', false);
    $("#dataMes").prop('disabled', false);
    $("#dataAno").prop('disabled', false);
    $("#codigoProduto").prop('disabled', false);
    $("#codigoCosif").prop('disabled', false);
    $("#valorProduto").prop('disabled', false);
    $("#descricao").prop('disabled', false);

}

function desabilitaInput(){

    $("#btnNovo").prop('disabled', false);

    $("#btnIncluir").prop('disabled', true);
    $("#btnLimpar").prop('disabled', true);
    $("#dataMes").prop('disabled', true);
    $("#dataAno").prop('disabled', true);
    $("#codigoProduto").prop('disabled', true);
    $("#codigoCosif").prop('disabled', true);
    $("#valorProduto").prop('disabled', true);
    $("#descricao").prop('disabled', true);

}

$( function() {
	
	getProdutos();
	getCodigosCosif();
	desabilitaInput();
    
} );
