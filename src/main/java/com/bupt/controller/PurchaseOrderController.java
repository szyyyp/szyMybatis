package com.bupt.controller;

import com.bupt.result.HttpResultCodeEnum;
import com.bupt.result.page.LtrPageable;
import com.bupt.pojo.PurchaseOrder;
import com.bupt.result.HttpResult;
import com.bupt.result.page.PageRecord;
import com.bupt.util.PageUtil;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.SearchResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Resource
    BeanSearcher beanSearcher;

    /**
     * 筛选采购单头
     * @param pageable
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping("/selectPurchaseOrder")
    public HttpResult<?> selectPurchaseOrder(@RequestBody LtrPageable<PurchaseOrder> pageable) throws IllegalAccessException {
        Map<String, Object> where = PageUtil.page(pageable);
        System.out.println(where);
        //SearchResult<PurchaseOrder> search = beanSearcher.search(PurchaseOrder.class, where);

        return null;
        //return HttpResult.of(HttpResultCodeEnum.SUCCESS,new PageRecord<PurchaseOrder>().pageRecord(where, search, pageable));

    }
}
