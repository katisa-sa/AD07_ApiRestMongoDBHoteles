package eus.dam.api.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "coordinates"
})

@Getter
@Setter
@Data
@NoArgsConstructor
public class Geometry {
	
	@JsonProperty("type")
	public String type;
	
	@JsonProperty("coordinates")
    public List<Double> coordinates;
	
    public Double distance;    

}
