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

import java.util.Dictionary;
import java.util.Hashtable;

import org.everit.osgi.authorization.god.AuthorizationGodConstants;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class AuthorizationGodActivator implements BundleActivator {

    private ServiceRegistration<?> godSR;

    @Override
    public void start(final BundleContext bundleContext) throws Exception {
        Dictionary<String, String> properties = new Hashtable<String, String>();
        properties.put(Constants.SERVICE_DESCRIPTION, AuthorizationGodConstants.GOD_SERVICE_DESCRIPTION);
        properties.put(AuthorizationGodConstants.PROP_AUTHORIZATION_IMPL,
                AuthorizationGodConstants.GOD_AUTHORIZATION_IMPL);
        godSR = bundleContext.registerService(
                new String[] {
                        AuthorizationGodConstants.OBJECT_CLASS_PERMISSION_CHECKER,
                        AuthorizationGodConstants.OBJECT_CLASS_AUTHORIZATION_QDSL_UTIL },
                new AuthorizationGod(),
                properties);
    }

    @Override
    public void stop(final BundleContext bundleContext) throws Exception {
        godSR.unregister();
    }

}
