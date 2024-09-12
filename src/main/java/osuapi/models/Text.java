package osuapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Text {
	
	@JsonProperty("html")
	private String html;
	
	@JsonProperty("bbcode")
	private String bbcode;
	
	@JsonProperty("raw")
	private String raw;
	
	private String Markup = bbcode!=null? bbcode : raw;
}
