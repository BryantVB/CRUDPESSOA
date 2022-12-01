package CrudGAMELIBRARY;

import java.util.List;
public interface PessoaDAO {
		void salvar(Pessoa p);
		List<Pessoa> listar(String nome);
	}
