package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String shape = in.next();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		StdDraw.setPenColor(r, g, b);
		boolean filled = in.nextBoolean();
		if (shape.equals("rectangle"))
		{
			double x = in.nextDouble();
			double y = in.nextDouble();
			double halfWidth = in.nextDouble();
			double halfHeight = in.nextDouble();
			if (filled == true)
			{
				StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
			}
			else
			{
				StdDraw.rectangle(x, y, halfWidth, halfHeight);
			}
		}
		if (shape.equals("ellipse"))
		{
			double x = in.nextDouble();
			double y = in.nextDouble();
			double semiMajorAxis = in.nextDouble();
			double semiMinorAxis = in.nextDouble();
			if (filled == true)
			{
				StdDraw.filledEllipse(x, y, semiMajorAxis, semiMinorAxis);
			}
			else
			{
				StdDraw.ellipse(x, y, semiMajorAxis, semiMinorAxis);
			}
		}
		else
		{
			double[] x = new double[3];
			double[] y = new double[3];
			for (int i = 0; i < 3; i++)
			{
				x[i] = in.nextDouble();
				y[i] = in.nextDouble();
			}
			if (filled == true)
			{
				StdDraw.filledPolygon(x, y);
			}
			else
			{
				StdDraw.polygon(x, y);
			}
		}
	}
}
