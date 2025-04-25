/*    */ import java.applet.AudioClip;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class AudioTester
/*    */ {
/*    */   private static AudioClip ding_clip;
/*    */   private static AudioClip tada_clip;
/*    */   private static AudioClip glass_clip;
/*    */   private static BufferedWriter BW;
/*    */   private static PrintWriter PW;
/*    */   
/*    */   AudioTester() {
/* 18 */     URL code_base = null;
/*    */ 
/*    */     
/* 21 */     String base_path = ColoradoLakefinder.getMyDir();
/* 22 */     String sound_path = "file:" + base_path + ColoradoLakefinder.getMySeparator();
/* 23 */     String debug_file = base_path + ColoradoLakefinder.getMySeparator() + "debug.txt";
/*    */ 
/*    */     
/* 26 */     try { FileWriter FW = new FileWriter(debug_file);
/* 27 */       BW = new BufferedWriter(FW);
/* 28 */       PW = new PrintWriter(BW, true); }
/* 29 */     catch (IOException e) { System.out.println("Can't make the debug file: " + debug_file); e.printStackTrace(); }
/*    */     
/*    */     try {
/* 32 */       out("The sound_path is " + sound_path);
/* 33 */       code_base = new URL(sound_path);
/* 34 */       out("The code base URL = " + code_base);
/* 35 */     } catch (MalformedURLException e) {
/* 36 */       System.out.println("My Bad URL"); e.printStackTrace();
/* 37 */     } catch (IOException e) {
/* 38 */       out("Because of ==> " + e); e.printStackTrace();
/*    */     } 
/* 40 */     SoundList soundlist = new SoundList(code_base);
/* 41 */     SoundLoader S_loader_ding = soundlist.startLoading("ding.wav");
/* 42 */     SoundLoader S_loader_glass = soundlist.startLoading("glass.wav");
/* 43 */     SoundLoader S_loader_tada = soundlist.startLoading("tada.wav");
/* 44 */     S_loader_ding.run();
/* 45 */     S_loader_glass.run();
/* 46 */     S_loader_tada.run();
/* 47 */     ding_clip = soundlist.getClip("ding.wav");
/* 48 */     tada_clip = soundlist.getClip("tada.wav");
/* 49 */     glass_clip = soundlist.getClip("glass.wav");
/*    */   }
/*    */   
/*    */   public static void ding() {
/* 53 */     if (ColoradoLakefinder.make_noise_B) ding_clip.play(); 
/* 54 */   } public static void break_glass() { if (ColoradoLakefinder.make_noise_B) glass_clip.play();  } public static void tada() {
/* 55 */     if (ColoradoLakefinder.make_noise_B) tada_clip.play(); 
/*    */   }
/*    */   
/*    */   public static void out(String strMessage) {
/* 59 */     System.out.println("Message = " + strMessage);
/* 60 */     PW.print(strMessage + "\n");
/* 61 */     PW.flush();
/*    */   }
/*    */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/AudioTester.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */