

#### BeanDefinition 属性
| 属性                     | 说明                                                       |
| :----------------------- | ---------------------------------------------------------- |
| Class                    | Bean全类名，必须是具体类，不能用抽象类或接口（不能实例化） |
| Name                     | Bean的名称或者id                                           |
| Scope                    | Bean的作用域（如: singleton\prototype）                    |
| Constructor arguments    | Bean构造器参数（用于依赖注入）                             |
| Properties               | Bean属性设置（用于依赖注入）                               |
| Autowiring mode          | Bean自动绑定模式（如：通过名称byName）                     |
| Lazy initialization mode | Bean延迟初始化模式（延迟或者非延迟）                       |
| Initialization method    | Bean初始化回调方法名称                                     |
| Destruction method       | Bean销毁回调方法名称                                       |

