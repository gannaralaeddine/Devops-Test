package com.example.devopstest.controllers;

import com.example.devopstest.entities.Stock;
import com.example.devopstest.interfaces.IStockService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Stock Management")
@RequestMapping("/stock")
//@CrossOrigin( origins = "http://localhost:4200")
public class StockRestController
{
    @Autowired
    IStockService stockService;

    @GetMapping("/retrieve-all-stocks")
    @ResponseBody
    public List<Stock> getStocks() {
        return stockService.retrieveAllStocks();
    }

    @GetMapping("/retrieve-stock/{stock-id}")
    @ResponseBody
    public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
        return stockService.retrieveStock(stockId);
    }

    @PostMapping("/add-stock")
    @ResponseBody
    public Stock addStock(@RequestBody Stock s) {
        return stockService.addStock(s);
    }

    @DeleteMapping("/delete-stock/{stock-id}")
    @ResponseBody
    public void deleteStock(@PathVariable("stock-id") Long stockId) {
        stockService.deleteStock(stockId);
    }

    @PutMapping("/update-stock/{stock-id}")
    @ResponseBody
    public Stock updateStock(@PathVariable("stock-id") Long stockId, @RequestBody Stock stock) {
        return stockService.updateStock(stockId, stock);
    }


}
