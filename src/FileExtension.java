import java.io.File;

public class FileExtension {
    public static void main(String[] args) {
        System.out.println(returnExtension("Choices.png"));
        System.out.println(returnExtension("lovers.JPEG"));
        System.out.println(returnExtension("lovers.JPG"));
        System.out.println(returnExtension("lovers.csv"));
    }

    public static String returnExtension(String file) {

        String extension = "";

        String fileName = file.toString().toLowerCase();

        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }

        if (extension.equals("png") || extension.equals("jpeg") || extension.equals("jpg")){
            return extension;
        }
        else{
            return null;
        }

    }
}

