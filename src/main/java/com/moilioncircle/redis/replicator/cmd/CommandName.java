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

package com.moilioncircle.redis.replicator.cmd;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class CommandName {
    public final String name;

    private CommandName(String name) {
        this.name = name;
    }

    public static CommandName name(String key) {
        return new CommandName(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandName that = (CommandName) o;
        return name.toUpperCase().equals(that.name.toUpperCase());
    }

    @Override
    public int hashCode() {
        return name.toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        return "CommandName{" +
                "name='" + name + '\'' +
                '}';
    }
}
