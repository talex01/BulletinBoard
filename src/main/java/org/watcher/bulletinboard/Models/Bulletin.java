package org.watcher.bulletinboard.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bulletin")
public class Bulletin {
    @Id
    @Column(name = "id_bulletin", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bulletin", nullable = false)
    private String bulletin;

    @Column(name = "phone", nullable = false)
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+3")
    @Column(name = "date", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id_category", nullable = false)
    private Category bulletinCategory;

    public Bulletin(String bulletin, String phone, Category category) {
        this.bulletin = bulletin;
        this.phone = phone;
        this.bulletinCategory = category;
    }

    public Bulletin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getBulletinCategory() {
        return bulletinCategory;
    }

    public void setBulletinCategory(Category bulletinCategory) {
        this.bulletinCategory = bulletinCategory;
    }

    @Override
    public String toString() {
        return "Bulletin{" +
                "id=" + id +
                ", bulletin='" + bulletin + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", bulletinCategory=" + bulletinCategory +
                '}';
    }
}
