import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class wordCounter implements ActionListener{
	JFrame frame;
	JLabel lTitle,lPara,lCount,lMsg;
	JButton btnEntry;
	JTextArea tPara;
	JLabel imgLabel;
	wordCounter(){
		frame = new JFrame("Word Counter");
		frame.setLocation(200,100);
		frame.setSize(700,700);
		frame.setLayout(null);
		Font font = new Font("Arial",Font.BOLD,30);
		
		ImageIcon img = new ImageIcon("bcc.jpg");
		img = new ImageIcon(img.getImage().getScaledInstance(700,700,0));
		imgLabel= new JLabel();
		imgLabel.setIcon(img);
		frame.setContentPane(imgLabel);
		
		ImageIcon logoIcon = new ImageIcon("lg.jpg");
		Image logo = logoIcon.getImage();
		frame.setIconImage(logo);
		
		lTitle = new JLabel("Word Counter");
		lTitle.setFont(font);
		lTitle.setBounds(230,20,600,100);
		frame.add(lTitle);
		
		font = new Font("Arial",Font.BOLD,18);
		
		lPara = new JLabel("Write here...");
		lPara.setFont(font);
		lPara.setBounds(100,140,200,50);
		frame.add(lPara);
		
		
		tPara = new JTextArea();
		tPara.setFont(font);
		tPara.setBounds(100,200,500,280);
		tPara.setLineWrap(true);
		tPara.setWrapStyleWord(true);
        frame.add(tPara);
	
		Color c = new Color(133,209,230);
		btnEntry= new JButton("Count");
		btnEntry.setBackground(c);
		btnEntry.addActionListener(this);
		btnEntry.setBounds(100,510,80,40);
		frame.add(btnEntry);
		
		lCount = new JLabel();
		lCount.setFont(font);
		lCount.setBounds(100,560,400,40);
		frame.add(lCount);
		
		lMsg = new JLabel();
		lMsg.setFont(font);
		lMsg.setBounds(100,590,300,40);
		frame.add(lMsg);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource().equals(btnEntry))
		{
			lCount.setText("");
			lMsg.setText("");
			if(tPara.getText().equals("")){
				lCount.setText("Please write something...");
			}
			else {
				String para = tPara.getText();
				String word[] = para.split(" ");
				int l=word.length;
				int flag=0;
                for(int i=0;i<word.length;i++){
						if(word[i].equals("")){
						    //System.out.println("\""+word[i]+"\"");
							l--;
							flag++;
                        }
						if(flag>0){
							lCount.setText("The paragraph contain " +flag+" extra space");
					     	lMsg.setText("Total words:"+l);
						}
						else {
                        lCount.setText("Total words:"+l);
						}
				}				
			}
				
		}
	}
	public static void main(String args[]){
		wordCounter wc = new wordCounter();
	}
}
