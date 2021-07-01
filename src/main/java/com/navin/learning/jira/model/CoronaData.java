package com.navin.learning.jira.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CoronaData {
    private String country;
    private String cases;
    private String deaths;
    private String recoveries;
}
