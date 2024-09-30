import java.io.File;

public class Ex01_File {
    public static void main(String[] args) {
        File f1 = new File("./test.txt");
        
        // 전달된 경로가 파일인지 검사 --> 존재하지 않는 파일로 검사할 경우 무조건 false
        boolean is_file = f1.isFile();
        System.out.println("isFile: " + is_file);

        // 전달된 경로가 디렉토리인지 검사 --> 존재하지 않는 디렉토리로 검사할 경우 무조건 false
        boolean is_dir = f1.isDirectory();
        System.out.println("isDirectory: " + is_dir);

        // 전달된 경로가 숨김 파일인지 검사 --> 존재하지 않는 파일로 검사할 경우 무조건 false
        boolean is_hidden = f1.isHidden();
        System.out.println("isHidden: " + is_hidden);

        // 절대 경로 값을 추출
        String abs = f1.getAbsolutePath();
        System.out.println("절대 경로: " + abs);

        // 생성자에 전달된 파일이나 디렉토리가 물리적으로 존재하는지 검사
        boolean is_exist = f1.exists();
        System.out.println("존재 여부: " + is_exist);
    }
}
