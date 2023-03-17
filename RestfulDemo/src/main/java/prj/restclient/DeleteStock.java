package prj.restclient;

import org.springframework.web.client.RestTemplate;

public class DeleteStock {
    public static void main(String[] args) {
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete("http://localhost:8080/v1/stock/{id}",1);
    }
}
