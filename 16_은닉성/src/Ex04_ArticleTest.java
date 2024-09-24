public class Ex04_ArticleTest {
    public static void main(String[] args) {
        Article article = new Article(1,"테스트 게시물", "JavaBeans를 테스트 합니다","자바 학생" ,"2023-05-01" );

        System.out.println(article.getSeq());
        System.out.println(article.getSubject());
        System.out.println(article.getContent());
        System.out.println(article.getwriter());
        System.out.println(article.getRegDate());
        
    }
}
