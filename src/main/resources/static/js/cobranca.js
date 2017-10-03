$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget); 
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
											
	var modal = $(this)
	modal.find('.modal-title').text('Confirma Exclusão [' + codigoTitulo+']')
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoTitulo);

	modal.find('.modal-body span').html('Deseja excluir o titulo: <strong> '+descricaoTitulo +'</strong> ?');

});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();
		
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});
		
		response.done(function(e) {
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role='+ codigoTitulo +']').html('<span class="badge badge-success">'+e+'</span>');
			botaoReceber.hide();
		});
		
		response.fail(function(e) {
			console.log(e);
			alert('Erro no recebimento do Título');
		});
		
	});
});