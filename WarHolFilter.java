import java.awt.Color;

/**
 * WarHoleFilter makes 4 smaller size images of the image chosen. Top left is without anything,
 * Top right is with a red tint, Bottom left with a green tint, and Bottom right a blue tint.
 *
 * @author Cristian Solis
 */
public class WarHolFilter extends Filter
{
    /**
     * Constructor for objects of class WarHolFilter.
     * @param name The name of the filter.
     */
    public WarHolFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
       int halfWidth = image.getWidth() / 2;
       int halfHeight = image.getHeight() / 2;
       OFImage copy = new OFImage(image);
       
       for(int y = 0; y < halfHeight; y++) {
            for(int x = 0; x < halfWidth; x++) {
                Color pix = copy.getPixel(x * 2, y * 2);
                int redColor = (pix.getRed());
                int greenColor = (pix.getGreen());
                int blueColor = (pix.getBlue());
                image.setPixel(x, y, pix); // Top-left
                image.setPixel(x + halfWidth, y, new Color(redColor, 0, 0)); // Top-right, Red tint
                image.setPixel(x, y + halfHeight, new Color(0, greenColor, 0)); // Bottom-left, Green tint
                image.setPixel(x + halfWidth, y + halfHeight, new Color(0, 0, blueColor)); // Bottom-right, Blue tint
            }
        }
    }
}