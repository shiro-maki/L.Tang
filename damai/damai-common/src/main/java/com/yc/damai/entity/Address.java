package com.yc.damai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
//import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author tl
 * @since 2023-10-11
 */
//@ApiModel(value = "Address对象", description = "")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "aid", type = IdType.AUTO)
      private Integer aid;

    private Integer uid;

    private String addr;

    
    public Integer getAid() {
        return aid;
    }

      public void setAid(Integer aid) {
          this.aid = aid;
      }
    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public String getAddr() {
        return addr;
    }

      public void setAddr(String addr) {
          this.addr = addr;
      }

    @Override
    public String toString() {
        return "Address{" +
              ", aid=" + aid +
                  ", uid=" + uid +
                  ", addr=" + addr +
              "}";
    }
}
