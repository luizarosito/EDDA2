package br.edu.ifsp.spo.edda.map;
import java.util.ArrayList;
import java.util.List;


public class Mapa {
		
private List<Associacao> associacoes = new ArrayList<Associacao>();
	public void insere(String cpf, Pessoa pessoa) {
		if (!this.contemChave(cpf)) {
			Associacao associacao = new Associacao(cpf, pessoa);
			this.associacoes.add(associacao);
		}
	}

	public Pessoa seleciona(String cpf) {
		for (Associacao associacao : this.associacoes) {
			if (cpf.equals(associacao.getCpf())) {
				return associacao.getPessoa();
			}
		}
		throw new IllegalArgumentException("chave não existe");
	}
	
	public void remover(String cpf) {
		if (this.contemChave(cpf)) {
			for (int i = 0; i < this.associacoes.size(); i++) {
				Associacao associacao = this.associacoes.get(i);
				if (cpf.equals(associacao.getCpf())) {
						this.associacoes.remove(i);
						break;
				}
			}
		} else {
			throw new IllegalArgumentException("chave não existe");
		}
	}
	
	public boolean contemChave(String cpf) {
		for (Associacao associacao : this.associacoes) {
			if (cpf.equals(associacao.getCpf())) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return this.associacoes.size();
	}
	
	
}

