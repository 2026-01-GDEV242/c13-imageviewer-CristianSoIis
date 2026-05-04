import java.awt.Color;

/**
 * FlippedWarHolFilter makes 4 smaller size images of the image chosen. Top left is without anything,
 * Top right is with a red tint and mirroed horizontally, Bottom left with a green tint and mirroed vertically, 
 * and Bottom right a blue tint and mirroed horizontally and vertically.
 *
 * @author Cristian Solis
 */
public class FlippedWarHolFilter extends Filter
{
    /**
     * Constructor for objects of class FlippedWarHolFilter.
     * @param name The name of the filter.
     */
    public FlippedWarHolFilter(String name)
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
                image.setPixel(halfWidth - 1 - x + halfWidth , y, new Color(redColor, 0, 0)); // Top-right, Red tint Mirrored horizontally      
                image.setPixel(x, halfHeight - 1 - y + halfHeight, new Color(0, greenColor, 0)); // Bottom-left, Green tint Mirrored vertically
                image.setPixel(halfWidth - 1 - x + halfWidth, halfHeight - 1 - y + halfHeight, new Color(0, 0, blueColor)); // Bottom-right, Blue tint Mirrored horizontally and vertically
            }
        }
    }
}
