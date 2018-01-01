/*
 * Copyright 2016-2018 Leon Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.parser;

import com.moilioncircle.redis.replicator.cmd.impl.LTrimCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Leon Chen
 * @since 2.3.1
 */
public class LTrimParserTest extends AbstractParserTest {
    @Test
    public void parse() throws Exception {
        LTrimParser parser = new LTrimParser();
        LTrimCommand cmd = parser.parse(toObjectArray("LTRIM mylist 0 99".split(" ")));
        assertEquals("mylist", cmd.getKey());
        assertEquals(0L, cmd.getStart());
        assertEquals(99L, cmd.getStop());
        System.out.println(cmd);
    }

}