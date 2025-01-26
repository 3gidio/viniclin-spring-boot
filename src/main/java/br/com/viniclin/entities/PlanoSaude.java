package br.com.viniclin.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum PlanoSaude {
	UNIMED, SULAMERICA, SANTACASA, PAGAMENTOAVISTA
}
