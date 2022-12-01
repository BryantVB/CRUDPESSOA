package CrudGAMELIBRARY;

public class Pessoa {
	private String Id;
	private String nome;
	private String Endereco;
	private String telefone;
	private String cpf;

	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return Endereco;
	}
  public void setEndereco(String endereco) {
	Endereco = endereco;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}


}