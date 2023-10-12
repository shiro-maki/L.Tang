package com.yc.damai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author tl
 * @since 2023-10-11
 */
@ApiModel(value = "Orderitem对象", description = "")
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "itemid", type = IdType.AUTO)
      private Integer itemid;

    private Integer count;

    private Double subtotal;

    private Integer pid;

    private Integer oid;

    
    public Integer getItemid() {
        return itemid;
    }

      public void setItemid(Integer itemid) {
          this.itemid = itemid;
      }
    
    public Integer getCount() {
        return count;
    }

      public void setCount(Integer count) {
          this.count = count;
      }
    
    public Double getSubtotal() {
        return subtotal;
    }

      public void setSubtotal(Double subtotal) {
          this.subtotal = subtotal;
      }
    
    public Integer getPid() {
        return pid;
    }

      public void setPid(Integer pid) {
          this.pid = pid;
      }
    
    public Integer getOid() {
        return oid;
    }

      public void setOid(Integer oid) {
          this.oid = oid;
      }

    @Override
    public String toString() {
        return "Orderitem{" +
              ", itemid=" + itemid +
                  ", count=" + count +
                  ", subtotal=" + subtotal +
                  ", pid=" + pid +
                  ", oid=" + oid +
              "}";
    }
}
