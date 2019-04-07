## 说明
### 目标：实现一个多数据源中间件，完成对多数据源操作的封装，使用者无须关心多数据源细节，就可以像普通的数据源一样操作
### 局限：限制了所有的数据源，状态配置需要一直
### 大概思路：
- 自定义DataSource完成多数据源的封装CustomDataSource
- 从CustomDtaSource获取的CustomConnection实例是对每个真实的Connection的集合实现，CustomDataSource不维护链接，有具体的DataSource处理
- 对CustomConnection的非幂等性操作在实现内对所有的真实的Connection进行操作
- 如果有任一个Connection出现异常，则抛出对应异常由具体的业务处理
- 主要需要完成：DataSource、Connection、Statement、PreparedStatement、CallableStatement的封装

