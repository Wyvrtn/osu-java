package osuapi.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import osuapi.enums.Ruleset;

@Getter
@Setter
@NoArgsConstructor
public class UserGroup extends Group {

    @JsonProperty("playmodes")
	private Ruleset[] playModes;
}
