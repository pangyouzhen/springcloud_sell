package com.imooc.order.utils;

import com.imooc.order.VO.ResultVO;

import javax.xml.transform.Result;

public class ResultVOUtils {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }
}
