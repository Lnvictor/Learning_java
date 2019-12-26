import java.io.FileWriter;

class Example {
    public static void main(String[] args) {
       try{
        FileWriter file = new FileWriter("/home/victor/Learning_java/Hello_unicode.txt");
        
        file.write("Aqui so tem babaca");
        file.close();
       }catch(Exception e){System.out.println(e);}    
       System.out.println("Success...");    
    }
}