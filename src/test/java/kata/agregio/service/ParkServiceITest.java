package kata.agregio.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ParkServiceITest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("should give status 200 with the actual park created")
    void shouldRetrieveACart() throws Exception {
        String parkRequestJson = "{ \"energyType\": \"SOLAR\", \"capacity\": 0 }";
        String parkResponseJson = "{ \"energyType\": \"SOLAR\", \"capacity\": 0 }";

        mvc.perform(post("/parks").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(parkRequestJson))
                .andExpect(status().isOk())
                .andExpect(content().json(parkResponseJson));

    }


}
