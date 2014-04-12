package cs5300proj1b.managers;

import java.util.ArrayList;

import cs5300.proj1a.objects.SessionObject;

public class CookieManager {
	
	private String COOKIE_DELIMITER = "_";
	
	/* Cookie contents
	 * 
	 *  SESSIONID_VERSIONUM_REPLICA1_REPLICA2....
	 * 
	 */
	
	public String generateCookieString(
			SessionObject object,
			ArrayList<String> replicatedservers){
		
		String retval = object.getSessionId() + COOKIE_DELIMITER + object.getVersion();
		for (String s : replicatedservers) {
			retval += COOKIE_DELIMITER + s;
		}
		return retval;
	}
	
	String[] parseCookieContent(String content){
		
		String [] list = content.split(COOKIE_DELIMITER);
		return list;
	}
}
