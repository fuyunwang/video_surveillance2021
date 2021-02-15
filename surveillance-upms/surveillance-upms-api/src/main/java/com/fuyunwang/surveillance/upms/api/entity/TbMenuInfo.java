package com.fuyunwang.surveillance.upms.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author FuyunWang
 * @since 2021-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbMenuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单路径
     */
    @TableField("menu_path")
    private String menuPath;

    /**
     * 顺序
     */
    @TableField("orders")
    private Integer orders;

    /**
     * 父级id,为0表示为根父级
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 权限类型,0是只有超管才能看到,1是高管可以看到,2是中管可以看到,3是所有人都可以看到
     */
    @TableField("auth_type")
    private Integer authType;

    @TableField("component")
    private String component;

    @TableField("redirect")
    private String redirect;


}
