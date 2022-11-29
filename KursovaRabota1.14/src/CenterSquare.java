import java.awt.*;
import java.io.*;

public class CenterSquare extends Frame{

	private static final long serialVersionUID = 1L;
	private int windowHeight = 0;
	private int windowWidth = 0;
	private String windowText = "";
	private int squareDimension = 0, squareR = 0, squareG = 0, squareB = 0;
	
	CenterSquare() throws IOException{
		super();
		try (BufferedReader br = new BufferedReader(
			new FileReader("D:\\Projects\\Java\\KursovaRabota1.14\\src\\square_parameters.txt"))) {
			String line;
			if ((line = br.readLine()) != null) {
				windowHeight = Integer.parseInt(line.split(" ")[0]);
				windowWidth = Integer.parseInt(line.split(" ")[1]);
			}
			if ((line = br.readLine()) != null) {
				windowText = line;
			}
			if ((line = br.readLine()) != null) {
				squareDimension = Integer.parseInt(line.split(" ")[0]);
				squareR = Integer.parseInt(line.split(" ")[1]);
				squareG = Integer.parseInt(line.split(" ")[2]);
				squareB = Integer.parseInt(line.split(" ")[3]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addWindowListener(new WindowClosingAdapter(true));
		setTitle(windowText);
		setSize(windowWidth, windowHeight);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		CenterSquare wnd = new CenterSquare();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		 super.paint(g);
		 g.setColor(new Color(squareR, squareG, squareB));
		 g.fillRect((windowWidth - squareDimension)/ 2, (windowHeight - squareDimension)/ 2, squareDimension, squareDimension);
		 
	}

}