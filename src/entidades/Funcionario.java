package entidades;

public class Funcionario {

	protected String nome;
	protected String cpf;
	protected int permissao;
	protected double salario;
	protected String senhaAcesso;
	
	public Funcionario(String nome, String cpf, String senhaAcesso) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.senhaAcesso = senhaAcesso;
		
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getPermissao() {
		return permissao;
	}


	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public String getSalario() {
		return String.format("%.2f", salario);
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getSenhaAcesso() {
		return senhaAcesso;
	}


	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}
	


	
	// geral
	
	public class Geral extends Funcionario {
		
		protected double salario;
		protected int permissao;
		
		public Geral(String nome, String cpf, String senhaAcesso) {
			super(nome, cpf, senhaAcesso);
			this.permissao = 1;
			this.salario = 2000;
			
		}
		
		@Override
		public int getPermissao() {
			return permissao;
		}
	}
	
	// gerente
	
	public class Gerente extends Funcionario {
		
		protected double salario;
		protected int permissao;
		
		public Gerente(String nome, String cpf, String senhaAcesso) {
			super(nome, cpf, senhaAcesso);
			this.permissao = 2;
			this.salario = 3000;
			
		}
		
		@Override
		public int getPermissao() {
			return permissao;
		}
	}
	
	// diretor
	
	public class Diretor extends Funcionario {
		
		protected double salario;
		protected int permissao;
		
		public Diretor(String nome, String cpf, String senhaAcesso) {
			super(nome, cpf, senhaAcesso);
			this.permissao = 3;
			this.salario = 8000;
			
		}
		
		@Override
		public int getPermissao() {
			return permissao;
		}
	}
	
	// admin
	
	public class Admin extends Funcionario {
		
		protected int permissao;
		
		public Admin(String nome, String cpf, String senhaAcesso) {
			super(nome, cpf, senhaAcesso);
			this.permissao = 4;
			this.salario = 0;
			
		}
		
		@Override
		public int getPermissao() {
			return permissao;
		}
	}
	
	
}
