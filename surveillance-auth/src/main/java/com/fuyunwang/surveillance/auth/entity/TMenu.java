package com.fuyunwang.surveillance.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author FuyunWang
 * @since 2020-10-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    // 菜单
    public static final String TYPE_MENU = "0";
    // 按钮
    public static final String TYPE_BUTTON = "1";
    /**
     * 菜单/按钮ID
     */
    @TableId(value = "MENU_ID", type = IdType.AUTO)
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 对应路由path
     */
    @TableField("PATH")
    private String path;

    /**
     * 对应路由组件component
     */
    @TableField("COMPONENT")
    private String component;

    /**
     * 权限标识
     */
    @TableField("PERMS")
    private String perms;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @TableField("TYPE")
    private String type;

    /**
     * 排序
     */
    @TableField("ORDER_NUM")
    private Double orderNum;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    //transient的作用等同于 exist=false。 不映射到数据库表中的字段
    private transient String createTimeFrom;
    private transient String createTimeTo;
}
