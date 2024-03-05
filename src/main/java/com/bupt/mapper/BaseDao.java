package com.bupt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Mapper
@Repository
public interface BaseDao<Model,PK extends Serializable> {
    /**
     * @param id PrimaryKey
     * @return int，0是失败，1是成功
     */
    int deleteByPrimaryKey(@Param("id") PK id);

    /**
     * @param ids List of primary keys
     * @return int，0是失败，1是成功
     */
    int deleteByIds(List<PK> ids);
    int insert(Model record);

    List<Model>findAll();

}
