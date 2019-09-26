package sc.senac.br.cadastropessoa.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sc.senac.br.cadastropessoa.model.Pessoa;

@ViewScoped
@ManagedBean
public class CadastroPessoaController {

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public void cadastrar() {
		pessoas.add(pessoa);
		pessoa = new Pessoa();
	}

	public void limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
