package prj;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg) {
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addStringPermission("reader");//授权
        return simpleAuthorInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        String username=((UsernamePasswordToken) token).getUsername();
        String password= String.valueOf(((UsernamePasswordToken) token).getPassword());

        if (!"spring".equals(username) || !"Shiro".equals(password) ) {
            throw new UnknownAccountException("UserName error");
        }
        return new SimpleAuthenticationInfo(username, "Shiro", getName());
    }



}

