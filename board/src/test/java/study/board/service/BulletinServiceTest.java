package study.board.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.Bulletin;
import study.board.web.BulletinListDto;
import study.board.web.BulletinListDto2;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BulletinServiceTest {
    @Autowired
    BulletinService bulletinService;

    @Test
    void 가입_및_조회() throws Exception {
        //given
        Bulletin bulletin = new Bulletin("hello", "content");
        bulletinService.save(bulletin);
        System.out.println("bulletin = " + bulletin);
        //when
        Bulletin findBulletin = bulletinService.findOne(bulletin.getId());

        //then
        assertThat(findBulletin).isSameAs(bulletin);
    }

    @Test
    void 리스트조회() throws Exception {
        //given
        Bulletin bulletin1 = new Bulletin("hello1", "content");
        Bulletin bulletin2 = new Bulletin("hello2", "content");
        bulletinService.save(bulletin1);
        bulletinService.save(bulletin2);

        //when
        List<BulletinListDto2> result = bulletinService.findAll();

        //then
        assertThat(result).contains(new BulletinListDto2(bulletin1), new BulletinListDto2(bulletin2));
    }


}
