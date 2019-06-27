package pd.server.hashmap;

import java.io.Serializable;

public class RecordRegistro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, indirizzo;

	public RecordRegistro(String n, String i) {
		nome = n;
		indirizzo = i;
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
}
