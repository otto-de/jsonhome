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

package de.otto.jsonhome.controller;

import de.otto.jsonhome.generator.JsonHomeGenerator;
import de.otto.jsonhome.generator.JsonHomeSource;
import de.otto.jsonhome.generator.SpringJsonHomeGenerator;
import de.otto.jsonhome.model.JsonHome;
import org.testng.annotations.Test;

import static de.otto.jsonhome.fixtures.ControllerFixtures.ControllerWithoutResource;
import static org.testng.Assert.assertNotNull;

/**
 * @author Guido Steinacker
 * @since 06.10.12
 */
public class GeneratorBasedJsonHomeSourceTest {

    @Test
    public void shouldReturnJsonHomeInstance() {
        // given
        final JsonHomeSource jsonHomeControllerBase = getJsonHomeSource();
        // when
        final JsonHome jsonHome = jsonHomeControllerBase.getJsonHome();
        // then
        assertNotNull(jsonHome);
    }

    private JsonHomeSource getJsonHomeSource() {
        final GeneratorBasedJsonHomeSource source = new GeneratorBasedJsonHomeSource();
        source.setControllerTypes(ControllerWithoutResource.class);
        source.setJsonHomeGenerator(getJsonHomeGenerator());
        return source;
    }

    private JsonHomeGenerator getJsonHomeGenerator() {
        final SpringJsonHomeGenerator jsonHomeGenerator = new SpringJsonHomeGenerator();
        jsonHomeGenerator.setApplicationBaseUri("http://app.example.org/");
        jsonHomeGenerator.setRelationTypeBaseUri("http://rel.example.org/");
        jsonHomeGenerator.postConstruct();
        return jsonHomeGenerator;
    }

}
