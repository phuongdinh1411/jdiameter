/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.common.impl.app.slg;

import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.slg.ClientSLgSession;
import org.jdiameter.api.slg.ServerSLgSession;
import org.jdiameter.client.impl.app.slg.ClientSLgSessionDataLocalImpl;
import org.jdiameter.common.api.app.IAppSessionDataFactory;
import org.jdiameter.common.api.app.slg.ISLgSessionData;
import org.jdiameter.server.impl.app.slg.ServerSLgSessionDataLocalImpl;

/**
 * @author fernando.mendioroz@telestax.com (Fernando Mendioroz)
 *
 */

public class SLgLocalSessionDataFactory implements IAppSessionDataFactory<ISLgSessionData> {

    public ISLgSessionData getAppSessionData(Class<? extends AppSession> clazz, String sessionId) {
        if (clazz.equals(ClientSLgSession.class)) {
            ClientSLgSessionDataLocalImpl data = new ClientSLgSessionDataLocalImpl();
            data.setSessionId(sessionId);
            return data;
        } else if (clazz.equals(ServerSLgSession.class)) {
            ServerSLgSessionDataLocalImpl data = new ServerSLgSessionDataLocalImpl();
            data.setSessionId(sessionId);
            return data;
        } else {
            throw new IllegalArgumentException("Invalid Session Class: " + clazz.toString());
        }
    }
}