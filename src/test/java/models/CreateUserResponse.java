package models;

import Utils.DateDeserealizer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreateUserResponse {
    private String name;
    private String job;
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    @JsonDeserialize(using = DateDeserealizer.class)
    private LocalDateTime createdAt;
}
