package util;

import org.apache.log4j.Logger;

public class AppLogger {
	private static Logger log = Logger.getLogger("devpinoyLogger");

	public static void logMessage(String message) {
		log.debug(message);
	}
}
