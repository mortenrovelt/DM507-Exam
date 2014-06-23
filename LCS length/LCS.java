/**
 * 
 * @author Claus
 *
 *	Programmet kan finde LCS length ud fra en streng. Den finder den længste
 *	delstreng af to strenge og indtegner i tabel. ^ betyder pil op, \ betyder 
 *	pil skråt op, < betyder pil venstre.
 */

public class LCS {

	public static void main(String[] args) {
		String x = "ABCBDAB";
		String y = "BDCABA";
		int m = x.length();
		int n = y.length();
		String[][] b = new String[m+1][n+1];
		int[][] c = new int[m+1][n+1];
		for (int i=0; i<=m;i++){
			c[i][0]=0;
			b[i][0]=" ";
		}
		for (int j=0; j<=n;j++){
			c[0][j]=0;
			b[0][j]=" ";
		}
		for (int i = 1; i<=m;i++){
			for (int j = 1; j<=n;j++){
				if (x.charAt(i-1)==y.charAt(j-1)){
					c[i][j] = c[i-1][j-1]+1;
					b[i][j] = "\\";
				}
				else if (c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i][j] = "^";
				}
				else{
					c[i][j] = c[i][j-1];
					b[i][j] = "<";
				}
			}
		}
		printtable(c, m+1, n+1);
		System.out.println("");
		printtableS(b, m+1, n+1);
	}
	
	public static void printtable (int[][] table,int tablesizex, int tablesizey){
		for (int row=0; row<tablesizex;row++){
			for (int col=0; col<tablesizey;col++){
				System.out.print(" | " +table[row][col]);
			}
			System.out.println(" |");
			System.out.println(" -----------------------------");
		}
	}
	public static void printtableS (String[][] table,int tablesizex, int tablesizey){
		for (int row=0; row<tablesizex;row++){
			for (int col=0; col<tablesizey;col++){
				System.out.print(" | " +table[row][col]);
			}
			System.out.println(" |");
			System.out.println(" ----------------------------");
		}
	}

}
