/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JCheckBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LakeCheckBoxes
/*     */ {
/*  15 */   static final String OTHER = new String("Other");
/*  16 */   static final String BELOW = new String("Below");
/*  17 */   static final String ABOVE = new String("Above");
/*  18 */   static final String SMALL = new String("Smaller");
/*  19 */   static final String BIG = new String("Bigger");
/*  20 */   static final String DEEP = new String("Deeper");
/*  21 */   static final String SHALLOW = new String("Shallower");
/*  22 */   static final String PAGE = new String("Page");
/*  23 */   static final String NAME = new String("Name");
/*  24 */   static final String BROOK = new String("Brookie");
/*  25 */   static final String MACKINAW = new String("Mackinaw");
/*  26 */   static final String RAINBOW = new String("Rainbow");
/*  27 */   static final String CUTTHROAT = new String("Cutthroat");
/*  28 */   static final String KOKANEE = new String("Kokanee");
/*  29 */   static final String BROWN = new String("Brown");
/*     */   
/*     */   static BlinkingJCheckBox elev_high;
/*     */   static BlinkingJCheckBox elev_low;
/*     */   static BlinkingJCheckBox size_high;
/*     */   static BlinkingJCheckBox size_low;
/*     */   static BlinkingJCheckBox depth_high;
/*     */   static BlinkingJCheckBox depth_low;
/*     */   static BlinkingJCheckBox page;
/*     */   static BlinkingJCheckBox name;
/*     */   static BlinkingJCheckBox other;
/*  40 */   static FishJCheckBox brook = new FishJCheckBox(BROOK);
/*  41 */   static FishJCheckBox lake = new FishJCheckBox(MACKINAW);
/*  42 */   static FishJCheckBox rain = new FishJCheckBox(RAINBOW);
/*  43 */   static FishJCheckBox cutt = new FishJCheckBox(CUTTHROAT);
/*  44 */   static FishJCheckBox koke = new FishJCheckBox(KOKANEE);
/*  45 */   static FishJCheckBox brown = new FishJCheckBox(BROWN);
/*  46 */   private CheckBox_listener CBL = new CheckBox_listener();
/*  47 */   private FishBox_listener FBL = new FishBox_listener();
/*     */   
/*  49 */   public static ArrayList CB_vector = new ArrayList();
/*     */ 
/*     */   
/*     */   LakeCheckBoxes() {
/*  53 */     elev_high = new BlinkingJCheckBox(BELOW);
/*  54 */     elev_high.addActionListener(this.CBL);
/*  55 */     elev_low = new BlinkingJCheckBox(ABOVE);
/*  56 */     elev_low.addActionListener(this.CBL);
/*  57 */     size_high = new BlinkingJCheckBox(SMALL);
/*  58 */     size_high.addActionListener(this.CBL);
/*  59 */     size_low = new BlinkingJCheckBox(BIG);
/*  60 */     size_low.addActionListener(this.CBL);
/*  61 */     depth_high = new BlinkingJCheckBox(DEEP);
/*  62 */     depth_high.addActionListener(this.CBL);
/*  63 */     depth_low = new BlinkingJCheckBox(SHALLOW);
/*  64 */     depth_low.addActionListener(this.CBL);
/*  65 */     page = new BlinkingJCheckBox(PAGE);
/*  66 */     page.addActionListener(this.CBL);
/*  67 */     name = new BlinkingJCheckBox(NAME);
/*  68 */     name.addActionListener(this.CBL);
/*  69 */     other = new BlinkingJCheckBox(OTHER);
/*  70 */     other.addActionListener(this.CBL);
/*  71 */     brook.addActionListener(this.FBL);
/*  72 */     lake.addActionListener(this.FBL);
/*  73 */     rain.addActionListener(this.FBL);
/*  74 */     cutt.addActionListener(this.FBL);
/*  75 */     koke.addActionListener(this.FBL);
/*  76 */     brown.addActionListener(this.FBL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void Clear_FishBoxes() {
/*  81 */     int j = CB_vector.size();
/*     */     
/*  83 */     for (int i = j - 1; i >= 0; i--) {
/*     */       
/*  85 */       JCheckBox b = CB_vector.get(i);
/*  86 */       if (b.getActionCommand().matches("FISH")) {
/*     */         
/*  88 */         b.setSelected(false);
/*  89 */         CB_vector.remove(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void AllowFind() {
/*  96 */     boolean empty = CB_vector.isEmpty();
/*  97 */     if (empty) {
/*     */       
/*  99 */       ColoradoLakefinder.find.setEnabled(false);
/*     */     }
/*     */     else {
/*     */       
/* 103 */       ColoradoLakefinder.clear.setEnabled(true);
/* 104 */       ColoradoLakefinder.find.setEnabled(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/LakeCheckBoxes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */