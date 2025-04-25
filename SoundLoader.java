/*    */ import java.applet.Applet;
/*    */ import java.applet.AudioClip;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ 
/*    */ class SoundLoader
/*    */   extends Thread {
/*    */   SoundList soundList;
/*    */   
/*    */   public SoundLoader(SoundList soundList, URL baseURL, String relativeURL) {
/* 11 */     this.soundList = soundList;
/* 12 */     AudioTester.out("SoundLoader constructor:   baseURL = " + baseURL + ", relativeURL = " + relativeURL);
/*    */     try {
/* 14 */       this.completeURL = new URL(baseURL, relativeURL);
/* 15 */       AudioTester.out("SoundLoader constructor:   completeURL = " + this.completeURL);
/* 16 */     } catch (MalformedURLException e) {
/* 17 */       System.err.println(e.getMessage());
/*    */     } 
/* 19 */     this.relativeURL = relativeURL;
/* 20 */     setPriority(1);
/* 21 */     start();
/*    */   }
/*    */   URL completeURL; String relativeURL;
/*    */   public void run() {
/* 25 */     AudioClip audioClip = Applet.newAudioClip(this.completeURL);
/* 26 */     this.soundList.putClip(audioClip, this.relativeURL);
/*    */   }
/*    */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/SoundLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */