package study.board.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import study.board.domain.Bulletin;

@Data
@AllArgsConstructor
public class BulletinListDto {
    private Long id;
    private String subject;

    public BulletinListDto(Bulletin bulletin){
        this.id=bulletin.getId();
        this.subject=bulletin.getSubject();
    }
}
