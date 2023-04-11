package com.sapient.grooming.Model;

public enum Tech {
    JAVA(8,Role.MANAGER),
    SAP(4,Role.SENIOR_ASSOCIATE),
    QA(3,Role.ASSOCIATE),
    REACT(2,Role.ASSOCIATE);

    private Integer exp;
    private Role role;

    public Integer getExp() {
        return this.exp;
    }

    public Role getRole() {
        return this.role;
    }

    private Tech(Integer exp, Role role){
        this.exp = exp;
        this.role = role;
    }

    public static Tech getTech(Integer exp,Role role){
        Tech[] techArray = Tech.values();
        for (Tech tech : techArray){
            if(tech.getExp().equals(exp) && tech.getRole().equals(role)) return tech;
        }
        return null;
    }

    public static Boolean findTech(String input) {
        Tech[] techArray = Tech.values();
        for (Tech tech : techArray) {
            if (tech.toString().equals(input)) return true;
        }
        return false;
    }

    public static Role findRoleByExpAndTech(Integer exp,String givenTech){
        Tech[] techArray = Tech.values();
        for (Tech tech : techArray) {
            if (tech.toString().equals(givenTech) && tech.getExp().equals(exp)) return tech.getRole();
        }
        return null;
    }

    public static Role findRoleByExp(Integer exp){
        Tech[] techArray = Tech.values();
        for (Tech tech : techArray) {
            if (tech.getExp().equals(exp)) return tech.getRole();
        }
        return null;
    }
}
