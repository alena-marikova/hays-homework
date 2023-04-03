package com.hays.homework.ctrl;

import com.hays.homework.entity.Customer;
import com.hays.homework.service.CustomerService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerCtrl.class)
public class CustomerCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @SpyBean
    private ModelMapper modelMapper;

    @Value("classpath:customer.json")
    private Resource customerJson;

    @Test
    public void updateCustomer() throws Exception {
        Customer customer = DataUtil.createGenericCustomer();
        customer.setId(1L);
        when(customerService.updateCustomer(any())).thenReturn(customer);

        mockMvc.perform(put("/api/customer").content(new String(customerJson.getContentAsByteArray())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("firstName").value("Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Surname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@test.com"));
    }

}
