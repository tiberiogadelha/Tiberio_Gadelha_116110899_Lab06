package p2cg;

public class Noob extends Usuario{

	public Noob(String nomeUsuario, String nomeLogin) throws Exception {
		super(nomeUsuario, nomeLogin);
	}
	
	@Override
	public boolean compraJogo(Jogo jogo) {
		if(procuraJogo(jogo.getNomeJogo()) == null) {
			if(saldo >= (jogo.getPreco()*0.9)) {
				totalGasto += jogo.getPreco()*0.9;
				saldo -= jogo.getPreco()*0.9;
				bibliotecaDeJogos.add(jogo);
				adicionaX2p(jogo.getPreco() * 10);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getNomeLogin() + FIM_DE_LINHA + getNomeUsuario() +" - Jogador Noob" + FIM_DE_LINHA + "Lista de Jogos: "+ FIM_DE_LINHA +
				bibliotecaDeJogos.toString() + FIM_DE_LINHA + "Total de preco dos jogos: R$ " + totalGasto + 
					FIM_DE_LINHA + "--------------------------------------------";
	}
	

}
