/**
 * Copyright (C) 2012 Ness Computing, Inc.
 *
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
 */
package com.opentable.server;

import com.google.inject.Module;
import com.google.inject.util.Modules;

import com.opentable.config.Config;

class DemoServer extends StandaloneServer
{
    private static DemoServer server = null;
    private final Config config;

    public DemoServer(Config config) {
        this.config = config;
    }

    public static void main(final String [] args)
    {
        server = new DemoServer(null);
        server.startServer();
    }

    @Override
    public Config getConfig() {
        if (config != null) {
            return config;
        }
        return super.getConfig();
    }

    public static StandaloneServer getServer()
    {
        return server;
    }

    @Override
    public Module getMainModule(final Config config)
    {
        return Modules.EMPTY_MODULE;
    }

    @Override
    protected Module getServerTemplateModule(Config config)
    {
        return Modules.EMPTY_MODULE;
    }

    @Override
    public String getServerType()
    {
        return "demo";
    }
}
