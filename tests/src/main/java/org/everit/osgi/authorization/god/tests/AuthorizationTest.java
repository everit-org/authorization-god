/**
 * This file is part of Everit - Authorization GOD Tests.
 *
 * Everit - Authorization GOD Tests is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Authorization GOD Tests is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Authorization GOD Tests.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authorization.god.tests;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.everit.osgi.authorization.PermissionChecker;
import org.everit.osgi.authorization.qdsl.util.AuthorizationQdslUtil;
import org.everit.osgi.dev.testrunner.TestRunnerConstants;
import org.junit.Assert;
import org.junit.Test;

import com.mysema.query.types.template.BooleanTemplate;

@Component(immediate = true, configurationFactory = false, policy = ConfigurationPolicy.OPTIONAL)
@Properties({
        @Property(name = TestRunnerConstants.SERVICE_PROPERTY_TESTRUNNER_ENGINE_TYPE, value = "junit4"),
        @Property(name = TestRunnerConstants.SERVICE_PROPERTY_TEST_ID, value = "AuthorizationTest"),
        @Property(name = "authorizationQdslUtil.target"),
        @Property(name = "permissionChecker.target")
})
@Service(value = AuthorizationTest.class)
public class AuthorizationTest {

    @Reference(bind = "setPermissionChecker")
    private PermissionChecker permissionChecker;

    @Reference(bind = "setAuthorizationQdslUtil")
    private AuthorizationQdslUtil authorizationQdslUtil;

    public void setAuthorizationQdslUtil(final AuthorizationQdslUtil authorizationQdslUtil) {
        this.authorizationQdslUtil = authorizationQdslUtil;
    }

    public void setPermissionChecker(final PermissionChecker permissionChecker) {
        this.permissionChecker = permissionChecker;
    }

    @Test
    public void testComplex() {
        Assert.assertEquals(BooleanTemplate.TRUE, authorizationQdslUtil.authorizationPredicate(0, null));

        Assert.assertTrue(permissionChecker.hasPermission(0, 0));

        Assert.assertEquals(-1, permissionChecker.getSystemResourceId());

        long[] authorizationScope = permissionChecker.getAuthorizationScope(0);
        Assert.assertEquals(1, authorizationScope.length);
        Assert.assertEquals(-1, authorizationScope[0]);
    }

}
