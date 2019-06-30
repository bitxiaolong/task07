package com.pojo;

public class Job {
    private Integer id;

    private String picture;

    private String direction;

    private String introduce;

    private String profession;

    private String threshold;

    private String difficultly;

    private String growth_cycle;

    private String salary;

    private String scarcity_level;

    private Long created_at;

    private Long updated_at;

    public Job(Integer id, String picture, String direction, String introduce, String profession, String threshold, String difficultly, String growth_cycle, String salary, String scarcity_level, Long created_at, Long updated_at) {
        this.id = id;
        this.picture = picture;
        this.direction = direction;
        this.introduce = introduce;
        this.profession = profession;
        this.threshold = threshold;
        this.difficultly = difficultly;
        this.growth_cycle = growth_cycle;
        this.salary = salary;
        this.scarcity_level = scarcity_level;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getDifficultly() {
        return difficultly;
    }

    public void setDifficultly(String difficultly) {
        this.difficultly = difficultly;
    }

    public String getGrowth_cycle() {
        return growth_cycle;
    }

    public void setGrowth_cycle(String growth_cycle) {
        this.growth_cycle = growth_cycle;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getScarcity_level() {
        return scarcity_level;
    }

    public void setScarcity_level(String scarcity_level) {
        this.scarcity_level = scarcity_level;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public Long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Long updated_at) {
        this.updated_at = updated_at;
    }
}
