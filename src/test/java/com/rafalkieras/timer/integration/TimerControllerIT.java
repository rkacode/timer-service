package com.rafalkieras.timer.integration;

import com.rafalkieras.timer.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest("server.port:0")
public class TimerControllerIT {

    @Value("${local.server.port}")
    protected int port;

    private RestTemplate restTemplate = new TestRestTemplate();

    private String getUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void dateApiTest() {
        ResponseEntity<String> response = restTemplate.getForEntity(getUrl() + "/api/timer/date", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void timeApiTest() {
        ResponseEntity<String> response = restTemplate.getForEntity(getUrl() + "/api/timer/time", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
