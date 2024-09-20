package me.yosae.springbootdeveloper;

import me.yosae.domain.Member;
import me.yosae.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/test1")
    public String test(){
        record TESTITEM(Long id, String name){}
        TESTITEM testitem = new TESTITEM(1L,"테스트아이템");
        return testitem.name;
    }

    @Autowired
    TestService testService;

    @GetMapping("test")
    public List<Member> get AllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
