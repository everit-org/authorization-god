/**
 * This file is part of Everit - Authorization GOD.
 *
 * Everit - Authorization GOD is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Authorization GOD is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Authorization GOD.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authorization.god;

import org.everit.osgi.authorization.PermissionChecker;
import org.everit.osgi.authorization.qdsl.util.AuthorizationQdslUtil;

public final class AuthorizationGodConstants {

    public static final String GOD_SERVICE_DESCRIPTION = "Authorization God";

    public static final String PROP_AUTHORIZATION_IMPL = "authorization.impl";

    public static final String GOD_AUTHORIZATION_IMPL = "god";

    public static final String OBJECT_CLASS_PERMISSION_CHECKER = PermissionChecker.class.getName();

    public static final String OBJECT_CLASS_AUTHORIZATION_QDSL_UTIL = AuthorizationQdslUtil.class.getName();

    private AuthorizationGodConstants() {
    }

}
