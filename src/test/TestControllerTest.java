import com.bookstore.util.OrderNoGenerator;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration
@ActiveProfiles("dev")
public class TestControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    // 这个方法在每个方法执行之前都会执行一遍
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); // 初始化MockMvc对象
    }

    @Test
    public void testString()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
            post("/api/user/freeze") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                    .param("id","70")
//                    .param("password","123456")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString1()throws Exception {
        String responseString = mockMvc.perform(
                post("/app/upload") // 请求的url，请求的方法是post
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                .param("version","1.0")
                .param("developer","XC")

        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString2()throws Exception {
        OrderNoGenerator orderNoGenerator = new OrderNoGenerator(10,3);
        String s = orderNoGenerator.generatorOrderNo();
        System.out.println("------------------------"+s);
    }
}
