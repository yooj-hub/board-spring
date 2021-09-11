package study.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import study.board.web.BulletinModificationForm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class Bulletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    private String subject;
    @Lob
    private String content;

    private String author;

    public Bulletin(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public Bulletin(String subject, String content, String author) {
        this.subject = subject;
        this.content = content;
        this.author = author;
    }

    public Long changeBulletin(BulletinModificationForm form) {
        this.subject = form.getSubject();
        this.content = form.getContent();
        return this.id;
    }

    @Override
    public String toString() {
        return "Bulletin{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
