/*   */ package com.apple.eawt;
/*   */ import java.awt.Canvas;
/*   */ import java.awt.Dimension;
/*   */ 
/*   */ public abstract class CocoaComponent extends Canvas {
/*   */   public long createNSViewLong() {
/* 7 */     return 0L;
/*   */   }
/*   */   
/*   */   public abstract int createNSView();
/*   */   
/*   */   public abstract Dimension getMaximumSize();
/*   */   
/*   */   public abstract Dimension getMinimumSize();
/*   */   
/*   */   public abstract Dimension getPreferredSize();
/*   */   
/*   */   public final void sendMessage(int paramInt, Object paramObject) {}
/*   */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/com/apple/eawt/CocoaComponent.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */