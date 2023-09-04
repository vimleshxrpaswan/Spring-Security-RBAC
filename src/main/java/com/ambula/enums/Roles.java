package com.ambula.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Roles {
    ADMIN("ROLE_ADMIN"),
    READER("ROLE_READER");

    @Getter
    private String value;

//    public static List<String> getAllValues() {
//        return List.of(Roles.values()).stream().map(data -> data.value).collect(Collectors.toList());
//    }


}
