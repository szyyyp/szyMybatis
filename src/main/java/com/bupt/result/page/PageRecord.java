package com.bupt.result.page;

import com.ejlchina.searcher.SearchResult;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PageRecord<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;
    private long pages;
    private LtrPageable page;

    public PageRecord<T> pageRecord(Map<String, Object> where, SearchResult<T> search,LtrPageable pageable) {
        PageRecord<T> page = new PageRecord<>();
        page.setPage(pageable);
        page.setTotal(search.getTotalCount().longValue());
        page.setRecords(search.getDataList());
        page.setCurrent(Long.parseLong(where.get("page").toString()));
        page.setSize(Long.parseLong(where.get("size").toString()));
        if (page.getSize() == 0L) {
            page.setPages(0L);
        } else {
            page.setPages((long) Math.ceil((double) page.getTotal() / (double) page.getSize()));
        }
        return page;
    }
}
