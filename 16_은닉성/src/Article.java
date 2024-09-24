public class Article {
    private int seq;
    private String subject; //글 제목
    private String content; //글 내용
    private String writer; //작성자
    private String regDate; //작성일시

    public Article(int seq, String subject, String content,String writer, String regDate){
        this.seq = seq;
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
    }

    public int getSeq(){
        return this.seq;
    }

    public void setSeq(int seq){
        this.seq = seq;
    }

    public String getSubject(){
        return this.subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getwriter(){
        return this.writer;
    }
    public void setwriter(String writer){
        this.writer = writer;
    }
    public String getRegDate(){
        return this.regDate;
    }
    public void setRegDate(String regDate){
        this.regDate = regDate;
    }
}
