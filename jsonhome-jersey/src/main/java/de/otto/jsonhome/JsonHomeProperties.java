/*
 * Copyright 2012 Guido Steinacker
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

package de.otto.jsonhome;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sebastian Schroeder
 * @since 15.12.2012
 */
public final class JsonHomeProperties {

    private JsonHomeProperties() {}

    public static Properties getProperties() {
        final InputStream is = JsonHomeProperties.class.getResourceAsStream("jsonhome.properties");
        final Properties properties = new Properties();
        if (is == null) {
            return properties;
        } else {
            try {
                properties.load(is);
                is.close();
            } catch (IOException e) {}
        }
        return properties;
    }

}
