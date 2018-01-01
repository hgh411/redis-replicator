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

import com.moilioncircle.redis.replicator.cmd.CommandParser;
import com.moilioncircle.redis.replicator.cmd.impl.BitOpCommand;
import com.moilioncircle.redis.replicator.cmd.impl.Op;

import static com.moilioncircle.redis.replicator.cmd.parser.CommandParsers.objToBytes;
import static com.moilioncircle.redis.replicator.cmd.parser.CommandParsers.objToString;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class BitOpParser implements CommandParser<BitOpCommand> {
    @Override
    public BitOpCommand parse(Object[] command) {
        int idx = 1;
        String strOp = objToString(command[idx++]);
        Op op = Op.valueOf(strOp.toUpperCase());
        String destKey = objToString(command[idx]);
        byte[] rawDestKey = objToBytes(command[idx]);
        idx++;
        String[] keys = new String[command.length - 3];
        byte[][] rawKeys = new byte[command.length - 3][];
        for (int i = idx, j = 0; i < command.length; i++, j++) {
            keys[j] = objToString(command[i]);
            rawKeys[j] = objToBytes(command[i]);
        }
        return new BitOpCommand(op, destKey, keys, rawDestKey, rawKeys);
    }

}
