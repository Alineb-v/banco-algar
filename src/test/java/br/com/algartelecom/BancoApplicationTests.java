package br.com.algartelecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.algartelecom.controller.TransacaoController;
import br.com.algartelecom.model.Conta;
import br.com.algartelecom.model.StatusConta;
import br.com.algartelecom.model.TipoConta;
import br.com.algartelecom.model.TipoTransacao;
import br.com.algartelecom.model.Transacao;
import br.com.algartelecom.service.TransacaoService;

@WebMvcTest(TransacaoController.class)
class BancoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private TransacaoService transacaoService;


	public Conta recuperarConta() {
		Conta conta = new Conta(1L, "Testez", "10045-3", TipoConta.CONTA_CORRENTE, 103.0, StatusConta.ATIVO);
		return conta;

	}

	public <T> String transformaEmJson(T toJson) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(toJson);

	}

	public Transacao recuperarTransacao() {
		Transacao transacao = new Transacao(1L, "10045-3", 50.0, null, TipoTransacao.DEPOSITO, null);
		return transacao;

	}
	/*
	 * @Test void deveriaDepositarValor() throws Exception { URI uri = new
	 * URI("/depositar/10045-3");
	 * 
	 * Mockito.when(transacaoService.depositar(recuperarTransacao(),
	 * "10045-3")).thenReturn(recuperarConta());
	 * 
	 * this.mockMvc.perform(post("/depositar")) .andExpect(status().isOk())
	 * .andExpect(content().string(containsString("Teste"))); }
	 */

}