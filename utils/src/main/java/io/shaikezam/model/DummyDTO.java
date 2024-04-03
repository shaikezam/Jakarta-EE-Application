package io.shaikezam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Data
@ToString
public class DummyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
}
