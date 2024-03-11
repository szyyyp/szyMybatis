package com.bupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName("t_car")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    String carNum;
    String brand;
    Double guidePrice;
    String carType;
    String produceTime;

}
