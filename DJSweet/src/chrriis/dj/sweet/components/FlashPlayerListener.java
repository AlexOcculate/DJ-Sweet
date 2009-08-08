/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 *
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
package chrriis.dj.sweet.components;

import org.eclipse.swt.internal.SWTEventListener;

/**
 * @author Christopher Deckers
 */
public interface FlashPlayerListener extends SWTEventListener {

  /**
   * The Flash player can invoke special commands to the application simply by calling:<br>
   * <code>ExternalInterface.call("sendCommand", commandName, arg1, arg2, ...);</code>
   */
  public void commandReceived(String command, Object[] args);

}
