/*     */ import java.awt.Font;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JList;
/*     */ 
/*     */ public class LakeButtons {
/*  10 */   private static DefaultListModel defaultlistmodel = new DefaultListModel();
/*  11 */   private static JList output_JList = new JList();
/*  12 */   static final String WIPE = null;
/*  13 */   protected static Vector printing_vector = new Vector(4000);
/*  14 */   protected static Vector filter_vector = new Vector(4000);
/*  15 */   private static LakeDataSet output_dataset = new LakeDataSet();
/*  16 */   private static LakeDataSet output_dataset1 = new LakeDataSet();
/*  17 */   static int fish_filter_counter = 0;
/*  18 */   private static String seperator = System.getProperty("line.separator");
/*     */   
/*  20 */   static int name_location = 1;
/*  21 */   static int town_location = 2;
/*  22 */   static int elevation_location = 3;
/*  23 */   static int page_location = 4;
/*  24 */   static int size_location = 5;
/*  25 */   static int avgdepth_location = 6;
/*  26 */   static int maxdepth_location = 7;
/*  27 */   static int fishname_location = 9;
/*  28 */   static int stocked_location = 10;
/*     */   
/*     */   static StringBuffer[] sss;
/*     */   
/*     */   public static void ToggleSounds() {
/*  33 */     ColoradoLakefinder.make_noise_B = !ColoradoLakefinder.make_noise_B;
/*     */     
/*  35 */     if (ColoradoLakefinder.make_noise_B) {
/*     */       
/*  37 */       ColoradoLakefinder.noise.setText("Sounds On");
/*  38 */       AudioTester.ding();
/*     */     } else {
/*  40 */       ColoradoLakefinder.noise.setText("Sounds Off");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void RestoreAll() {
/*  48 */     ColoradoLakefinder.print.setEnabled(false);
/*  49 */     if (ColoradoLakefinder.Initialize_CheckBoxes() == true) {
/*     */       
/*  51 */       AudioTester.ding();
/*  52 */       ColoradoLakefinder.restore.setEnabled(false);
/*  53 */       if (!LakeCheckBoxes.CB_vector.isEmpty()) {
/*  54 */         ColoradoLakefinder.clear.setEnabled(true);
/*     */       }
/*  56 */       LakeCheckBoxes.AllowFind();
/*     */     }
/*     */     else {
/*     */       
/*  60 */       ColoradoLakefinder.restore.setEnabled(false);
/*  61 */       ColoradoLakefinder.find.setEnabled(false);
/*  62 */       AudioTester.break_glass();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void PrintAll() {
/*  68 */     printing_vector.clear();
/*  69 */     int l = sss.length;
/*     */ 
/*     */ 
/*     */     
/*  73 */     for (int i = 0; i < l - 1; i++) {
/*  74 */       String line = sss[i].toString();
/*  75 */       int cr_location = line.indexOf('\n');
/*     */       
/*  77 */       if (cr_location < 1) {
/*  78 */         printing_vector.add(sss[i].toString());
/*     */       } else {
/*  80 */         printing_vector.add(sss[i].substring(0, cr_location - 1));
/*  81 */         printing_vector.add(sss[i].substring(cr_location + 1, line.length()));
/*     */       } 
/*  83 */       if (i > 1) {
/*  84 */         printing_vector.add(" ");
/*     */       }
/*     */     } 
/*  87 */     LakePrinter printNOW = new LakePrinter(printing_vector);
/*  88 */     AudioTester.ding();
/*     */   }
/*     */ 
/*     */   
/*     */   static void WriteBox(BlinkingJCheckBox bjcb, PrintWriter pw) {
/*  93 */     pw.println(bjcb.getText() + ":" + bjcb.textfield.getText() + ":" + bjcb.textfield.isEnabled() + ":" + bjcb.textfield.isFocusable() + ":" + bjcb.isFocusable() + ":" + bjcb.isSelected());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void WriteBox(FishJCheckBox fjcb, PrintWriter pw) {
/* 103 */     pw.println(fjcb.getText() + ":" + fjcb.textfield + ":" + "false" + ":" + "false" + ":" + "false" + ":" + fjcb.isSelected());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SaveAll() {
/*     */     try {
/* 115 */       FileWriter FW = new FileWriter(ColoradoLakefinder.outfile);
/* 116 */       BufferedWriter BW = new BufferedWriter(FW);
/* 117 */       PrintWriter PW = new PrintWriter(BW);
/* 118 */       WriteBox(LakeCheckBoxes.elev_high, PW);
/* 119 */       WriteBox(LakeCheckBoxes.elev_low, PW);
/* 120 */       WriteBox(LakeCheckBoxes.size_high, PW);
/* 121 */       WriteBox(LakeCheckBoxes.size_low, PW);
/* 122 */       WriteBox(LakeCheckBoxes.depth_high, PW);
/* 123 */       WriteBox(LakeCheckBoxes.depth_low, PW);
/* 124 */       WriteBox(LakeCheckBoxes.other, PW);
/* 125 */       WriteBox(LakeCheckBoxes.name, PW);
/* 126 */       WriteBox(LakeCheckBoxes.page, PW);
/* 127 */       WriteBox(LakeCheckBoxes.brook, PW);
/* 128 */       WriteBox(LakeCheckBoxes.lake, PW);
/* 129 */       WriteBox(LakeCheckBoxes.rain, PW);
/* 130 */       WriteBox(LakeCheckBoxes.cutt, PW);
/* 131 */       WriteBox(LakeCheckBoxes.koke, PW);
/* 132 */       WriteBox(LakeCheckBoxes.brown, PW);
/*     */       
/* 134 */       PW.close();
/* 135 */       BW.close();
/* 136 */       ColoradoLakefinder.save.setEnabled(false);
/* 137 */       ColoradoLakefinder.restore.setEnabled(true);
/* 138 */       AudioTester.ding();
/*     */     }
/* 140 */     catch (IOException e) {
/*     */       
/* 142 */       System.out.println("Here we have a failure to write...");
/* 143 */       e.printStackTrace();
/* 144 */       AudioTester.break_glass();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void ClearAll() {
/* 150 */     ColoradoLakefinder.find.setEnabled(false);
/* 151 */     ColoradoLakefinder.print.setEnabled(false);
/* 152 */     ColoradoLakefinder.clear.setEnabled(false);
/* 153 */     ColoradoLakefinder.save.setEnabled(true);
/* 154 */     ColoradoLakefinder.restore.setEnabled(true);
/*     */     
/* 156 */     ColoradoLakefinder.JSP_pane1.setViewportView(ColoradoLakefinder.ITA);
/* 157 */     ColoradoLakefinder.JSP_pane2.setViewportView(null);
/* 158 */     int j = LakeCheckBoxes.CB_vector.size();
/* 159 */     for (int i = 0; i < j; i++) {
/*     */       
/* 161 */       JCheckBox b = LakeCheckBoxes.CB_vector.remove(0);
/* 162 */       if (b.getActionCommand().matches("FISH")) {
/*     */         
/* 164 */         FishJCheckBox fb = (FishJCheckBox)b;
/* 165 */         fb.setSelected(false);
/*     */       }
/*     */       else {
/*     */         
/* 169 */         BlinkingJCheckBox cb = (BlinkingJCheckBox)b;
/* 170 */         cb.textfield.setText("");
/* 171 */         cb.textfield.setEnabled(false);
/* 172 */         cb.setSelected(false);
/*     */       } 
/*     */     } 
/* 175 */     LakeCheckBoxes.AllowFind();
/* 176 */     AudioTester.ding();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void FindAll() {
/* 188 */     int number_of_activated_checkboxes = LakeCheckBoxes.CB_vector.size();
/*     */     
/* 190 */     defaultlistmodel.clear();
/* 191 */     output_dataset.setText(WIPE);
/* 192 */     output_dataset1.setText(WIPE);
/* 193 */     String buff = "                                                ";
/*     */     
/* 195 */     int ix0 = -8;
/* 196 */     int ix1 = 8 + ix0;
/* 197 */     int ix2 = 25 + ix1;
/* 198 */     int ix3 = 15 + ix2;
/* 199 */     int ix4 = 7 + ix3;
/* 200 */     int ix5 = 5 + ix4;
/* 201 */     int ix6 = 7 + ix5;
/* 202 */     int ix7 = 6 + ix6;
/* 203 */     int ix8 = 9 + ix7;
/* 204 */     int ix9 = 70 + ix8;
/* 205 */     int ix10 = 80 + ix9;
/* 206 */     int ix11 = 10 + ix10;
/* 207 */     int ix12 = 10 + ix11;
/* 208 */     int ix13 = 10 + ix12;
/* 209 */     int ix14 = 10 + ix13;
/* 210 */     int ix15 = 10 + ix14;
/* 211 */     int ix16 = 10 + ix15;
/* 212 */     int ix17 = 10 + ix16;
/* 213 */     int ix18 = 10 + ix17;
/* 214 */     int ix19 = 10 + ix18;
/* 215 */     int ix20 = 10 + ix19;
/* 216 */     int[] idx = { ix0, ix1, ix2, ix3, ix4, ix5, ix6, ix7, ix8, ix9, ix10, ix11, ix12, ix13, ix14, ix15, ix16, ix17, ix18, ix19, ix20 };
/*     */ 
/*     */ 
/*     */     
/* 220 */     if (!IsCheckBoxData_Valid(number_of_activated_checkboxes)) {
/*     */       
/* 222 */       AudioTester.break_glass();
/* 223 */       ColoradoLakefinder.print.setEnabled(false);
/* 224 */       ColoradoLakefinder.save.setEnabled(false);
/* 225 */       ColoradoLakefinder.find.setEnabled(false);
/*     */       
/*     */       return;
/*     */     } 
/* 229 */     int number_of_valid_lakes = Filter_Activate(number_of_activated_checkboxes);
/*     */     
/* 231 */     if (number_of_valid_lakes < 1) {
/*     */       
/* 233 */       output_dataset.setRed();
/* 234 */       output_dataset.append("No lakes matched your search.");
/* 235 */       output_dataset.append("Change your search parameters.");
/* 236 */       ColoradoLakefinder.JSP_pane1.setViewportView(output_dataset);
/* 237 */       ColoradoLakefinder.JSP_pane2.setViewportView(null);
/* 238 */       ColoradoLakefinder.print.setEnabled(false);
/* 239 */       ColoradoLakefinder.find.setEnabled(false);
/* 240 */       AudioTester.break_glass();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 245 */     AudioTester.tada();
/* 246 */     ColoradoLakefinder.print.setEnabled(true);
/* 247 */     ColoradoLakefinder.save.setEnabled(true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     sss = new StringBuffer[4 + number_of_valid_lakes];
/*     */     
/* 254 */     for (int j = 0; j < 5; ) { sss[j] = new StringBuffer(200); j++; }
/* 255 */      int i = 0;
/* 256 */     sss[i].append("Your search found " + Integer.toString(number_of_valid_lakes) + " lakes");
/* 257 */     output_dataset1.append(sss[i].toString());
/* 258 */     i++;
/* 259 */     sss[i].append("Lake Name                                      Atlas       max   avg ");
/* 260 */     output_dataset1.append(sss[i].toString());
/* 261 */     defaultlistmodel.addElement(sss[i]);
/* 262 */     i++;
/* 263 */     sss[i].append("Historical fish          City       Elevation  Pg.  size   Depth Depth    Comments");
/* 264 */     output_dataset1.append(sss[i].toString());
/* 265 */     defaultlistmodel.addElement(sss[i]);
/* 266 */     i++;
/*     */     
/* 268 */     for (Enumeration<String> e = filter_vector.elements(); e.hasMoreElements(); ) {
/*     */       
/* 270 */       String s = e.nextElement();
/* 271 */       String[] ss = s.split("\\$");
/* 272 */       sss[i] = new StringBuffer(buff + buff + buff + buff);
/*     */       
/* 274 */       for (int m = name_location; m < ss.length; m++) {
/*     */         
/* 276 */         int len = ss[m].length();
/* 277 */         if (m < fishname_location) { sss[i].replace(idx[m], idx[m] + len + 1, ss[m]); }
/* 278 */         else if (m == fishname_location) { sss[i].append("\n" + ss[m]); }
/* 279 */         else if (m == stocked_location) { sss[i].append("  Recent ==> " + ss[m]); }
/* 280 */         else if (m > stocked_location) { sss[i].append("  " + ss[m]); }
/*     */       
/*     */       } 
/* 283 */       output_dataset1.append(sss[i].toString());
/* 284 */       defaultlistmodel.addElement(sss[i].toString());
/* 285 */       i++;
/*     */     } 
/*     */     
/* 288 */     sss[i] = new StringBuffer();
/* 289 */     char C = '©';
/* 290 */     sss[i].append("\n" + C + " 2004-2012 Alan Malkiel.");
/* 291 */     defaultlistmodel.addElement(sss[i]);
/*     */     
/* 293 */     output_dataset1.append(seperator + C + "2004-2012 Alan Malkiel.");
/* 294 */     output_dataset1.setFont(new Font("Courier", 0, 11));
/* 295 */     output_JList.setModel(defaultlistmodel);
/* 296 */     output_JList.setFont(new Font("Courier", 0, 12));
/* 297 */     output_JList.setSelectionInterval(1, 2);
/*     */     class MyCellRenderer
/*     */       extends JTextArea implements ListCellRenderer {
/* 300 */       int count = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
/* 308 */         this.count++;
/* 309 */         String s = value.toString();
/* 310 */         setText(s);
/* 311 */         setEnabled(true);
/* 312 */         setFont(new Font("Courier", 0, 12));
/* 313 */         return this;
/*     */       }
/*     */     };
/*     */     
/* 317 */     output_JList.setCellRenderer(new MyCellRenderer());
/*     */     
/* 319 */     ColoradoLakefinder.JSP_pane2.setViewportView(output_JList);
/* 320 */     ColoradoLakefinder.JSP_pane1.setViewportView(output_dataset1);
/* 321 */     output_dataset1.setCaretPosition(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean IsCheckBoxData_Valid(int vector_size) {
/* 333 */     boolean status = true;
/* 334 */     BlinkingJCheckBox cb = null;
/* 335 */     FishJCheckBox fb = null;
/*     */ 
/*     */     
/* 338 */     if (vector_size == 0) { Alert_User(null); return false; }
/*     */     
/* 340 */     for (int i = 0; i < vector_size; i++) {
/*     */       
/* 342 */       JCheckBox b = LakeCheckBoxes.CB_vector.get(i);
/* 343 */       String action_command = b.getActionCommand();
/* 344 */       if (action_command.matches("FISH")) {
/*     */         
/* 346 */         fish_filter_counter++;
/*     */       } else {
/*     */         
/* 349 */         cb = (BlinkingJCheckBox)b;
/* 350 */         String text_string = "";
/* 351 */         text_string = cb.textfield.getText();
/* 352 */         if (text_string.matches("")) { Alert_User(cb); status = false; }
/*     */         
/* 354 */         else if (action_command.matches(LakeCheckBoxes.BIG))
/*     */         
/* 356 */         { if (!text_string.matches("\\d{1,5}"))
/*     */           {
/* 358 */             Alert_User(cb);
/* 359 */             status = false;
/*     */           }
/*     */            }
/* 362 */         else if (action_command.matches(LakeCheckBoxes.SMALL))
/*     */         
/* 364 */         { if (!text_string.matches("\\d{1,5}")) {
/*     */             
/* 366 */             Alert_User(cb);
/* 367 */             status = false;
/*     */           
/*     */           }
/* 370 */           else if (LakeCheckBoxes.CB_vector.contains(LakeCheckBoxes.size_low)) {
/*     */ 
/*     */             
/* 373 */             String small_str = LakeCheckBoxes.size_low.textfield.getText();
/* 374 */             if (!small_str.matches("\\d{1,5}")) {
/*     */               
/* 376 */               Alert_User(cb);
/* 377 */               status = false;
/*     */             } else {
/*     */               
/* 380 */               int small = Integer.parseInt(small_str);
/* 381 */               int big = Integer.parseInt(cb.textfield.getText());
/* 382 */               if (small > big) {
/*     */                 
/* 384 */                 Alert_User(cb);
/* 385 */                 Alert_User(LakeCheckBoxes.size_low);
/* 386 */                 status = false;
/*     */               } 
/*     */             } 
/*     */           }  }
/* 390 */         else if (action_command.matches(LakeCheckBoxes.SHALLOW))
/*     */         
/* 392 */         { if (!text_string.matches("\\d{1,3}"))
/*     */           {
/* 394 */             Alert_User(cb);
/* 395 */             status = false;
/*     */           }
/*     */            }
/* 398 */         else if (action_command.matches(LakeCheckBoxes.DEEP))
/*     */         
/* 400 */         { if (!text_string.matches("\\d{1,3}") || Integer.parseInt(text_string) > 500) {
/*     */ 
/*     */             
/* 403 */             Alert_User(cb);
/* 404 */             status = false;
/*     */           
/*     */           }
/* 407 */           else if (LakeCheckBoxes.CB_vector.contains(LakeCheckBoxes.depth_low)) {
/*     */ 
/*     */             
/* 410 */             String shallow_str = LakeCheckBoxes.depth_low.textfield.getText();
/* 411 */             if (!shallow_str.matches("\\d{1,3}")) {
/*     */               
/* 413 */               Alert_User(cb);
/* 414 */               status = false;
/*     */             } else {
/*     */               
/* 417 */               int shallow = Integer.parseInt(shallow_str);
/* 418 */               int deep = Integer.parseInt(cb.textfield.getText());
/* 419 */               if (shallow < deep) {
/*     */                 
/* 421 */                 Alert_User(cb);
/* 422 */                 Alert_User(LakeCheckBoxes.depth_low);
/* 423 */                 status = false;
/*     */               } 
/*     */             } 
/*     */           }  }
/* 427 */         else if (action_command.matches(LakeCheckBoxes.ABOVE))
/*     */         
/* 429 */         { if (!text_string.matches("\\d{1,5}") || Integer.parseInt(text_string) > 19999)
/*     */           {
/*     */             
/* 432 */             Alert_User(cb);
/* 433 */             status = false;
/*     */           }
/*     */            }
/* 436 */         else if (action_command.matches(LakeCheckBoxes.BELOW))
/*     */         
/* 438 */         { if (!text_string.matches("\\d{4,5}") || Integer.parseInt(text_string) > 19999) {
/*     */ 
/*     */             
/* 441 */             Alert_User(cb);
/* 442 */             status = false;
/*     */           
/*     */           }
/* 445 */           else if (LakeCheckBoxes.CB_vector.contains(LakeCheckBoxes.elev_low)) {
/*     */ 
/*     */             
/* 448 */             String low_str = LakeCheckBoxes.elev_low.textfield.getText();
/* 449 */             if (!low_str.matches("\\d{4,5}")) {
/*     */               
/* 451 */               Alert_User(cb);
/* 452 */               status = false;
/*     */             } else {
/*     */               
/* 455 */               int low = Integer.parseInt(low_str);
/* 456 */               int high = Integer.parseInt(cb.textfield.getText());
/* 457 */               if (low > high) {
/*     */                 
/* 459 */                 Alert_User(cb);
/* 460 */                 Alert_User(LakeCheckBoxes.elev_low);
/* 461 */                 status = false;
/*     */               } 
/*     */             } 
/*     */           }  }
/* 465 */         else if (action_command.matches(LakeCheckBoxes.PAGE))
/*     */         
/* 467 */         { if (!text_string.matches("\\d{1,3}") || Integer.parseInt(text_string) > 113) {
/*     */             
/* 469 */             Alert_User(cb); status = false;
/*     */           }  }
/* 471 */         else if (action_command.matches(LakeCheckBoxes.NAME))
/*     */         
/* 473 */         { if (!text_string.matches(".+")) {
/* 474 */             Alert_User(cb); status = false;
/*     */           }  }
/* 476 */         else if (action_command.matches(LakeCheckBoxes.OTHER))
/*     */         
/* 478 */         { if (!text_string.matches(".+")) {
/* 479 */             Alert_User(cb); status = false;
/*     */           }  }
/*     */       
/*     */       } 
/*     */     } 
/* 484 */     return status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int Filter_Activate(int cb_vector_size) {
/* 495 */     int current_lake_count = 0;
/* 496 */     String text_string = "";
/* 497 */     String fish_string = "";
/*     */     
/* 499 */     BlinkingJCheckBox cb = null;
/* 500 */     FishJCheckBox fb = null;
/*     */ 
/*     */ 
/*     */     
/* 504 */     filter_vector.clear();
/*     */     
/* 506 */     filter_vector.addAll(Arrays.asList(Lake_Data_Rev11.lake_data_rev11));
/*     */     
/* 508 */     for (int i = 0; i < cb_vector_size; i++) {
/*     */       
/* 510 */       JCheckBox b = LakeCheckBoxes.CB_vector.get(i);
/* 511 */       String action_command = b.getActionCommand();
/* 512 */       if (action_command.matches("FISH")) {
/*     */         
/* 514 */         fb = (FishJCheckBox)b;
/* 515 */         text_string = fb.textfield;
/*     */       }
/*     */       else {
/*     */         
/* 519 */         text_string = ((BlinkingJCheckBox)b).textfield.getText();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 525 */       if (action_command.matches(LakeCheckBoxes.BIG)) {
/*     */         
/* 527 */         int limit = Integer.parseInt(text_string);
/* 528 */         current_lake_count = LakeFilter.FilterSizeBigger(limit);
/*     */       }
/* 530 */       else if (action_command.matches(LakeCheckBoxes.SMALL)) {
/*     */         
/* 532 */         int limit = Integer.parseInt(text_string);
/* 533 */         current_lake_count = LakeFilter.FilterSizeSmaller(limit);
/*     */       }
/* 535 */       else if (action_command.matches(LakeCheckBoxes.SHALLOW)) {
/*     */         
/* 537 */         int limit = Integer.parseInt(text_string);
/* 538 */         current_lake_count = LakeFilter.FilterDepthShallower(limit);
/*     */       }
/* 540 */       else if (action_command.matches(LakeCheckBoxes.DEEP)) {
/*     */         
/* 542 */         int limit = Integer.parseInt(text_string);
/* 543 */         current_lake_count = LakeFilter.FilterDepthDeeper(limit);
/*     */       }
/* 545 */       else if (action_command.matches(LakeCheckBoxes.ABOVE)) {
/*     */         
/* 547 */         int limit = Integer.parseInt(text_string);
/* 548 */         current_lake_count = LakeFilter.FilterElevationAbove(limit);
/*     */       }
/* 550 */       else if (action_command.matches(LakeCheckBoxes.BELOW)) {
/*     */         
/* 552 */         int limit = Integer.parseInt(text_string);
/* 553 */         current_lake_count = LakeFilter.FilterElevationBelow(limit);
/*     */       }
/* 555 */       else if (action_command.matches(LakeCheckBoxes.PAGE)) {
/*     */         
/* 557 */         int limit = Integer.parseInt(text_string);
/* 558 */         current_lake_count = LakeFilter.FilterPage(limit);
/*     */       }
/* 560 */       else if (action_command.matches(LakeCheckBoxes.NAME)) {
/*     */         
/* 562 */         String search_name = text_string.toUpperCase();
/* 563 */         current_lake_count = LakeFilter.FilterName(search_name);
/*     */       }
/* 565 */       else if (action_command.matches(LakeCheckBoxes.OTHER)) {
/*     */         
/* 567 */         String fish_name = text_string.toUpperCase();
/* 568 */         current_lake_count = LakeFilter.FilterUserFish(fish_name);
/*     */       }
/* 570 */       else if (action_command.matches("FISH")) {
/*     */         
/* 572 */         if (fish_filter_counter-- > 1) {
/*     */           
/* 574 */           fish_string = fish_string + ".*" + text_string + ".*|";
/*     */         }
/*     */         else {
/*     */           
/* 578 */           fish_string = fish_string + ".*" + text_string + ".*";
/* 579 */           current_lake_count = LakeFilter.FilterFishSpecies(fish_string);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 584 */     return current_lake_count;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class LakeFilter
/*     */   {
/*     */     static String this_lake;
/*     */ 
/*     */     
/*     */     static String all_fish;
/*     */ 
/*     */     
/*     */     static String temp;
/*     */     
/*     */     static String[] this_lake_parts;
/*     */     
/*     */     static String[] user_typed_fish_array;
/*     */     
/*     */     static String user_fish;
/*     */ 
/*     */     
/*     */     public static int FilterUserFish(String user_typed_fish) {
/* 607 */       user_typed_fish_array = user_typed_fish.split("\\&");
/* 608 */       for (int j = 0; j < user_typed_fish_array.length; j++) {
/*     */         
/* 610 */         user_fish = ".*(" + user_typed_fish_array[j] + ").*";
/* 611 */         int filter_vector_size = LakeButtons.filter_vector.size();
/* 612 */         for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */           
/* 614 */           this_lake = LakeButtons.filter_vector.elementAt(i);
/* 615 */           this_lake_parts = this_lake.split("\\$");
/* 616 */           temp = this_lake_parts[LakeButtons.fishname_location].toUpperCase();
/* 617 */           if (!temp.matches(user_fish))
/*     */           {
/* 619 */             LakeButtons.filter_vector.removeElementAt(i);
/*     */           }
/*     */         } 
/*     */       } 
/* 623 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public static int FilterName(String name) {
/* 628 */       int filter_vector_size = LakeButtons.filter_vector.size();
/* 629 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 631 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 632 */         this_lake_parts = this_lake.split("\\$");
/* 633 */         temp = this_lake_parts[LakeButtons.name_location].toUpperCase();
/* 634 */         if (!temp.matches(".*" + name + ".*"))
/*     */         {
/*     */           
/* 637 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/* 640 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static int FilterPage(int limit) {
/* 646 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */ 
/*     */       
/* 649 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 651 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 652 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 654 */         temp = this_lake_parts[LakeButtons.page_location];
/* 655 */         int this_lake_value = Integer.parseInt(temp);
/* 656 */         if (this_lake_value != limit)
/*     */         {
/* 658 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/* 661 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static int FilterSizeSmaller(int limit) {
/* 667 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */ 
/*     */       
/* 670 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */ 
/*     */         
/* 673 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/*     */         
/* 675 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 677 */         temp = this_lake_parts[LakeButtons.size_location];
/* 678 */         float this_lake_value = Float.parseFloat(temp);
/*     */ 
/*     */         
/* 681 */         if (this_lake_value > limit)
/*     */         {
/* 683 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/*     */       
/* 687 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static int FilterSizeBigger(int limit) {
/* 693 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */ 
/*     */       
/* 696 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 698 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 699 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 701 */         temp = this_lake_parts[LakeButtons.size_location];
/* 702 */         float this_lake_value = Float.parseFloat(temp);
/* 703 */         if (this_lake_value < limit)
/*     */         {
/* 705 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/*     */       
/* 709 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static int FilterDepthShallower(int limit) {
/* 715 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */       
/* 717 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 719 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 720 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 722 */         temp = this_lake_parts[LakeButtons.avgdepth_location];
/* 723 */         float this_lake_value = Float.parseFloat(temp);
/* 724 */         if (this_lake_value > limit)
/*     */         {
/* 726 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/* 729 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public static int FilterDepthDeeper(int limit) {
/* 734 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */       
/* 736 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 738 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 739 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 741 */         temp = this_lake_parts[LakeButtons.avgdepth_location];
/* 742 */         float this_lake_value = Float.parseFloat(temp);
/* 743 */         if (this_lake_value < limit)
/*     */         {
/* 745 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/* 748 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public static int FilterElevationBelow(int limit) {
/* 753 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */       
/* 755 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 757 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 758 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 760 */         temp = this_lake_parts[LakeButtons.elevation_location];
/* 761 */         int this_lake_value = Integer.parseInt(temp);
/* 762 */         if (this_lake_value > limit)
/*     */         {
/* 764 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/*     */       
/* 768 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public static int FilterElevationAbove(int limit) {
/* 773 */       int filter_vector_size = LakeButtons.filter_vector.size();
/*     */       
/* 775 */       for (int i = filter_vector_size - 1; i >= 0; i--) {
/*     */         
/* 777 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 778 */         this_lake_parts = this_lake.split("\\$");
/*     */         
/* 780 */         temp = this_lake_parts[LakeButtons.elevation_location];
/* 781 */         int this_lake_value = Integer.parseInt(temp);
/* 782 */         if (this_lake_value < limit)
/*     */         {
/* 784 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/* 787 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static int FilterFishSpecies(String target_fish) {
/* 793 */       for (int i = LakeButtons.filter_vector.size() - 1; i >= 0; i--) {
/*     */         
/* 795 */         this_lake = LakeButtons.filter_vector.elementAt(i);
/* 796 */         this_lake_parts = this_lake.split("\\$");
/* 797 */         all_fish = this_lake_parts[LakeButtons.fishname_location];
/* 798 */         if (!all_fish.matches(target_fish))
/*     */         {
/* 800 */           LakeButtons.filter_vector.removeElementAt(i);
/*     */         }
/*     */       } 
/* 803 */       return LakeButtons.filter_vector.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void Alert_User(BlinkingJCheckBox cb) {
/* 811 */     output_dataset.setRed();
/* 812 */     if (cb == null) {
/* 813 */       output_dataset.append("Please check your search");
/* 814 */       output_dataset.append("parameters and try again.");
/* 815 */       ColoradoLakefinder.JSP_pane1.setViewportView(output_dataset);
/* 816 */       ColoradoLakefinder.JSP_pane2.setViewportView(null);
/*     */       
/*     */       return;
/*     */     } 
/* 820 */     cb.Blink(cb);
/* 821 */     String data_string = cb.textfield.getText();
/* 822 */     if (data_string.length() < 1) data_string = " is empty"; 
/* 823 */     output_dataset.append("Problems with the following parameters");
/* 824 */     output_dataset.append(cb.getActionCommand() + " " + data_string);
/* 825 */     ColoradoLakefinder.JSP_pane1.setViewportView(output_dataset);
/* 826 */     ColoradoLakefinder.JSP_pane2.setViewportView(null);
/*     */   }
/*     */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/LakeButtons.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */