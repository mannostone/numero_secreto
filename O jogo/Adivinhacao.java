import javax.swing.JOptionPane; // Sim, eu quis usar o JOptionPane

public class Adivinhacao {
	
	public static void main(String[] args) {

int loop = 1; // Variável que irá fazer o jogo repetir quantas vezes desejar.
int dificuldade; // variável responsável pela entrada na escolha de dificuldades diferentes.
int seletor; // variável responsável pela escolha da dificuldade.
int numero_secreto = 0; // Número aleatório do jogo.
int total_tentativas = 0; // Total de tentativas restantes no jogo.
int chute = 0; // Responsável por captar o valor digitado.
int vitorias = 0; // Contador de acertos.
int contSecreto = 0; // Contador de números secretos.
int x,y; // Responsáveis pela -> Dificuldade Custom.


while (loop != 0) {
	// Seletor de dificuldade
	dificuldade = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao jogo!\nDigite ( 0 ) para selecionar uma dificuldade diferente ou tecle qualquer número para modo normal: "));

	// Caso seja digitado "nivel" o jogador irá escolher uma dificuldade diferente da padrão 
	if (dificuldade == 0) {
		// Dificuldade padrão será selecionada (Normal) caso jogador entre com qualquer outro valor
		seletor = Integer.parseInt(JOptionPane.showInputDialog("Digite [1] para Fácil\nDigite [2] para Difícil\nDigite [3] para Hardcore\nDigite [4] para Customizar o jogo "));
		        
		// Fácil
		if (seletor == 1) {
			JOptionPane.showMessageDialog (null, "Fácil selecionado.\nNúmeros -> 0-50");
			numero_secreto = (int) (Math.random()*50); // Números de 0-50
			total_tentativas = 5; // Número de tentativas não alterado
			}
		        
		// Dificil 
		else if (seletor == 2) {
			JOptionPane.showMessageDialog(null, "Dificil selecionado.\nNúmeros -> 0-150");
			numero_secreto = (int) (Math.random()*300); // Números de 0-300
			total_tentativas = 5;
			}
		        
		// Hardcore
		else if (seletor == 3) {
			JOptionPane.showMessageDialog(null, "Hardcore selecionado.\nNúmeros -> 0-1000! Boa sorte");
			numero_secreto = (int) (Math.random()*300); // Números de 1-300
			total_tentativas = 5; // Não alterado propositalmente
			}
		
		// Custom Game
		else if (seletor == 4) {
			// "x" equivale ao limite máximo do gerador de números
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite um número limite: "));
			JOptionPane.showMessageDialog(null, "Serão gerados valores de 1 a " + x);
			// "y" equivale ao número de tentativas
			y = Integer.parseInt (JOptionPane.showInputDialog("Digite o número de tentativas desejadas: "));
			JOptionPane.showMessageDialog(null, "Dados salvos, bom jogo!");
		                
			numero_secreto = (int) (Math.random() * x); // Números de 1-?
			total_tentativas = y; // Very Easy mode? Ai não meu consagrado
			}
	
	} // Encerramento do seletor de dificuldades
	
	// Caso o jogador digite qualquer coisa diferente, a dificuldade padrão será selecionada
	else {
		JOptionPane.showMessageDialog(null, "Normal selecionado.\nNúmeros -> 0-100");
		numero_secreto = (int) (Math.random()*100);
		total_tentativas = 5;
		}

	// Jogo
	while (total_tentativas > 0) {
		
		chute = Integer.parseInt(JOptionPane.showInputDialog ("\nVocê tem " + total_tentativas + " tentativas restantes\nDigite um número "));
		JOptionPane.showMessageDialog (null, "Você digitou: " + chute);
		        
		if (numero_secreto == chute) {
			JOptionPane.showMessageDialog (null, "Você acertou o número!\nNúmero secreto:" + numero_secreto);
			vitorias ++; // Contador de vitórias
			break; // Caso acerte, sai do laço while imediatamente
			}
		        
		else if (chute > numero_secreto) JOptionPane.showMessageDialog(null, "Você errou, o seu chute foi maior que o número secreto");
		        
		else if (chute < numero_secreto) JOptionPane.showMessageDialog(null, "Você errou, o seu chute foi menor que o número secreto");
		    
		// Contador de tentativas restantes
		total_tentativas--;
		} // Chave de repetição do jogo
		
		contSecreto++; // contador de números secretos gerados
		// Executado caso o jogador erre o número secreto
		if (numero_secreto != chute) {
			JOptionPane.showMessageDialog (null, "O número secreto era " +  numero_secreto);
			}

	loop = Integer.parseInt(JOptionPane.showInputDialog (null, "Digite ( 0 ) para sair do jogo ou qualquer outro número para jogar de novo"));

} // Chave do laço While de repetição do jogo

		JOptionPane.showMessageDialog (null, "Você adivinhou " + vitorias + " de " + contSecreto + " números secretos!\nFim de jogo.");
		
} // Chave do Main
} // Chave da Classe

