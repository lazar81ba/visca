package main.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ChangeSecondsRequest {

    @NotNull
    @Min(18)
    private Integer seconds;

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
