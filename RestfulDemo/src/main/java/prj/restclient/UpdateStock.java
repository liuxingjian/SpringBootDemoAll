package prj.restclient;

import org.springframework.web.client.RestTemplate;
import prj.model.Stock;


public class UpdateStock {
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();

        Stock stock = new Stock();
        stock.setID(1);
        stock.setName("Computer");
        stock.setNum(100);
        stock.setDescription("excellent");

        restTemplate.put("http://localhost:8080/v1/stock",stock);
    }
}
