import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Execute {
	private int [][]cheeseborad=new int[17][17];
	private JFrame jframe;
	private AI ai;

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
			                        		if (e.getSource() == button[j][j1])
								{
			                        			if(cheeseborad[j][j1]==0){
			                        				cheeseborad[j][j1]=1;
				                        			button[j][j1].setLabel("O");
				                        			cheeseborad=ai.choice(cheeseborad);
			                        			}
			                        			else {
										System.out.print("It is not empty\n");
									}
			                        			
			                        			

			                        
				                        		
				                        	}
											
										}
										
									}

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
		int count=0;
		int up=12;
		for(int s=0;s<13;s++){
			for (int f=0;f<=count;f++){	
				if(cheeseborad[up][f]==cheeseborad[1+up][f+1]&&cheeseborad[up][f]==cheeseborad[2+up][f+2]&&cheeseborad[up][f]==cheeseborad[up+3][f+3]&&cheeseborad[up][f]==cheeseborad[up+4][f+4]){
					if(cheeseborad[up][f]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[up][f]==2){
						System.out.print("AI win!\n");
						return true;
					}

				}
				if(cheeseborad[up][c1-f]==cheeseborad[up+1][c1-(f+1)]&&cheeseborad[up][c1-f]==cheeseborad[up+2][c1-(f+2)]&&cheeseborad[up][c1-f]==cheeseborad[up+3][c1-(f+3)]&&cheeseborad[up][c1-f]==cheeseborad[up+4][c1-(f+4)]){
					if(cheeseborad[up][c1-f]==1){
						System.out.print("Player win!\n");
						return true;
					}
					else if (cheeseborad[up][c1-f]==2){
						System.out.print("AI win!\n");
						return true;
					}

				}
				
				

			}
			count++;up--;//--代表往上提升
			
		}
		
		
		return false;
	}
}

