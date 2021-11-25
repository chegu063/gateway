##sql

```mysql
CREATE TABLE `t_app` (
`id` int NOT NULL AUTO_INCREMENT,
`app_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '应用名称',
`description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
`context_path` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '路径上下文',
`enabled` tinyint NOT NULL DEFAULT '0' COMMENT '是否开启，1开启0未开启',
`created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```

```mysql
CREATE TABLE `t_app_instance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_id` int NOT NULL COMMENT '应用id',
  `version` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '版本号',
  `ip` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ip',
  `port` int DEFAULT NULL COMMENT '端口号',
  `weight` int DEFAULT NULL COMMENT '权重',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```

```mysql
CREATE TABLE `t_app_plugin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_id` int NOT NULL COMMENT '应用id',
  `plugin_id` int NOT NULL COMMENT '插件id',
  `enabled` tinyint NOT NULL DEFAULT '0' COMMENT '是否开启，1开启0未开启',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```

```mysql
CREATE TABLE `t_route_rule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_id` int NOT NULL COMMENT '应用Id',
  `version` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '路由版本',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `match_object` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '匹配对象，DEFAULT，QUERY，HEADER',
  `match_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '匹配key',
  `match_method` tinyint DEFAULT NULL COMMENT '匹配方式,1:=,2:regex,3:like',
  `match_rule` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '匹配规则',
  `priority` int DEFAULT NULL COMMENT '优先级，值越大优先级越高',
  `enabled` tinyint DEFAULT '0' COMMENT '是否启用，1=开启0=禁用',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```

```mysql
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```