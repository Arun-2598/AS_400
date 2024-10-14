package project.testex1;

import com.jagacy.Key;
import com.jagacy.SessionVt;
import com.jagacy.util.JagacyException;
import com.jagacy.util.JagacyProperties;
import com.jagacy.util.Loggable;

import project.testex1.*;

public class LoginScreen {

	private SessionVt session;
	public Loggable logger;
	public JagacyProperties props;

	public LoginScreen(SessionVt s) throws JagacyException {
		this.session = s;
		props = s.getProperties();
		logger = s.getLoggable();

	}

	public void logon(String userName, String password) throws JagacyException {

		logger.info("Enter username and password");
		session.waitForCursor(5, 52, 2000);
		session.waitForChange(1000);
		session.writeString(userName);
		session.waitForChange(1000);

		session.writeKey(Key.TAB);
		session.waitForChange(3000);

		session.writePosition(6, 52, "");
		session.waitForCursor(6, 52, 5000);

		session.writeString(password);
		session.waitForChange(1000);

		session.writeKey(Key.ENTER);
		session.waitForChange(2000);

		// Added this step when we get Display Program Messaga displays
		session.waitForCursor(0, 27, 2000);

		String title = session.readPosition(0, 27, 15);
		System.out.println("Screen Title is " + title);
		if (title.equalsIgnoreCase("Display Program")) {
			session.writeKey(Key.ENTER);
			session.waitForChange(2000);
		}

	}

	public final void enterUserNPasswordCDOC(String uName, String pass) throws JagacyException {

		logger.info("enter user name and password CDOC");

		session.waitForCursor(5, 52, 1000);
		session.writeString(uName);
		session.waitForChange(1000);
		if (uName.length() < 10) {
			session.writeKey(Key.TAB);
		}

		session.waitForCursor(6, 52, 1000);
		session.writeString(pass);
		session.waitForChange(1000);

		session.writeKey(Key.ENTER);
		session.waitForChange(1000);

		// Added this step when we get Display Program Messaga displays
		session.waitForCursor(0, 27, 2000);

		String title = session.readPosition(0, 27, 15);
		System.out.println("Screen Title is " + title);
		if (title.equalsIgnoreCase("Display Program")) {
			session.writeKey(Key.ENTER);
			session.waitForChange(2000);
		}

	}

	public void enterUserName(String userName) {
		logger.info("Enter User Name");
		JagacyUtil.writePositionMethod(session, 5, 52, userName, 1000);
	}

	public void enterPassword(String password) {
		logger.info("Enter Password");
		JagacyUtil.pressKeys(session, Key.TAB, 1000);
		JagacyUtil.waitForChangeMethod(session, 1000);
		JagacyUtil.waitForCursorMethod(session, 6, 52, 1000);
		JagacyUtil.writeStringMethod(session, password, 1000);
	}

	public void pressEnterKey() {
		logger.info("Enter Password");
		JagacyUtil.pressKeys(session, Key.ENTER, 1000);
	}

	public static SessionVt startAS400() throws JagacyException {
		SessionVt session = new SessionVt("myJagacyVT", "172.29.167.120", "dec-vt220");
		session.open();
		return session;
	}

	// public void startSessionAndLoginToMasterMenu(String userName, String
	// password) throws Exception {
	// enterUserNPasswordCDOC(userName, password);
	// if (session.readPosition(0, 27, 7).toString().trim().equals("Display")) {
	// session.writeKey(Key.ENTER);
	// session.waitForChange(1000);
	// }
	// session.waitForChange(1000);
	// if (session.readPosition(0, 33, 13).equals("Command Entry")) {
	// IBMMainMenuScreen iBMMainMenuScreen = new IBMMainMenuScreen(session);
	// iBMMainMenuScreen.enterValueToComandLineField("CALL XXC870");
	// session.waitForChange(1000);
	// }
	// Ltl38MasterMenuScreen masterMenu = new Ltl38MasterMenuScreen(session);
	// masterMenu.verifyScreenTitle();
	// }
}
