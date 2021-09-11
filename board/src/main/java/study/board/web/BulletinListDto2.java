package study.board.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import study.board.domain.Bulletin;

@Data
@AllArgsConstructor
public class BulletinListDto2 {
    private Long id;
    private String subject;
    private String author;

    public BulletinListDto2(Bulletin bulletin) {
        this.id = bulletin.getId();
        this.subject = bulletin.getSubject();
        this.author = bulletin.getAuthor();
    }
}
