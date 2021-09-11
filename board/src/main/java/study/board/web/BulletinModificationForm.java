package study.board.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class BulletinModificationForm {
    private Long id;
    @NotNull
    private String subject;
    private String content;
    private String author;
}
