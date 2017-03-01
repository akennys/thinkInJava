//: net/mindview/util/DaemonThreadFactory.java
package net.mindview.util;

import static net.mindview.util.Print.print;

import java.util.concurrent.*;

public class DaemonThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		print("DaemonThreadFactory : " + t + " ");
		return t;
	}
} /// :~
