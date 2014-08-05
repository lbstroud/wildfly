/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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
package org.wildfly.clustering.server.group;

import org.jboss.modules.ModuleIdentifier;
import org.jboss.msc.service.ServiceBuilder;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.ServiceTarget;
import org.wildfly.clustering.server.GroupServiceBuilder;
import org.wildfly.clustering.spi.ClusteredGroupServiceInstaller;

/**
 * @author Paul Ferraro
 */
public class ChannelNodeFactoryServiceInstaller extends GroupNodeFactoryServiceInstaller implements ClusteredGroupServiceInstaller {

    private static final GroupServiceBuilder<JGroupsNodeFactory> BUILDER = new GroupServiceBuilder<JGroupsNodeFactory>() {
        @Override
        public ServiceBuilder<JGroupsNodeFactory> build(ServiceTarget target, ServiceName name, String group, ModuleIdentifier module) {
            return ChannelNodeFactoryService.build(target, name, group);
        }
    };

    public ChannelNodeFactoryServiceInstaller() {
        super(BUILDER);
    }
}
