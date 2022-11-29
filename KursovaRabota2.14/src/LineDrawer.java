import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LineDrawer extends Frame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private int mouseX = 0;
	private int mouseY = 0;
	private int currentMouseClickX = 0;
	private int currentMouseClickY = 0;
	private int mouseClicks = 0;
	private int firstPointX = 0, firstPointY = 0;
	TextField tfX = new TextField("", 10);
	TextField tfY = new TextField("", 10);

	LineDrawer() {
		super("Welcome to Line Drawer");
		setBackground(Color.lightGray);
		setSize(1000, 1000);
		setLocation(100, 100);
		addWindowListener(new WindowClosingAdapter(true));
		addMouseListener(this);
		addMouseMotionListener(this);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(tfX);
		add(tfY);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		LineDrawer wnd = new LineDrawer();
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		if (mouseClicks == 1) {
			g.fillOval(currentMouseClickX - 2, currentMouseClickY - 2, 5, 5);
			firstPointX = currentMouseClickX;
			firstPointY = currentMouseClickY;
			mouseClicks++;
		} else if (mouseClicks > 1) {
			g.fillOval(firstPointX - 2, firstPointY - 2, 5, 5);
			g.fillOval(currentMouseClickX - 2, currentMouseClickY - 2, 5, 5);
			g.drawLine(firstPointX, firstPointY, currentMouseClickX, currentMouseClickY);
			mouseClicks = 0;
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1) {
			currentMouseClickX = e.getX(); 
			currentMouseClickY = e.getY();
			mouseClicks++;
			repaint();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		tfX.setText(String.valueOf(mouseX));
		tfY.setText(String.valueOf(mouseY));
	}
}
