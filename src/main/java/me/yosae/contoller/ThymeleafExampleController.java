package me.yosae.contoller;

import me.yosae.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafExampleController {

    @GetMapping("/example")
    public String thymeleafExample(Model model){ //뷰로 데이터를 넘겨주는 모델 객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setAge(19);
        examplePerson.setName("홍길동");
        examplePerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person", examplePerson);
        model.addAttribute("today", LocalDate.now());

        return "example";
    }

    @GetMapping("/test")
    public String test(){
        String test = "test";
        return test;
    }


}
