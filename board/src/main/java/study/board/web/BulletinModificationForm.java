package study.board.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class BulletinModificationForm {
    private Long id;
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
    @NotBlank
    private String author;
}
