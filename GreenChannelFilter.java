import java.awt.Color;

/**
 * An image filter to find green value in pixels
 * 
 * @author Cristian Solis
 * 
 */
public class GreenChannelFilter extends Filter
{
    /**
     * Constructor for objects of class GreenChannelFilter.
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int greenColor = (pix.getGreen());
                image.setPixel(x, y, new Color(greenColor, greenColor, greenColor));
            }
        }
    }
}
