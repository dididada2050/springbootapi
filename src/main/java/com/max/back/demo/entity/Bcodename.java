package com.max.back.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author max
 * @since 2021-07-29
 */

/**
 * Lombok项目是一个java库，它可以自动插入到编辑器和构建工具中，增强java的性能。
 * 不要再写另一个getter或equals方法，只要有一个注释，你的类就有一个功能齐全的构建器，自动记录变量等等。
 */

/**
 * @EqualsAndHashCode
1.些注解会生成equals(Object other)和hashCode()方法。
2.它默认使用非静态，非瞬态的属性
3.可通过参数exclude排除一些属性
4.可通过参数of指定仅使用哪些属性
5.它默认仅使用该类中定义的属性目不调用父类的方法
6.可通过 callSuper=true 解决上一点问题。让其生成的方法中调用父类的方法。
另:@Data 相当干 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode 这5个注解的合集。
通过官方文档，可以得知，当使用@Data注解时，则有了 @EqualsAndHashCode注解，那么就会在此类中存在equals(Object other) hashCode()方法，且不会使用父类的属性，这就导致了可能的问题。
比如，有多个类有相同的部分属性，把它们定义到父类中，恰好id(数据库主键)也在父类中，那么就会存在部分对象在比较时，它们并不
相等，却因为lombok自动生成的eauals(Obiectother)和hashCode()方法判定为相等，从而导致出错。
修复此问题的方法很简单:
1.使用@Getter @Setter @ToString 代替 @Data并且自定义equals(Objectother)和hashCode)方法，比如有些类只需要判断主键id是否相等即足矣。
2.或者使用在使用 @Data 时同时加上@EgualsAndHashCode(callSuper=true)注解。
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bcodename")
public class Bcodename implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("codeid")
    private String codeid;

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("option1")
    private String option1;

    @TableField("ordercol")
    private Integer ordercol;


}
