package com.cp.demo3;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String userName;
    private Integer age;


}
