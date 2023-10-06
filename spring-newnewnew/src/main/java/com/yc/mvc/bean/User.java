package com.yc.mvc.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class User {
    @NotNull(message = "账号不能为空")
    @Length(min = 4, max = 16, message = "账号必须是4-16个字符")
    String name;
    @NotBlank
    @Length(min = 6, max = 12)
    String pwd;
    @Email
    String email;
    Character gender;
    Date birthday;
    @Max(140)
    @Min(18)
    int age;
    @Size(min = 2)
    String[] likes;
    List<String> types;
    List<Object> servlets = new ArrayList<>();

}
