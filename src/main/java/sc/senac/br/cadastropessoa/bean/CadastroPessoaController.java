package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sc.senac.br.cadastropessoa.dao.DaoGeneric;
import sc.senac.br.cadastropessoa.model.Pessoa;
import sc.senac.br.cadastropessoa.util.UtilDate;

@ViewScoped
@ManagedBean
public class CadastroPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private DaoGeneric<Pessoa> daoGeneric;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		pessoas = new ArrayList<>();
		daoGeneric = new DaoGeneric<>();
		carregarPessoas();
	}

	public void cadastrar() {
		pessoas.add(pessoa);
		daoGeneric.salvar(pessoa);
		limpar();
		carregarPessoas();
	}

	public void limpar() {
		pessoa = new Pessoa();
	}

	public void deletar() {
		daoGeneric.deletar(pessoa);
		carregarPessoas();
	}

	public void carregarPessoas() {
		pessoas = daoGeneric.listarTodos(Pessoa.class);
	}

	public void alterar() {
		daoGeneric.alterar(pessoa);
	}

	public String converteData(Date data) {
		return UtilDate.converteDataParaString(data);
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
