package com.hsfw.performance.controller;

import com.hsfw.performance.entity.BaseResponse;
import com.hsfw.performance.service.RangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/range")
public class RangeController {
    @Autowired
    RangeInfoService rangeInfoService;

    @GetMapping("/infos")
    public BaseResponse getRangeInfoService(@RequestParam("gameTypeCN") String gameTypeCN,@RequestParam("cellType") String cellType) {
        BaseResponse baseResponse;
        List<HashMap<String, String>> res = new ArrayList<>();
        try {
            res = rangeInfoService.getRangeInfoService(gameTypeCN,cellType);
            baseResponse = BaseResponse.buildResponse().setObj(res).build();
        } catch (Exception e) {
            baseResponse = BaseResponse.buildResponse().setMessage(e.getMessage()).build();
        }
        return baseResponse;
    }
}
