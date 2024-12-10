import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Class 'QnA' gives the basic structure of the two different kind of cards that are displayed throughout the game. 
Please note that this is created solely for storing content.
It has two constructors:
1. QnA(String q) : This is suitable for storing paragraph only
2. QnA(String q, String o1 , String o2 , String o3, String o4, int pt1 , int pt2 , int pt3 , int pt4) : This is suitable
for storing the question, option1,option2, option3, option4, and points allocated for choosing each respective option in order
*/

public class QnA {

	String question , option1 , option2 , option3 , option4 ;
	int pt1,pt2,pt3,pt4; 
	
	public QnA(String q) {
		this(q,"","","","",0,0,0,0);
	}
	
	public QnA(String q, String o1 , String o2 , String o3, String o4, int pt1 , int pt2 , int pt3 , int pt4) {
		question=q;
		option1=o1;
		option2=o2;
		option3 = o3;
		option4 = o4;
		//nextFrame = n;
		this.pt1=pt1; this.pt2=pt2; this.pt3 = pt3; this.pt4 = pt4;
	}

	int retPts(String ansChosen ) {
		if(ansChosen==option1) {return pt1;}
		else if(ansChosen==option2) {return pt2;}
		else if(ansChosen==option3) {return pt3;}
		else if(ansChosen==option4) {return pt4;}
		return 0;
	}
	
}

