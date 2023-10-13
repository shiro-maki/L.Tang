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
//@ApiModel(value = "Category对象", description = "")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "cid", type = IdType.AUTO)
      private Integer cid;

    private String cname;

    
    public Integer getCid() {
        return cid;
    }

      public void setCid(Integer cid) {
          this.cid = cid;
      }
    
    public String getCname() {
        return cname;
    }

      public void setCname(String cname) {
          this.cname = cname;
      }

    @Override
    public String toString() {
        return "Category{" +
              ", cid=" + cid +
                  ", cname=" + cname +
              "}";
    }
}
