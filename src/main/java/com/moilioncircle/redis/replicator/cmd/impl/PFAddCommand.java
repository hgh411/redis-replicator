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

package com.moilioncircle.redis.replicator.cmd.impl;

import com.moilioncircle.redis.replicator.cmd.Command;

import java.util.Arrays;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class PFAddCommand implements Command {

    private static final long serialVersionUID = 1L;

    private String key;
    private String[] elements;
    private byte[] rawKey;
    private byte[][] rawElements;

    public PFAddCommand() {
    }

    public PFAddCommand(String key, String[] elements) {
        this(key, elements, null, null);
    }

    public PFAddCommand(String key, String[] elements, byte[] rawKey, byte[][] rawElements) {
        this.key = key;
        this.elements = elements;
        this.rawKey = rawKey;
        this.rawElements = rawElements;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public byte[] getRawKey() {
        return rawKey;
    }

    public void setRawKey(byte[] rawKey) {
        this.rawKey = rawKey;
    }

    public byte[][] getRawElements() {
        return rawElements;
    }

    public void setRawElements(byte[][] rawElements) {
        this.rawElements = rawElements;
    }

    @Override
    public String toString() {
        return "PFAddCommand{" +
                "key='" + key + '\'' +
                ", element=" + Arrays.toString(elements) +
                '}';
    }
}
