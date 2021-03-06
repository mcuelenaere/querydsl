/*
 * Copyright 2011, Mysema Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mysema.query.sql;

import com.mysema.query.QueryMetadata;


/**
 * SerializationContext defines a callback interface for SQLQuery serialization
 * 
 * @author tiwe
 *
 */
public interface SerializationContext {

    /**
     * @param metadata
     * @param forCountRow
     */
    void serialize(QueryMetadata metadata, boolean forCountRow);

    /**
     * @param str
     */
    SerializationContext append(String str);

    /**
     * @param string
     * @param offset
     */
    void handle(String template, Object... args);

}
