package com.gudt.imis.clubmanageis.model;

public enum ClubRoleEnum {
    MANAGE(0,"管理员"),
    ACCOUNTED(1,"记账员 "),
    ORDINARYMEMBER(2,"普通成员"),
    ;
    private int code;
    private String role;

    ClubRoleEnum(int code, String role) {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
