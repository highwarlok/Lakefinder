/*    */ import java.applet.AudioClip;
/*    */ import java.net.URL;
/*    */ import java.util.Hashtable;
/*    */ 
/*    */ 
/*    */ class SoundList
/*    */   extends Hashtable
/*    */ {
/*    */   URL baseURL;
/*    */   SoundLoader S_loader;
/*    */   
/*    */   public SoundList(URL baseURL) {
/* 13 */     super(5);
/* 14 */     this.baseURL = baseURL;
/* 15 */     AudioTester.out("SoundList Constructor:  The soundlist base URL is " + baseURL);
/*    */   }
/*    */   
/*    */   public SoundLoader startLoading(String relativeURL) {
/* 19 */     AudioTester.out("SoundList startLoading():  The soundlist base URL is " + this.baseURL);
/* 20 */     this.S_loader = new SoundLoader(this, this.baseURL, relativeURL);
/* 21 */     return this.S_loader;
/*    */   }
/*    */   
/*    */   public AudioClip getClip(String relativeURL) {
/* 25 */     AudioTester.out("SoundList getClip():  The relative URL is " + relativeURL);
/* 26 */     return (AudioClip)get(relativeURL);
/*    */   }
/*    */   
/*    */   public void putClip(AudioClip clip, String relativeURL) {
/* 30 */     put((K)relativeURL, (V)clip);
/*    */   }
/*    */ }


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/SoundList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */