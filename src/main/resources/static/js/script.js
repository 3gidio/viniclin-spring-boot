function confirmarExclusao() {
	// Pega o elemento formulário pelo ID
	var form = document.getElementById("form-excluir");
	//submete o formulário para envia-lo a rota de apagar, juntamente com o ID do cliente que deve ser excluido
	form.submit();
}