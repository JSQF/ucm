package io.saltcat.ucm.dao;

import io.satl.ucm.domain.Environment;

import java.util.List;

/**
 * Created by huawei on 3/19/16.
 */
public interface EnvironmentDAO {

    Environment getById(Integer id);

    Environment getByCode(String code);

    int countAll();

    List<Environment> getAll();

    void add(Environment environment);

    void update(Environment environment);

    void delete(Integer id);

    

}
