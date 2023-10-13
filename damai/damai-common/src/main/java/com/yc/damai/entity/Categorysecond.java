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
//@ApiModel(value = "Categorysecond对象", description = "")
public class Categorysecond implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "csid", type = IdType.AUTO)
      private Integer csid;

    private String csname;

    private Integer cid;

    
    public Integer getCsid() {
        return csid;
    }

      public void setCsid(Integer csid) {
          this.csid = csid;
      }
    
    public String getCsname() {
        return csname;
    }

      public void setCsname(String csname) {
          this.csname = csname;
      }
    
    public Integer getCid() {
        return cid;
    }

      public void setCid(Integer cid) {
          this.cid = cid;
      }

    @Override
    public String toString() {
        return "Categorysecond{" +
              ", csid=" + csid +
                  ", csname=" + csname +
                  ", cid=" + cid +
              "}";
    }
}
