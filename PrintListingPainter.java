/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.LineBreakMeasurer;
/*     */ import java.awt.font.TextAttribute;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Printable;
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.text.AttributedString;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PrintListingPainter
/*     */   implements Printable
/*     */ {
/*  30 */   private Font bodyfnt = new Font("Courier", 0, 10);
/*  31 */   private Font microfnt = new Font("Courier", 0, 7);
/*  32 */   private int rememberedPageIndex = -1;
/*  33 */   private int EndPosition = 0;
/*  34 */   private int LinePosition = 0;
/*  35 */   private int StartPosition = 0;
/*     */   private boolean rememberedEOF = false;
/*     */   private boolean FinishedLastLine = true;
/*     */   private Vector V;
/*  39 */   int vectorStart = 0;
/*  40 */   int vectorCurrent = 0;
/*  41 */   int vectorEnd = 0;
/*     */   PrintListingPainter(Vector v) {
/*  43 */     this.V = v;
/*     */   }
/*     */ 
/*     */   
/*     */   public int print(Graphics g, PageFormat pf, int pageIndex) {
/*  48 */     Graphics2D g2d = (Graphics2D)g;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     if (pageIndex != this.rememberedPageIndex) {
/*     */       
/*  55 */       this.rememberedPageIndex = pageIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  61 */       if (this.rememberedEOF || (this.vectorEnd == this.V.size() && this.LinePosition == 0))
/*     */       {
/*     */ 
/*     */         
/*  65 */         return 1;
/*     */       }
/*  67 */       this.LinePosition = this.EndPosition;
/*  68 */       this.StartPosition = this.LinePosition;
/*  69 */       this.vectorCurrent = this.vectorEnd;
/*  70 */       this.vectorStart = this.vectorCurrent;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  75 */       this.LinePosition = this.StartPosition;
/*  76 */       this.vectorCurrent = this.vectorStart;
/*     */     } 
/*     */     
/*  79 */     g2d.setFont(this.bodyfnt);
/*  80 */     g2d.setColor(Color.black);
/*  81 */     int x = (int)pf.getImageableX();
/*  82 */     int y = (int)pf.getImageableY() + this.bodyfnt.getSize();
/*  83 */     float Y_Delta = GetDeltaY(this.bodyfnt, g2d);
/*  84 */     double pageHeightY = pf.getImageableY() + pf.getImageableHeight();
/*     */     
/*  86 */     double pageWidthX = pf.getImageableWidth();
/*  87 */     FontRenderContext FRC = g2d.getFontRenderContext();
/*     */     
/*     */     do {
/*  90 */       if (this.vectorCurrent >= this.V.size()) {
/*     */ 
/*     */         
/*  93 */         this.rememberedEOF = true;
/*  94 */         return 0;
/*     */       } 
/*  96 */       String line = this.V.get(this.vectorCurrent);
/*     */       
/*  98 */       this.vectorCurrent++;
/*  99 */       if (line == null) line = " "; 
/* 100 */       if (line.length() == 0) line = " "; 
/* 101 */       AttributedString AS = new AttributedString(line);
/* 102 */       AS.addAttribute(TextAttribute.FONT, this.bodyfnt);
/* 103 */       AttributedCharacterIterator ACI = AS.getIterator();
/* 104 */       int ACIend = ACI.getEndIndex();
/* 105 */       LineBreakMeasurer LBM = new LineBreakMeasurer(ACI, FRC);
/* 106 */       LBM.setPosition(this.LinePosition);
/* 107 */       while (this.LinePosition < ACIend && y < pageHeightY) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 112 */         TextLayout TLayout = LBM.nextLayout((float)pageWidthX);
/* 113 */         TLayout.draw(g2d, x, y);
/* 114 */         y = (int)(y + Y_Delta);
/* 115 */         this.LinePosition = LBM.getPosition();
/*     */       } 
/*     */       
/* 118 */       if (this.LinePosition == ACIend)
/*     */       {
/* 120 */         this.vectorEnd = this.vectorCurrent;
/* 121 */         this.FinishedLastLine = true;
/* 122 */         this.LinePosition = 0;
/*     */       }
/*     */       else
/*     */       {
/* 126 */         this.vectorEnd = this.vectorCurrent - 1;
/* 127 */         System.out.println("...backing up...");
/* 128 */         this.FinishedLastLine = false;
/* 129 */         this.EndPosition = this.LinePosition;
/*     */       }
/*     */     
/* 132 */     } while (y < pageHeightY);
/*     */ 
/*     */     
/* 135 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float GetDeltaY(Font f, Graphics2D g2d) {
/* 141 */     String test = "The quick brown fox jumped over the lazy dog!@#$%^&*()|;]~`";
/* 142 */     AttributedString AStest = new AttributedString(test);
/* 143 */     AStest.addAttribute(TextAttribute.FONT, f);
/* 144 */     AttributedCharacterIterator ACItest = AStest.getIterator();
/* 145 */     FontRenderContext FRCtest = g2d.getFontRenderContext();
/* 146 */     LineBreakMeasurer LBMtest = new LineBreakMeasurer(ACItest, FRCtest);
/* 147 */     TextLayout TLtest = LBMtest.nextLayout(500.0F);
/* 148 */     return TLtest.getDescent() + TLtest.getLeading() + TLtest.getAscent();
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/PrintListingPainter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */