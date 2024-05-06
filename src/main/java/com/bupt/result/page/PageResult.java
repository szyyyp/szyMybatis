package com.bupt.result.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class  PageResult<T> extends Page<T> {
    Pageable pageable;
}
