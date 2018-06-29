package com.starlightfinancial.springsecuritydemocsdn.security.metadatasource;

import com.starlightfinancial.springsecuritydemocsdn.domain.SysResourceRepository;
import com.starlightfinancial.springsecuritydemocsdn.domain.SysRole;
import com.starlightfinancial.springsecuritydemocsdn.domain.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/29 17:07
 * @Modified By:
 */
public class DaoBasedFilterInvocationSecurityMetadataSource extends DefaultFilterInvocationSecurityMetadataSource {
    /**
     * Sets the internal request map from the supplied map. The key elements should be of
     * type {@link RequestMatcher}, which. The path stored in the key will depend on the
     * type of the supplied UrlMatcher.
     *
     * @param requestMap order-preserving map of request definitions to attribute lists
     */
    public DaoBasedFilterInvocationSecurityMetadataSource(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
        super(requestMap);
    }


    @Autowired
    private SysResourceRepository sResourceVODao;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
     */
    @PostConstruct
    private void loadResourceDefine() {   //一定要加上@PostConstruct注解
        // 在Web服务器启动时，提取系统中的所有权限。
        List<SysRole> allSysRole = sysRoleRepository.findAll();
        allSysRole.stream().collect(Collectors.toList());
        /*
         * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
         * sparta
         */
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

        for (String auth : query) {
            ConfigAttribute ca = new SecurityConfig(auth);
            //List<Map<String,Object>> query1 = sResourceVODao.findByRoleName(auth);
            List<String> query1 = new ArrayList<String>();
            List<Map<String, Object>>  list1 = sResourceVODao.findByRoleName(auth);
            if(list1!=null && list1.size()>0) {
                for(Map<String, Object> map :list1){
                    Object value = map.get("resource_string");
                    String url = String.valueOf(value);
                    query1.add(url);
                }
            }
            for (String res : query1) {
                String url = res;

                /*
                 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
                 * sparta
                 */
                if (resourceMap.containsKey(url)) {

                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }

            }
        }

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }
    // 根据URL，找到相关的权限配置。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        System.out.println("nwuidhwuiehdfu");
        // object 是一个URL，被用户请求的url。
        FilterInvocation filterInvocation = (FilterInvocation) object;
        if (resourceMap == null) {
            loadResourceDefine();
        }
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(resURL);
            }
        }

        return null;
    }
    @Override
    public boolean supports(Class<?> arg0) {

        return true;
    }

}
