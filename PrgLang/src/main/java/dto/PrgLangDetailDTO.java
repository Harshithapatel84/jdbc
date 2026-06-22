package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PrgLangDetailDTO {

    private String LangName;
    private String CurtVersion;
    private int developedYear;
    private String developedBy;
    private boolean openSource;
}
