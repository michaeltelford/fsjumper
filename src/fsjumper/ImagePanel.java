
package fsjumper;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Panel for displaying images of the random points.
 * @author Michael Telford
 */
public class ImagePanel extends JPanel {

    public static String directoryPath = "images";
    public static String imageFileExt = ".jpg";

    private int pointStartingHeight = 0;
    private int point1StartingWidth = 0;
    private int point2StartingWidth = 142;
    private int point3StartingWidth = 285;

    private Points points = null;
    private Toolkit tools = null;

    public ImagePanel(JFrame frame){
        super();
        points = new Points();
        tools = Toolkit.getDefaultToolkit();
        this.setSize(frame.getWidth(), frame.getHeight());
    }

    // Clear panel, randomise points and display them on the panel.
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        String[] randomPoints = points.getRandomPoints();

        // Load image 1.
        String imagePath = String.format("%s/%s%s", directoryPath, randomPoints[0], imageFileExt);
        g.drawImage(tools.getImage(getClass().getResource(imagePath)),
                point1StartingWidth, pointStartingHeight, this);

        // Load image 2.
        imagePath = String.format("%s/%s%s", directoryPath, randomPoints[1], imageFileExt);
        g.drawImage(tools.getImage(getClass().getResource(imagePath)),
                point2StartingWidth, pointStartingHeight, this);

        // Load image 2.
        imagePath = String.format("%s/%s%s", directoryPath, randomPoints[2], imageFileExt);
        g.drawImage(tools.getImage(getClass().getResource(imagePath)),
                point3StartingWidth, pointStartingHeight, this);
    }
}