package entidades;

public class Cliente {

	private String nomeTitular;
	private String cpfTitular;
	private String idadeTitular;
	private int pessoas;
	private int numeroQuarto;
	private boolean hospedado;
	private double diariaQuarto;
	private Funcionario funcionario;

	public Cliente (String nomeTitular, String cpfTitular, String idadeTitular, int pessoas, 
			int numeroQuarto, boolean status, Funcionario funcionario) {
		
		this.nomeTitular = nomeTitular;
		this.cpfTitular = cpfTitular;
		this.idadeTitular = idadeTitular;
		this.pessoas = pessoas;
		this.numeroQuarto = numeroQuarto;
		this.hospedado = false;
		this.funcionario = funcionario;
	}
	
	
	// getters e setters
	public Funcionario getFuncionario() {
		return this.funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	public String getIdadeTitular() {
		return idadeTitular;
	}
	public void setIdadeTitular(String idadeTitular) {
		this.idadeTitular = idadeTitular;
	}
	public int getPessoas() {
		return pessoas;
	}
	public void setPessoas(int pessoas) {
		this.pessoas = pessoas;
	}
	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public double getDiariaQuarto() {
		return diariaQuarto;
	}
	public void setDiariaQuarto(double valorFinal) {
		this.diariaQuarto = valorFinal;
	}
	public void setHospedagem(boolean status) {
		this.hospedado = status;
	}
	public boolean getHospedagem() {
		return hospedado;
	}
}
