package project.testex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Path;
import java.util.Properties;

import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

import org.testng.annotations.Test;

import com.jagacy.AbstractSession;
import com.jagacy.Key;
import com.jagacy.SessionVt;
import com.jagacy.telnet.ConduitVt;
import com.jagacy.ui.AbstractPanel;
import com.jagacy.ui.PanelVt;
import com.jagacy.util.JagacyException;
import com.jagacy.util.JagacyProperties;
import com.jagacy.util.Util;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestBase {

	public JagacyProperties props;

	// public static void main(String[] args) throws JagacyException,
	// SocketException, Exception {
	@Test
	public void one() throws JagacyException, Exception {

		String host = reader("jagacy.host");

		String terminal = reader("Terminal");

		SessionVt session = new SessionVt("jagacyVT", host, terminal);
		session.open();

		Thread.sleep(10000);
//		LoginScreen log = new LoginScreen(session);
//		log.startAS400();

		boolean open2 = session.isOpen();
		System.out.println(open2);

		session.waitForCursor(5, 52, 1000);
		session.waitForChange(1000);

		// Enter Username
		session.writeString("DISTEST");
		session.waitForChange(1000);
		session.writeKey(Key.TAB);
		session.waitForChange(3000);

		// Enter password
		session.waitForCursor(6, 52, 1000);
		session.waitForChange(1000);
		session.writeString("usertest23");
		session.waitForChange(1000);
		session.writeKey(Key.ENTER);
		session.waitForChange(4000);

		Thread.sleep(3000);
		session.writeKey(Key.ENTER);
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);

		// company
		session.waitForCursor(10, 49, 1000);
		session.waitForChange(1000);
		session.writeString("con");
		// Location
		session.waitForChange(4000);
		session.waitForCursor(11, 49, 4000);
		session.writeString("112");

		session.waitForChange(1000);
		session.writeKey(Key.ENTER);
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);

		session.waitForChange(1000);
		// session.writeKey(Key.ENTER);
		session.waitForCursor(7, 1, 1000);
		session.writeString("5");
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);
		
		session.waitForChange(1000);
		// session.writeKey(Key.ENTER);
		session.waitForCursor(3, 1, 1000);
		session.writeString("1");
		session.waitForChange(4000);
		session.writeKey(Key.ENTER);
		
		
		session.writeKey(Key.ENTER);

		session.waitForChange(1000);
		// session.writeKey(Key.ENTER);
//		session.waitForCursor(21, 38, 1000);
//		session.writeString("2");
//		session.waitForChange(4000);
//		// session.waitForChange(4000);
//		session.writeKey(Key.ENTER);
//		session.waitForChange(4000);
//		session.writeKey(Key.ENTER);

		
	}
}
