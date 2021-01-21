package com.gzl.model.entity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author gzl
 * @since 2020-11-28
 */
@Data
public class MenuEntity implements Serializable {
    private static final long menuEntityUID = -8708186267247178920L;
    private String menuId;
    private String menuName;
    private String parentId;
    private String menuLevel;
    private List<MenuEntity> childMenu;
}
