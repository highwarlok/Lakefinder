/*    */ import java.awt.print.PrinterJob;
/*    */ import java.util.Vector;
/*    */ import javax.print.attribute.HashPrintRequestAttributeSet;
/*    */ import javax.print.attribute.standard.OrientationRequested;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LakePrinter
/*    */ {
/* 12 */   HashPrintRequestAttributeSet h_pras = new HashPrintRequestAttributeSet();
/* 13 */   PrinterJob job = PrinterJob.getPrinterJob();
/*    */ 
/*    */   
/*    */   LakePrinter(Vector V) {
/* 17 */     this.h_pras.add(OrientationRequested.LANDSCAPE);
/* 18 */     this.job.setPrintable(new PrintListingPainter(V)); try {
/* 19 */       this.job.print(this.h_pras);
/* 20 */     } catch (Exception e) {
/*    */       
/* 22 */       System.out.println("Print Job exception");
/* 23 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/LakePrinter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */