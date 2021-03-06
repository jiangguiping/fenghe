package com.jiang.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsDetailVO implements Serializable {

    private Long goodsId;

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private String tag;

    private String[] goodsCarouselList;

    private Integer originalPrice;

    private String goodsDetailContent;
}

