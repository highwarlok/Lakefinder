/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BlinkingJCheckBox
/*     */   extends JCheckBox
/*     */ {
/*     */   public JTextField textfield;
/* 194 */   Dimension text_box_size = new Dimension(100, 24);
/* 195 */   static Color CB_color = Color.cyan;
/* 196 */   private Push_Listener PL = new Push_Listener();
/* 197 */   private Caret_Listener CL = new Caret_Listener();
/*     */   BlinkingJCheckBox blink_me;
/* 199 */   int blink_count = 0;
/*     */   
/* 201 */   Timer CB_timer = new Timer(500, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 203 */           if (BlinkingJCheckBox.this.blink_count++ > 6)
/* 204 */             BlinkingJCheckBox.this.CB_timer.stop(); 
/* 205 */           if (BlinkingJCheckBox.this.blink_count % 2 == 1) {
/* 206 */             BlinkingJCheckBox.this.blink_me.setForeground(Color.red);
/*     */           } else {
/* 208 */             BlinkingJCheckBox.this.blink_me.setForeground(Color.black);
/*     */           } 
/*     */         }
/*     */       });
/*     */   
/*     */   BlinkingJCheckBox(String s) {
/* 214 */     super(s);
/*     */     
/* 216 */     setForeground(Color.black);
/* 217 */     setFocusable(false);
/* 218 */     this.textfield = new JTextField();
/* 219 */     this.textfield.setEnabled(false);
/* 220 */     this.textfield.setMaximumSize(this.text_box_size);
/* 221 */     this.textfield.setPreferredSize(this.text_box_size);
/* 222 */     this.textfield.setActionCommand("TextField");
/* 223 */     this.textfield.addActionListener(this.PL);
/* 224 */     this.textfield.addCaretListener(this.CL);
/*     */   }
/*     */ 
/*     */   
/*     */   void Blink(BlinkingJCheckBox comp) {
/* 229 */     this.blink_me = comp;
/* 230 */     comp.blink_count = 0;
/* 231 */     this.CB_timer.start();
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/BlinkingJCheckBox.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */