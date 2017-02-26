package example.api.control;

import example.api.common.TestInit;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yookeun on 2017. 2. 26..
 */
public class BoardControllerTest extends TestInit {

    @Test
    public void selectListBoard() throws Exception {
        mockMvc.perform(get("/api/board"))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    public void selectOneBoard() throws Exception {
        mockMvc.perform(get("/api/board/1"))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    public void insertBoard() throws Exception {
        mockMvc.perform(post("/api/board")
                .param("title", "test title")
                .param("content", "test content "))
                .andDo(print())
                .andExpect(status().isOk());
    }

}