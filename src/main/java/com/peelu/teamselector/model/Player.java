
package com.peelu.teamselector.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artwork",
    "squad",
    "credits",
    "id",
    "name",
    "points",
    "type",
    "isSelected",
    "role"
})
public class Player {

    @JsonProperty("artwork")
    private List<Artwork> artwork = null;
    @JsonProperty("squad")
    private Squad squad;
    @JsonProperty("credits")
    private Double credits;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("isSelected")
    private Boolean isSelected;
    @JsonProperty("role")
    private Object role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("artwork")
    public List<Artwork> getArtwork() {
        return artwork;
    }

    @JsonProperty("artwork")
    public void setArtwork(List<Artwork> artwork) {
        this.artwork = artwork;
    }

    @JsonProperty("squad")
    public Squad getSquad() {
        return squad;
    }

    @JsonProperty("squad")
    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    @JsonProperty("credits")
    public Double getCredits() {
        return credits;
    }

    @JsonProperty("credits")
    public void setCredits(Double credits) {
        this.credits = credits;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("isSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("isSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonProperty("role")
    public Object getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(Object role) {
        this.role = role;
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
