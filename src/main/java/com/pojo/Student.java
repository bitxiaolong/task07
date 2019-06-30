package com.pojo;

public class Student {
      private Integer id;

      private String name;

      private String title;

      private String banner;

      private String introduce;

      private Integer selery;

      private String photo;

      private Long created_at;

      private Long updated_at;

    public Student(Integer id, String name, String title, String banner, String introduce, Integer selery, String photo, Long created_at, Long updated_at) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.banner = banner;
        this.introduce = introduce;
        this.selery = selery;
        this.photo = photo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getSelery() {
        return selery;
    }

    public void setSelery(Integer selery) {
        this.selery = selery;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
