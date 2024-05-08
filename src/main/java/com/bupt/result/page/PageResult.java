package com.bupt.result.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ejlchina.searcher.SearchResult;
import lombok.Data;

import java.util.Map;
@Data
public class  PageResult<T> extends Page<T> {
    Pageable pageable;

    public PageResult<T> pageResult(Map<String, Object> where, SearchResult<T> search, Pageable pageable) {
        PageResult<T> page = new PageResult<>();
        page.setPageable(pageable);
        page.setTotal(search.getTotalCount().longValue());
        page.setRecords(search.getDataList());
        page.setCurrent(Long.parseLong(where.get("page").toString()));
        page.setSize(Long.parseLong(where.get("size").toString()));
        /*if (page.getSize() == 0L) {
            page.setPages(0L);
        } else {
            page.setPages((long) Math.ceil((double) page.getTotal() / (double) page.getSize()));
        }*/
        return page;
    }
}
