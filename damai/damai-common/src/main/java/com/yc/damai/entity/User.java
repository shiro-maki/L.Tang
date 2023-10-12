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
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "uid", type = IdType.AUTO)
      private Integer uid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String sex;

    private Integer state;

    private String code;

    private String addr;

    
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
    
    public String getName() {
        return name;
    }

      public void setName(String name) {
          this.name = name;
      }
    
    public String getEmail() {
        return email;
    }

      public void setEmail(String email) {
          this.email = email;
      }
    
    public String getPhone() {
        return phone;
    }

      public void setPhone(String phone) {
          this.phone = phone;
      }
    
    public String getSex() {
        return sex;
    }

      public void setSex(String sex) {
          this.sex = sex;
      }
    
    public Integer getState() {
        return state;
    }

      public void setState(Integer state) {
          this.state = state;
      }
    
    public String getCode() {
        return code;
    }

      public void setCode(String code) {
          this.code = code;
      }
    
    public String getAddr() {
        return addr;
    }

      public void setAddr(String addr) {
          this.addr = addr;
      }

    @Override
    public String toString() {
        return "User{" +
              ", uid=" + uid +
                  ", username=" + username +
                  ", password=" + password +
                  ", name=" + name +
                  ", email=" + email +
                  ", phone=" + phone +
                  ", sex=" + sex +
                  ", state=" + state +
                  ", code=" + code +
                  ", addr=" + addr +
              "}";
    }
}
