package com.yc.damai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
//import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author tl
 * @since 2023-10-11
 */
//@ApiModel(value = "Orders对象", description = "")
    @Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @TableField(exist=false)
    private List<Orderitem> orderItems;

    public void setOrderItems(List<Orderitem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<Orderitem> getOrderItems() {
        return orderItems;
    }

    @TableField(exist=false)
    private User user;

      @TableId(value = "oid", type = IdType.AUTO)
      private Integer oid;

    private Double total;

    private LocalDateTime ordertime;

    private Integer state;

    private String addr;

    private String phone;

    private Integer uid;

    private String name;

//
//    public Integer getOid() {
//        return oid;
//    }
//
//      public void setOid(Integer oid) {
//          this.oid = oid;
//      }
//
    public Double getTotal() {
        return total;
    }

      public void setTotal(Double total) {
          this.total = total;
      }
//
//    public LocalDateTime getOrdertime() {
//        return ordertime;
//    }
//
//      public void setOrdertime(LocalDateTime ordertime) {
//          this.ordertime = ordertime;
//      }
//
//    public Integer getState() {
//        return state;
//    }
//
//      public void setState(Integer state) {
//          this.state = state;
//      }
//
//    public String getAddr() {
//        return addr;
//    }
//
//      public void setAddr(String addr) {
//          this.addr = addr;
//      }
//
//    public String getPhone() {
//        return phone;
//    }
//
//      public void setPhone(String phone) {
//          this.phone = phone;
//      }
//
//    public Integer getUid() {
//        return uid;
//    }
//
//      public void setUid(Integer uid) {
//          this.uid = uid;
//      }
//
//    public String getName() {
//        return name;
//    }
//
//      public void setName(String name) {
//          this.name = name;
//      }

    @Override
    public String toString() {
        return "Orders{" +
              ", oid=" + oid +
                  ", total=" + total +
                  ", ordertime=" + ordertime +
                  ", state=" + state +
                  ", addr=" + addr +
                  ", phone=" + phone +
                  ", uid=" + uid +
                  ", name=" + name +
              "}";
    }
}
