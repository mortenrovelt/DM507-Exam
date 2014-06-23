/**
 * @author Claus
 * LP-iterativ kan finde længste del palindrom af et ord
 */

public class LPIterativ {

	public static void main(String[] args) {
		String x = "ALLAN";
		int m = x.length();
		int[][] table = new int[m][m];
		//Udfylder diagonalen
		for (int i=0; i<m;i++){
			table[i][i]= 1;
		}
		
		for (int i=m-1; i>=0;i--){
			for (int j=i+1; j<m;j++){
				if (x.charAt(i)==x.charAt(j)){
					table[i][j]=2+table[i+1][j-1];
				} else{
					table[i][j]=Math.max(table[i+1][j],table[i][j-1]);
				}
				
			}
		}
		System.out.println("Længste palindrom i "+x+ " er: "+table[0][m-1]+"\n");
		printtable(table, m, m);
		System.out.println("\n Køretiden er O(n^2) og pladsforbruget er ligeledes O(n^2)");
	}
	
	public static void printtable (int[][] table,int tablesizex, int tablesizey){
		for (int row=0; row<tablesizex;row++){
			for (int col=0; col<tablesizey;col++){
				System.out.print(" | " +table[row][col]);
			}
			System.out.println(" |");
			System.out.println(" -----------------------");
		}
	}

}
