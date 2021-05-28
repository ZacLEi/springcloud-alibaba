package com.liulei.demo.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Orders {
    @TableId
    private Long id;
    private String itemName;
    private Double price;
    private Long userId;
    private Date createTime;
    private Date modifyTime;
}
