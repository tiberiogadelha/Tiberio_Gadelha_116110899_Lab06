package p2cg;

public class RPG extends Jogo {

	public RPG(String nomeJogo, int preco) {
		super(nomeJogo, preco);
	}
	
	@Override
	public int registraJogada(int score, boolean zerou) {
		if (zerou == true) {
			qtdZerado++;
		}
		if (score > bestScore) {
			bestScore = score;
		}
		qtdJogado++;
		return 10;
	}
	
	@Override
	public String toString() {
		return FIM_DE_LINHA + "+ " + getNomeJogo() + " - RPG:" + FIM_DE_LINHA +  "==> Jogou " + qtdJogado + " vez(es)" + 
	FIM_DE_LINHA  + "==> Zerou " + qtdZerado + " vez(es)" + FIM_DE_LINHA + "==> Maior score: " + bestScore;
	}
	

}
