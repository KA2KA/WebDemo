package com.Dao.Impl;

import com.Dao.RoleDao;
import com.Model.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by wuwan on 2016/9/30.
 */

@Repository("roleDao")
public class RoleDaoImpl extends GeneralDaoImpl<RoleEntity, String > implements RoleDao {

}
