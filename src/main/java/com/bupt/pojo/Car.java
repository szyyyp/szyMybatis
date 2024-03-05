package com.bupt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    Long id;
    String carNum;
    String brand;
    Double guidePrice;
    String carType;
    String productTime;

}
