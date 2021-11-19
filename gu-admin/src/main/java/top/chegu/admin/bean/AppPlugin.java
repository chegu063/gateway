package top.chegu.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chegu
 * @since 2021-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_app_plugin")
@ApiModel(value="AppPlugin对象", description="")
public class AppPlugin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "应用id")
    @TableField("app_id")
    private Integer appId;

    @ApiModelProperty(value = "插件id")
    @TableField("plugin_id")
    private Integer pluginId;

    @ApiModelProperty(value = "是否开启，1开启0未开启")
    @TableField("enabled")
    private Boolean enabled;


}
