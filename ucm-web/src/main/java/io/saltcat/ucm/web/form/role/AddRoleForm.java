package io.saltcat.ucm.web.form.role;

import io.saltcat.ucm.exception.UcmException;
import io.saltcat.ucm.web.form.ValidForm;
import org.springframework.util.StringUtils;

/**
 * Created by huawei on 4/3/16.
 */
public class AddRoleForm implements ValidForm {

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void validate() throws UcmException{
        if (!StringUtils.hasLength(this.name)) {
            throw new UcmException("角色名称不能为空");
        }
        if(!StringUtils.hasLength(this.code)) {
            throw new UcmException("角色代码不能为空");
        }
    }
}
