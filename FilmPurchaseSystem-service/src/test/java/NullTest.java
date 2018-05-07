
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class NullTest {
    private ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void setUpBeforeClass()  {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-*.xml"});
    }

    @After
    public void tearDown()  {
    }
    @Test
    public void nullTest()  {
    }

}
