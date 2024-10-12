package com.kocesat.mybatisdemo.model.channel;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * tfunction
 */
@Data
@Builder
public class Function implements Serializable {
    private String code;

    private String nameTr;

    private String nameEn;

    private Boolean isMonetary;

    private Date createdAt;

    private Date modifiedAt;

    private String createdUser;

    private Short status;

    private static final long serialVersionUID = 1L;
}