/* QuestionFrame class decides which component is where and how is it presented. Based on the two different types:
Paragraph and Question with Answers, two different kinds of look and feel along with different background colors have been choosen.
It also has the code to decide the feedback to be displayed based on option chosen.
*/


	public class QuestionCard extends JPanel  {
		private static final long serialVersionUID = 1L;
		QnA quest ;
		int in,ptsAdded ;
	
		int sol;
		
		String addedPoints(int in) {
			
			  if(in==40) { ptsAdded=quest.pt1;
				  return "Bravo! That's the right decision :) .";
			  }
			  else if(in==30) { ptsAdded=quest.pt2; 
				  return "You are almost there, but could have made a better decision :| .";
			  }
			   
			  else if(in==20) {ptsAdded=quest.pt3;
				  return "No, this ain't the right move. Be more compassionate towards others.";
			  }
			  
			  else { ptsAdded=quest.pt4;
				 return "It is absolutely the worst decision you could have taken.\n Be empathetic, kind and have some humanity";
			  }
			  
		}
		
   		int retAns(String a) {
   			
		  	if(a==quest.option1) {   return quest.pt1; }
		  	if(a==quest.option2) {   return quest.pt2; }
		  	if(a==quest.option3) {return quest.pt3; }
		  	if(a==quest.option4) { return quest.pt4; }
		  	 return 0 ;
			
		}
   		
   		int retAnsToRunner() {
   			return ptsAdded;
   		}
   		
		
		public QuestionCard (QnA ques[], int index) {
			this.in = index;
			Boolean flag = false;
			
			this.quest = ques[index];
			
       if(quest.option1 != "" && quest.option2 != "" && quest.option3 != "" && quest.option4 != "" ) {
                        removeAll();		
			     flag=true;
			     JTextArea j = new JTextArea(quest.question);
			
                         j.setFont(new Font("Serif", Font.PLAIN, 20));
                         j.setLineWrap(true);
                         j.setWrapStyleWord(true);
                         j.setEditable(false);
                         j.setBackground(getBackground());
                         j.setOpaque(false);

			JCheckBox c1,c2,c3,c4 ;
		
			c1=new JCheckBox(quest.option1);
			c2=new JCheckBox(quest.option2);
			c3=new JCheckBox(quest.option3);
			c4=new JCheckBox(quest.option4);
			//next =new JButton("Next");
			
			ButtonGroup group = new ButtonGroup();
			group.add(c1);
			group.add(c2);
			group.add(c3);
			group.add(c4); 
			
			c1.addActionListener(
					new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
					
						String str = addedPoints(quest.pt1) ;
						JTextArea l1 = new JTextArea(str) ;
                                                 l1.setFont(new Font("Serif", Font.BOLD, 20));
                                                 l1.setLineWrap(true);
                                                 l1.setWrapStyleWord(true);
                                                 l1.setEditable(false);
                                                 l1.setBackground(getBackground());
                                                 l1.setOpaque(false);
						add(l1);
                                       
						c1.setVisible(false);
						c2.setVisible(false);
						c3.setVisible(false);
						c4.setVisible(false);
                                                j.setVisible(false);
						
						l1.setBounds(450,100,400,60);
						repaint();
						
						  
						
					}
					
			}
			
			
					);
			
			c2.addActionListener(
					new ActionListener() {

					
						public void actionPerformed(ActionEvent e) {
							
					
							String str = addedPoints(quest.pt2) ;
						 JTextArea l1 = new JTextArea(str) ;
                                                 l1.setFont(new Font("Serif", Font.BOLD, 20));
                                                 l1.setLineWrap(true);
                                                 l1.setWrapStyleWord(true);
                                                 l1.setEditable(false);
                                                 l1.setBackground(getBackground());
                                                 l1.setOpaque(false);
						add(l1);
							c1.setVisible(false);
							c2.setVisible(false);
							c3.setVisible(false);
							c4.setVisible(false);
							j.setVisible(false);
							l1.setBounds(450,100,400,60);
							repaint();
							
						}
					}
					
					);
			c3.addActionListener(

new ActionListener() {

		public void actionPerformed(ActionEvent e) {
							
				String str = addedPoints(quest.pt3) ;
				JTextArea l1 = new JTextArea(str) ;
           l1.setFont(new Font("Serif", Font.BOLD, 20));
           l1.setLineWrap(true);
           l1.setWrapStyleWord(true);
           l1.setEditable(false);
           l1.setBackground(getBackground());
           l1.setOpaque(false);                                      
						add(l1);
							c1.setVisible(false);
							c2.setVisible(false);
							c3.setVisible(false);
							c4.setVisible(false);
							j.setVisible(false);
							l1.setBounds(450,100,400,60);
							repaint();
							
						}
					}
					
					
					);
			c4.addActionListener(

new ActionListener() {
		public void actionPerformed(ActionEvent e) {
									
					String str = addedPoints(quest.pt4) ;
					JTextArea l1 = new JTextArea(str) ;
          l1.setFont(new Font("Serif", Font.BOLD, 20));
          l1.setLineWrap(true);
          l1.setWrapStyleWord(true);
          l1.setEditable(false);
          l1.setBackground(getBackground());
          l1.setOpaque(false);
					   	add(l1);
							c1.setVisible(false);
							c2.setVisible(false);
							c3.setVisible(false);
							c4.setVisible(false);
							j.setVisible(false);
							l1.setBounds(450,100,400,60);
							repaint();
													
						}
					}
					
					
					);
			
			j.setBounds(20,100,1000,200);
			c1.setBounds( 200 , 300 , 500 , 60);
			c2.setBounds(200, 360 , 500 , 60);
			c3.setBounds(200 , 420 , 500 , 60);
			c4.setBounds(200 , 480 , 500 , 60); 

		        removeAll();
			
			add(j);
			add(c1); 
			add(c2); 
			add(c3); 
			add(c4); 
}
			
else {   
         JTextArea jd= new JTextArea(quest.question);
          jd.setFont(new Font("Serif", Font.PLAIN, 20));
          jd.setLineWrap(true);
          jd.setWrapStyleWord(true);
          jd.setEditable(false);
          jd.setBackground(getBackground());
          jd.setOpaque(false);
         jd.setBounds(20,100,1000,800);
         removeAll();
         add(jd);
         jd.setVisible(true);
       }
			
			setSize (1200,500);
			setVisible(true);
			setLayout(null);
		
			if(flag==false) {
			 setBackground(Color.CYAN); }
			
			else {
			setBackground(Color.PINK);
			}
                   
                         setForeground(Color.BLACK);
			
		}
		
	}
		
