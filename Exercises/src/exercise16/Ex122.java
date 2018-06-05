package exercise16;

public class Ex122 {
	
	final int rank = 1;
	final int suit = 1;
	
    public int compareTo(Card that) {
    	if(this.rank == 1 && that.rank != 1)
    		return 1;
    	else {
    		if (this.suit < that.suit) {
    			return -1;
    		}
    		if (this.suit > that.suit) {
    			return 1;
    		}
    		if (this.rank < that.rank) {
    			return -1;
    		}
    		if (this.rank > that.rank) {
    			return 1;
    		}
    	}
        return 0;
    }

}
