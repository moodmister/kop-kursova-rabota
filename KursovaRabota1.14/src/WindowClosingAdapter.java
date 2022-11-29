/* WindowClosingAdapter.java */
import java.awt.event.*;

public class WindowClosingAdapter extends WindowAdapter {
	private boolean exitSystem;

	public WindowClosingAdapter(boolean exitSystem) {
		this.exitSystem = exitSystem;
	}

	public WindowClosingAdapter() {
		this(false);
	}

	public void windowClosing(WindowEvent event) {
		event.getWindow().setVisible(false);
		event.getWindow().dispose();
		if (exitSystem) {
			System.exit(0);
		}
	}
}