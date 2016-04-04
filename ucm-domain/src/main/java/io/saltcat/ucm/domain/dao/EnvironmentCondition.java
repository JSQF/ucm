package io.saltcat.ucm.domain.dao;

/**
 * Created by huawei on 3/19/16.
 */
public class EnvironmentCondition {

    private Integer id;
    private String name;
    private boolean nameLike;
    private String code;
    private boolean codeLike;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNameLike() {
        return nameLike;
    }

    public void setNameLike(boolean nameLike) {
        this.nameLike = nameLike;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCodeLike() {
        return codeLike;
    }

    public void setCodeLike(boolean codeLike) {
        this.codeLike = codeLike;
    }
}
