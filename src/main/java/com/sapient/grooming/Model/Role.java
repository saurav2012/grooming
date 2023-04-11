package com.sapient.grooming.Model;

public enum Role {
    ASSOCIATE(20),
    SENIOR_ASSOCIATE(30),
    MANAGER(45);

    private Integer increment;

    public Integer getIncrement() {
        return this.increment;
    }

    private Role(Integer inc) {
        this.increment = inc;
    }

    public static Role getRole(Integer inc){
        Role[] roles = Role.values();
        for(Role role : roles){
            if(role.getIncrement().equals(inc)) return role;
        }
        return null;
    }
    public static Integer getIncrementByRole(Role inputRole){
        Role[] roles = Role.values();
        for(Role role : roles){
            if(role.equals(inputRole)) return role.getIncrement();
        }
        return null;
    }
}
