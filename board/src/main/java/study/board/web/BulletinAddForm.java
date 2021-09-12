package study.board.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletinAddForm {
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
    @NotBlank
    private String author;
}