/* The class 'GameCode' initializes the array of QnA which stores the story and returns it to the next class.

*/

public class GameCode  {
	
	QnA arr[] ;
	
	public GameCode() {
		arr = new QnA[20];
		
	String p1= "In the heart of a lush meadow, under a clear blue sky, lived Chirpy, a golden-feathered chick 🐣 known for her endless curiosity.\n"
			+ " Her closest friends were Benny, a powerful bear 🐅 with a love for challenges, \n Sammy, a clever duck 🐡 who always knew the quickest way through problems,\n "
			+ "and Whiskers, a rabbit 🐿 with sharp wits and a knack for solving puzzles. \n"
			+ "\n"
			+ "One day, while playing hide-and-seek among wildflowers, the group stumbled upon a mysterious globe 🌎 half-buried in the dirt. \n"
			+ "\n";
				
		
		
		 arr[0] = new QnA( p1 );
		 
  String q1=" The Globe’s Ownership  \n" +
		 " They brushed off the dust and admired the globe, but then Whiskers squinted at it thoughtfully.\n"
		  +  " 'I think this belongs to Mr. Ram. He mentioned a rare globe in his collection.'\n\n "  
		 + " What should they do?  ";
  				 
  
  String o1= "A) Keep the globe, it's finders-keepers \n ";
  
  String o2="B) Return the globe, but only if rewarded  ";
  
  String o3= "C) Sell the globe and split the profit ";
  
  String o4 = "D) Return the globe immediately, respecting ownership ";
  
  
         arr[1] = new QnA(q1,o1,o2,o3,o4,10,30,20,40);
         
 String p2= "Answer: D) Return the globe immediately, respecting ownership \n"
 		+ "\"Let’s take it back right away,\" Benny insisted. \"It’s the right thing to do.\"  \r\n"
 		+ "They carefully carried the globe to Mr. Ram’s cozy treehouse. Mr. Ram, his feathers graying with age, smiled warmly.\n"
 		+ " \"Thank you for your honesty, my young friends,\" he said. \"In return, how would you like to explore the world through this magical globe?\\n"
 		+ "The globe spun and shimmered, transporting them to new places. Their first stop was a forest where they met Rosie, a swift rabbit 🐇\n "
 		+ "in the middle of an intense training session for the Fitness Olympics 🏋‍♀.  \n"
 		+ " ";        
		 
         arr[2]= new QnA (p2 );

         
String q2=" Including Others\n"  +
" Rosie hopped over nervously. \"I’d love to join your adventure, but what if I can’t keep up? \" \n" +
"\nHow should the friends respond?";      

String o21 = "A) Reject Rosie, fearing she'll slow them down";

String o22 = "B) Invite Rosie, but only if she proves herself ";

String o23 = "C) Welcome Rosie, embracing diversity and inclusivity";

String o24 = "D) Ignore her";

         
         arr[3]= new QnA (q2,o21,o22,o23,o24, 10,20,40,10);
         
String p3=" Answer: C) Welcome Rosie, embracing diversity and inclusivity \n" +  

"\"Everyone brings something unique,\" Sammy said with a grin. \"You’re fast! We could use someone like you.\" \n "+

"Rosie’s eyes sparkled with excitement, and the group continued their adventure, crossing rivers, climbing hills,\n and discovering hidden trails."  



+ "\n\n One afternoon, while exploring a maze of ruins, Benny stumbled upon a clue etched into a stone. " 

;         
         
         arr[4]= new QnA (p3);
         
String q3=" Honesty vs. Advantage \n" +  
"Benny traced the letters with his claw. \"This clue could give us an edge in solving the puzzle,\" he murmured.\n\n" + 

"What should Benny do?";  
 ;   
 
 String o31 = "A)Share the clue, but only with close friends ";
 
 String o32 = "B)Use the clue to sabotage competitors ";
 
 String o33 = "C) Share the clue with everyone, promoting teamwork ";
 
 String o34 = "D)Keep the clue secret for personal gain  ";
         
         arr[5]= new QnA (q3,o31,o32,o33,o34,30,20,40,10 );
         
String p4 = "Answer: C) Share the clue with everyone, promoting teamwork \n"  +

" \"No secrets among friends,\" Benny said as he called everyone over. Together, they solved the puzzle and discovered \n" +
"a hidden passage leading to treasure.\n\n"  +



"Their celebration was short-lived as an alarm 🚨 blared through the ruins. A rival treasure hunter appeared, smirking with mischief.";  



         
         arr[6]= new QnA (p4 );
   
String q4 =  " Dealing with Adversity  " +
       "  \"Well, well, looks like you did all the hard work for me!\" the rival sneered. \n\n"  +

         "How should the friends react?";  

    String o41 = " A) Engage in a heated argument";
    String o42= " B) Sit and cry for help. "; 
    String o43= "C) Try to collaborate with the rival, finding common ground "; 
    String o44 = "D) Use underhanded tactics to outsmart the rival "; 

        arr[7]= new QnA (q4,o41,o42,o43,o44,10,10,40,20 );

 String p5= "Answer: C) Try to collaborate with the rival, finding common ground\n " +  

         "\"How about we work together instead?\" Whiskers offered. \"There’s plenty of treasure for all of us.\" \n" +

         "The rival hunter disagreed. He ran away with the treasure. Sammy tried to chase him, but Chirpy stopped him.\n"+
         
       "  \"Maybe he needed the treasure more than us. \", said Chirpy. Not everything in Life happens the way we expect it to turnout.\n "
      	+ "In such situations, we should learn a lesson from the incident and move on. Moving on is essential to live life to the fullest \n"+
    " He continued,	\"Forgive but never forget, because the same person/thing/incident might occur if you forget. \"\n "+
   "  \"You are right Chirpy, I was foolish. Let us continue the exploration together! \", said Sammy \n " +  
        " They navigated the ruins together, uncovering ancient relics and stories from the past. \n\n " +

        

       " Later, they faced a daunting obstacle course 🎯 that tested their endurance, agility, and problem-solving skills. " ;        
         
         arr[8]= new QnA (p5 );
         
         String q5= " Perseverance\n"+  
       "  Whiskers panted as they reached a steep wall. \"This course is tough! Should we turn back?\" \n\n" +  

         "What should they do?";  
         
         
   String o51 =     " A) Give up, citing unfair challenges ";  
String o52 =      "B) Take shortcuts, compromising integrity";   
String o53 =      "  C) Work together, using unique skills ";  
String o54 =       " D) Take mentorship from someone, then try again.";  

         arr[9]= new QnA (q5,o51,o52,o53,o54,10,20,40,30 );

  String p6 =       
        " Answer: C) Work together, using unique skills. Taking mentorship is also the right approach, but this team plans to work together\n" +
        "  to figure out the solution . " +

        " \"We've got this,\" Rosie encouraged. \"Let’s combine our strengths.\" " + 

        " With Rosie leading the jumps, Benny smashing through barriers, and Whiskers navigating the maze, they completed the course\n"
        + " and discovered a glowing orb 🫚 at the end.\n" +  
         
       " \"We might have lost out on the treasure, but the orb is ours! \", exclaimed Chirpy in joy . \"Exactly!\", said Whiskers."
         ;
         arr[10]= new QnA ( p6);
         
String q6  =    "Wealth Distribution\n"+  
        " The magical orb sparkled with power, but Chirpy had to decide how to divide it. \n\n"  +

         "How should they distribute the treasure?";

  String o61 =      " A) Split it equally among friends"   ;
   String o62 =     " B) Give the majority to the most contributing member";  
   String o63 =     " C) Use it for personal gain, ignoring others";  
  String o64 =      " D) Donate it to charity, without discussing ";  


         arr[11]= new QnA (q6,o61,o62,o63,o64,40,20,10,30 );

String p7 =         
        " Answer: A) Split it equally among friends \n\n " +

       "  \"Let’s share it equally,\" Benny suggested. \"That way, everyone benefits.\"  " + 

       "  They also donated part of the treasure to the local community, spreading joy wherever they traveled. \n\n " +  

        

        " Their story soon became famous, drawing attention from across the world. ";  
        
         
         
         arr[12]= new QnA ( p7);
         
         
        String q7 = "Fame and Humility\n"+  
        " \"Looks like we’re famous!\" Sammy chuckled. \"How should we handle this?\"  \n\n" +

         "How should they manage their fame?" ;
        
        
  String o71 =       "A) Bask in glory, emphasizing individual achievements";  
  String o72 =        "B) Share credit with teammates, acknowledging contributions ";  
 String o73 =        "C) Use fame for personal gain and endorsements ";  
String o74 =         "D) Stay humble, focusing on the journey ";  

arr[13]= new QnA (q7,o71,o72,o73,o74,10,40,20,30 );

 String p8 =   "Answer: B) Share credit with teammates, acknowledging contributions\n " +  

         "\"Let’s make sure everyone gets recognized,\" Chirpy said. \"We did this together.\" \n\n"+  

        

         "As the group gathered under the stars one evening, they reflected on their adventure.";  

        
         
         arr[14] = new QnA(p8);     

        String q8= " Reflection and Growth\n"+  
        " Benny leaned back and sighed contentedly. \"What do we do with everything we’ve learned?\" \n\n" +  

         "What should they do with their newfound wisdom?" ;
        
        
String o81 =   "A) Keep it to themselves, fearing criticism";  
String o82 =    "B) Share it with close friends and family ";  
String o83 =         "C) Write a book, inspiring others "; 
String o84 =       "  D) Use it to lecture others, imposing their views ";  

arr[15] = new QnA(q8,o81,o82,o83,o84,10,30,40,20);

String p9 = "Answer: C) Write a book, inspiring others\n" +  

"Whiskers grinned. \"Let’s write a book! Our adventure might inspire others to go on their own journeys.\" \n\n" + 



"Soon, their book became a bestseller, inspiring people everywhere to embrace new experiences. ";  


arr[16] = new QnA(p9);


String p10 = "\"It’s the journey that matters most,\" Chirpy said. \"That’s what makes every adventure worthwhile.\"\n" +  

"Under the glow of the moon, the friends exchanged smiles, content with the memories they had made.\n " +   

"\"The real treasure,\" Benny said softly, \"is the friends we make and the lessons we learn.\" \n" +  

"With hearts full of joy and spirits high, they drifted off to sleep, ready for whatever adventures tomorrow might bring.";       
         
arr[17] = new QnA(p10);  
        
String p11="The End!" ;

 arr[ 18 ]= new QnA (p11) ;
         
   
         
         
	}
	
