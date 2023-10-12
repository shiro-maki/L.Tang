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
@ApiModel(value = "Adminuser对象", description = "")
public class Adminuser implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "uid", type = IdType.AUTO)
      private Integer uid;

    private String username;

    private String password;

    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public String getUsername() {
        return username;
    }

      public void setUsername(String username) {
          this.username = username;
      }
    
    public String getPassword() {
        return password;
    }

      public void setPassword(String password) {
          this.password = password;
      }

    @Override
    public String toString() {
        return "Adminuser{" +
              ", uid=" + uid +
                  ", username=" + username +
                  ", password=" + password +
              "}";
    }
}
