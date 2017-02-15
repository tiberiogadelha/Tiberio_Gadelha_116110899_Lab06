package p2cg;

public class Veterano extends Usuario{

	public Veterano(String nomeUsuario, String nomeLogin) throws Exception {
		super(nomeUsuario, nomeLogin);
		setX2p(1000);
	}
	
	@Override
	public boolean compraJogo(Jogo jogo) {
		if(saldo >= (jogo.getPreco()*0.8)) {
			totalGasto += jogo.getPreco()*0.8;
			saldo -= jogo.getPreco()*0.8;
			bibliotecaDeJogos.add(jogo);
			adicionaX2p(jogo.getPreco() * 15);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getNomeLogin() + FIM_DE_LINHA + getNomeUsuario() +" - Jogador Veterano" + FIM_DE_LINHA + "Lista de Jogos: "+ FIM_DE_LINHA +
				bibliotecaDeJogos.toString() + FIM_DE_LINHA + "Total de preco dos jogos: R$ " + totalGasto + 
					FIM_DE_LINHA + "--------------------------------------------";
	}
	
	

}
