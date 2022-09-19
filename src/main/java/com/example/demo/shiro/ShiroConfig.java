//package com.example.demo.shiro;
//
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.session.mgt.eis.SessionDAO;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.crazycake.shiro.RedisCacheManager;
//import org.crazycake.shiro.RedisManager;
//import org.crazycake.shiro.RedisSessionDAO;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author 10450
// * @description TODO
// * @date 2021/7/22 17:56
// */
//@Configuration
//public class ShiroConfig {
//
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager((org.apache.shiro.mgt.SecurityManager) securityManager);
//
//        //这里定义用户未认证时跳转的路径
//        shiroFilterFactoryBean.setLoginUrl("/admin/401");
//        //这里是用户登录成功后跳转的路径
//        shiroFilterFactoryBean.setSuccessUrl("/admin/index");
//        //这里是用户没有访问权限跳转的路径
//        // 但是这个配置无效，只有perms，roles，ssl，rest，port才是属于AuthorizationFilter，
//        // 而anon，authcBasic，authc，user是AuthenticationFilter
//        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/unAuth");
//
//        //自定义拦截器限制并发人数,参考博客：
////        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
//        //限制同一帐号同时在线的个数
//        //filtersMap.put("kickout", kickoutSessionControlFilter());
//        //统计登录人数
////        shiroFilterFactoryBean.setFilters(filtersMap);
//
//        // 配置访问权限 必须是LinkedHashMap，因为它必须保证有序
//        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 --> : 这是一个坑，一不小心代码就不好使了
//        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/admin/login","anon");
//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/img/**", "anon");
//        filterChainDefinitionMap.put("/druid/**", "anon");
//
//        //解锁用户专用 测试用的
//        filterChainDefinitionMap.put("/unlockAccount","anon");
//        filterChainDefinitionMap.put("/Captcha.jpg","anon");
//        //logout是shiro提供的过滤器
//        filterChainDefinitionMap.put("/logout", "logout");
//
//        filterChainDefinitionMap.put("/admin/unAuth","anon");
//        filterChainDefinitionMap.put("/admin/401","anon");
//
//
//        //其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
//        //如果开启限制同一账号登录,改为 .put("/**", "kickout,user");
//        filterChainDefinitionMap.put("/**","authc");
////        filterChainDefinitionMap.put("/**", "user");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//    //    将realm加入管理器中
//
//    /**
//     * 配置核心安全事务管理器
//     * @return
//     */
//    @Bean(name="securityManager")
//    public DefaultWebSecurityManager defaultWebSecurityManager(){
//        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
//        // 设置realm.
//        defaultWebSecurityManager.setRealm(realm());
//        // 自定义缓存实现 使用redis
//        defaultWebSecurityManager.setCacheManager(cacheManager());
//        // 自定义session管理 使用redis
//        defaultWebSecurityManager.setSessionManager(sessionManager());
//        return defaultWebSecurityManager;
//    }
//
//    //配置realm
//    @Bean
//    public Realm realm(){
//        return  new LoginAuthorizingRealm();
//    }
//
//    /**
//     * shiro缓存管理器;
//     * 需要添加到securityManager中
//     * @return
//     */
//    @Bean
//    public RedisCacheManager cacheManager(){
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        redisCacheManager.setRedisManager(redisManager());
//        //redis中针对不同用户缓存
//        redisCacheManager.setPrincipalIdFieldName("username");
//        //用户权限信息缓存时间
//        redisCacheManager.setExpire(200000);
//        return redisCacheManager;
//    }
//
//    @Bean
//    public RedisManager redisManager(){
//        RedisManager redisManager = new RedisManager();
//        redisManager.setHost("127.0.0.1:6379");
//        redisManager.setPassword("123456");
//        return redisManager;
//    }
//
//    /**
//     * Session Manager
//     * 使用的是shiro-redis开源插件
//     */
//    @Bean
//    public DefaultWebSessionManager sessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setSessionDAO(sessionDAO());
//        return sessionManager;
//    }
//
////    /**
////     * 配置会话管理器，设定会话超时及保存
////     * @return
////     */
////    @Bean("sessionManager")
////    public SessionManager sessionManager() {
////        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
////        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
////        //配置监听
////        listeners.add(sessionListener());
////        sessionManager.setSessionListeners(listeners);
////        sessionManager.setSessionIdCookie(sessionIdCookie());
////        sessionManager.setSessionDAO(sessionDAO());
////        sessionManager.setCacheManager(cacheManager());
////
////        //全局会话超时时间（单位毫秒），默认30分钟  暂时设置为10秒钟 用来测试
////        sessionManager.setGlobalSessionTimeout(1800000);
////        //是否开启删除无效的session对象  默认为true
////        sessionManager.setDeleteInvalidSessions(true);
////        //是否开启定时调度器进行检测过期session 默认为true
////        sessionManager.setSessionValidationSchedulerEnabled(true);
////        //设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话 默认为 1个小时
////        //设置该属性 就不需要设置 ExecutorServiceSessionValidationScheduler 底层也是默认自动调用ExecutorServiceSessionValidationScheduler
////        //暂时设置为 5秒 用来测试
////        sessionManager.setSessionValidationInterval(3600000);
////        //取消url 后面的 JSESSIONID
////        sessionManager.setSessionIdUrlRewritingEnabled(false);
////        return sessionManager;
////
////    }
//
//    /**
//     * SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件
//     * MemorySessionDAO 直接在内存中进行会话维护
//     * EnterpriseCacheSessionDAO  提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
//     * @return
//     */
//    @Bean
//    public SessionDAO sessionDAO() {
//        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//        redisSessionDAO.setRedisManager(redisManager());
//        //session在redis中的保存时间,最好大于session会话超时时间
//        redisSessionDAO.setExpire(12000);
//        return redisSessionDAO;
//    }
//
//
//    /**
//     * 开启shiro 注解模式
//     * 可以在controller中的方法前加上注解
//     * 如 @RequiresPermissions("userInfo:add")
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
////        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//    /**
//     * 配置Shiro生命周期处理器
//     * @return
//     */
//    @Bean(name = "lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    /**
//     * 解决： 无权限页面不跳转 shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized") 无效
//     * shiro的源代码ShiroFilterFactoryBean.Java定义的filter必须满足filter instanceof AuthorizationFilter，
//     * 只有perms，roles，ssl，rest，port才是属于AuthorizationFilter，而anon，authcBasic，auchc，user是AuthenticationFilter，
//     * 所以unauthorizedUrl设置后页面不跳转 Shiro注解模式下，登录失败与没有权限都是通过抛出异常。
//     * 并且默认并没有去处理或者捕获这些异常。在SpringMVC下需要配置捕获相应异常来通知用户信息
//     * @return
//     *
//     * globalExceptionHandle 处理了，所以这个注释了
//     */
////    @Bean
////    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
////        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
////        Properties properties=new Properties();
////        //这里的 /unauthorized 是页面，不是访问的路径
////        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/unauthorized");
////        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException","/unauthorized");
////        simpleMappingExceptionResolver.setExceptionMappings(properties);
////        return simpleMappingExceptionResolver;
////    }
//
////    /**
////     * 解决spring-boot Whitelabel Error Page
////     * @return
////     */
////    @Bean
////    public EmbeddedServletContainerCustomizer containerCustomizer() {
////
////        return new EmbeddedServletContainerCustomizer() {
////            @Override
////            public void customize(ConfigurableEmbeddedServletContainer container) {
////
////                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/unauthorized.html");
////                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
////                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
////
////                container.addErrorPages(error401Page, error404Page, error500Page);
////            }
////        };
////    }
//
////    /**
////     * cookie对象;会话Cookie模板 ,默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid或rememberMe，自定义
////     * @return
////     */
////    @Bean
////    public SimpleCookie rememberMeCookie(){
////        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
////        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
////        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
////        //setcookie()的第七个参数
////        //设为true后，只能通过http访问，javascript无法访问
////        //防止xss读取cookie
////        simpleCookie.setHttpOnly(true);
////        simpleCookie.setPath("/");
////        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
////        simpleCookie.setMaxAge(2592000);
////        return simpleCookie;
////    }
////
////    /**
////     * cookie管理对象;记住我功能,rememberMe管理器
////     * @return
////     */
////    @Bean
////    public CookieRememberMeManager rememberMeManager(){
////        /**
////         * 修复安全问题，生成随机秘钥
////         */
////        KeyGenerator keygen = null;
////        try {
////            keygen = KeyGenerator.getInstance("AES");
////        } catch (NoSuchAlgorithmException e) {
////            e.printStackTrace();
////        }
////        SecretKey deskey = keygen.generateKey();
////        System.out.println(org.apache.shiro.codec.Base64.encodeToString(deskey.getEncoded()));
////
////        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
////        cookieRememberMeManager.setCookie(rememberMeCookie());
////        //rememberMe cookie加密的密钥 不安全！
//////        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
////        cookieRememberMeManager.setCipherKey(org.apache.shiro.codec.Base64.decode(deskey.getEncoded()));
////        return cookieRememberMeManager;
////    }
////
////    /**
////     * FormAuthenticationFilter 过滤器 过滤记住我
////     * @return
////     */
////    @Bean
////    public FormAuthenticationFilter formAuthenticationFilter(){
////        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
////        //对应前端的checkbox的name = rememberMe
////        formAuthenticationFilter.setRememberMeParam("rememberMe");
////        return formAuthenticationFilter;
////    }
//
//
//
////    /**
////     * 让某个实例的某个方法的返回值注入为Bean的实例
////     * Spring静态注入
////     * @return
////     */
////    @Bean
////    public MethodInvokingFactoryBean getMethodInvokingFactoryBean(){
////        MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
////        factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
////        factoryBean.setArguments(new Object[]{securityManager()});
////        return factoryBean;
////    }
//
////    /**
////     * 配置session监听
////     * @return
////     */
////    @Bean("sessionListener")
////    public SessionListener sessionListener(){
//////        ShiroSessionListener sessionListener = new ShiroSessionListener();
////        SessionListener sessionListener = new ShiroSessionListener();
////
////
////        return sessionListener;
////    }
////
////    /**
////     * 配置会话ID生成器
////     * @return
////     */
////    @Bean
////    public SessionIdGenerator sessionIdGenerator() {
////        return new JavaUuidSessionIdGenerator();
////    }
//
////    /**
////     * 配置保存sessionId的cookie
////     * 注意：这里的cookie 不是上面的记住我 cookie 记住我需要一个cookie session管理 也需要自己的cookie
////     * 默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid
////     * @return
////     */
////    @Bean("sessionIdCookie")
////    public SimpleCookie sessionIdCookie(){
////        //这个参数是cookie的名称
////        SimpleCookie simpleCookie = new SimpleCookie("sid");
////        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
////
////        //setcookie()的第七个参数
////        //设为true后，只能通过http访问，javascript无法访问
////        //防止xss读取cookie
////        simpleCookie.setHttpOnly(true);
////        simpleCookie.setPath("/");
////        //maxAge=-1表示浏览器关闭时失效此Cookie
////        simpleCookie.setMaxAge(-1);
////        return simpleCookie;
////    }
//
//
//
//
//    /**
//     * 并发登录控制
//     * @return
//     */
////    @Bean
////    public KickoutSessionControlFilter kickoutSessionControlFilter(){
////        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
////        //用于根据会话ID，获取会话进行踢出操作的；
////        kickoutSessionControlFilter.setSessionManager(sessionManager());
////        //使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
////        kickoutSessionControlFilter.setCacheManager(cacheManager());
////        //是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
////        kickoutSessionControlFilter.setKickoutAfter(false);
////        //同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
////        kickoutSessionControlFilter.setMaxSession(1);
////        //被踢出后重定向到的地址；
////        kickoutSessionControlFilter.setKickoutUrl("/login?kickout=1");
////        return kickoutSessionControlFilter;
////    }
//
//    /**
//     * 配置密码比较器
//     * @return
//     */
////    @Bean("credentialsMatcher")
////    public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher(){
////        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager());
////
////        //如果密码加密,可以打开下面配置
////        //加密算法的名称
////        //retryLimitHashedCredentialsMatcher.setHashAlgorithmName("MD5");
////        //配置加密的次数
////        //retryLimitHashedCredentialsMatcher.setHashIterations(1024);
////        //是否存储为16进制
////        //retryLimitHashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
////
////        return retryLimitHashedCredentialsMatcher;
////    }
//
//}
