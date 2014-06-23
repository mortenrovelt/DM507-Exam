/**
 * svar på opgave 7a i juni 2013, kan bruges til andre tabeller også.
 * Blot ret tablesizex og y og pristabellen, så ordnet resten selv
*/

public class OpstilTabel {
	public static void main(String[] args) {
		int tablesizex = 4;
		int tablesizey = 4;
		int [ ] [ ] price = {   
				{ 1, 2, 3, 4 },
                { 2, 5, 7, 9 },
                { 3, 8, 10, 12 },
                { 5, 8, 17, 20 }
            };
		
		System.out.print("Price table \n \n");
		printtable(price,tablesizex,tablesizey);
		
		int[][] maxprice = new int[tablesizex][tablesizey];
		
		for (int i = 0; i<tablesizex;i++){
			for (int j=0;j<tablesizey;j++){
				int max = price[i][j];
				if (i==0 && j>0){
					for (int t=0;t<j;t++){
						if (maxprice[i][t]+maxprice[i][j-t-1] > max)
							max = maxprice[i][t]+maxprice[i][j-t-1];
					}
				}
				else if (i>0 && j==0){
					for (int s=0;s<i;s++){
						if (maxprice[s][j]+maxprice[i-s-1][j] > max)
							max = maxprice[s][j]+maxprice[i-s-1][j];
					}
				}
				else if (i>0 && j>0){
					for (int t=0;t<j;t++){
						if (maxprice[i][t]+maxprice[i][j-t-1] > max)
							max = maxprice[i][t]+maxprice[i][j-t-1];
					}
					for (int s=0;s<i;s++){
						if (maxprice[s][j]+maxprice[i-s-1][j] > max)
							max = maxprice[s][j]+maxprice[i-s-1][j];
					}
				}
			maxprice[i][j] = max;	
			}
		}
		
		System.out.print("\n Max price table \n \n");
		printtable(maxprice,tablesizex,tablesizey);
			
	}
	
	public static void printtable (int[][] price,int tablesizex, int tablesizey){
		for (int row=0; row<tablesizex;row++){
			for (int col=0; col<tablesizey;col++){
				System.out.print(" | " +price[row][col]);
			}
			System.out.println(" |");
			System.out.println(" ------------------");
		}
	}

}
