package prj.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import prj.exception.ParamExcepion;
import prj.model.Stock;
import prj.tool.HttpCodeEnum;
import prj.tool.HttpReturn;

import java.util.HashMap;

@RestController
@RequestMapping("v1")
public class Controller {
    static HashMap<Integer, Stock> stockHM=new HashMap<>();
    @RequestMapping(value = "/stock/{id}",method= RequestMethod.GET)
    @ApiOperation(value = "Get stock by id",notes="id <100")
    @ApiResponses({
            @ApiResponse(code=200,message = "请求错误"),
            @ApiResponse(code=400,message = "参数错误"),
            @ApiResponse(code=404,message = "页面未找到"),
            @ApiResponse(code=500,message = "服务错误")
    })
    public HttpReturn getStockByID(@PathVariable Integer id){
        if(id>100){
            throw new ParamExcepion(400,"param id is more than 100");
        }
        return new HttpReturn(HttpCodeEnum.OK,stockHM.get(id));
    }
    @RequestMapping(value = "/stocks",method = RequestMethod.GET)
    public HttpReturn getStocks(){
        return new HttpReturn(HttpCodeEnum.OK,stockHM);
    }
    @RequestMapping(value = "/stock",method = RequestMethod.POST)
    public HttpReturn addStock(@RequestBody Stock stock){
        stockHM.put(stock.getID(),stock);
        return new HttpReturn(HttpCodeEnum.CREATEOK,"create ok");
    }
    @RequestMapping(value = "/stock",method = RequestMethod.PUT)
    public HttpReturn updateStock(@RequestBody Stock stock){
        stockHM.remove(stock.getID());
        stockHM.put(stock.getID(),stock);
        return new HttpReturn(HttpCodeEnum.OK,"update ok");
    }
    @RequestMapping(value = "/stock/{id}",method = RequestMethod.DELETE)
    public HttpReturn deleteStock(@PathVariable Integer id){
        stockHM.remove(id);
        return new HttpReturn(HttpCodeEnum.OK,"delete ok");
    }
}
