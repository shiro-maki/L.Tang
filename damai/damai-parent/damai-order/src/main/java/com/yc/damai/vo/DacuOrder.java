package com.yc.damai.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DacuOrder implements Serializable {
    private int uid;
    private int pid;
    private int num;
}
