/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ public class PrefPane
/*    */   extends JFrame
/*    */ {
/*    */   protected JButton okButton;
/*    */   protected JLabel prefsText;
/*    */   
/*    */   public PrefPane() {
/* 18 */     getContentPane().setLayout(new BorderLayout(10, 10));
/* 19 */     this.prefsText = new JLabel("LakeFinder Preferences...There are none.");
/* 20 */     JPanel textPanel = new JPanel(new FlowLayout(0, 10, 10));
/* 21 */     textPanel.add(this.prefsText);
/* 22 */     getContentPane().add(textPanel, "North");
/*    */     
/* 24 */     this.okButton = new JButton("OK");
/* 25 */     JPanel buttonPanel = new JPanel(new FlowLayout(1, 10, 10));
/* 26 */     buttonPanel.add(this.okButton);
/* 27 */     this.okButton.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent newEvent) {
/* 29 */             PrefPane.this.setVisible(false);
/*    */           }
/*    */         });
/* 32 */     getContentPane().add(buttonPanel, "South");
/* 33 */     setSize(390, 129);
/* 34 */     setLocation(20, 40);
/*    */   }
/*    */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/PrefPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */