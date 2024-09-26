package me.yosae.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.yosae.domain.Member;
import me.yosae.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc //서버 배포 없이 테스트용 MVC 환경을 만들어 줌
class TestControllerTest2 {
    //------- 사전설정-------------
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }
    @Autowired
    private ObjectMapper objectMapper;
    //-------------------------------


    @DisplayName("quiz(): GET /quiz?code=1 이면 응답 코드는 201, 응답 본문은 Created!를 리턴한다.")
    @Test
    public void getQuiz1() throws Exception{
        //given
        final String url = "/quiz";

        //when
        final ResultActions result = mockMvc.perform(get(url)
            .param("code", "1")
        );

        //then
        result
                .andExpect(status().isCreated())
                .andExpect(content().string("Created"));
    }

    @DisplayName("quiz(): GET /quiz?code=2이면 응답 코드는 400, 응답 본문은 Bad Request를 리턴한다.")
    @Test
    public void getQuiz2() throws Exception{

    }

}