	  QnA[] retQuestion() {
		return arr;
	}

}
	
/* Taking the array of QnA as input, the class 'Helperv3' creates an array of QuestionCard JFrames, and organises them using Card Layout.
Few components which are common throughout the cards are also coded in this class.
*/


public class Helperv3 {
	//private static final long serialVersionUID = 7L;
	QnA question[] ;
	int QnAlength,index,ptsVal ;
	JLabel  totlPts ;
	JButton endGame, scoreRevealer,next ;
	JFrame f;
	JPanel cards,buttonGroup ;
	QuestionCard qc[];
	 int i;
         CardLayout cl;
	
	public QuestionCard getCurrentCard() {
    String currentCardName = "name" + i; 
    for (Component comp : cards.getComponents()) {
        if (currentCardName.equals(comp.getName()) && comp instanceof QuestionCard) {
            return (QuestionCard) comp;
        }
    }
    return null;
}

	 
	public Helperv3() { i=0;
	
		f=new JFrame();
                cards = new JPanel();
                buttonGroup = new JPanel(); 
		totlPts = new JLabel();
		GameCode h = new GameCode();
		question = h.retQuestion();
		cl = new CardLayout();
                qc = new QuestionCard[19];	         

             for(int i=0;i<19;i++){
		qc[i] = new QuestionCard(question,i);
                qc[i].setName("name"+i ); }
	/*
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("Image path"); 
        Image scaledImage = imageIcon.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH); 
        imageLabel.setIcon(new ImageIcon(scaledImage));

        
        qc[18].setLayout(new BorderLayout());
        qc[18].add(imageLabel, BorderLayout.CENTER); */

              cards.setLayout(cl);  
                 
              for(int i=0;i<19;i++){ 
		cards.add(qc[i] ,"name"+i ); }            

                              


		endGame=new JButton("Exit"); //go to c19
		endGame.addActionListener( new ActionListener() { 
			public void actionPerformed(ActionEvent e){
			       cl.show(cards, "name"+18 );
                         int a= JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?");
	                if(a==JOptionPane.YES_OPTION ){
	                   System.exit(0);
	               } 
			       
		    }
			 
		  }
		);
		
		next = new JButton("Next -> ");
	
		next.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           
		            if(i<19){ i+=1 ;
				
				ptsVal+= getCurrentCard().retAnsToRunner();
				totlPts.setText("Score: "+ptsVal);
				totlPts.repaint();
		       
					 cl.show(cards, "name"+i);  }
			    
				else {next.setVisible(false); next.repaint(); }
				 
			}
		}
				
				);
		
		scoreRevealer = new JButton("score revealer"); //refresh score, going to c1
		 scoreRevealer.addActionListener( new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
                                 ptsVal=0; i=1;
                                 totlPts.setText("Score :"+ptsVal);
			      cl.first(cards );
			 }
		 }
				 );
		
		
		 
		f=new JFrame();
	
                cards.setVisible(true);		

                endGame.setBackground(Color.ORANGE); 
                scoreRevealer.setBackground(Color.ORANGE);
                next.setBackground(Color.ORANGE);  
                endGame.setForeground(Color.BLACK); 
                scoreRevealer.setForeground(Color.BLACK);
                next.setForeground(Color.BLACK); 

		buttonGroup.add(endGame); 
		buttonGroup.add(scoreRevealer);
		buttonGroup.add(next);	
		                
                scoreRevealer.setPreferredSize(new Dimension(200, 40));
                next.setPreferredSize(new Dimension(100, 40));
                endGame.setPreferredSize(new Dimension(100, 40));

	             	buttonGroup.setLayout(new FlowLayout());
                buttonGroup.setVisible(true);		

                totlPts.setBackground(Color.ORANGE);
                totlPts.setForeground(Color.BLACK);

                cards.setBounds(30, 20, 1200, 600); 
                buttonGroup.setBounds(30, 630, 800, 50); 
                totlPts.setBounds(850, 630, 200, 50); 
                totlPts.setVisible(true);
		
		
                
	        cl.show(cards, qc[0].getName() );
                     
		f.add(totlPts);
		f.add(cards);
		f.add(buttonGroup);
                f.setLayout(null);
                f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

/* As the name suggests, class 'TestGame' creates an instance of Helperv3' to test and run the game.
*/

public class TestGame {

	public static void main(String []args) {
		new Helperv3();
	}
  
}

/* To play the game, the user reads the story and selects the option he/she deems fit and clicks on 'next', after the user
has played the game till where desired, then the 'score revealer' button is pressed which takes the user to the initial
frame and reveals the total scores along with feedback, when pressing next.

*/


