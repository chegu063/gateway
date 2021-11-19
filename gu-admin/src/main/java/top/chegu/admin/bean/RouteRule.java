/*
 * Copyright (c) 2021 chegu <1107313063@qq.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author chegu
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_route_rule")
@ApiModel(value="RouteRule对象", description="")
public class RouteRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "应用Id")
    @TableField("app_id")
    private Integer appId;

    @ApiModelProperty(value = "路由版本")
    @TableField("version")
    private String version;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "匹配对象，DEFAULT，QUERY，HEADER")
    @TableField("match_object")
    private String matchObject;

    @ApiModelProperty(value = "匹配key")
    @TableField("match_key")
    private String matchKey;

    @ApiModelProperty(value = "匹配方式,1:=,2:regex,3:like")
    @TableField("match_method")
    private Boolean matchMethod;

    @ApiModelProperty(value = "匹配规则")
    @TableField("match_rule")
    private String matchRule;

    @ApiModelProperty(value = "优先级，值越大优先级越高")
    @TableField("priority")
    private Integer priority;

    @ApiModelProperty(value = "是否启用，1=开启0=禁用")
    @TableField("enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private LocalDateTime createdTime;


}
