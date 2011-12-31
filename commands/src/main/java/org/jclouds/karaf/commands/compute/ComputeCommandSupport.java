/**
 * Copyright (C) 2011, the original authors
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */
package org.jclouds.karaf.commands.compute;

import java.util.Collections;
import java.util.List;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.jclouds.compute.ComputeService;
import org.osgi.service.cm.ConfigurationAdmin;


/**
 * @author <a href="mailto:gnodet[at]gmail.com">Guillaume Nodet (gnodet)</a>
 */
public abstract class ComputeCommandSupport extends OsgiCommandSupport {

    private ConfigurationAdmin configurationAdmin;
    private List<ComputeService> services;

    @Option(name = "--provider")
    protected String provider;

    public ConfigurationAdmin getConfigurationAdmin() {
        return configurationAdmin;
    }

    public void setConfigurationAdmin(ConfigurationAdmin configurationAdmin) {
        this.configurationAdmin = configurationAdmin;
    }

    public void setServices(List<ComputeService> services) {
        this.services = services;
    }

    protected List<ComputeService> getComputeServices() {
        if (provider == null) {
            return services;
        } else {
            return Collections.singletonList(getComputeService());
        }
    }

    protected ComputeService getComputeService() {
        return ComputeHelper.getComputeService(provider, services);
    }
}