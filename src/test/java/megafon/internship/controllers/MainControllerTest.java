package megafon.internship.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testingInterlistGetMapper() throws Exception {
        this.mockMvc.perform(get("/interlist"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testingEmployeelistGetMapper() throws Exception {
        this.mockMvc.perform(get("/employeelist"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
