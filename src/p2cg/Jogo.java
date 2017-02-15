package p2cg;

import java.util.HashSet;

public abstract class Jogo {
	public static final String FIM_DE_LINHA = System.lineSeparator();
	private String nomeJogo;
	private int preco;
	protected int bestScore;
	protected int qtdJogado;
	protected int qtdZerado;
	private HashSet<Jogabilidade> jogabilidade;
	private int x2p;
	
	public Jogo(String nomeJogo, int preco) {
		this.nomeJogo = nomeJogo;
		this.setPreco(preco);
		bestScore = 0;
		qtdJogado = 0;
		qtdZerado = 0;
		x2p = 0;
	}
	
	public abstract int registraJogada(int score, boolean zerou) throws Exception;
	
	public String getNomeJogo() {
		return nomeJogo;
	}


	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	
	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	public int getQtdJogado() {
		return qtdJogado;
	}

	public void setQtdJogado(int qtdJogado) {
		this.qtdJogado = qtdJogado;
	}

	public int getQtdZerado() {
		return qtdZerado;
	}


	public String getJogabilidade() {
		return jogabilidade.toString();
	}

	public int getX2p() {
		return x2p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidade == null) ? 0 : jogabilidade.hashCode());
		result = prime * result + ((nomeJogo == null) ? 0 : nomeJogo.hashCode());
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
		Jogo other = (Jogo) obj;
		if (jogabilidade == null) {
			if (other.jogabilidade != null)
				return false;
		} else if (!jogabilidade.equals(other.jogabilidade))
			return false;
		if (nomeJogo == null) {
			if (other.nomeJogo != null)
				return false;
		} else if (!nomeJogo.equals(other.nomeJogo))
			return false;
		return true;
	}


	
	
	
	
	



}
