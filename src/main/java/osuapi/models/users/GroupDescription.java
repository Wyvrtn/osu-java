package osuapi.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupDescription {
    /// <summary>
    /// The description of this group, as a pre-rendered HTML string.
    /// </summary>
    @JsonProperty("html")
    public String html;

    /// <summary>
    /// The description of this group, as a markdown string.
    /// </summary>
    @JsonProperty("markdown")
    public String markdown;
}
