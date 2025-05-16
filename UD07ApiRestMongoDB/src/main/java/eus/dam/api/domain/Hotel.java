package eus.dam.api.domain;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


//Solo se incluirán en el JSON las propiedades que no sean nulas
@JsonInclude(JsonInclude.Include.NON_NULL) 
//Especifica el orden en el que las propiedades del objeto deben aparecer en el JSON
@JsonPropertyOrder({
    "_id",
    "id",
    "type",
    "geometry",
    "properties"
})

@Getter
@Setter
@Data
@AllArgsConstructor
@Document(collection="hotelData")

public class Hotel {
		
	@JsonProperty("_id")
	private String id;
	@JsonProperty("id")
    private Integer establecimientoId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("geometry")
    private Geometry geometry;
	@JsonProperty("properties")
	private Properties properties; 

	public Hotel(Integer establecimientoId, String type, Geometry geometry, Properties properties) {
		super();
		this.establecimientoId = establecimientoId;
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", establecimientoId=" + establecimientoId + ", type=" + type + ", geometry="
				+ geometry + ", properties=" + properties + "]";
	}




}
