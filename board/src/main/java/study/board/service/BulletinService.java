package study.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.Bulletin;
import study.board.repository.BulletinRepository;
import study.board.web.BulletinListDto;
import study.board.web.BulletinListDto2;
import study.board.web.BulletinModificationForm;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BulletinService {

    private final BulletinRepository bulletinRepository;

    @Transactional
    public Long save(Bulletin bulletin) {
        Bulletin savedBulletin = bulletinRepository.save(bulletin);
        return savedBulletin.getId();
    }

    public Long saveByDto() {
        return -1L;
    }

    public Bulletin findOne(Long id) {
        return bulletinRepository.findById(id).orElse(null);

    }

    public List<BulletinListDto2> findAll() {
        List<BulletinListDto2> result = bulletinRepository.findAll().stream().map(a -> new BulletinListDto2(a.getId(), a.getSubject(), a.getAuthor())).collect(toList());
        Collections.reverse(result);
        return result;
    }

    @Transactional
    public Long modification(BulletinModificationForm form) {
        Bulletin bulletin = bulletinRepository.findById(form.getId()).orElse(null);
        if (bulletin == null) {
            return -1L;
        }
        return bulletin.changeBulletin(form);
    }

    public Long deleteBulletin(Long id) {
        bulletinRepository.deleteById(id);
        return id;
    }

    @Transactional
    public void updateBulletin(BulletinModificationForm form) {
        Bulletin bulletin = findOne(form.getId());
        bulletin.changeBulletin(form);
    }

    public List<BulletinListDto2> findAllBySubject(String subject) {
        List<BulletinListDto2> result = bulletinRepository.findAllBySubject(subject).stream().map(a -> new BulletinListDto2(a.getId(), a.getSubject(), a.getAuthor())).collect(toList());
        Collections.reverse(result);
        return result;
    }



}
