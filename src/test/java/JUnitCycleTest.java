import org.junit.jupiter.api.*;

public class JUnitCycleTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll (가장 먼저 실행)");
    }

    @BeforeEach
    public void  beforeEach(){
        System.out.println("@BeforeEach (함수 마다 이전에 실행)");
    }

    @Test
    public void test1(){
        System.out.println("test1 실행");
    }

    @Test
    public void test2(){
        System.out.println("test2 실행");
    }

    @Test
    public void test3(){
        System.out.println("test3 실행");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll (모두 끝난 뒤에 실행)");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach(함수 마다 이후에 실행)");
    }
}
