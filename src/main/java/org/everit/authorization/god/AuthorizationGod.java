/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.authorization.god;

import org.everit.authorization.PermissionChecker;
import org.everit.authorization.qdsl.util.AuthorizationQdslUtil;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

/**
 * The "GOD" implementation of the {@link PermissionChecker} and {@link AuthorizationQdslUtil}
 * interfaces, it allows everything.
 */
public class AuthorizationGod implements PermissionChecker, AuthorizationQdslUtil {

  private static final int DEFAULT_SYSTEM_RESOURCE_ID = -1;

  @Override
  public BooleanExpression authorizationPredicate(final long authorizedResourceId,
      final Expression<Long> targetResourceId, final String... actions) {
    return Expressions.TRUE;
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
  public boolean hasPermission(final long authorizedResourceId, final long targetResourceId,
      final String... actions) {
    return true;
  }

}
