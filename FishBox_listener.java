/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.AbstractAction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FishBox_listener
/*     */   extends AbstractAction
/*     */ {
/*     */   public void actionPerformed(ActionEvent e) {
/* 151 */     FishJCheckBox source = (FishJCheckBox)e.getSource();
/* 152 */     ColoradoLakefinder.restore.setEnabled(true);
/* 153 */     if (!source.isSelected()) {
/*     */       
/* 155 */       LakeCheckBoxes.CB_vector.remove(source);
/* 156 */       if (LakeCheckBoxes.CB_vector.isEmpty())
/*     */       {
/* 158 */         ColoradoLakefinder.clear.setEnabled(false);
/* 159 */         ColoradoLakefinder.print.setEnabled(false);
/* 160 */         ColoradoLakefinder.find.setEnabled(false);
/* 161 */         ColoradoLakefinder.save.setEnabled(true);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 166 */       LakeCheckBoxes.CB_vector.add(source);
/* 167 */       ColoradoLakefinder.clear.setEnabled(true);
/* 168 */       ColoradoLakefinder.find.setEnabled(false);
/* 169 */       ColoradoLakefinder.save.setEnabled(true);
/*     */     } 
/* 171 */     LakeCheckBoxes.AllowFind();
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/FishBox_listener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */