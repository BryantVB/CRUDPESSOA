package CrudGAMELIBRARY;

import java.util.List;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PessoaControl {
	private ObservableList<Pessoa> pessoas = FXCollections.observableArrayList();
	private PessoaDAOImpl dao = new PessoaDAOImpl();
private StringProperty id = new SimpleStringProperty();	
private StringProperty nome = new SimpleStringProperty();
private StringProperty endereco = new SimpleStringProperty();	
private StringProperty telefone = new SimpleStringProperty();
private StringProperty cpf = new SimpleStringProperty();




public StringProperty idProperty() {
	return id;
}
public StringProperty nomeProperty() {
	return nome;
}

public StringProperty enderecoProperty() {
	return endereco;
}
public StringProperty telefoneProperty() {
	return telefone;
}
public StringProperty cpfProperty() {
	return cpf;
}


public void salvar() {
	System.out.println("Id: " + id.get());
	System.out.println("Nome: " + nome.get());
	System.out.println("Endereco: " + endereco.get());
	System.out.println("Telefone: " + telefone.get());
	System.out.println("Cpf: " + cpf.get());
	
	Pessoa p = new Pessoa();
	p.setId(id.get());
	p.setNome(nome.get());
	p.setEndereco(endereco.get());
	p.setTelefone(telefone.get());
	p.setCpf(cpf.get());

	dao.salvar(p);
	pessoas.add(p);
}
public void listar() {
	List<Pessoa> encontrados = dao.listar(nome.get());
	pessoas.clear();
	pessoas.addAll(encontrados);
}
public void Excluir() {
	
	Pessoa p = new Pessoa();
	p.setId(id.get());
	dao.excluir(p);
	
	}

public ObservableList<Pessoa> getPessoa(){
	return pessoas;
}

}