package com.jiang.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchGoodsVO implements Serializable {

    private Long goodsId;

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;

}

