package Clase4;

public class Gambler 
{
	public static int Trials(int s, int g)
	{
		int resultado = 0;
		while(s != 0 && s != g) {
			if(Math.random() < 0.5) {
				s--;
			}else{
				s++;
			}
			if(s == g){
				resultado = 1;
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		int stakeInicial = Integer.parseInt(args[0]);
		int goal = Integer.parseInt(args[1]);
		int trials = Integer.parseInt(args[2]);
		int ganadas = 0;
		int perdidas = 0;
		
		int stake = stakeInicial;
		
		for(int i = 0; i < trials; i++) {
			int resultado = Trials(stake, goal);
			if(resultado == 1){
				ganadas++;
			}
			if(resultado == 0){
				perdidas++;
			}
			stake = stakeInicial;
		}
		
		perdidas = trials - ganadas;
		
		System.out.println("wins: " + ganadas + " and losses: " + perdidas + " of " + trials + " trials");

	}

}
