import java.util.ArrayList;
import java.util.Random;


public class AI {
	static int c=0;
	
	Random random=new Random();
	int[][]collectP=new int[8][2];
	int times=0;
	ArrayList<Integer>possible=new ArrayList<Integer>();
	public void choice(int [][]cheeseborad,int f,int s){//<<一開始因應對手區域隨機下棋 1
		if(c<1)
		{
			int first = 0,second=0,fend=0,send=0;
			
			first=f==0?f:f-1;
			second=s==0?s:s-1;
			fend=f<16?f+1:f;
			send=s<16?s+1:s;
			for(int ff=first;ff<=fend;ff++){
				for (int ss=second; ss <= send;ss++) {
					if(ff!=f||ss!=s){
						collectP[times][0]=ff;
						collectP[times][1]=ss;
						times++;
					}
				}
				
			}
			int r=random.nextInt(times);
			cheeseborad[collectP[r][0]][collectP[r][1]]=2;
			
			c++;
		}
		else {
			AttackAndDefend(cheeseborad, 4,2);
		}
		
	}
	
	void AttackAndDefend(int [][]cheeseborad,int judgeNumber,int decideNumber){// 還要寫評估函數 走下3步
		int c1=16;
		int judge=0;int judge2=0;int judge3=0;int judge4=0;int judge5=0;int judge6=0;
		int count =0;
		loop:
		for (int i = 0; i <17; i++) {
			for (int j = 0; j <13; j++) {
				judge=0;judge2=0;			
				if(cheeseborad[i][j]==decideNumber)	judge++;			
				if(cheeseborad[i][j+1]==decideNumber)	judge++;
				if(cheeseborad[i][j+2]==decideNumber)	judge++;
				if(cheeseborad[i][j+3]==decideNumber)	judge++;
				if (cheeseborad[i][j+4]==decideNumber)	judge++;
				
				if(cheeseborad[j][i]==decideNumber)	judge2++;
				if(cheeseborad[j+1][i]==decideNumber)	judge2++;
				if(cheeseborad[j+2][i]==decideNumber)	judge2++;
				if(cheeseborad[j+3][i]==decideNumber)	judge2++;
				if (cheeseborad[j+4][i]==decideNumber)	judge2++;
				
				if(judge>=judgeNumber)
				{
					if(cheeseborad[i][j+4]==0){
						if(decideNumber==2){
							cheeseborad[i][j+4]=2;
							break loop;
						}
						else {
							//possible.add(i);
							//possible.add(j+4);
						}
						count++;
						
					}
								
					
					if(cheeseborad[i][j+3]==0){
						if(decideNumber==2){
							cheeseborad[i][j+3]=2;
							break loop;
						}
						else {
							//possible.add(i);
							//possible.add(j+4);
							
						}
						count++;
						
					}
									
					
					if(cheeseborad[i][j+1]==0){
						if(decideNumber==2){
							cheeseborad[i][j+1]=2;
							break loop;
						}
						else {
							
						}		
						count++;

					}		
					
					if(cheeseborad[i][j+2]==0){
						if (decideNumber==2) {
							cheeseborad[i][j+2]=2;
							break loop;
						}	
						else {
							
						}
						count++;
						
					}
					
					
					if(cheeseborad[i][j]==0){
						if (decideNumber==2) {
							cheeseborad[i][j]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}				
					
					
				}
				if (judge2>=judgeNumber)
				{		
					if(cheeseborad[j+4][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+4][i]=2;
							break loop;
						}
						else {
							
						}
						count++;	
						
					}
											
					
					if(cheeseborad[j+3][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+3][i]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
					
					
					if(cheeseborad[j+1][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+1][i]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
				

					if(cheeseborad[j+2][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+2][i]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
					

					if(cheeseborad[j][i]==0){
						if (decideNumber==2) {
							cheeseborad[j][i]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
						
					
					
				}
			
				
			}
			
		}
		int up=12;int down=0;
		loop:
		for(int s=0;s<13;s++){
			for (int f=0;f<=s;f++){	
				judge3=0;judge4=0;judge5=0;judge6=0;
				if(cheeseborad[up+f][f]==decideNumber)		judge3++;
				if(cheeseborad[up+f+1][f+1]==decideNumber)	judge3++;
				if(cheeseborad[up+f+2][f+2]==decideNumber)	judge3++;
				if(cheeseborad[up+f+3][f+3]==decideNumber)	judge3++;
				if(cheeseborad[up+f+4][f+4]==decideNumber)	judge3++;

				if(cheeseborad[up+f][c1-f]==decideNumber)		judge4++;
				if(cheeseborad[up+f+1][c1-(f+1)]==decideNumber)	judge4++;
				if(cheeseborad[up+f+2][c1-(f+2)]==decideNumber)	judge4++;
				if(cheeseborad[up+f+3][c1-(f+3)]==decideNumber)	judge4++;
				if(cheeseborad[up+f+4][c1-(f+4)]==decideNumber)	judge4++;
				
				if(cheeseborad[down-f][f+4]==decideNumber)		judge5++;
				if(cheeseborad[down+1-f][f+3]==decideNumber)	judge5++;
				if(cheeseborad[down+2-f][f+2]==decideNumber)	judge5++;
				if(cheeseborad[down+3-f][f+1]==decideNumber)	judge5++;
				if(cheeseborad[down+4-f][f]==decideNumber)		judge5++;
				
				if(cheeseborad[down-f][c1-(f+4)]==decideNumber)		judge6++;
				if(cheeseborad[down+1-f][c1-(f+3)]==decideNumber)	judge6++;
				if(cheeseborad[down+2-f][c1-(f+2)]==decideNumber)	judge6++;
				if(cheeseborad[down+3-f][c1-(f+1)]==decideNumber)	judge6++;
				if(cheeseborad[down+4-f][c1-f]==decideNumber)		judge6++;
				//
				if(judge3>=judgeNumber){
					if(cheeseborad[up+f][f]==0){
						if (decideNumber==2) {
							cheeseborad[up+f][f]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
						
					}
					if(cheeseborad[up+f+1][f+1]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+1][f+1]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
					if(cheeseborad[up+f+2][f+2]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+2][f+2]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
					if(cheeseborad[up+f+3][f+3]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+3][f+3]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
					if(cheeseborad[up+f+4][f+4]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+4][f+4]=2;
							break loop;
						}
						else {
							
						}		
						count++;
						
					}
					
				}
				if (judge4>=judgeNumber)//目前這裡有問題
				{
					if(cheeseborad[up+f][c1-f]==0){
						if (decideNumber==2) {
							cheeseborad[up+f][c1-f]=2;
							break loop;
						}
						else {
							
						}
						count++;
						
					}
					if(cheeseborad[up+f+1][c1-(f+1)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+1][c1-(f+1)]=2;
							break loop;
						}
						else{
							
						}			
						count++;
						
					}
					if(cheeseborad[up+f+2][c1-(f+2)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+2][c1-(f+2)]=2;
							break loop;
						}
						else {
							
						}					
						count++;
						
					}
					if(cheeseborad[up+f+3][c1-(f+3)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+3][c1-(f+3)]=2;
							break loop;
						}
						else {
							
						}
						count++;

					}
					if(cheeseborad[up+f+4][c1-(f+4)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+4][c1-(f+4)]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					
				}
				//
				if (judge5>=judgeNumber)
				{
					if(cheeseborad[down-f][f+4]==0){
						if (decideNumber==2) {
							cheeseborad[down-f][f+4]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					if(cheeseborad[down+1-f][f+3]==0){
						if (decideNumber==2) {
							cheeseborad[down+1-f][f+3]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					if(cheeseborad[down+2-f][f+2]==0){
						if (decideNumber==2) {
							cheeseborad[down+2-f][f+2]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					if(cheeseborad[down+3-f][f+1]==0){
						if (decideNumber==2) {
							cheeseborad[down+3-f][f+1]=2;
							break loop;
						}
						else {
							
						}
						count++;

					}
					if(cheeseborad[down+4-f][f]==0){
						if (decideNumber==2) {
							cheeseborad[down+4-f][f]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					
				}
				
				if(judge6>=judgeNumber){
					if(cheeseborad[down-f][c1-(f+4)]==0){
						if(decideNumber==2){
							cheeseborad[down-f][c1-(f+4)]=2;
							break loop;
						}
						else{
							
						}
						count++;
					}
					if(cheeseborad[down+1-f][c1-(f+3)]==0){
						if(decideNumber==2){
							cheeseborad[down+1-f][c1-(f+3)]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					if(cheeseborad[down+2-f][c1-(f+2)]==0){
						if(decideNumber==2){
							cheeseborad[down+2-f][c1-(f+2)]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					if(cheeseborad[down+3-f][c1-(f+1)]==0){
						if(decideNumber==2){
							cheeseborad[down+3-f][c1-(f+1)]=2;
							break loop;
						}
						else {
							
						}
						count++;
					}
					if(cheeseborad[down+4-f][c1-f]==0){
						if(decideNumber==2){
							cheeseborad[down+4-f][c1-f]=2;
							break loop;
						}
						else {
							
						}
						count++;

					}
					
				}			
				

			}
			up--;down++;//--代表往上提升
			
		}
		if (count==0&&decideNumber==2) {
			AttackAndDefend(cheeseborad, 3,1);//防守
		}
		else if (count>0&&decideNumber==1) {
			
		}
		else if (count==0&&decideNumber==1) {
			//把所有可防守性丟到minmax去評估最佳解
		}
		
		
	}
	
	int [][]MinMax(int [][]cheeseborad,ArrayList<Integer>re){//<<經過檢查後 選出最佳步 3 //目前希望把它回傳值做成要下哪一步的參數
		int [][]copyCheeseborad=cheeseborad;
		int half=re.size()/2;
		int z=0,o=1;
		//copyCheeseborad[A1][A2]=2;
		for (int i = 0; i < half; i++){
			copyCheeseborad[re.get(z)][re.get(o)]=2;
			//這裡處理
			z=o+1;o=z+1;
		}
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
