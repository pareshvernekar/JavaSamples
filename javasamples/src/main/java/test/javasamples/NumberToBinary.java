package test.javasamples;

public class NumberToBinary {
	
	
	private int getIndex(int n) {
		double i = 0.0;
		if (n == 0)
			return -1;
		while (Math.pow(2.0, i) <= (double)n) {
			i+=1.0;
		}
		return (int)(i-1);
	}
	
	private short[] toBinary(int i) {
		
		short[] binRep = new short[16];
		int size = binRep.length;
		boolean isOdd = Boolean.FALSE;
		int remainder = i;
		int index = 0;
 		for (int j = 0;j < size;j++) {
			binRep[j] = 0;
		}
		if (i == 0)
			return binRep;
		if (i == 1) {
			binRep[1] = 1;
			return binRep;
		}
		while (index >= 0) {
			index = getIndex(remainder);
			if (index != -1)
				binRep[index] = 1;
			remainder = remainder - (int) Math.pow(2.0, index);
			
		}
		
		return binRep;
	}

	public static void main(String[] args) {
		
		NumberToBinary nb = new NumberToBinary();

		int i = 6;		//0111
		short[] binRep = nb.toBinary(i);
		int size = binRep.length;
		for (int j = size-1 ;j >= 0 ;j--) {
			System.out.print(binRep[j]);
			
		}
		
	}

}
