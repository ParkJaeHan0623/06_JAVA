import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex04_파일읽기 {
    public static void main(String[] args) {
        String filePath = "./test.txt";
        byte[] buffer = null;
        String content = null;

        InputStream is = null;

        try {
            is = new FileInputStream(filePath);
            buffer = new byte[is.available()];
            // 파일 내용을 buffer에 저장
            is.read(buffer);
        } catch (FileNotFoundException e) {
            System.out.println("[Error] " + e.getMessage());
            System.out.println("---------------------");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("[Error] " + e.getMessage());
            System.out.println("---------------------");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            System.out.println("---------------------");
            e.printStackTrace();

        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // buffer 배열에 내용이 있다면?
        if (buffer != null) {
            try {
                content = new String(buffer, "utf-8");
                System.out.println(content);
            } catch (Exception e) {
                System.out.println("[Error] 인코딩 지정 에러");
                e.printStackTrace();
            }
        }
    }
}