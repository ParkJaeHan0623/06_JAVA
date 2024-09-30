import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Ex03_파일저장 {
    public static void main(String[] args) {
        //1) 기본 준비
        //저장할 파일 경로
        String filePath = "./test.txt";
        //파일에 저장할 내용
        String content = "Hello, World!";
        //2) 저장할 내용을 스트림(byte배열 ->이진수 모음)으로 변환
        byte[] buffer = null;
        try {
            buffer = content.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //3) 파일에 내용을 저장
        OutputStream os = null;
        try {
            os = new FileOutputStream(filePath);
            os.write(buffer);
        }
        catch(FileNotFoundException e) {
            System.out.println("[Error] "+e.getMessage());
            System.out.println("---------------------");
            e.printStackTrace();
        }
         catch (IOException e) {
            System.out.println("[Error] "+e.getMessage());
            System.out.println("---------------------");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("[Error] "+e.getMessage());
            System.out.println("---------------------");
            e.printStackTrace();
        }
        finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
}
