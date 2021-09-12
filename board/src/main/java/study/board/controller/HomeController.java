package study.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.board.domain.Bulletin;
import study.board.service.BulletinService;
import study.board.web.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final BulletinService bulletinService;

    @GetMapping("/")
    public String home(Model model) {
        List<BulletinListDto2> bulletinListDtos = bulletinService.findAll();
        model.addAttribute("bulletinListDtos", bulletinListDtos);
        model.addAttribute("search", new SearchBySubject());
        return "home/board2";
    }

    @GetMapping("/board/{id}")
    public String boards(@PathVariable("id") Long bulletinId, Model model) {
        Bulletin findBulletin = bulletinService.findOne(bulletinId);
        model.addAttribute("bullentin", findBulletin);
        return "bulletin/bulletin";

    }

    @GetMapping("/board/edit/{id}")
    public String edit(@PathVariable("id") Long bulletinId, Model model) {
        Bulletin bulletin = bulletinService.findOne(bulletinId);
        BulletinModificationForm form = new BulletinModificationForm(bulletin.getId(), bulletin.getSubject(), bulletin.getContent(), bulletin.getAuthor());
        model.addAttribute("form", form);
        return "bulletin/bulletinEdit";

    }

    @PostMapping("/board/edit/{id}")
    public String editCompleted(@PathVariable("id") Long bulletinId, @Validated @ModelAttribute(name = "form") BulletinModificationForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "bulletin/bulletinEdit";
        }
        bulletinService.updateBulletin(form);
        return "redirect:/";
    }

    @PostMapping("/board/search")
    public String search(@ModelAttribute SearchBySubject search, Model model) {
        List<BulletinListDto2> result = bulletinService.findAllBySubject(search.getSubject());
        model.addAttribute("search", new SearchBySubject());
        model.addAttribute("bulletinListDtos", result);
        return "home/board2";
    }

    @GetMapping("/board/add")
    public String moveToAddForm(Model model) {
        BulletinAddForm form = new BulletinAddForm("", "", "");
        model.addAttribute("form", form);
        return "bulletin/bulletinAddForm";
    }

    @PostMapping("/board/add")
    public String add(@Validated @ModelAttribute(name="form") BulletinAddForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info("errors={}",bindingResult);
            return "bulletin/bulletinAddForm";
        }
        Bulletin bulletin = new Bulletin(form.getSubject(), form.getContent(), form.getAuthor());
        bulletinService.save(bulletin);
        return "redirect:/";
    }

}
