import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SetPixel {
   public static void main(String args[])throws IOException {
      //Reading the image
      File file= new File("C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\photo.jpg");
      BufferedImage img = ImageIO.read(file);
      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
            //Retrieving contents of a pixel
            int pixel = img.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            //Modifying the RGB values
            green = 150;
            blue = 150;
            //Creating new Color object
            color = new Color(red, green, blue);
            //Setting new Color object to the image
            img.setRGB(x, y, color.getRGB());
         }
      }
      //Saving the modified image
      file = new File("C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\photo1.jpg");
      ImageIO.write(img, "jpg", file);
      System.out.println("Done...");

/*
      // Analyse d'un point rouge 
      
      File fileRouge= new File("C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\rouge.jpg");
      BufferedImage imgRouge = ImageIO.read(fileRouge);
      int pointOk = 0;
      for (int y = 0; y < imgRouge.getHeight(); y++) {
         for (int x = 0; x < imgRouge.getWidth(); x++) {
            //Retrieving contents of a pixel
            int pixel = imgRouge.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            if (red > 232 &&  red < 242   // ref : 237
              && green > 22 && green <30 // ref : 28 
              && blue > 30 && blue < 40) {  // 34
            	
            	pointOk++;
            	
            }
            
            System.out.println(red + " " + green + " " + blue);
            
         }
      }
      
      System.out.println("pointOk: " + pointOk);
      if (pointOk > 100) {
      	
      	System.out.println("L'image contient du rouge!");
      }else {
      	System.out.println("L'image ne contient pas de rouge");
      }
      System.out.println("Analyse rouge terminée");
      */
      
      // Analyse par classe recherche
      
      // Recherche d'une couleur
      Recherche rechercheRouge = new Recherche(237, 28, 34, "C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\rouge.jpg");
      boolean rouge  = rechercheRouge.analyse();
      
      Recherche rechercheBleu = new Recherche(62, 72, 204, "C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\bleu.jpg");
      boolean bleu = rechercheBleu.analyse();
      
      Recherche rechercheVert = new Recherche(35, 177, 75, "C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\vert.jpg");
      boolean vert = rechercheVert.analyse();
      
      // Test de cas d'erreurs
      /*
      Recherche rechercheRouge1 = new Recherche(237, 28, 34, "C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\bleu.jpg");
      boolean rouge1  = rechercheRouge1.analyse();
      
      Recherche rechercheBleu1 = new Recherche(62, 72, 204, "C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\vert.jpg");
      boolean bleu1 = rechercheBleu1.analyse();
      
      Recherche rechercheVert1 = new Recherche(35, 177, 75, "C:\\Users\\kinte\\eclipse-workspace\\ImageColor\\rouge.jpg");
      boolean vert1 = rechercheVert1.analyse();
      */
      
   }  // end of main 
}