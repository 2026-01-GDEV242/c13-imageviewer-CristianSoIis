import java.awt.Color;

/**
 * Write a description of class FlippedWarHolFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlippedWarHolFilter extends Filter
{
    /**
     * Constructor for objects of class BlueChannelFilter.
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
        //int height = image.getHeight();
        //int width = image.getWidth();
        
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

                //image.setPixel(x, y, image.getPixel(width - 1 - x, y));
                //image.setPixel(width - 1 - x, y, left);
            }
        }
   
        /*
        public void apply(OFImage image)
    `{
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width / 2; x++) {
                Color left = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(width - 1 - x, y));
                image.setPixel(width - 1 - x, y, left);
                }
            }
    `}
         */
   
    }
}
