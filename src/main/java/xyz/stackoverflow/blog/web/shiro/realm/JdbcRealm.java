package xyz.stackoverflow.blog.web.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.stackoverflow.blog.pojo.entity.User;
import xyz.stackoverflow.blog.service.PermissionService;
import xyz.stackoverflow.blog.service.RoleService;
import xyz.stackoverflow.blog.service.UserService;
import xyz.stackoverflow.blog.web.shiro.util.SimpleByteSource;

import java.util.Set;

public class JdbcRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String email = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.getUserByEmail(email);
        SimpleAuthorizationInfo sa = new SimpleAuthorizationInfo();
        Set<String> roleSet = roleService.getRoleByUserId(user.getId());
        if (roleSet != null) {
            Set<String> permissionSet = permissionService.getAllPermission(roleSet.toArray(new String[0]));
            sa.setRoles(roleSet);
            if (permissionSet != null) {
                sa.setStringPermissions(permissionSet);
            }
        }
        return sa;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String email = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByEmail(email);
        SimpleAuthenticationInfo sa = new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), new SimpleByteSource(user.getSalt()), getName());
        return sa;
    }
}