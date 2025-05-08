# MASTER Common

<p>
    <a href="#联系我们"><img src="https://img.shields.io/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-%E5%A4%A7%E5%B8%88%E5%AD%A6Java-blue" alt="公众号"></a>
</p>

![](https://img.shields.io/badge/SpringBoot-2.3.7-brightgreen.svg)

# 项目简介
Master Common基础功能包，个人多年开发整理的包含Hutool及日常使用工具类，使用顺畅，如有问题欢迎指正～

## 项目特点
1. 封装了常用的注解类及统一返回全局请求基础类
2. 使用@RateLimiter注解对接口进行限流。
3. 使用@DataScope(deptAlias = "t1", userAlias = "t2")进行数据过滤。
4. 使用@PreAuthorize("hasAuthority('system:config:remove')")注解可以对接口进行权限校验。
5. 使用@Log(value = "刷新系统配置缓存", type = SysLogTypeConstant.CONFIG, businessType = BusinessTypeEnum.CLEAN)
   注解进行系统日志存储。
6. 使用@DS("master")切换数据源，优先方法高于类
7. 添加了常用的枚举常量类，增加了项目中常用的配置类，如json序列化及其他配置，详情见config包下配置
8、增加了企业微信系统报错告警，详见SystemWarningUtil类。
## 联系我们

<div style="display: flex; gap: 20px;">
	<div style="text-align: center">
		<img style="max-width: 100%" src="./doc/file/mpqrcode.jpg" alt="公众号" />
		<p>公众号</p>
	</div>
	<div style="text-align: center">
		<img style="max-width: 100%" src="./doc/file/wxcode.jpg" alt="微信" />
		<p>添加微信，加入交流群</p>
	</div>
</div>

## 许可证

[Apache License 2.0](./LICENSE)

Copyright (c) 2023 熊扬软件开发工作室 Limited All rights reserved