import javax.swing.JOptionPane; // Sim, eu quis usar o JOptionPane

public class Adivinhacao {
	
	public static void main(String[] args) {

int loop = 1; // Vari�vel que ir� fazer o jogo repetir quantas vezes desejar.
int dificuldade; // vari�vel respons�vel pela entrada na escolha de dificuldades diferentes.
int seletor; // vari�vel respons�vel pela escolha da dificuldade.
int numero_secreto = 0; // N�mero aleat�rio do jogo.
int total_tentativas = 0; // Total de tentativas restantes no jogo.
int chute = 0; // Respons�vel por captar o valor digitado.
int vitorias = 0; // Contador de acertos.
int contSecreto = 0; // Contador de n�meros secretos.
int x,y; // Respons�veis pela -> Dificuldade Custom.


while (loop != 0) {
	// Seletor de dificuldade
	dificuldade = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao jogo!\nDigite ( 0 ) para selecionar uma dificuldade diferente ou tecle qualquer n�mero para modo normal: "));

	// Caso seja digitado "nivel" o jogador ir� escolher uma dificuldade diferente da padr�o 
	if (dificuldade == 0) {
		// Dificuldade padr�o ser� selecionada (Normal) caso jogador entre com qualquer outro valor
		seletor = Integer.parseInt(JOptionPane.showInputDialog("Digite [1] para F�cil\nDigite [2] para Dif�cil\nDigite [3] para Hardcore\nDigite [4] para Customizar o jogo "));
		        
		// F�cil
		if (seletor == 1) {
			JOptionPane.showMessageDialog (null, "F�cil selecionado.\nN�meros -> 0-50");
			numero_secreto = (int) (Math.random()*50); // N�meros de 0-50
			total_tentativas = 5; // N�mero de tentativas n�o alterado
			}
		        
		// Dificil 
		else if (seletor == 2) {
			JOptionPane.showMessageDialog(null, "Dificil selecionado.\nN�meros -> 0-150");
			numero_secreto = (int) (Math.random()*300); // N�meros de 0-300
			total_tentativas = 5;
			}
		        
		// Hardcore
		else if (seletor == 3) {
			JOptionPane.showMessageDialog(null, "Hardcore selecionado.\nN�meros -> 0-1000! Boa sorte");
			numero_secreto = (int) (Math.random()*300); // N�meros de 1-300
			total_tentativas = 5; // N�o alterado propositalmente
			}
		
		// Custom Game
		else if (seletor == 4) {
			// "x" equivale ao limite m�ximo do gerador de n�meros
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero limite: "));
			JOptionPane.showMessageDialog(null, "Ser�o gerados valores de 1 a " + x);
			// "y" equivale ao n�mero de tentativas
			y = Integer.parseInt (JOptionPane.showInputDialog("Digite o n�mero de tentativas desejadas: "));
			JOptionPane.showMessageDialog(null, "Dados salvos, bom jogo!");
		                
			numero_secreto = (int) (Math.random() * x); // N�meros de 1-?
			total_tentativas = y; // Very Easy mode? Ai n�o meu consagrado
			}
	
	} // Encerramento do seletor de dificuldades
	
	// Caso o jogador digite qualquer coisa diferente, a dificuldade padr�o ser� selecionada
	else {
		JOptionPane.showMessageDialog(null, "Normal selecionado.\nN�meros -> 0-100");
		numero_secreto = (int) (Math.random()*100);
		total_tentativas = 5;
		}

	// Jogo
	while (total_tentativas > 0) {
		
		chute = Integer.parseInt(JOptionPane.showInputDialog ("\nVoc� tem " + total_tentativas + " tentativas restantes\nDigite um n�mero "));
		JOptionPane.showMessageDialog (null, "Voc� digitou: " + chute);
		        
		if (numero_secreto == chute) {
			JOptionPane.showMessageDialog (null, "Voc� acertou o n�mero!\nN�mero secreto:" + numero_secreto);
			vitorias ++; // Contador de vit�rias
			break; // Caso acerte, sai do la�o while imediatamente
			}
		        
		else if (chute > numero_secreto) JOptionPane.showMessageDialog(null, "Voc� errou, o seu chute foi maior que o n�mero secreto");
		        
		else if (chute < numero_secreto) JOptionPane.showMessageDialog(null, "Voc� errou, o seu chute foi menor que o n�mero secreto");
		    
		// Contador de tentativas restantes
		total_tentativas--;
		} // Chave de repeti��o do jogo
		
		contSecreto++; // contador de n�meros secretos gerados
		// Executado caso o jogador erre o n�mero secreto
		if (numero_secreto != chute) {
			JOptionPane.showMessageDialog (null, "O n�mero secreto era " +  numero_secreto);
			}

	loop = Integer.parseInt(JOptionPane.showInputDialog (null, "Digite ( 0 ) para sair do jogo ou qualquer outro n�mero para jogar de novo"));

} // Chave do la�o While de repeti��o do jogo

		JOptionPane.showMessageDialog (null, "Voc� adivinhou " + vitorias + " de " + contSecreto + " n�meros secretos!\nFim de jogo.");
		
} // Chave do Main
} // Chave da Classe

