```
├── src
│   ├── main
│   │   ├── java/com/example/demo # Java源代码目录
│   │   └── resources            # 配置资源目录
├── pom.xml                      # Maven项目配置文件
└── README.md                    # 项目说明文档
```

## 技术栈
- Spring Boot
- MyBatis Plus
- Maven
- Java 8+

## 功能模块
1. **售后管理** (`AfterSaleController`)
2. **客户管理** (`CustomerController`)
3. **订单管理** (`OrderController`)
4. **角色权限管理** (`RolerController`)
5. **菜单管理** (`MenusController`)
6. **销售计划管理** (`SellJhController`)
7. **回复管理** (`ReplayController`)

## 开发环境要求
1. JDK 1.8+
2. Maven 3.5+
3. MySQL 5.7+

## 目录说明
| 路径 | 说明 |
|------|------|
| `src/main/java/com/example/demo/controller` | 控制器层 |
| `src/main/java/com/example/demo/service` | 服务层 |
| `src/main/java/com/example/demo/mapper` | 数据访问层 |
| `src/main/java/com/example/demo/pojo` | 实体类 |
| `src/main/resources/application.properties` | 配置文件 |
| `src/main/resources/mapper` | MyBatis XML映射文件 |

## 贡献指南
1. Fork本仓库
2. 创建feature分支
3. 提交代码
4. 创建Pull Request
