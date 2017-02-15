package p2cg;

import java.util.HashSet;

public abstract class Usuario {
	public static final String FIM_DE_LINHA = System.lineSeparator();
	private String nomeUsuario;
	private String nomeLogin;
	protected int saldo;
	protected HashSet<Jogo> bibliotecaDeJogos;
	private int x2p;
	protected int totalGasto;
	
	public Usuario(String nomeUsuario, String nomeLogin) throws Exception{
		if (nomeUsuario.trim().equals("") || nomeUsuario == null) {
			throw new Exception("O nome do usuario nao pode ser nulo ou vazio.");
		}
		if (nomeLogin.trim().equals("") || nomeLogin == null) {
			throw new Exception("O nome do login nao pode ser nulo ou vazio.");
		}
		this.nomeUsuario = nomeUsuario;
		this.nomeLogin= nomeLogin;
		saldo = 0;
		setX2p(0);
		totalGasto = 0;
		bibliotecaDeJogos = new HashSet<>();
		
	}
	
	public void creditaConta(int valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Nao pode colocar uma quantidade negativa de credito");
		}
		saldo += valor;
				
	}
	
	public abstract boolean compraJogo(Jogo jogo);
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception {
		Jogo jogo = procuraJogo(nomeDoJogo);
		if (!(jogo == null)) {
			x2p += procuraJogo(nomeDoJogo).registraJogada(score, zerou);
		}
		
	}
	
	public Jogo procuraJogo(String nomeDoJogo) {
		for (Jogo jogoProcurado: bibliotecaDeJogos) {
			if (jogoProcurado.getNomeJogo().equals(nomeDoJogo)) {
				return jogoProcurado;
			}
		}
		return null;
	}
	
	protected void adicionaX2p(int qtd) {
		x2p += qtd;
	}

	public int getSaldo() {
		return saldo;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public HashSet<Jogo> getBibliotecaDeJogos() {
		return bibliotecaDeJogos;
	}

	public void setBibliotecaDeJogos(HashSet<Jogo> bibliotecaDeJogos) {
		this.bibliotecaDeJogos = bibliotecaDeJogos;
	}
	
	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeLogin == null) ? 0 : nomeLogin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nomeLogin == null) {
			if (other.nomeLogin != null)
				return false;
		} else if (!nomeLogin.equals(other.nomeLogin))
			return false;
		return true;
	}

	

	

}
