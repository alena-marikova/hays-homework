package com.hays.homework.ctrl;

import com.hays.homework.entity.Quotation;
import com.hays.homework.service.QuotationService;
import com.hays.homework.util.DataUtil;
import org.junit.jupiter.api.Test;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuotationCtrl.class)
public class QuotationCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuotationService quotationService;

    @SpyBean
    private ModelMapper modelMapper;

    @Value("classpath:quotation.json")
    private Resource quotationJson;

    @Test
    public void createQuotation() throws Exception {
        Quotation quotation = DataUtil.createGenericQuotation();
        quotation.setId(1L);
        when(quotationService.createQuotation(any())).thenReturn(quotation);

        mockMvc.perform(post("/api/quotation").content(new String(quotationJson.getContentAsByteArray())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.beginningOfInsurance").value("12-12-2023"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.insuredAmount").value(4000L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfSigningMortgage").value("11-12-2023"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer").isMap());
    }

}
