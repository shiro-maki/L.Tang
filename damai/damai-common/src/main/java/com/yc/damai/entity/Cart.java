package com.yc.damai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author tl
 * @since 2023-10-11
 */
//@ApiModel(value = "Cart对象", description = "")
    @Data
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

//      @ApiModelProperty("购物车ID")
        @TableId(value = "ciid", type = IdType.AUTO)
      private Integer ciid;

//      @ApiModelProperty("用户ID")
      private Integer uid;

//      @ApiModelProperty("商品ID")
      private Integer pid;

//      @ApiModelProperty("商品数量")
      private Integer count;
      private Product product;

    
    public Integer getCiid() {
        return ciid;
    }

      public void setCiid(Integer ciid) {
          this.ciid = ciid;
      }
    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public Integer getPid() {
        return pid;
    }

      public void setPid(Integer pid) {
          this.pid = pid;
      }
    
    public Integer getCount() {
        return count;
    }

      public void setCount(Integer count) {
          this.count = count;
      }

    @Override
    public String toString() {
        return "Cart{" +
              ", ciid=" + ciid +
                  ", uid=" + uid +
                  ", pid=" + pid +
                  ", count=" + count +
              "}";
    }
}
