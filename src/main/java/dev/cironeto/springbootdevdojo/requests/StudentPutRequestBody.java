package dev.cironeto.springbootdevdojo.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentPutRequestBody {
    private long id;
    private String name;
}
