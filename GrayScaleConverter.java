/**
 * A RGB to GrayScale conversion implementation
 * 
 * @author:  Victor Pereira
 * @version: 27/12/2019
 */

import edu.duke.*;
import java.io.File;

class GrayScaleConverter {
    
    public ImageResource makeGray(ImageResource image){
        
        ImageResource out = new ImageResource(image.getWidth(), image.getHeight());
        
        for (Pixel pixel : out.pixels()){
            
            Pixel image_pixel = image.getPixel(pixel.getX(), pixel.getY());
            
            int average =   (image_pixel.getRed() + image_pixel.getBlue() +                        image_pixel.getGreen()) / 3;

            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);

        }
        out.setFileName("GrayScale-"+image.getFileName());

        return out;
    }

    public void convertBunch(){
        DirectoryResource directory = new DirectoryResource();

        for (File file : directory.selectedFiles()){
            ImageResource file_gray = new ImageResource(file);
            file_gray = makeGray(file_gray);
            file_gray.draw();
            file_gray.setFileName("copy-" + file_gray.getFileName());
            file_gray.save();
        }
    }

    private void test_makeGray(){
        ImageResource fr = new ImageResource();
        ImageResource image_in_Gray = makeGray(fr);

        image_in_Gray.draw();
    }

    private void test_convertBatch(){
        convertBunch();
    }

    public static void main(String[] args) {
        GrayScaleConverter Example = new GrayScaleConverter();
        Example.test_convertBatch();
    }
}