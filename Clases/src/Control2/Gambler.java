package Control2;

public class Gambler {
	public static void main(String[] args) {
		int stakeInicial = Integer.parseInt(args[0]);
		int goal = Integer.parseInt(args[1]);
		int trials = Integer.parseInt(args[2]);
		int ganadas = 0;
		int perdidas = 0;
		
		int stake = stakeInicial;
		
		for(int i = 0; i < trials; i++) {
			while(stake != 0 && stake != goal) {
				if(Math.random() < 0.5) {
					stake--;
				}else{
					stake++;
				}
				if(stake == goal){
					ganadas++;
				}
				if(stake == 0){
					perdidas++;
				}
			}
			stake = stakeInicial;
		}
		
		System.out.println("wins: " + ganadas + " and losses: " + perdidas + " of " + trials + " trials");

	}

}
