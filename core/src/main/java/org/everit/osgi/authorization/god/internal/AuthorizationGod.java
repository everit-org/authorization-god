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
package org.everit.osgi.authorization.god.internal;

import org.everit.osgi.authorization.PermissionChecker;
import org.everit.osgi.authorization.qdsl.util.AuthorizationQdslUtil;

import com.mysema.query.types.Expression;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.template.BooleanTemplate;

public class AuthorizationGod implements PermissionChecker, AuthorizationQdslUtil {

    private static final int DEFAULT_SYSTEM_RESOURCE_ID = -1;

    @Override
    public BooleanExpression authorizationPredicate(final long authorizedResourceId,
            final Expression<Long> targetResourceId, final String... actions) {
        return BooleanTemplate.TRUE;
    }

    @Override
    public long[] getAuthorizationScope(final long authorizedResourceId) {
        return new long[] { DEFAULT_SYSTEM_RESOURCE_ID };
    }

    @Override
    public long getSystemResourceId() {
        return DEFAULT_SYSTEM_RESOURCE_ID;
    }

    @Override
    public boolean hasPermission(final long authorizedResourceId, final long targetResourceId, final String... actions) {
        return true;
    }

}
