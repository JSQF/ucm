package io.saltcat.ucm.web.form.role;

import io.saltcat.ucm.exception.UcmException;
import io.saltcat.ucm.web.form.ValidForm;
import org.springframework.util.StringUtils;

/**
 * Created by huawei on 4/3/16.
 */
public class UpdateRoleForm implements ValidForm {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void validate() throws UcmException {
        if (!StringUtils.hasLength(id)) {
            throw new UcmException("角色ID不能为空");
        }
        try{
            Integer.parseInt(this.id);
        }catch (Exception e) {
            throw new UcmException("角色ID格式不正确");
        }
        if (!StringUtils.hasLength(this.name)) {
            throw new UcmException("更新角色名称不能为空");
        }
    }
}
