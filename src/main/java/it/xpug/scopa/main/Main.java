package it.xpug.scopa.main;

import it.xpug.scopa.jetty.*;


public class Main {
	public static void main(String[] args) {		
		ReusableJettyApp app = new ReusableJettyApp(SimpleWebappServlet.class);		
		app.start(8080, "src/main/webapp");
	}
}
