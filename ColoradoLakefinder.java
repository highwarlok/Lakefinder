/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ColoradoLakefinder
/*     */   extends JFrame
/*     */ {
/*     */   protected static myJButton restore;
/*     */   protected static myJButton save;
/*     */   protected static myJButton print;
/*     */   protected static myJButton clear;
/*     */   protected static myJButton quit;
/*     */   protected static myJButton find;
/*     */   protected static myJButton noise;
/*     */   public static boolean make_noise_B;
/*     */   protected static Color backgroundColor;
/*     */   protected static String outfile;
/*     */   protected static LakeCheckBoxes LCB;
/*     */   private MasterButtonPanel BP_master;
/*     */   private JPanel Org;
/*     */   private JPanel Top_Org;
/*     */   
/*     */   public ColoradoLakefinder() {
/*  50 */     outfile = getMyDir() + getMySeparator() + "LakeSave";
/*  51 */     backgroundColor = new Color(220, 175, 75);
/*  52 */     LCB = new LakeCheckBoxes();
/*  53 */     this.Org = new JPanel();
/*  54 */     this.Top_Org = new JPanel();
/*  55 */     this.Mid_Org = new JPanel();
/*  56 */     this.Bot_Org = new JPanel();
/*  57 */     this.D_pane = new JPanel();
/*  58 */     JSP_pane1 = new JScrollPane();
/*  59 */     JSP_pane2 = new JScrollPane();
/*  60 */     ITA = new IntroTextArea();
/*  61 */     this.TabPane = new JTabbedPane();
/*  62 */     this.AT = new AudioTester();
/*  63 */     this.button_panel_v_size = 260;
/*  64 */     this.button_panel_h_size = 190;
/*  65 */     this.scroll_panel_h_size = 300;
/*  66 */     this.scroll_panel_v_size = this.button_panel_v_size * 2;
/*  67 */     this.BP_master = new MasterButtonPanel(this.button_panel_h_size, this.button_panel_v_size);
/*  68 */     OK = true;
/*  69 */     JSP_pane1.setPreferredSize(new Dimension(this.scroll_panel_h_size, this.scroll_panel_v_size));
/*  70 */     Initialize_CheckBoxes();
/*  71 */     Initialize_Boxes();
/*  72 */     setTitle("Colorado Lakefinder 11 by Alan");
/*  73 */     setSize(this.button_panel_h_size * 3 + this.scroll_panel_h_size, this.button_panel_v_size * 2);
/*  74 */     addWindowListener(new WindowAdapter() {
/*  75 */           public void windowClosing(WindowEvent e) { System.exit(0); }
/*     */         });
/*  77 */     this; setDefaultLookAndFeelDecorated(true);
/*  78 */     getContentPane().setLayout(new BoxLayout(getContentPane(), 0));
/*  79 */     this.D_pane.setLayout(new BoxLayout(this.D_pane, 0));
/*  80 */     this.D_pane.add(this.Org);
/*  81 */     this.D_pane.add(JSP_pane1);
/*  82 */     JSP_pane2.setPreferredSize(getSize());
/*  83 */     this.TabPane.setFocusable(false);
/*  84 */     this.TabPane.addTab("Lake Search", this.D_pane);
/*  85 */     this.TabPane.addTab("My Search Results", JSP_pane2);
/*  86 */     getContentPane().add(this.TabPane);
/*  87 */     JRootPane RP = getRootPane();
/*  88 */     RP.setDefaultButton(find);
/*  89 */     pack();
/*  90 */     setVisible(true);
/*  91 */     toFront();
/*  92 */     LakeCheckBoxes.AllowFind();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     this.resbundle = ResourceBundle.getBundle("LakeFinderProjectstrings", Locale.getDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel Mid_Org;
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel Bot_Org;
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel D_pane;
/*     */ 
/*     */ 
/*     */   
/*     */   protected static JScrollPane JSP_pane1;
/*     */ 
/*     */ 
/*     */   
/*     */   protected static JScrollPane JSP_pane2;
/*     */ 
/*     */ 
/*     */   
/*     */   protected static IntroTextArea ITA;
/*     */ 
/*     */ 
/*     */   
/*     */   protected JTabbedPane TabPane;
/*     */ 
/*     */ 
/*     */   
/*     */   private AudioTester AT;
/*     */ 
/*     */ 
/*     */   
/*     */   private int button_panel_h_size;
/*     */ 
/*     */ 
/*     */   
/*     */   private int button_panel_v_size;
/*     */ 
/*     */ 
/*     */   
/*     */   private int scroll_panel_h_size;
/*     */ 
/*     */ 
/*     */   
/*     */   private int scroll_panel_v_size;
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean OK;
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceBundle resbundle;
/*     */ 
/*     */ 
/*     */   
/*     */   protected PrefPane prefs;
/*     */ 
/*     */ 
/*     */   
/*     */   public void Initialize_Boxes() {
/* 164 */     ButtonPanel BP_elev = new ButtonPanel(this.button_panel_h_size, this.button_panel_v_size);
/* 165 */     PairBox PB_elev_high = new PairBox();
/* 166 */     PairBox PB_elev_low = new PairBox();
/* 167 */     LabelBox LB_elev = new LabelBox();
/*     */     
/* 169 */     LB_elev.add(new JLabel("Select lakes above or  ", 0));
/* 170 */     LB_elev.add(Box.createVerticalGlue());
/* 171 */     LB_elev.add(new JLabel("below these elevations.", 0));
/* 172 */     PB_elev_high.add(LakeCheckBoxes.elev_high);
/* 173 */     PB_elev_high.add(LakeCheckBoxes.elev_high.textfield);
/* 174 */     PB_elev_low.add(LakeCheckBoxes.elev_low);
/* 175 */     PB_elev_low.add(LakeCheckBoxes.elev_low.textfield);
/* 176 */     BP_elev.setBorder(BorderFactory.createTitledBorder("Elevation Selection"));
/* 177 */     BP_elev.add(LB_elev);
/* 178 */     BP_elev.add(Box.createVerticalGlue());
/* 179 */     BP_elev.add(PB_elev_high);
/* 180 */     BP_elev.add(Box.createVerticalGlue());
/* 181 */     BP_elev.add(PB_elev_low);
/* 182 */     BP_elev.add(Box.createVerticalGlue());
/*     */     
/* 184 */     ButtonPanel BP_size = new ButtonPanel(this.button_panel_h_size, this.button_panel_v_size);
/* 185 */     LabelBox LB_size = new LabelBox();
/* 186 */     PairBox PB_size_high = new PairBox();
/* 187 */     PairBox PB_size_low = new PairBox();
/* 188 */     LB_size.add(new JLabel("Select lakes larger or   ", 0));
/* 189 */     LB_size.add(new JLabel("smaller than these sizes.", 0));
/* 190 */     PB_size_high.add(LakeCheckBoxes.size_high);
/* 191 */     PB_size_high.add(LakeCheckBoxes.size_high.textfield);
/* 192 */     PB_size_low.add(LakeCheckBoxes.size_low);
/* 193 */     PB_size_low.add(LakeCheckBoxes.size_low.textfield);
/* 194 */     BP_size.setBorder(BorderFactory.createTitledBorder("Size Selection"));
/* 195 */     BP_size.add(LB_size);
/* 196 */     BP_size.add(Box.createVerticalGlue());
/* 197 */     BP_size.add(PB_size_high);
/* 198 */     BP_size.add(Box.createVerticalGlue());
/* 199 */     BP_size.add(PB_size_low);
/* 200 */     BP_size.add(Box.createVerticalGlue());
/*     */     
/* 202 */     ButtonPanel BP_depth = new ButtonPanel(this.button_panel_h_size, this.button_panel_v_size);
/* 203 */     LabelBox LB_depth = new LabelBox();
/* 204 */     PairBox PB_depth_high = new PairBox();
/* 205 */     PairBox PB_depth_low = new PairBox();
/* 206 */     BP_depth.setBorder(BorderFactory.createTitledBorder("Depth Selection"));
/* 207 */     LB_depth.add(new JLabel("Select lakes deeper or      "));
/* 208 */     LB_depth.add(new JLabel("shallower than these depths."));
/* 209 */     PB_depth_high.add(LakeCheckBoxes.depth_high);
/* 210 */     PB_depth_high.add(LakeCheckBoxes.depth_high.textfield);
/* 211 */     PB_depth_low.add(LakeCheckBoxes.depth_low);
/* 212 */     PB_depth_low.add(LakeCheckBoxes.depth_low.textfield);
/* 213 */     BP_depth.add(LB_depth);
/* 214 */     BP_depth.add(Box.createVerticalGlue());
/* 215 */     BP_depth.add(PB_depth_high);
/* 216 */     BP_depth.add(Box.createVerticalGlue());
/* 217 */     BP_depth.add(PB_depth_low);
/* 218 */     BP_depth.add(Box.createVerticalGlue());
/*     */     
/* 220 */     ButtonPanel BP_page = new ButtonPanel(this.button_panel_h_size, this.button_panel_v_size);
/* 221 */     LabelBox LB_page = new LabelBox();
/* 222 */     LabelBox LB_name = new LabelBox();
/* 223 */     PairBox PB_page = new PairBox();
/* 224 */     PairBox PB_name = new PairBox();
/* 225 */     BP_page.setBorder(BorderFactory.createTitledBorder("Page and Name"));
/* 226 */     LB_page.add(new JLabel("Get lakes from this page"));
/* 227 */     LB_page.add(new JLabel("of the Colorado Atlas."));
/* 228 */     LB_name.add(new JLabel("Get lakes containing  "));
/* 229 */     LB_name.add(new JLabel("this name (or fragment)."));
/* 230 */     LB_name.add(Box.createVerticalGlue());
/* 231 */     PB_page.add(LakeCheckBoxes.page);
/* 232 */     PB_page.add(LakeCheckBoxes.page.textfield);
/* 233 */     PB_name.add(LakeCheckBoxes.name);
/* 234 */     PB_name.add(LakeCheckBoxes.name.textfield);
/* 235 */     BP_page.add(Box.createVerticalGlue());
/* 236 */     BP_page.add(LB_page);
/* 237 */     BP_page.add(PB_page);
/* 238 */     BP_page.add(Box.createVerticalGlue());
/* 239 */     BP_page.add(LB_name);
/* 240 */     BP_page.add(PB_name);
/* 241 */     BP_page.add(Box.createVerticalGlue());
/*     */     
/* 243 */     ButtonPanel BP_fish = new ButtonPanel(this.button_panel_h_size, this.button_panel_v_size);
/* 244 */     PairBox PB_other = new PairBox();
/* 245 */     BP_fish.setBorder(BorderFactory.createTitledBorder("Fish Species"));
/* 246 */     PB_other.add(Box.createHorizontalStrut(6));
/* 247 */     PB_other.add(LakeCheckBoxes.other);
/* 248 */     PB_other.add(LakeCheckBoxes.other.textfield);
/* 249 */     PB_other.add(Box.createHorizontalGlue());
/* 250 */     BP_fish.add(Box.createVerticalGlue());
/* 251 */     BP_fish.add(LakeCheckBoxes.brook);
/* 252 */     BP_fish.add(LakeCheckBoxes.lake);
/* 253 */     BP_fish.add(LakeCheckBoxes.rain);
/* 254 */     BP_fish.add(LakeCheckBoxes.cutt);
/* 255 */     BP_fish.add(LakeCheckBoxes.koke);
/* 256 */     BP_fish.add(LakeCheckBoxes.brown);
/* 257 */     BP_fish.add(PB_other);
/* 258 */     BP_fish.add(Box.createVerticalGlue());
/*     */     
/* 260 */     JSP_pane1.setBorder(BorderFactory.createTitledBorder("Lakes that match"));
/* 261 */     JSP_pane1.setViewportView(ITA);
/*     */     
/* 263 */     this.Top_Org.setLayout(new BoxLayout(this.Top_Org, 0));
/* 264 */     this.Mid_Org.setLayout(new BoxLayout(this.Mid_Org, 1));
/* 265 */     this.Bot_Org.setLayout(new BoxLayout(this.Bot_Org, 0));
/* 266 */     this.Top_Org.add(BP_elev);
/* 267 */     this.Top_Org.add(BP_depth);
/* 268 */     this.Top_Org.add(BP_size);
/* 269 */     this.Bot_Org.add(BP_page);
/* 270 */     this.Bot_Org.add(this.BP_master);
/* 271 */     this.Bot_Org.add(BP_fish);
/*     */     
/* 273 */     this.Org.setLayout(new BoxLayout(this.Org, 1));
/* 274 */     this.Org.setBackground(backgroundColor);
/* 275 */     this.Org.add(this.Top_Org);
/* 276 */     this.Org.add(Box.createVerticalGlue());
/* 277 */     this.Org.add(this.Mid_Org);
/* 278 */     this.Org.add(Box.createVerticalGlue());
/* 279 */     this.Org.add(this.Bot_Org);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void BoxFiller(String s, BlinkingJCheckBox bjcb) {
/* 286 */     String[] splits = s.split(":");
/* 287 */     if (splits[1].length() < 1)
/* 288 */       return;  bjcb.textfield.setText(splits[1]);
/* 289 */     bjcb.textfield.setEnabled(splits[2].matches("true"));
/* 290 */     bjcb.textfield.setFocusable(splits[3].matches("true"));
/* 291 */     bjcb.setFocusable(splits[4].matches("true"));
/* 292 */     bjcb.setSelected(splits[5].matches("true"));
/* 293 */     LakeCheckBoxes.CB_vector.add(bjcb);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void BoxFiller(String s, FishJCheckBox fjcb) {
/* 299 */     String[] splits = s.split(":");
/* 300 */     boolean state = splits[5].matches("true");
/* 301 */     fjcb.setSelected(state);
/* 302 */     if (state) LakeCheckBoxes.CB_vector.add(fjcb);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean Initialize_CheckBoxes() {
/* 308 */     LakeCheckBoxes.CB_vector.clear();
/* 309 */     clear.setEnabled(false);
/* 310 */     find.setEnabled(false);
/* 311 */     restore.setEnabled(false);
/* 312 */     save.setEnabled(false);
/* 313 */     noise.setEnabled(true);
/*     */     
/*     */     try {
/* 316 */       FileReader FR = new FileReader(outfile);
/* 317 */       BufferedReader BR = new BufferedReader(FR);
/*     */       
/* 319 */       String s = BR.readLine();
/* 320 */       BoxFiller(s, LakeCheckBoxes.elev_high);
/* 321 */       s = BR.readLine();
/* 322 */       BoxFiller(s, LakeCheckBoxes.elev_low);
/* 323 */       s = BR.readLine();
/* 324 */       BoxFiller(s, LakeCheckBoxes.size_high);
/* 325 */       s = BR.readLine();
/* 326 */       BoxFiller(s, LakeCheckBoxes.size_low);
/* 327 */       s = BR.readLine();
/* 328 */       BoxFiller(s, LakeCheckBoxes.depth_high);
/* 329 */       s = BR.readLine();
/* 330 */       BoxFiller(s, LakeCheckBoxes.depth_low);
/* 331 */       s = BR.readLine();
/* 332 */       BoxFiller(s, LakeCheckBoxes.other);
/* 333 */       s = BR.readLine();
/* 334 */       BoxFiller(s, LakeCheckBoxes.name);
/* 335 */       s = BR.readLine();
/* 336 */       BoxFiller(s, LakeCheckBoxes.page);
/* 337 */       s = BR.readLine();
/* 338 */       BoxFiller(s, LakeCheckBoxes.brook);
/* 339 */       s = BR.readLine();
/* 340 */       BoxFiller(s, LakeCheckBoxes.lake);
/* 341 */       s = BR.readLine();
/* 342 */       BoxFiller(s, LakeCheckBoxes.rain);
/* 343 */       s = BR.readLine();
/* 344 */       BoxFiller(s, LakeCheckBoxes.cutt);
/* 345 */       s = BR.readLine();
/* 346 */       BoxFiller(s, LakeCheckBoxes.koke);
/* 347 */       s = BR.readLine();
/* 348 */       BoxFiller(s, LakeCheckBoxes.brown);
/* 349 */       return OK;
/*     */     
/*     */     }
/* 352 */     catch (IOException e) {
/*     */       
/* 354 */       restore.setEnabled(false);
/* 355 */       System.out.println("Can't get input, missing file ==> " + outfile);
/* 356 */       System.out.println("Because of ==> " + e);
/*     */     }
/* 358 */     catch (NoSuchElementException e) {
/* 359 */       System.out.println("Hit the end of ==> " + outfile);
/*     */     }
/* 361 */     catch (NullPointerException e) {
/* 362 */       System.out.println("Caught a null pointer exception.");
/*     */     } 
/* 364 */     return !OK;
/*     */   }
/*     */   
/*     */   public static String getMyDir() {
/* 368 */     String dirPath, OS = System.getProperty("os.name").toUpperCase();
/* 369 */     String soundFile = "LakeFinderSounds";
/* 370 */     String installFolder = "Colorado Lakefinder 11";
/*     */ 
/*     */     
/* 373 */     if (OS.startsWith("MAC")) {
/*     */       
/* 375 */       dirPath = getMySeparator() + "Applications" + getMySeparator() + installFolder + getMySeparator() + soundFile;
/*     */     }
/*     */     else {
/*     */       
/* 379 */       dirPath = "C:" + getMySeparator() + installFolder + getMySeparator() + soundFile;
/*     */     } 
/* 381 */     return dirPath;
/*     */   }
/*     */   
/*     */   public static String getMySeparator() {
/* 385 */     return System.getProperty("file.separator");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 390 */     new ColoradoLakefinder();
/*     */   }
/*     */   
/*     */   class MasterButtonPanel
/*     */     extends JPanel
/*     */   {
/*     */     MasterButtonPanel(int x, int y) {
/* 397 */       setPreferredSize(new Dimension(x, y));
/* 398 */       setMaximumSize(new Dimension(x, y));
/* 399 */       setBackground(ColoradoLakefinder.backgroundColor);
/* 400 */       setLayout(new FlowLayout());
/* 401 */       setBorder(BorderFactory.createTitledBorder("Choose an action"));
/*     */       
/* 403 */       ColoradoLakefinder.restore = new myJButton("Restore");
/* 404 */       ColoradoLakefinder.save = new myJButton("Save");
/* 405 */       ColoradoLakefinder.print = new myJButton("Print");
/* 406 */       ColoradoLakefinder.clear = new myJButton("Clear");
/* 407 */       ColoradoLakefinder.quit = new myJButton("Quit");
/* 408 */       ColoradoLakefinder.find = new myJButton("Push to Find");
/* 409 */       ColoradoLakefinder.noise = new myJButton("Sounds Off");
/*     */       
/* 411 */       ColoradoLakefinder.find.addActionListener(new FindAction());
/* 412 */       ColoradoLakefinder.quit.addActionListener(new QuitAction());
/* 413 */       ColoradoLakefinder.clear.addActionListener(new ClearAction());
/* 414 */       ColoradoLakefinder.print.addActionListener(new PrintAction());
/* 415 */       ColoradoLakefinder.restore.addActionListener(new RestoreAction());
/* 416 */       ColoradoLakefinder.save.addActionListener(new SaveAction());
/* 417 */       ColoradoLakefinder.noise.addActionListener(new NoiseAction());
/*     */ 
/*     */       
/* 420 */       ColoradoLakefinder.find.setPreferredSize(new Dimension(150, 40));
/* 421 */       ColoradoLakefinder.find.setBackground(new Color(100, 50, 200));
/* 422 */       ColoradoLakefinder.find.setForeground(Color.black);
/*     */       
/* 424 */       Font default_font = ColoradoLakefinder.find.getFont();
/* 425 */       Font new_big_font = default_font.deriveFont(1, 16.0F);
/* 426 */       ColoradoLakefinder.find.setFont(new_big_font);
/* 427 */       ColoradoLakefinder.print.setEnabled(false);
/*     */       
/* 429 */       add(ColoradoLakefinder.find);
/* 430 */       add(ColoradoLakefinder.save);
/* 431 */       add(ColoradoLakefinder.quit);
/* 432 */       add(ColoradoLakefinder.clear);
/* 433 */       add(ColoradoLakefinder.print);
/* 434 */       add(ColoradoLakefinder.restore);
/* 435 */       add(ColoradoLakefinder.noise);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/ColoradoLakefinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */