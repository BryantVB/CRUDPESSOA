package CrudGAMELIBRARY;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PessoaBoundary extends Application{
	private Label lblId = new Label("Id: ");
	private Label lblNome = new Label("Nome: ");
	private Label lblEndereco = new Label("Endereco: ");
	private Label lblTelefone = new Label("Telefone: ");
	private Label lblCpf = new Label("Cpf: ");

	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtEndereco = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtCpf = new TextField();
	private Button btnSalvar = new Button("Salvar");
	private Button btnListar = new Button("Listar");
	private Button btnExcluir = new Button("Excluir");
	private PessoaControl control = new PessoaControl();
	private TableView<Pessoa> table = new TableView<>();
			

	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane(); 
		GridPane grid = new GridPane(); 
		principal.setTop(grid); 
		principal.setCenter(table); 
		Scene scn = new Scene(principal, 500,400); 
		
		grid.add(lblId, 0, 0);
		grid.add(lblNome, 0, 1);
		grid.add(lblEndereco, 0, 2);
		grid.add(lblTelefone, 0, 3);
		grid.add(lblCpf, 0, 4);
	
		
		grid.add(txtId, 1, 0);
		grid.add(txtNome, 1, 1);
		grid.add(txtEndereco, 1, 2);
		grid.add(txtTelefone, 1, 3);
		grid.add(txtCpf, 1, 4);

		
		grid.add(btnSalvar, 0, 7);
		grid.add(btnListar, 1, 7);
		grid.add(btnExcluir, 2, 7);
		
		Bindings.bindBidirectional(control.idProperty(), txtId.textProperty());
		Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
        Bindings.bindBidirectional(control.enderecoProperty(), txtEndereco.textProperty());
        Bindings.bindBidirectional(control.telefoneProperty(), txtTelefone.textProperty());
        Bindings.bindBidirectional(control.cpfProperty(), txtCpf.textProperty());
  
      
        
        TableColumn<Pessoa, String> col1 = new TableColumn<>("ID");
		col1.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Pessoa, String> col2 = new TableColumn<>("Nome");
		col2.setCellValueFactory(new PropertyValueFactory<>("nome"));
				
		TableColumn<Pessoa, String> col3 = new TableColumn<>("Endereco");
		col3.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		
		TableColumn<Pessoa, String> col4 = new TableColumn<>("Telefone");
		col4.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		
		TableColumn<Pessoa, String> col5 = new TableColumn<>("Cpf");
		col5.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
		
	
		
		table.getColumns().addAll(col1, col2, col3, col4, col5);
		
		table.setItems(control.getPessoa());
		btnSalvar.setOnAction((e) -> {
			control.salvar();
		});
		
		btnListar.setOnAction((e) -> {
			control.listar();
		});
		btnExcluir.setOnAction((e) -> {
			control.Excluir();
		});
		
		stage.setScene(scn); 
		stage.setTitle("Cadastrar Pessoas"); 
		stage.show(); 
	}
	public static void main(String[] args) {
		Application.launch(PessoaBoundary.class, args);
	}


}
