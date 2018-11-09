import java.util.Random;


public class AI {
	static int c=0;
	Random random=new Random();
	public void choice(int [][]cheeseborad){//<<一開始因應對手區域隨機下棋 1
		if(c<4){
			c=c==3?4:c;
			cheeseborad[c][16-c]=2;
			c++;
		}
		else {
			Attack(cheeseborad);
		}
		
	}
	
	void Attack(int [][]cheeseborad){// 還要寫評估函數 走下3步
		int c1=16;
		int judge=0;int judge2=0;int judge3=0;int judge4=0;
		int count =0;
		loop:
		for (int i = 0; i <17; i++) {
			for (int j = 0; j <13; j++) {
				judge=0;judge2=0;			
				if(cheeseborad[i][j]==2)	judge++;			
				if(cheeseborad[i][j+1]==2)	judge++;
				if(cheeseborad[i][j+2]==2)	judge++;
				if(cheeseborad[i][j+3]==2)	judge++;
				if (cheeseborad[i][j+4]==2)	judge++;
				
				if(cheeseborad[j][i]==2)	judge2++;
				if(cheeseborad[j+1][i]==2)	judge2++;
				if(cheeseborad[j+2][i]==2)	judge2++;
				if(cheeseborad[j+3][i]==2)	judge2++;
				if (cheeseborad[j+4][i]==2)	judge2++;
				
				if(judge==4)
				{
					if(cheeseborad[i][j+4]==0){
						cheeseborad[i][j+4]=2;
						count++;
						break loop;
					}
								
					
					else if(cheeseborad[i][j+3]==0){
						cheeseborad[i][j+3]=2;
						count++;
						break loop;
					}
									
					
					else if(cheeseborad[i][j+1]==0){
						cheeseborad[i][j+1]=2;
						count++;
						break loop;
					}		
					
					else if(cheeseborad[i][j+2]==0){
						cheeseborad[i][j+2]=2;
						count++;
						break loop;
					}
					
					
					else if(cheeseborad[i][j]==0){
						cheeseborad[i][j]=2;
						count++;
						break loop;
					}
						
					
					
				}
				else if (judge2==4)
				{		
					if(cheeseborad[j+4][i]==0){
						cheeseborad[j+4][i]=2;
						count++;	
						break loop;
					}
											
					
					else if(cheeseborad[j+3][i]==0){
						cheeseborad[j+3][i]=2;
						count++;
						break loop;
					}
					
					
					else if(cheeseborad[j+1][i]==0){
						cheeseborad[j+1][i]=2;
						count++;
						break loop;
					}
				

					else if(cheeseborad[j+2][i]==0){
						cheeseborad[j+2][i]=2;
						count++;
						break loop;
					}
					

					else if(cheeseborad[j][i]==0){
						cheeseborad[j][i]=2;
						count++;
						break loop;
					}
						
					
					
				}
			
				
			}
			
		}
		int up=12;
		loop:
		for(int s=0;s<13;s++){
			for (int f=0;f<=s;f++){	
				judge3=0;judge4=0;
				if(cheeseborad[up][f]==2)	judge3++;
				if(cheeseborad[1+up][f+1]==2)	judge3++;
				if(cheeseborad[up+2][f+2]==2)	judge3++;
				if(cheeseborad[up+3][f+3]==2)	judge3++;
				if(cheeseborad[up+4][f+4]==2)	judge3++;

				if(cheeseborad[up][c1-f]==2)	judge4++;
				if(cheeseborad[up+1][c1-(f+1)]==2)	judge4++;
				if(cheeseborad[up+2][c1-(f+2)]==2)	judge4++;
				if(cheeseborad[up+3][c1-(f+3)]==2)	judge4++;
				if(cheeseborad[up+4][c1-(f+4)]==2)	judge4++;
				if(judge3>=3){
					if(cheeseborad[up][f]==0){
						cheeseborad[up][f]=2;
						count++;
						break loop;
						
					}
					else if(cheeseborad[up+1][f+1]==0){
						cheeseborad[up+1][f+1]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+2][f+2]==0){
						cheeseborad[up+2][f+2]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+3][f+3]==0){
						cheeseborad[up+3][f+3]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+4][f+4]==0){
						cheeseborad[up+4][f+4]=2;
						count++;
						break loop;
					}
					
				}
				else if (judge4>=3)//目前這裡有問題
				{
					if(cheeseborad[up][c1-f]==0){
						cheeseborad[up][c1-f]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+1][c1-(f+1)]==0){
						cheeseborad[up+1][c1-(f+1)]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+2][c1-(f+2)]==0){
						cheeseborad[up+2][c1-(f+2)]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+3][c1-(f+3)]==0){
						cheeseborad[up+3][c1-(f+3)]=2;
						count++;
						break loop;
					}
					else if(cheeseborad[up+4][c1-(f+4)]==0){
						cheeseborad[up+4][c1-(f+4)]=2;
						count++;
						break loop;
					}
					
				}
				
			
				
				
				

			}
			up--;//--代表往上提升
			
		}
		if (count==0) {
			Defend(cheeseborad);
		}
		
		
	}
	void Defend(int [][]cheeseborad)//防守 跟防守後都需要minmax 而which可以假設下在哪一步而去推論
	{
		
		
	}
	int [][]MinMax(int [][]cheeseborad,int A1,int A2){//<<經過檢查後 選出最佳步 3 //目前希望把它回傳值做成要下哪一步的參數
		int [][]copyCheeseborad=cheeseborad;
		copyCheeseborad[A1][A2]=2;
		return cheeseborad;
	}
	int	[][] Min(int [][]cheeseborad,int add){
		return cheeseborad;
	}
	int [][]Max(int [][]cheeseborad,int reduce)
	{
		return cheeseborad;
	}
	

}
