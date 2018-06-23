package net.maxqfz.tinkoff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TinkoffApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void HomeURLShouldThrowErrorPage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("error");
    }

    @Test
    public void Get1ShouldProvideRightProduct() {
        String body = this.restTemplate.getForObject("/1", String.class);
        assertThat(body).contains("RightProduct");
    }

    @Test
    public void Get2ShouldProvideRightProduct() {
        String body = this.restTemplate.getForObject("/2", String.class);
        assertThat(body).contains("RightProduct");
    }

    @Test
    public void Get3ShouldProvideRightProduct() {
        String body = this.restTemplate.getForObject("/3", String.class);
        assertThat(body).contains("RightProduct");
    }

    @Test
    public void Get4ShouldThrowErrorPage() {
        String body = this.restTemplate.getForObject("/4", String.class);
        assertThat(body).contains("error");
    }
}
