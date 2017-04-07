package org.mainacad.db.register.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Register {
    @Getter
    @Setter
    private Groups groups;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Getter
    @Setter
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Getter
    @Setter
    private LocalDate finishDate;

    public List<LocalDate> dateList(){
        List<LocalDate> dates = new ArrayList<>();
        LocalDate date = startDate;
        while (!date.equals(finishDate)){
            dates.add(date);
            date=date.plusDays(1);
        }
        return dates;
    }



}
