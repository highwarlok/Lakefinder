/*    */ package com.apple.eawt;
/*    */ 
/*    */ import java.util.EventObject;
/*    */ 
/*    */ public class ApplicationEvent
/*    */   extends EventObject {
/*    */   ApplicationEvent(Object paramObject) {
/*  8 */     super(paramObject);
/*    */   }
/*    */   
/*    */   ApplicationEvent(Object paramObject, String paramString) {
/* 12 */     super(paramObject);
/*    */   }
/*    */   
/*    */   public boolean isHandled() {
/* 16 */     return false;
/*    */   }
/*    */   
/*    */   public void setHandled(boolean paramBoolean) {}
/*    */   
/*    */   public String getFilename() {
/* 22 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/com/apple/eawt/ApplicationEvent.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */