/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import android.app.Activity;
import android.view.WindowManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Activity activity = this.cordova.getActivity();
    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
  }

  @Override
  public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
    switch(action) {
      case "activate":
        return activate(args, callbackContext);
      case "deactivate":
        return deactivate(args, callbackContext);
    }
    return false;
  }

  private boolean deactivate(CordovaArgs args, CallbackContext callbackContext) {
    try {
      Activity activity = this.cordova.getActivity();
      activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
      callbackContext.success();
      return true;
    } catch (Exception e) {
      callbackContext.error("error clear flags: " + e.getMessage());
      return false;
    }
  }

  private boolean activate(CordovaArgs args, CallbackContext callbackContext) {
    try {
      Activity activity = this.cordova.getActivity();
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
      return true;
    } catch (Exception e) {
      callbackContext.error("error add flags: " + e.getMessage());
      return false;
    }
  }
}
