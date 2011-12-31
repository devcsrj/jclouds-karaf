/*
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

package org.jclouds.karaf.commands.compute.completer;

import java.util.Set;
import org.apache.karaf.shell.console.Completer;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.Image;

public class ImageCompleter extends ComputeCompleterSupport implements Completer {

    @Override
    public void updateCache() {
        cache.clear();
        ComputeService service = getService();
        if (service != null) {
            Set<? extends Image> images = service.listImages();
            if (images != null) {
                for (Image image : images) {
                    cache.add(image.getId());
                }
            }
        }
    }
}