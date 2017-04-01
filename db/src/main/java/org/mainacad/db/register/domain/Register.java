package org.mainacad.db.register.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Register {
    @Getter
    @Setter
    private Groups groups;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Getter
    @Setter
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Getter
    @Setter
    private Date finishDate;



}
