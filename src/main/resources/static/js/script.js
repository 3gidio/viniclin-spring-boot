document.addEventListener("DOMContentLoaded", function() {
	document.querySelectorAll(".btn-excluir").forEach(button => {
		button.addEventListener("click", function() {
			let clienteId = this.getAttribute("data-id");
			dispararAlerta(clienteId);
		});
	});
});
function carregarEvento(idCliente) {
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelectorAll(".btn-sim").forEach(button => {
			button.addEventListener("click", function() {
				confirmarExclusao(idCliente, true);
			});
		});
	});
}


function confirmarExclusao(idCliente, confirmado) {
	if (confirmado) {
		console.log("confirmando exclusão do cliente: " + idCliente);
		// Cria um formulário dinâmico para exclusão
		var form = document.createElement("form");
		form.method = "post";
		form.action = "apagar-cliente";

		// Adiciona um campo hidden com o id do cliente
		var inputId = document.createElement("input");
		inputId.type = "hidden";
		inputId.name = "id";

		inputId.value = idCliente;

		console.log(inputId.value);

		form.appendChild(inputId);

		// Adiciona o formulário ao body e o submete
		document.body.appendChild(form);
		form.submit();
	}
}