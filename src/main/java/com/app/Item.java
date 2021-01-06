package com.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor @Setter @Getter
public class Item {
    private String name;
    private String EAN;
    private String old_amount;
    private String new_amount;
}
