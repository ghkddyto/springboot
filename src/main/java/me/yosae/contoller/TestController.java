package me.yosae.contoller;

import me.yosae.domain.Member;
import me.yosae.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public String test(){
        record TESTITEM(Long id, String name){}
        TESTITEM testitem = new TESTITEM(1L,"테스트아이템");
        return testitem.name;
    }

    @GetMapping("/test2")
    public List<Member> getAllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;
    }

    @GetMapping("/test3")
    public String test3(){
        Number testNumber1;
        testNumber1 = 33.3;
        return testNumber1.toString();
    }

    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code){
        switch (code){
            case 1:
                return ResponseEntity.created(null).body("Created!");
            case 2:
                return ResponseEntity.badRequest().body("Bad Request");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code){
        switch (code.value()){
            case 1:
                return ResponseEntity.status(403).body("forbidden!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value){}
