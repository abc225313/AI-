import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Execute {// A* ab cut minmax
	private int [][]cheeseborad=new int[17][17];
	private JFrame jframe;
	private AI ai;
	private static int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Execute window = new Execute();
					window.jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Execute() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jframe = new JFrame();
		jframe.setSize(950, 950);
		jframe.getContentPane().setLayout(new GridLayout(17,17));
		final Button button[][] = new Button[17][17];
		
		for (int i = 0; i < button.length; i++) {
			for (int  i1= 0;i1< button.length;i1++) {  
				button[i][i1] = new Button();
				jframe.getContentPane().add(button[i][i1]);
				button[i][i1].addActionListener(
		                    new ActionListener() {
		                        public void actionPerformed(ActionEvent e)
		                        {
		                        	ai=new AI();
		                        	loop:
		                        	for (int j = 0; j < button.length; j++) {
		                        		for (int j1 = 0; j1 < button.length; j1++) {
		                        			if(check(cheeseborad)){break loop;}
		                        			if (e.getSource() == button[j][j1]){
		                        				if(cheeseborad[j][j1]==0){
			                        				count++;
			                        				cheeseborad[j][j1]=1;
				                        			button[j][j1].setLabel("O");
				                        			if(check(cheeseborad)){break loop;}
				                        			ai.choice(cheeseborad);
				                        			for (int k = 0; k < button.length; k++) {
														for (int l = 0; l < button.length; l++) {
															if(cheeseborad[k][l]==2){
																button[k][l].setLabel("X");
															}
															
														}
														
													}
			                        			}
			                        			else {
													System.out.print("It is not empty\n");
												}
		                        			}
		                        				
		                        			}
		                        		}
		                        			
		                        	/*loop:
		                        	for (int j = 0; j < button.length; j++) {
		                        		for (int j1 = 0; j1 < button.length; j1++) {
		                        			if(check(cheeseborad)){break loop;}
		                        			
		                        				if (e.getSource() == button[j][j1]){
				                        			if(cheeseborad[j][j1]==0){
				                        				count++;
				                        				cheeseborad[j][j1]=1;
					                        			button[j][j1].setLabel("O");
					                        			if(check(cheeseborad)){break loop;}
				                        			}
				                        			else {
														System.out.print("It is not empty\n");
													}
		                        			}
			                         
				                        		
				                        	
		                        			
											
										}
										
									}*/

		                        }
		                            
		                        
		                    });

			}
			
		}
	
		
	}
	static boolean check(int [][]cheeseborad){
		int c1=16;
		for (int i = 0; i <17; i++) {
			for (int j = 0; j <13; j++) {
				if(cheeseborad[i][j]==cheeseborad[i][j+1]&&cheeseborad[i][j]==cheeseborad[i][j+2]&&cheeseborad[i][j]==cheeseborad[i][j+3]&&cheeseborad[i][j]==cheeseborad[i][j+4]){
					if(cheeseborad[i][j]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[i][j]==2){
						System.out.print("AI win!\n");
						return true;
					}
				}
				
				if(cheeseborad[j][i]==cheeseborad[j+1][i]&&cheeseborad[j][i]==cheeseborad[j+2][i]&&cheeseborad[j][i]==cheeseborad[j+3][i]&&cheeseborad[j][i]==cheeseborad[j+4][i]){	
					if(cheeseborad[j][i]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[j][i]==2){
						System.out.print("AI win!\n");
						return true;
					}
				}
				
				
			}
			
		}
		
		int up=12;int down=0;
		for(int s=0;s<13;s++){//4個
			for (int f=0;f<=s;f++){	
				if(cheeseborad[up+f][f]==cheeseborad[up+1+f][f+1]&&cheeseborad[up+f][f]==cheeseborad[up+2+f][f+2]&&cheeseborad[up+f][f]==cheeseborad[up+3+f][f+3]&&cheeseborad[up+f][f]==cheeseborad[up+4+f][f+4]){
					
					if(cheeseborad[up+f][f]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[up+f][f]==2){
						System.out.print("AI win!\n");
						return true;
					}

				}
				if(cheeseborad[up+f][c1-f]==cheeseborad[up+f+1][c1-(f+1)]&&cheeseborad[up+f][c1-f]==cheeseborad[up+f+2][c1-(f+2)]&&cheeseborad[up+f][c1-f]==cheeseborad[up+f+3][c1-(f+3)]&&cheeseborad[up+f][c1-f]==cheeseborad[up+f+4][c1-(f+4)]){
					if(cheeseborad[up+f][c1-f]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[up+f][c1-f]==2){
						System.out.print("AI win!\n");
						return true;
					}

				}

				if(cheeseborad[down-f][f+4]==cheeseborad[down+1-f][f+3]&&cheeseborad[down-f][f+4]==cheeseborad[down+2-f][f+2]&&cheeseborad[down-f][f+4]==cheeseborad[down+3-f][f+1]&&cheeseborad[down-f][f+4]==cheeseborad[down+4-f][f]){		
					if(cheeseborad[down-f][f+4]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[down-f][f+4]==2){
						System.out.print("AI win!\n");
						return true;
					}

				}
				if(cheeseborad[down-f][c1-(f+4)]==cheeseborad[down+1-f][c1-(f+3)]&&cheeseborad[down-f][c1-(f+4)]==cheeseborad[down+2-f][c1-(f+2)]&&cheeseborad[down-f][c1-(f+4)]==cheeseborad[down+3-f][c1-(f+1)]&&cheeseborad[down-f][c1-(f+4)]==cheeseborad[down+4-f][c1-f]){		
					if(cheeseborad[down-f][c1-(f+4)]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[down-f][c1-(f+4)]==2){
						System.out.print("AI win!\n");
						return true;
					}

				}
				
				

			}
			up--;down++;//--代表往上提升
			

		}
		
		
		return false;
	}
}


