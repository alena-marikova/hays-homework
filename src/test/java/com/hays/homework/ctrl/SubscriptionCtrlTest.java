package com.hays.homework.ctrl;

import com.hays.homework.entity.Subscription;
import com.hays.homework.service.SubscriptionService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubscriptionCtrl.class)
public class SubscriptionCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriptionService subscriptionService;

    @SpyBean
    private ModelMapper modelMapper;

    @Value("classpath:subscription.json")
    private Resource subscriptionJson;

    @Test
    public void getSubscription() throws Exception {
        Subscription subscription = DataUtil.createGenericSubscription();
        subscription.setId(1L);
        when(subscriptionService.getSubscription(any())).thenReturn(subscription);

        mockMvc.perform(get("/api/subscription").param("id", "1"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void createSubscription() throws Exception {
        Subscription subscription = DataUtil.createGenericSubscription();
        subscription.setId(1L);
        when(subscriptionService.getSubscription(any())).thenReturn(subscription);

        mockMvc.perform(post("/api/subscription").content(new String(subscriptionJson.getContentAsByteArray())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
