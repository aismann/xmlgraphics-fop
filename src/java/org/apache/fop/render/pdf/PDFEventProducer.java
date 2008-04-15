/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.render.pdf;

import org.apache.fop.events.EventBroadcaster;
import org.apache.fop.events.EventProducer;
import org.apache.fop.events.model.AbstractEventModelFactory;
import org.apache.fop.events.model.EventModel;

/**
 * Event producer interface for events generated by the PDF renderer.
 */
public interface PDFEventProducer extends EventProducer {

    /** Provider class for the event producer. */
    class Provider {
        
        /**
         * Returns an event producer.
         * @param broadcaster the event broadcaster to use
         * @return the event producer
         */
        public static PDFEventProducer get(EventBroadcaster broadcaster) {
            return (PDFEventProducer)broadcaster.getEventProducerFor(
                    PDFEventProducer.class);
        }
    }

    /** Event model factory for this event producer. */
    public static class EventModelFactory extends AbstractEventModelFactory {

        /** {@inheritDoc} */
        public EventModel createEventModel() {
            return loadModel(getClass(), "event-model.xml");
        }
        
    }
    
    /**
     * Some link targets haven't been fully resolved.
     * @param source the event source
     * @param count the number of unresolved links
     * @event.severity WARN
     */
    void nonFullyResolvedLinkTargets(Object source, int count);
    
}