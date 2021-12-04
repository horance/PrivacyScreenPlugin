var exec = require('cordova/exec');

/** 
 * enable privacy screen
 */
exports.activate = function(arg, success, error) {
  exec(success, error, "PrivacyScreenPlugin", "activate", [arg]);
};
exports.deactivate = function(arg, success, error) {
  exec(success, error, "PrivacyScreenPlugin", "deactivate", [arg]);
};
