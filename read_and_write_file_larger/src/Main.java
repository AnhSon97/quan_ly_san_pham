import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public void copyFileUsingStream(File source, File dest) throws IOException {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(dest);
            inputStream = new FileInputStream(source);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte [] buffer = new byte[1];
            int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,length);;
                System.out.println();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name");
        String input = in.nextLine();
        System.out.println("Enter file name");
        String output = in.nextLine();
        File source = new File(input);
        File dest = new File(output);

        Main main = new Main();
        try {
//            main.copyFileUsingJava7Files(source,dest);
            main.copyFileUsingStream(source,dest);
        } catch (IOException e) {
            System.out.println("can not copy that files");
            e.getMessage();
        }
    }
}




