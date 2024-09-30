import java.io.File;

public class Ex02_File2 {
    public static void main(String[] args) {
        File f2 = new File("a/b/c/target");
        System.out.println("isFile: " + f2.isFile());
        System.out.println("isDirectory: " + f2.isDirectory());
        System.out.println("isHidden: " + f2.isHidden());
        System.out.println("절대 경로: " + f2.getAbsolutePath());
        System.out.println("존재 여부: " + f2.exists());

        //경로에 따른 디렉토리 생성
        f2.mkdirs();
        //f2.mkdir(); // a/b/c 디렉토리가 없기 때문에 target 디렉토리 생성 불가. 최종 폴더만 생성하려고 함

        // 마지막 "/" 뒤의 문자열을 추출
        System.out.println(f2.getName());
        // 마지막 "/" 앞의 문자열을 추출
        System.out.println(f2.getParent());
        System.out.println("---------------------");

        //삭제 시도 ---> 성공하면 true, 실패하면 false
        // boolean is_delete = f2.delete();
        // System.out.println("삭제 여부: " + is_delete);
    }
}
