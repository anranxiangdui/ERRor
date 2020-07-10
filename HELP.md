###这个是对过滤器,拦截器,自定义异常,AOP处理流程的测试  执行流程图见static文件夹图片

###(单个)正常请求执行流程

Filter------->过滤请求开始
Springboot--->拦截器(preHandle)执行
AOP---------->环绕通知执行开始
AOP---------->前置方法执行
Controller--->成功方法开始执行
AOP---------->环绕通知执行结束
AOP---------->后置通知执行
AOP---------->返回通知执行
Springboot--->拦截器(postHandle)执行
Springboot--->拦截器(afterCompletion)执行
Filter------->过滤请求结束

###(单个)异常请求执行流程

Filter------->过滤请求开始
Springboot--->拦截器(preHandle)执行
AOP---------->环绕通知执行开始
AOP---------->前置方法执行
Controller--->异常方法开始执行
AOP---------->后置通知执行
AOP---------->异常通知执行
SpringMVC---->检测到全局异常
Springboot--->拦截执行但是判断存在异常
Filter------->全局异常拦截,不再向上抛

###(两个)正常请求执行流程

Filter------>过滤请求开始
Springboot------>拦截器(preHandle)执行
Springboot2------>拦截器(preHandle)执行
AOP------>环绕通知执行开始
AOP------>前置方法执行
AOP2------>环绕通知执行开始
AOP2------>前置方法执行
Controller------>成功方法开始执行
AOP2------>环绕通知执行结束
AOP2------>后置通知执行
AOP2------>返回通知执行
AOP------>环绕通知执行结束
AOP------>后置通知执行
AOP------>返回通知执行
Springboot2------>拦截器(postHandle)执行
Springboot------>拦截器(postHandle)执行
Springboot2------>拦截器(afterCompletion)执行
Springboot------>拦截器(afterCompletion)执行
Filter------>过滤请求结束

###(两个)异常请求执行流程

Filter------>过滤请求开始
Springboot------>拦截器(preHandle)执行
Springboot2------>拦截器(preHandle)执行
AOP------>环绕通知执行开始
AOP------>前置方法执行
AOP2------>环绕通知执行开始
AOP2------>前置方法执行
Controller------>异常方法开始执行
AOP2------>后置通知执行
AOP2------>异常通知执行
AOP------>后置通知执行
AOP------>异常通知执行
SpringMVC------>检测到全局异常
Springboot2------>拦截执行但是判断存在异常
Springboot------>拦截执行但是判断存在异常
Filter------>全局异常拦截,不再向上抛