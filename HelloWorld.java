import edu.duke.FileResource;

public class HelloWorld{
    public static void main(String[] args) {
        FileResource x = new FileResource("Hello_unicode.txt");
        for (String i : x.lines()){
            System.out.println(i);
        }
    }
}
