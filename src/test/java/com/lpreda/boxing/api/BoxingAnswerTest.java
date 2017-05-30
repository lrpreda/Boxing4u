package com.lpreda.boxing.api;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for Boxing API
 *
 * @author lrpre
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoxingAnswerTest {
    
    @Autowired
    private MockMvc mvc;
    
    public BoxingAnswerTest() {
    }

    /**
     * Test of BoxingSolver method, of class BoxingAnswer.
     * @throws java.lang.Exception
     */
    @Test
    public void testBoxingSolver() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/rest/boxing/1/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"1\":\"Apple\",\"2\":\"Apple & Orange\",\"3\":\"Orange\"}")));
    }
    
    /**
     * Test invalid request
     * @throws Exception 
     */
    @Test
    public void getInvalidParameter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/rest/boxing/1/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test of Helper method, of class BoxingAnswer.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testHelper() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/rest/boxing/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("For labelOpt : send 1 for label Orange, "
                        + "2 for Apple or 3 for Apple & Orange For fuitOpt : send 1 for Orange or 2 for Apple")));
    
    }
    
}
