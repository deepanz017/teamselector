
package com.peelu.teamselector.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "maxPerTeam",
    "minPerTeam",
    "name",
    "shortName"
})
public class Type {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("maxPerTeam")
    private Integer maxPerTeam;
    @JsonProperty("minPerTeam")
    private Integer minPerTeam;
    @JsonProperty("name")
    private String name;
    @JsonProperty("shortName")
    private String shortName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("maxPerTeam")
    public Integer getMaxPerTeam() {
        return maxPerTeam;
    }

    @JsonProperty("maxPerTeam")
    public void setMaxPerTeam(Integer maxPerTeam) {
        this.maxPerTeam = maxPerTeam;
    }

    @JsonProperty("minPerTeam")
    public Integer getMinPerTeam() {
        return minPerTeam;
    }

    @JsonProperty("minPerTeam")
    public void setMinPerTeam(Integer minPerTeam) {
        this.minPerTeam = minPerTeam;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
