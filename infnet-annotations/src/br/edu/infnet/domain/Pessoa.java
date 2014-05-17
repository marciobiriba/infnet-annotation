package br.edu.infnet.domain;

import br.edu.infnet.framework.annotation.FormHtml;
import br.edu.infnet.framework.annotation.InputText;
import br.edu.infnet.framework.renderizador.HtmlRenderizador;

@FormHtml(nome="Pessoa")
public class Pessoa extends HtmlRenderizador{
	@InputText(nome="Nome")
	private String nome;
	@InputText(nome="Idade",tamanho=5)
	private int idade;
	@InputText(nome="Endereco",tamanho=40)
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
