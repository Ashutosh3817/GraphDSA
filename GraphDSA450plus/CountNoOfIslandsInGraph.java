package GraphDSA450plus;

public class CountNoOfIslandsInGraph {
	public static void main(String[] args) {
		int m =8;
		int n=8;
		int[][] arr = {{0,0,1,1,1,1,1,1},
				       {0,0,1,1,1,1,1,1},
				       {1,1,1,1,1,1,1,0},
				       {1,1,0,0,0,1,1,0},
				       {1,1,1,1,0,1,1,0},
				       {1,1,1,1,0,1,1,0},
				       {1,1,1,1,1,1,1,0},
				       {1,1,1,1,1,1,1,0}};
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==0 && visited[i][j]==false) {
					drawTreeComponent(arr,i,j,visited);
					count++;
				}
			}
		}
	    System.out.println(count);
	}
	public static void drawTreeComponent(int[][] arr,int i,int j,boolean[][] visited) {
		if(i<0||j<0||i>=arr.length||j>=arr[0].length||arr[i][j]==1 || visited[i][j]==true) return;
		visited[i][j] = true;
		drawTreeComponent(arr,i-1,j,visited);//north wala neib
		drawTreeComponent(arr,i,j+1,visited);//east
		drawTreeComponent(arr,i,j-1,visited);//west
		drawTreeComponent(arr,i+1,j,visited);//south

	}
}
