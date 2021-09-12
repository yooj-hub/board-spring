package study.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.Bulletin;
import study.board.service.BulletinService;

import javax.annotation.PostConstruct;

//@Component
@RequiredArgsConstructor
public class TestDummy {
    private final BulletinService bulletinService;


    @PostConstruct
    @Transactional
    public void init() {
        Bulletin bulletin1 = new Bulletin("hello1", "hello content1 hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1hello content1", "userA");
        Bulletin bulletin2 = new Bulletin("hello2", "hello content2", "userB");
        bulletinService.save(bulletin1);
        bulletinService.save(bulletin2);


    }

}
