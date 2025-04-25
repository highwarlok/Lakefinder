/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
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
/*     */ class CheckBox_listener
/*     */   implements ActionListener
/*     */ {
/*     */   public void actionPerformed(ActionEvent e) {
/* 115 */     BlinkingJCheckBox source = (BlinkingJCheckBox)e.getSource();
/* 116 */     if (!source.isSelected()) {
/*     */       
/* 118 */       source.textfield.setText("");
/* 119 */       source.textfield.setEnabled(false);
/* 120 */       LakeCheckBoxes.CB_vector.remove(source);
/* 121 */       if (LakeCheckBoxes.CB_vector.isEmpty())
/*     */       {
/* 123 */         ColoradoLakefinder.clear.setEnabled(false);
/* 124 */         ColoradoLakefinder.print.setEnabled(false);
/* 125 */         ColoradoLakefinder.find.setEnabled(false);
/* 126 */         ColoradoLakefinder.save.setEnabled(true);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 131 */       source.textfield.setFocusable(true);
/* 132 */       source.textfield.requestFocus();
/* 133 */       source.textfield.setEnabled(true);
/* 134 */       LakeCheckBoxes.CB_vector.add(source);
/*     */ 
/*     */       
/* 137 */       ColoradoLakefinder.clear.setEnabled(true);
/* 138 */       ColoradoLakefinder.print.setEnabled(false);
/* 139 */       ColoradoLakefinder.find.setEnabled(true);
/* 140 */       ColoradoLakefinder.save.setEnabled(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/CheckBox_listener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */