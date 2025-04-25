package com.apple.eawt;

import java.util.EventListener;

public interface ApplicationListener extends EventListener {
  void handleAbout(ApplicationEvent paramApplicationEvent);
  
  void handleOpenApplication(ApplicationEvent paramApplicationEvent);
  
  void handleReOpenApplication(ApplicationEvent paramApplicationEvent);
  
  void handleOpenFile(ApplicationEvent paramApplicationEvent);
  
  void handlePreferences(ApplicationEvent paramApplicationEvent);
  
  void handlePrintFile(ApplicationEvent paramApplicationEvent);
  
  void handleQuit(ApplicationEvent paramApplicationEvent);
}


/* Location:              /home/mike/Colorado Lakefinder 11/ColoradoLakefinder.jar!/com/apple/eawt/ApplicationListener.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */