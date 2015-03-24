package pl.edu.agh.planner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class TestController {


    @RequestMapping(value = "**/" + "jsonStockPrices.json", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
    public String getStocks(@RequestParam("q") String rawSymbols)
    {
        return "ALA MA KOTA HURA ";
    }
}
