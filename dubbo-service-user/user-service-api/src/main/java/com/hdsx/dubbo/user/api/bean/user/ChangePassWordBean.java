package com.hdsx.dubbo.user.api.bean.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ChangePassWordBean implements Serializable {
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("原始密码")
    private String password;

    @ApiModelProperty("新密码")
    private String newpassword;

    @ApiModelProperty("密钥")
    private String key;

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

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
