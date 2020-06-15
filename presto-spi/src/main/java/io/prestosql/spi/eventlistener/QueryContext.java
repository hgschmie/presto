/*
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
package io.prestosql.spi.eventlistener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.prestosql.spi.resourcegroups.ResourceGroupId;
import io.prestosql.spi.session.ResourceEstimates;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface QueryContext
{
    @JsonProperty
    String getUser();

    @JsonProperty
    Optional<String> getPrincipal();

    @JsonProperty
    Optional<String> getTraceToken();

    @JsonProperty
    Optional<String> getRemoteClientAddress();

    @JsonProperty
    Optional<String> getUserAgent();

    @JsonProperty
    Optional<String> getClientInfo();

    @JsonProperty
    Set<String> getClientTags();

    @JsonProperty
    Set<String> getClientCapabilities();

    @JsonProperty
    Optional<String> getSource();

    @JsonProperty
    Optional<String> getCatalog();

    @JsonProperty
    Optional<String> getSchema();

    @JsonProperty
    Optional<ResourceGroupId> getResourceGroupId();

    @JsonProperty
    Map<String, String> getSessionProperties();

    @JsonProperty
    ResourceEstimates getResourceEstimates();

    @JsonProperty
    String getServerAddress();

    @JsonProperty
    String getServerVersion();

    @JsonProperty
    String getEnvironment();

    @JsonIgnore
    default <T> T getSystemProperty(String name, Class<T> type)
    {
        throw new UnsupportedOperationException();
    }
}
