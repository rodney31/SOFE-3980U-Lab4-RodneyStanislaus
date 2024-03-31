package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }
	
	    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }
    @Test
    public void getParameter2() throws Exception {
        this.mvc.perform(get("/").param("operand1","0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }
	@Test
	    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","+").param("operand2","0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void postParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1","100").param("operator","+").param("operand2","110"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("operand2", "110"));
    }

    /**
     * Test The multiply function with values of the same length
     */
    @Test
    public void multiply() throws Exception {
        this.mvc.perform(post("/").param("operand1","1100100").param("operator","*").param("operand2","1110101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10110110110100"))
                .andExpect(model().attribute("operand1", "1100100"));
    }

    /**
     * Test The multiply function with the first value having a length less than the second value
     */
    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1010").param("operator","*").param("operand2","110100"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1000001000"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    /**
     * Test The multiply function with the first value having a length greater than the second value
     */
    @Test
    public void multiply3() throws Exception {
        this.mvc.perform(post("/").param("operand1","101010").param("operator","*").param("operand2","110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11111100"))
                .andExpect(model().attribute("operand1", "101010"));
    }

    /**
     * Test The multiply function with one value as a zero
     */
    @Test
    public void multiply4() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","*").param("operand2","1110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The multiply function with both values as a zero
     */
    @Test
    public void multiply5() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","*").param("operand2","0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The bitwiseOR function with values of the same length
     */
    @Test
    public void bitwiseOR() throws Exception {
        this.mvc.perform(post("/").param("operand1","1110").param("operator","|").param("operand2","1100"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "1110"));
    }

    /**
     * Test The bitwiseOR function with the first value having a length less than the second value
     */
    @Test
    public void bitwiseOR2() throws Exception {
        this.mvc.perform(post("/").param("operand1","101").param("operator","|").param("operand2","1000"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "101"));
    }

    /**
     * Test The bitwiseOR function with the first value having a length greater than the second value
     */
    @Test
    public void bitwiseOR3() throws Exception {
        this.mvc.perform(post("/").param("operand1","111100").param("operator","|").param("operand2","100"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "111100"))
                .andExpect(model().attribute("operand1", "111100"));
    }

    /**
     * Test The bitwiseOR function with one value as a zero
     */
    @Test
    public void bitwiseOR4() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","|").param("operand2","1101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The bitwiseOR function with both values as a zero
     */
    @Test
    public void bitwiseOR5() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","|").param("operand2","0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The bitwiseAND function with values of the same length
     */
    @Test
    public void bitwiseAND() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","&").param("operand2","101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "101"))
                .andExpect(model().attribute("operand1", "111"));
    }

    /**
     * Test The bitwiseAND function with the first value having a length less than the second value
     */
    @Test
    public void bitwiseAND2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1000").param("operator","&").param("operand2","101011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1000"))
                .andExpect(model().attribute("operand1", "1000"));
    }

    /**
     * Test The bitwiseAND function with the first value having a length greater than the second value
     */
    @Test
    public void bitwiseAND3() throws Exception {
        this.mvc.perform(post("/").param("operand1","1011101").param("operator","&").param("operand2","1101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "1011101"));
    }

    /**
     * Test The bitwiseAND function with one value as a zero
     */
    @Test
    public void bitwiseAND4() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","&").param("operand2","110110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The bitwiseAND function with both values as a zero
     */
    @Test
    public void bitwiseAND5() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","&").param("operand2","0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }
}
