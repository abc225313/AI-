import java.util.ArrayList;
import java.util.Random;


public class AI {
	private static int c=0;
	Random random=new Random();
	private int[][]collectP=new int[8][2];
	private int times=0;
	private int [][]cheeseborad;
	ArrayList<Integer>possible=new ArrayList<Integer>();
	
	public AI(int [][]cheeseborad){
		this.cheeseborad=cheeseborad;
	}
	public void choice(int f,int s){//<<一開始因應對手區域隨機下棋 1
		if(c<0)
		{
			int first = 0,second=0,fend=0,send=0;	
			first=f==0?f:f-1;
			second=s==0?s:s-1;
			fend=f<16?f+1:f;
			send=s<16?s+1:s;
			for(int ff=first;ff<=fend;ff++){
				for (int ss=second; ss <= send;ss++) {
					if(cheeseborad[ff][ss]==0){
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
			AttackAndDefend(4,2);
		}
		
	}
	static boolean avoid(int decide,int a,int b,int [][]cheeseborad){
		a=a<1?1:a;
		a=a>15?15:a;
		b=b<1?1:b;
		b=b>15?15:b;
		if(decide==1){
			if(cheeseborad[a][b+1]!=2&&cheeseborad[a][b-1]!=2){
				return true;
			}
		}
		else {
			if(cheeseborad[a+1][b]!=2&&cheeseborad[a-1][b]!=2){
				return true;
			}
		}
		
		return false;
	}
	
	void AttackAndDefend(int judgeNumber,int decideNumber){// 還要寫評估函數 走下3步
		int c1=16;
		int judge=0;int judge2=0;int judge3=0;int judge4=0;int judge5=0;int judge6=0;
		int count =0;
		loop:
		for (int i = 0; i <17; i++) {
			for (int j = 0; j <13; j++) {
				judge=0;judge2=0;			
				if(cheeseborad[i][j]==decideNumber)		judge++;			
				if(cheeseborad[i][j+1]==decideNumber)	judge++;
				if(cheeseborad[i][j+2]==decideNumber)	judge++;
				if(cheeseborad[i][j+3]==decideNumber)	judge++;
				if (cheeseborad[i][j+4]==decideNumber)	judge++;
				
				if(cheeseborad[j][i]==decideNumber)		judge2++;
				if(cheeseborad[j+1][i]==decideNumber)	judge2++;
				if(cheeseborad[j+2][i]==decideNumber)	judge2++;
				if(cheeseborad[j+3][i]==decideNumber)	judge2++;
				if (cheeseborad[j+4][i]==decideNumber)	judge2++;
				
				if(judge>=judgeNumber)//左右
				{
					if(cheeseborad[i][j+4]==0){
						if(decideNumber==2){
							cheeseborad[i][j+4]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(1, i, j+4, cheeseborad)){
								if(j+4==16){
									if(cheeseborad[i][j+3]!=2&&cheeseborad[i][j+2]!=2&&cheeseborad[i][j+1]!=2&&cheeseborad[i][j]!=2){
										possible.add(i);
										possible.add(j+4);
										count++;
									}
									
								}
								else {
									possible.add(i);
									possible.add(j+4);
									count++;
								}
								
							}
							
						}
						
						
					}
								
					
					if(cheeseborad[i][j+3]==0){
						if(decideNumber==2){
							cheeseborad[i][j+3]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(1, i, j+3, cheeseborad)){
								possible.add(i);
								possible.add(j+3);
								count++;
							}
													
						}
						
						
					}
									
					
					if(cheeseborad[i][j+2]==0){
						if(decideNumber==2){
							cheeseborad[i][j+2]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(1, i, j+2, cheeseborad)){
								possible.add(i);
								possible.add(j+2);
								count++;
							}
						}		
						

					}		
					
					if(cheeseborad[i][j+1]==0){
						if (decideNumber==2) {
							cheeseborad[i][j+1]=2;
							count++;
							break loop;
						}	
						else{
							if(avoid(1, i, j+1, cheeseborad)){
								possible.add(i);
								possible.add(j+1);
								count++;
							}			
							
						}
						
					}
					
					
					if(cheeseborad[i][j]==0){
						if (decideNumber==2) {
							cheeseborad[i][j]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(1, i, j, cheeseborad)){
								possible.add(i);
								possible.add(j);
								count++;
							}					
						}
						
					}				
					
					
				}
				if (judge2>=judgeNumber)//上下
				{		
					if(cheeseborad[j+4][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+4][i]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(2, j+4, i, cheeseborad)){
								if(j+4==16){
									if(cheeseborad[j+3][i]!=2&&cheeseborad[j+2][i]!=2&&cheeseborad[j+1][i]!=2&&cheeseborad[j][i]!=2){
										possible.add(j+4);
										possible.add(i);
										count++;
									}
								}
								else {
									possible.add(j+4);
									possible.add(i);
									count++;
								}
								
								
							}
							
						}
						
					}
											
					
					if(cheeseborad[j+3][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+3][i]=2;
							count++;
							break loop;
						}
						else{
							if(avoid(2, j+3, i, cheeseborad)){
								possible.add(j+3);
								possible.add(i);
								count++;
							}				
							
						}
						
					}
					
					
					if(cheeseborad[j+2][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+2][i]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(2, j+2, i, cheeseborad)){
								possible.add(j+2);
								possible.add(i);
								count++;
							}				
						}
						
					}
				

					if(cheeseborad[j+1][i]==0){
						if (decideNumber==2) {
							cheeseborad[j+1][i]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(2, j+1, i, cheeseborad)){
								possible.add(j+1);
								possible.add(i);
								count++;
							}					
							
						}
						
					}
					

					if(cheeseborad[j][i]==0){
						if (decideNumber==2) {
							cheeseborad[j][i]=2;
							count++;
							break loop;
						}
						else {
							if(avoid(2, j, i, cheeseborad)){
								possible.add(j);
								possible.add(i);
								count++;
							}				
						}
						
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
							count++;
							break loop;
						}
						else {
							/*possible.add(up+f);
							possible.add(f);*/
							count++;
						}
						
						
						
					}
					if(cheeseborad[up+f+1][f+1]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+1][f+1]=2;
							count++;
							break loop;
						}
						else {
							possible.add(up+f+1);
							possible.add(f+1);
							count++;
						}
						
						
					}
					if(cheeseborad[up+f+2][f+2]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+2][f+2]=2;
							count++;
							break loop;
						}
						else {
							possible.add(up+f+2);
							possible.add(f+2);
							count++;
							
						}
						
						
					}
					if(cheeseborad[up+f+3][f+3]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+3][f+3]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
						
					}
					if(cheeseborad[up+f+4][f+4]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+4][f+4]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}		
						
						
					}
					
				}
				if (judge4>=judgeNumber)
				{
					if(cheeseborad[up+f][c1-f]==0){
						if (decideNumber==2) {
							cheeseborad[up+f][c1-f]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
						
					}
					if(cheeseborad[up+f+1][c1-(f+1)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+1][c1-(f+1)]=2;
							count++;
							break loop;
						}
						else{
							count++;
						}			
						
						
					}
					if(cheeseborad[up+f+2][c1-(f+2)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+2][c1-(f+2)]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}					
						
						
					}
					if(cheeseborad[up+f+3][c1-(f+3)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+3][c1-(f+3)]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						

					}
					if(cheeseborad[up+f+4][c1-(f+4)]==0){
						if (decideNumber==2) {
							cheeseborad[up+f+4][c1-(f+4)]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					
				}
				//
				if (judge5>=judgeNumber)
				{
					if(cheeseborad[down-f][f+4]==0){
						if (decideNumber==2) {
							cheeseborad[down-f][f+4]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					if(cheeseborad[down+1-f][f+3]==0){
						if (decideNumber==2) {
							cheeseborad[down+1-f][f+3]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					if(cheeseborad[down+2-f][f+2]==0){
						if (decideNumber==2) {
							cheeseborad[down+2-f][f+2]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					if(cheeseborad[down+3-f][f+1]==0){
						if (decideNumber==2) {
							cheeseborad[down+3-f][f+1]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						

					}
					if(cheeseborad[down+4-f][f]==0){
						if (decideNumber==2) {
							cheeseborad[down+4-f][f]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					
				}
				
				if(judge6>=judgeNumber){
					if(cheeseborad[down-f][c1-(f+4)]==0){
						if(decideNumber==2){
							cheeseborad[down-f][c1-(f+4)]=2;
							count++;
							break loop;
						}
						else{
							count++;
						}
						
					}
					if(cheeseborad[down+1-f][c1-(f+3)]==0){
						if(decideNumber==2){
							cheeseborad[down+1-f][c1-(f+3)]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					if(cheeseborad[down+2-f][c1-(f+2)]==0){
						if(decideNumber==2){
							cheeseborad[down+2-f][c1-(f+2)]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					if(cheeseborad[down+3-f][c1-(f+1)]==0){
						if(decideNumber==2){
							cheeseborad[down+3-f][c1-(f+1)]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						
					}
					if(cheeseborad[down+4-f][c1-f]==0){
						if(decideNumber==2){
							cheeseborad[down+4-f][c1-f]=2;
							count++;
							break loop;
						}
						else {
							count++;
						}
						

					}
					
				}			
				

			}
			up--;down++;//--代表往上提升
			
		}
		if (count==0&&decideNumber==2) {
			AttackAndDefend(3,1);//防守
		}
		else if (count>0&&decideNumber==1)
		{
			
			if(possible.size()==2)
			{
				cheeseborad[possible.get(0)][possible.get(1)]=2;
			}
			
			else if(possible.size()>2)
			{
				int f=0,f1=1;
				int[]array=WhoisBig(cheeseborad, possible);
				cheeseborad[array[0]][array[1]]=2;
				for(int i=0;i<possible.size()/2;i++){
					System.out.printf("a:%d b:%d\n",possible.get(f),possible.get(f1));
					f=f1+1;f1=f+1;
				}
				System.out.print("-------------------------------------------\n");
				
			}
			else {
				System.out.print("catch");//用評估函數
			}
			
			
			//System.out.printf("big:",big);
			
			
		}
		else if (count==0&&decideNumber==1)
		{
			System.out.print("我會出現的\n");
		}
		
		
	}
	int []WhoisBig(int [][]cheeseborad,ArrayList<Integer>arrayList){
		int end=possible.size()/2;///
		int []copy=new int[2];
		int f=0,f1=1,f2=2,f3=3;
		try{
			copy[0]=arrayList.get(0);
			copy[1]=arrayList.get(1);
		}catch(Exception e){
			System.out.print(e);
		}
		
		for(int i=0;i<end-1;i++){
			if(MinMax(cheeseborad, arrayList.get(f), arrayList.get(f1))<MinMax(cheeseborad, arrayList.get(f2), arrayList.get(f3)))
			{
				copy[0]=arrayList.get(f2);
				copy[1]=arrayList.get(f3);
			}
			
			f=f1+1;f1=f+1;f2=f3+1;f3=f2+1;
		}
		
		
		return copy;
		
	}
	
	
	int MinMax(int [][]cheeseborad,int a,int b)//更改作法
	{
		int r1=a,r2=b;
		r1=r1<1?0:r1;
		r1=r1>15?15:r1;
		r2=r2<1?0:r2;
		r2=r2>15?15:r2;
		if(cheeseborad[r1][r2+1]==0||cheeseborad[r1][r2-1]==0||cheeseborad[r1-1][r2]==0||cheeseborad[r1+1][r2]==0){
			return 0;
		}
		
		int points=0;
		int judge1=0;int judge2=0;
		a=a<4?0:a-4;
		a=a>8?8:a;
		b=b<4?0:b-4;
		b=b>8?8:b;
		for(int first=0;first<5;first++)
		{		
			judge1=0;judge2=0;
			if(cheeseborad[a][b+first]==2)		points-=5;			
			if(cheeseborad[a][b+1+first]==2)	points-=20;
			if(cheeseborad[a][b+2+first]==2)	points-=30;
			if(cheeseborad[a][b+3+first]==2)	points-=20;
			if(cheeseborad[a][b+4+first]==2)	points-=5;
			
			if(cheeseborad[a+first][b]==2)		points-=5;
			if(cheeseborad[a+1+first][b]==2)	points-=20;
			if(cheeseborad[a+2+first][b]==2)	points-=30;
			if(cheeseborad[a+3+first][b]==2)	points-=20;
			if (cheeseborad[a+4+first][b]==2)	points-=5;

			if(cheeseborad[a][b+first]==1)		judge1++;			
			if(cheeseborad[a][b+1+first]==1)	judge1++;
			if(cheeseborad[a][b+2+first]==1)	judge1++;
			if(cheeseborad[a][b+3+first]==1)	judge1++;
			if(cheeseborad[a][b+4+first]==1)	judge1++;
			
			if(cheeseborad[a+first][b]==1)		judge2++;
			if(cheeseborad[a+1+first][b]==1)	judge2++;
			if(cheeseborad[a+2+first][b]==1)	judge2++;
			if(cheeseborad[a+3+first][b]==1)	judge2++;
			if (cheeseborad[a+4+first][b]==1)	judge2++;
			
			if(judge1>3&&points>-10){
				points+=20;
			}
			if(judge2>3&&points>-10){
				points+=20;
			}
		}
		
	
		return points;
	}
	int	[][] Min(int [][]cheeseborad,int add){
		return cheeseborad;
	}
	int [][]Max(int [][]cheeseborad,int reduce)
	{
		return cheeseborad;
	}
	

}
